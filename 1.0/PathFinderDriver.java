package pathFinder;

import java.util.ArrayList;



public class PathFinderDriver
{

	public static void main(String[] args)
	{
		long s = System.currentTimeMillis();
		
		PathFinder a = new PathFinder();
		
		ArrayList<Aspect> l = a.findPath(a.getAllAspectList().get(15), a.getAllAspectList().get(21), 5);
		
		for(int i = 0; i < l.size(); i++)
		{
			System.out.println(l.get(i).getName().toString());
		}
		
		double t = (double)(System.currentTimeMillis() - s)/1000;
		
		System.out.println(t);
	}

}
