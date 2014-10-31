package pathFinder;

public class AspectStep
{
	private Aspect currentAspect;
	private int stepNumber;
	private AspectStep previousStep;
	
	
	//Constructor, allows for AspectStep to be NULL
	public AspectStep(Aspect aspectName, AspectStep prev)
	{
		this.currentAspect = aspectName;
		
		if(prev != null)
		{
			this.previousStep = prev;
						
			this.stepNumber = prev.getStepNumber() + 1;
		}
		else
		{
			this.previousStep = null;
			
			this.stepNumber = 1;
		}		
	}
	
	//Getters
	public Aspect getCurrentAspect()
	{
		return this.currentAspect;
	}
	public int getStepNumber()
	{
		return this.stepNumber;
	}
	public AspectStep getPreviousStep()
	{
		return this.previousStep;
	}
	
}
