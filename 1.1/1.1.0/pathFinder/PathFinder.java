package pathFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.image.*;

import javax.imageio.ImageIO;

public class PathFinder
{
	private ArrayList<Aspect> allAspectList;
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
		String pngFile = "aspects.png";
		InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream(csvFile));
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int aspectNum = 0;
	 
		try {
			BufferedImage wholeImage = ImageIO.read(new File(pngFile));
			br = new BufferedReader(isr);;
			br.readLine();//Ignore Header in .CSV file
			while ((line = br.readLine()) != null) {
		        // use comma as separator
				String[] aspectTemp = line.split(cvsSplitBy);
	 
				//Don't add empty aspects (haven't found them yet...)
				if (aspectTemp.length > 0)
				{
	                int xOffset = aspectNum%8 * 64;
	                int yOffset = aspectNum/8 * 64;
	                
					//reads from the line into the Aspect object
					this.allAspectList.add(new Aspect(aspectTemp[0], aspectTemp[1], aspectTemp[2], wholeImage.getSubimage(xOffset, yOffset, 64, 64)));
				}
				
				aspectNum++;
			}
	 
		} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
		            System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		//Save a bit of memory
		this.allAspectList.trimToSize();
		
		//Pre-calculation of partner aspects
		for (Aspect a : this.allAspectList)
		{
			a.determinePartnerAspects(this.allAspectList);
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
			
			//Only add next nodes if this one is enabled (except for the start, obviously)
			if (tempStep.getCurrentAspect().getEnabled() || tempStep.getPreviousStep() == null)
			{
				for(Aspect a : tempStep.getCurrentAspect().getCompatableAspects())
				{
					//Adds a new node to check to the queue for each possible path
					this.nodesToCheck.add(new AspectStep(a, tempStep));
				}
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
}
