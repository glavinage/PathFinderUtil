package pathFinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder
{
	private ArrayList<Aspect> allAspectList;
	private ArrayList<Aspect> ownedAspectList;
	private Queue<AspectStep> nodesToCheck;
	private PathChecker check;
	
	public PathFinder()
	{
		this.allAspectList = new ArrayList<Aspect>();
		this.nodesToCheck = new LinkedList<AspectStep>();
		this.check = new PathChecker();
		
		//method used to simply constructor
		this.readAspects();
	}
	
	//Should only be called by the constructor
	private void readAspects()
	{
		//reads in the Research Aspects.csv
		String csvFile = "Research Aspects.csv";
		InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream(csvFile));
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(isr);;
			br.readLine();//Ignore Header in .CSV file
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] aspectTemp = line.split(cvsSplitBy);
	 
				//reads from the line into the Aspect object
				this.allAspectList.add(new Aspect(aspectTemp[0], aspectTemp[1], aspectTemp[2]));
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//Save a bit of memory
		this.allAspectList.trimToSize();
				
		//Initialize the ownedAspectList to hold all aspects by default, allows the user to remove aspects from consideration
		this.ownedAspectList = new ArrayList<Aspect>(this.allAspectList);
		
		//Sets each aspect's partners
		this.editAspects();
	}
	
	/*
	 * Call this method each time a calculation is run. It removes the aspects that are not to be included
	 * Pass a list of the aspects by String name
	 */
	public void updateOwnedAspectList(ArrayList<String> aspectsToRemove)
	{
		//Initialize the ownedAspectList to hold all aspects by default, allows the user to remove aspects from consideration
		this.ownedAspectList = new ArrayList<Aspect>(this.allAspectList);
		
		for(int i = 0; i < aspectsToRemove.size(); i++)
		{
			for(int j = 0; j < this.ownedAspectList.size(); j++)
			{
				if(aspectsToRemove.get(i).equals(this.ownedAspectList.get(j).getName()))
				{
					this.ownedAspectList.remove(j);
				}
			}
		}
		
		//Save a bit of memory
		this.ownedAspectList.trimToSize();
		
		//Sets each aspect's partners
		this.editAspects();
	}
	
	//Sets the aspects to be with valid partners from ownedAspectList
	private void editAspects()
	{
		for(int i = 0; i < this.ownedAspectList.size(); i++)
		{
			//
			this.ownedAspectList.get(i).determinePartnerAspects(this.ownedAspectList);
		}
	}
	
	public ArrayList<Aspect> findPath(Aspect start, Aspect end, int minSteps)
	{
		//Clears the queue of any old variables
		this.nodesToCheck.clear();
		//adds the starting node to the queue
		this.nodesToCheck.add(new AspectStep(start, null));
		
		//Initialize the temp variable for the do loop
		AspectStep tempStep;
		
		do
		{
			//grabs the front AspectStep from the queue
			tempStep = this.nodesToCheck.poll();
			
			for(int i = 0; i < tempStep.getCurrentAspect().getCompatableAspects().size(); i++)
			{
				//Adds a new node to check to the queue for each possible path
				this.nodesToCheck.add(new AspectStep(tempStep.getCurrentAspect().getCompatableAspects().get(i), tempStep));
			}
			
		//loop repeats until the path is valid
		}while(!this.check.checkPathWorks(start, end, minSteps, tempStep));
		
		//returns the valid path based on the tempStep's recursive pointers
		return this.check.getSolution(tempStep);
	}
	
	public ArrayList<Aspect> getAllAspectList()
	{
		return this.allAspectList;
	}
	public ArrayList<Aspect> getOwnedAspectList()
	{
		return this.ownedAspectList;
	}
}
