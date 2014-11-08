package pathFinder;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Aspect
{
	private String name;
	private String componentA;
	private String componentB;
	private ArrayList<Aspect> compatibleAspects;
	private BufferedImage image;
	private boolean enabled;
	// Counts of total of each Primal Aspect in this aspect
	int aerCount, aquaCount, ignisCount, ordoCount, perditioCount, terraCount;

	public Aspect(String aspectName, String compA, String compB, BufferedImage aspectImage)
	{
		this.name = aspectName;
		this.componentA = compA;
		this.componentB = compB;
		this.compatibleAspects = new ArrayList<Aspect>();
		this.image = aspectImage;
		this.enabled = true;
	}

	// Returns true if the Partner Aspect is compatible with this aspect
	public boolean isValidPartnerAspect(Aspect a)
	{
		// If this is a parent Aspect
		if(this.name.equals(a.getComponentA()))
			return true;
		// If this is a parent Aspect
		if(this.name.equals(a.getComponentB()))
			return true;
		// If this is a child Aspect
		if(this.componentA.equals(a.getName()))
			return true;
		// If this is a child Aspect
		if(this.componentB.equals(a.getName()))
			return true;

		// Otherwise not directly related
		return false;
	}

	// Returns true if the Partner Aspect is compatible with this aspect
	public boolean isComponentAspect(Aspect a)
	{
		// If this is a child Aspect
		if(this.componentA.equals(a.getName()))
			return true;
		// If this is a child Aspect
		if(this.componentB.equals(a.getName()))
			return true;

		// Otherwise not directly related
		return false;
	}

	// Used to generate a list of partner aspects that can link to this Aspect
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

		// Save a bit of memory
		this.compatibleAspects.trimToSize();
	}

	// Used to calculate the total primal component aspects of this Aspect
	public void determineComponentAspect(ArrayList<Aspect> aspectList)
	{
		Queue<Aspect> q = new LinkedList<Aspect>();

		q.add(this);

		while(!q.isEmpty())
		{
			// System.out.println("Test");
			Aspect a = q.poll();

			if(a.isNamed("Aer"))
				this.aerCount++;
			else if(a.isNamed("Aqua"))
				this.aquaCount++;
			else if(a.isNamed("Ignis"))
				this.ignisCount++;
			else if(a.isNamed("Ordo"))
				this.ordoCount++;
			else if(a.isNamed("Perditio"))
				this.perditioCount++;
			else if(a.isNamed("Terra"))
				this.terraCount++;
			else
			{
				for(Aspect t : aspectList)
				{
					if(a.isComponentAspect(t))
					{
						q.add(t);
					}

				}
			}
		}
	}

	//
	public void sortByPrimalCost()
	{
		for(int a = 0; a < this.compatibleAspects.size(); a++)
		{
			for(int b = a + 1; b < compatibleAspects.size(); b++)
			{
				if(this.compatibleAspects.get(b).getTotalPrimalCost() < this.compatibleAspects.get(a)
						.getTotalPrimalCost())
				{
					Collections.swap(this.compatibleAspects, a, b);
				}
			}
		}
	}

	// Getter Methods
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

	// Overwrite Functions
	public String toString()
	{
		String s = this.name + " is composed of " + this.componentA + " & " + componentB;

		return s;
	}

	// Returns a detailed string including all related aspects
	public String toStringDeatil()
	{
		String s = this.name + " is composed of " + this.componentA + " & " + componentB + " and is compatible with";

		for(int i = 0; i < this.compatibleAspects.size(); i++)
		{
			s += " " + this.compatibleAspects.get(i).getName();
		}

		return s;
	}

	// Returns details on what primal components make up this aspect
	public String toStringBaseComponents()
	{
		String s = this.name + " is composed of " + this.aerCount + " Aer " + this.aquaCount + " Aqua "
				+ this.ignisCount + " Ignis " + this.ordoCount + " Ordo " + this.perditioCount + " Perditio "
				+ this.terraCount + " Terra for a total of " + this.getTotalPrimalCost();

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

	// Returns ture if this aspect has the same name as the passed string
	public boolean isNamed(String n)
	{
		if(this.getName().equals(n))
		{
			return true;
		}

		return false;
	}

	// Returns total primal cost
	public int getTotalPrimalCost()
	{
		int t = this.aerCount + this.aquaCount + this.ignisCount + this.ordoCount + this.perditioCount
				+ this.terraCount;

		return t;
	}
}
