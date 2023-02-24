import java.io.FileInputStream;//required for I/O from file
import java.util.Scanner;//required for I/O from stdin
import java.awt.Point;//required for Points
import java.awt.geom.*;//required for Lines
import java.text.DecimalFormat;//required for rounding
import java.util.ArrayList;//required for ArrayList generics
import java.util.HashMap;
import java.util.List;//required for List generics
import java.util.Map;

public class prob28 {
	private static boolean PRINT_SETUP_MSGS = false;
	private static boolean PRINT_DEBUG_MSGS = true;
	private static Point2D start = new Point();
	private static Point2D destination = new Point();

	public static void main(String[] args) {
		try
		{
			runP8_BestRoute();
		}
		catch (Exception e)
		{
			System.out.println("error: "+e.getMessage());	
		}
	}
	private static void runP8_BestRoute()
	{
		List<String> lines = readFromFileInputByCommandLine();
		
		List<Point2D> points = new ArrayList<Point2D>();
		Map<Point2D,String> pointNames = new HashMap<Point2D,String>();
		List<Line2D> walls = new ArrayList<Line2D>();
		
		//parse through each line and pull out the points for the path, and the obstructions into lists
		int regionCounter = 0;
		for(String line:lines){
			if (line.trim().equals("~")){
				regionCounter++;
			}
			else if (regionCounter <1){
				findPoints(line,points,pointNames);
			}
			else{
				findWalls(line,walls);
			}
		}
		//whittle down the combinations of points into all possible lines for a path (and assemble the list of all points)
		List<Line2D> possibleLines = new ArrayList<Line2D>();
		List<Point2D> allPoints = findAllPossibleLines(points,possibleLines);
		//remove the lines which violate the rules
		removeBadLines(walls,possibleLines);
		//take the remaining lines and try all combinations of those lines and find the shortest one.
		findBestPath(allPoints,possibleLines,pointNames);
		//Make Java happy so it doesn't end in an error state :)
		System.exit(0);
	}
	private static List<String> readFromFileInputByCommandLine() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Takes each line sent to it, stores the coordinates and label
	 * for the point, and makes special note of the start and end points.
	 * */
	private static void findPoints(String line,List<Point2D> points,Map<Point2D,String> pointNames)
	{
		String[] pointSet = line.split(" ");//label in [0]
		String[] coords = pointSet[1].split(",");
		String label = pointSet[0].trim();
		Integer x = Integer.parseInt(coords[0].trim());
		Integer y = Integer.parseInt(coords[1].trim());
		Point newPoint = new Point(x,y);
		if (label.equalsIgnoreCase("X")){
			start = newPoint;
		}
		else if (label.equalsIgnoreCase("Y")){
			destination = newPoint;
		}
		else{
			points.add(newPoint);
		}
		pointNames.put(newPoint, label);
		if (PRINT_DEBUG_MSGS && PRINT_SETUP_MSGS)
		{
			System.out.println("found point: "+newPoint.toString());
		}
	}
	/**
	 * Assembles the begin and end points for walls into a list of wall lines
	 * */
	private static void findWalls(String line,List<Line2D> walls)
	{
		String[] wallList = line.split(" ");
		String[] wallCoords = wallList[0].split(",");
		Integer x = Integer.parseInt(wallCoords[0]);
		Integer y = Integer.parseInt(wallCoords[1]);
		Point wall1 = new Point(x,y);
		wallCoords = wallList[1].split(",");
		x = Integer.parseInt(wallCoords[0]);
		y = Integer.parseInt(wallCoords[1]);
		Point wall2 = new Point(x,y);
		Line2D wall = new Line2D.Double();
		wall.setLine(wall1, wall2);
		walls.add(wall);
		if (PRINT_DEBUG_MSGS && PRINT_SETUP_MSGS)
		{
			System.out.println("WALLS:");
			for(Line2D w:walls)
			{
				System.out.println("wall line=("+w.getX1()+","+w.getY1()+") ("+w.getX2()+","+w.getY2()+")");
			}
		}
	}
	/**
	 * Runs through all possible combinations of lines which can be
	 * created with the points we have on the grid. Takes into account
	 * that a point (A,B) and a point (C,D) make the same line if the
	 * line is: [ (A,B); (C,D) ] or the line is: [ (C,D); (A,B) ]
	 * and limits lines to only one instance of any given combination of points 
	 * */
	private static List<Point2D> findAllPossibleLines(List<Point2D> points, List<Line2D> possibleLines)
	{
		//create line segment map for all possible combinations of points
		List<Point2D> allPoints = new ArrayList<Point2D>(points);
		allPoints.add(start);
		allPoints.add(destination);
		for(Point2D p1:allPoints)
		{
			for(Point2D p2:allPoints)
			{
				if (!p1.equals(p2))
				{
					Line2D line1 = new Line2D.Double(p1,p2);
					Line2D line2 = new Line2D.Double(p2,p1);
					if (!ListContainsLine(possibleLines, line1) && !ListContainsLine(possibleLines, line2))
					{
						possibleLines.add(line1);
					}
					else
					{
						if (PRINT_DEBUG_MSGS && PRINT_SETUP_MSGS)
						{
							System.out.println("skipping line=("+line1.getX1()+","+line1.getY1()+") ("+line1.getX2()+","+line1.getY2()+")");
						}
					}
				}
			}
		}
		if (PRINT_DEBUG_MSGS && PRINT_SETUP_MSGS)
		{
			System.out.println("POSSIBLE LINES:");
			for(Line2D line:possibleLines)
			{
				System.out.println("line=("+line.getX1()+","+line.getY1()+") ("+line.getX2()+","+line.getY2()+")");			
			}
		}
		return allPoints;
	}
	/**
	 * Runs through the current list of possible lines, and the list of wall
	 * lines, and removes any lines from the possible lines list which intersect
	 * the wall lines. (Uses the built-in Java classes for Lines to determine the
	 * intersections. In languages without said in-built classes, the programmer
	 * would need to write their own intersection function).
	 * 
	 * Also removes any lines which directly connect the starting point to 
	 * the destination point, as that is not allowed by the rules of the exercise.
	 * */
	private static void removeBadLines(List<Line2D> walls,List<Line2D> possibleLines)
	{
		//remove segments that cross walls
		List<Line2D> badLines = new ArrayList<Line2D>();//requires java.util.*
		for(Line2D wall:walls)
		{
			for(Line2D line:possibleLines)
			{
				if (line.intersectsLine(wall))
				{
					if (PRINT_DEBUG_MSGS && PRINT_SETUP_MSGS)
					{
						System.out.println("removing line: ("+line.getX1()+","+line.getY1()+") ("+line.getX2()+","+line.getY2()+") it intersects wall at: ("+wall.getX1()+","+wall.getY1()+") ("+wall.getX2()+","+wall.getY2()+")");
					}
					badLines.add(line);
				}
			}			
		}
		//remove any direct from start to destination line(s)
		Line2D forbidden = new Line2D.Double(start,destination);
		badLines.add(forbidden);
		for(Line2D line:badLines)
		{
			possibleLines.remove(line);//can't remove from collection while iterating over it
		}
		if (PRINT_DEBUG_MSGS && PRINT_SETUP_MSGS)
		{
			System.out.println("REMAINING LINES:");
			for(Line2D line:possibleLines)
			{
				System.out.println("line=("+line.getX1()+","+line.getY1()+") ("+line.getX2()+","+line.getY2()+")");			
			}
		}
	}
	/**
	 * Takes the filtered list of possible lines, and the list of all points, and
	 * creates a path starting at the "start" point, and ending at the "destination"
	 * point which touches all of the "open" points at least once, with no repeated
	 * path segments.
	 * 
	 * Uses a recursive function (getValidPaths) to walk through the lists of all
	 * possible points, and all possible lines and assemble all possible paths that
	 * can be assembled (more on that in function description below)
	 * 
	 * Once we have a list of valid paths which satisy the rules of the exercise, 
	 * we then walk through each path which was found to be valid and check the distance
	 * the path travels. We store the shortest distance path found in a temp variable
	 * until we are done parsing each valid path, updating the shortest path found
	 * as we go.
	 * 
	 * Once we are done parsing through all of the valid paths that were found,
	 * we will output to standard output the shortest path found in the format:
	 * 
	 * Shortest path:
	 * (s.s,s.s) (o1.o1,o1.o1)
	 * ...
	 * (o2.o2,o2.o2) (d.d,d.d)
	 * Distance=#.##
	 * 
	 * Where (s.s,s.s) is the start point, (d.d,d.d) is the destination point
	 * and (o1.o1,o1.o1)... are the rest of the open points in the path.
	 * And the distance is shown as a rounded 2 decimal point double/float type number
	 * 
	 * */
	private static void findBestPath(List<Point2D> allPoints,List<Line2D> possibleLines,Map<Point2D,String> pointNames)
	{
		List<List<Line2D>> validPaths = new ArrayList<List<Line2D>>();
		getValidPaths(allPoints, 0, validPaths, possibleLines);
		double pathDistance = 0;
		List<Line2D> pathTmp = new ArrayList<Line2D>();
		double shortestDistance = 0;
		List<Line2D> shortestPath = new ArrayList<Line2D>();
		for(List<Line2D> path:validPaths)
		{//note: enumeration of collection expires collection, so need to do a "deep copy" into the temp variable to store the values
			pathDistance = 0;
			pathTmp = new ArrayList<Line2D>();
			for(Line2D line:path)
			{
				pathDistance += line.getP1().distance(line.getP2());
				pathTmp.add(new Line2D.Double(line.getP1().getX(),line.getP1().getY(),line.getP2().getX(),line.getP2().getY()));
			}
			if (shortestDistance == 0 || pathDistance < shortestDistance)
			{
				shortestDistance = pathDistance;
				shortestPath = pathTmp;
			}
		}
		System.out.print("Shortest path: ");
		int counter=1;
		for(Line2D line:shortestPath)
		{
			//System.out.println("("+line.getX1()+","+line.getY1()+") ("+line.getX2()+","+line.getY2()+")");
			if (counter==1){
				System.out.print(pointNames.get(line.getP1()));
				System.out.print(pointNames.get(line.getP2()));
			}
			else{
				System.out.print(pointNames.get(line.getP2()));
			}
			counter++;
		}
		System.out.println("");
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Distance="+df.format(shortestDistance));
	}
    /**
     * This is a cpu-intensive function which will recursively call itself as it walks through
     * every point in the list of all points on the grid, and all possible lines from the 
     * filtered list of lines we have assembled which don't violate the path rules.
     * 
     * This is an ugly way to get this sort of data, but all other ways to do this would require
     * the programmer to have advanced programming knowledge. As this exercise is intended to
     * be solved by high-school students in a limited-time contest, it was judged that a
     * "brute force" method would be the most common method a student might use to
     * solve this problem.
     * 
     * The recursive function walks through the list of all points and splits off recursively until
     * the index matches the list size, then it walks back up the chain and assembles the points
     * into a path, and adds them to a collection. Each potential path of assembled lines is then
     * 'walked through', and paths which do not follow the path rules are discarded. All remaining
     * paths are added to the 'valid paths' output list which is returned to the caller.
     * */
	static void getValidPaths(List<Point2D> list, int index, List<List<Line2D>> output,List<Line2D> possibleLines) 
    {
        if (index == list.size()) 
        {
            try
            {
            	if (list.size() > 1)
                {//all calculations assume a list with at least 2 elements in it
                	if (
                			(list.get(0).equals(start) || list.get(1).equals(start)) &&
                			(list.get(list.size()-1).equals(destination) || list.get(list.size()-2).equals(destination))
                		)
                	{
            			List<Line2D> testPath = new ArrayList<Line2D>();
            			boolean bailedout = false;
            			for(int i=0; i<(list.size()-1);i++)
            			{
            				Point2D p1 = list.get(i);
            				Point2D p2 = list.get(i+1);
            				Line2D l = new Line2D.Double(p1, p2);
            				testPath.add(l);
            				if (!ListContainsLine(possibleLines, l))
            				{
            					bailedout = true;
            					break;//line isn't in possible line list, bail out
            				}
            			}
            			//walk the path
            			Point2D location = start;
            			for(Line2D line: testPath)
            			{
            				//move to the end of the line
            				if (line.intersectsLine(location.getX(), location.getY(), location.getX(), location.getY()))
            				{
                				if (!line.getP1().equals(location))
                				{
                					location = line.getP1();
                				}
                				else
                				{
                					location = line.getP2();
                				}
            				}
            				else
            				{
            					bailedout = true;
            					break;
            				}
            			}
            			if (!location.equals(destination))
            			{
            				bailedout = true;
            			}
                		if (!bailedout)
                		{
                			output.add(testPath);
                		}
                	}
                }            	
            }
            catch (Exception ex)
            {
            	System.out.println("error");
            }
        } 
        else 
        {
        	try
        	{
                for (int i = index; i < list.size(); i++) 
                {
                    Point2D temp = list.get(index);
                    list.set(index, list.get(i));
                    list.set(i,temp);
                    getValidPaths(list, index + 1,output,possibleLines);
                    temp = list.get(index);
                    list.set(index, list.get(i));
                    list.set(i,temp);
                }
        	}
        	catch(Exception ex)
        	{
        		System.out.println("error");
        	}
        }
    }

	private static boolean ListContainsLine(final List<Line2D> list, Line2D _line)
	{//faster than overriding/extending Java built-in classes which are 
		boolean result = false;
		double x1 = _line.getX1();
		double y1 = _line.getY1();
		double x2 = _line.getX2();
		double y2 = _line.getY2();
		for(Line2D line:list)
		{
			double lx1 = line.getX1();
			double ly1 = line.getY1();
			double lx2 = line.getX2();
			double ly2 = line.getY2();
			if ((lx1==x1 && ly1==y1 && lx2==x2 && ly2==y2)||
				(lx1==x2 && ly1==y2 && lx2==x1 && ly2==y1))
			{
				result = true;
				break;
			}
		}
		return result;
	}
	private static List<String> readFromFileToArrayList(String filePath) {
		List<String> lines = new ArrayList<String>();// requires java.util.*
		FileInputStream fis = null;
		int i = 0;// holds the remaining bytes to read
		char c;// placeholder character holder
		char CR = (char) 13;// -> \r
		char LF = (char) 10;// -> \n
		try {
			fis = new FileInputStream(filePath);
			String line = "";
			while ((i = fis.read()) != -1) {
				c = (char) i;
				if (c != CR) {// if the character is the \r character, we are at the end of the line
					if (c != LF) {// non-Linux based file systems (like Windows) will add the new line (line feed)
								  // character as well, ignoring this
						line += c;
					}
				} else {
					lines.add(line);
					line = "";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fis != null) {
				try
				{
					fis.close();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		return lines;
	}
}
