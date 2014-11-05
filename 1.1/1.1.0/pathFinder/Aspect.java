package pathFinder;

import java.util.ArrayList;
import java.awt.image.*;

public class Aspect
{
	private String name;
	private String componentA;
	private String componentB;
	private ArrayList<Aspect> compatibleAspects;
	private BufferedImage image;
	private boolean enabled;
	
	public Aspect(String aspectName, String compA, String compB, BufferedImage aspectImage)
	{
		this.name = aspectName;
		this.componentA = compA;
		this.componentB = compB;
		this.compatibleAspects = new ArrayList<Aspect>();
		this.image = aspectImage;
		this.enabled = true;
	}
	
	//Returns true if the Partner Aspect is compatible with this aspect
	public boolean isValidPartnerAspect(Aspect a)
	{
		//If this is a parent Aspect
		if(this.name.equals(a.getComponentA()))
			return true;
		//If this is a parent Aspect
		if(this.name.equals(a.getComponentB()))
			return true;
		//If this is a child Aspect
		if(this.componentA.equals(a.getName()))
			return true;
		//If this is a child Aspect
		if(this.componentB.equals(a.getName()))
			return true;
		
		//Otherwise not directly related
		return false;
	}
	
	//Used to generate a list of partner aspects that can link to this Aspect
	public void determinePartnerAspects(ArrayList<Aspect> aspectList)
	{
		this.compatibleAspects.clear();
		
		for(int i = 0; i < aspectList.size(); i++)
		{
			if(this.isValidPartnerAspect(aspectList.get(i)))
			{
				this.compatibleAspects.add(aspectList.get(i));
			}
		}
		
		//Save a bit of memory
		this.compatibleAspects.trimToSize();
	}
	
	//Getter Methods
	public String getName()
	{
		return this.name;
	}
	public String getComponentA()
	{
		return this.componentA;
	}
	public String getComponentB()
	{
		return this.componentB;
	}
	public ArrayList<Aspect> getCompatableAspects()
	{
		return this.compatibleAspects;
	}
	public BufferedImage getImage()
	{
		return this.image;
	}
	public boolean getEnabled()
	{
		return this.enabled;
	}

	public void toggleEnabled()
	{
		this.enabled = !this.enabled;
	}
	
	//Overwrite Functions
	public String toString()
	{
		String s = this.name + " is composed of " + this.componentA + " & " + componentB;
			
		return s;
	}
	//Returns a detailed string including all related aspects
	public String toStringDeatil()
	{
		String s = this.name + " is composed of " + this.componentA + " & " + componentB + " and is compatible with";
		
		for(int i = 0; i < this.compatibleAspects.size(); i++)
		{
			s += " " + this.compatibleAspects.get(i).getName();
		}
		
		return s;
	}
	public boolean equals(Aspect a)
	{
		if(this.getName().equals(a.getName()))
		{
            return true;
		}
		
		return false;
	}
}
