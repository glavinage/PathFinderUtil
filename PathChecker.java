package pathFinder;

import java.util.ArrayList;

public class PathChecker
{
	private Aspect endApect;
	public PathChecker()
	{
		
	}
	
	public boolean checkPathWorks(Aspect start, Aspect end, int minSteps, AspectStep solutionStep)
	{
		this.endApect = end;
		
		//Makes sure there is the correct minimum of steps
		if(solutionStep.getStepNumber() < minSteps - 1)
			return false;
		//Checks if the solution is the correct ending aspect
		if(solutionStep.getCurrentAspect().isValidPartnerAspect(end) == false)
			return false;
		
		//Moves through the solution to the beginning for verification
		AspectStep temp = solutionStep;
		while(temp.getPreviousStep() != null)
		{
			temp = temp.getPreviousStep();
		}
		
		//Verifies that the starting aspect is indeed the desired starting aspect
		return temp.getCurrentAspect().equals(start);
	}
	
	public ArrayList<Aspect> getSolution(AspectStep solutionStep)
	{
		//An array of aspects that make the solution to return
		ArrayList<Aspect> solution = new ArrayList<Aspect>();
		
		solution.add(this.endApect);
		
		AspectStep temp = solutionStep;
		do
		{
			solution.add(0, temp.getCurrentAspect());
			temp = temp.getPreviousStep();
		}while(temp.getPreviousStep() != null);
		
		solution.add(0, temp.getCurrentAspect());
		
		return solution;
	}
}
