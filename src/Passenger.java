
import java.util.Random;

public class Passenger extends Security
{
	private String name;
	private String[] carryOn;
	private static final int DEFAULT = 4;
	private int numOfBagEntries;
	private int numOfCarryOnEntries;
	private Node firstNode;
	
	public Passenger()
	{
		name = null;
	}
	
	public Passenger(String name1)
	{
		name = name1;
		numOfBagEntries = 0;
		String[] tempbag = (String[])new String[DEFAULT];
		carryOn = (String[]) tempbag;
		
		firstNode = null;
		numOfCarryOnEntries = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addToBag(String anEntry)
	{
		Node newNode = new Node(anEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numOfBagEntries++;
	}
	
	public void addToCarryOn(String anEntry)
	{
		carryOn[numOfCarryOnEntries] = anEntry;
		numOfCarryOnEntries++;
	}
	
	public void addCarryOn()
	{
		Random generator = new Random();
		int threat = generator.nextInt(11);
		threat = threat%5;
		
		if (threat == 0)
		{
			String bag1[] = {"water", "phone", "computer", "guns"};
			for (int i = 0; i < bag1.length; i++)
				addToCarryOn(bag1[i]);
		}
		
		if (threat == 1)
		{
			String bag3[] = {"water", "phone", "computer", "bombs"};
			for (int i = 0; i < bag3.length; i++)
				addToCarryOn(bag3[i]);
		}
		
		if (threat == 2)
		{
			String bag4[] = {"water", "phone", "computer", "drugs"};
			for (int i = 0; i < bag4.length; i++)
				addToCarryOn(bag4[i]);
		}
		
		else if (threat > 2)
		{
			String bag2[] = {"water", "phone", "computer", "food"};
			for (int i = 0; i < bag2.length; i++)
				addToCarryOn(bag2[i]);
		}	
	}
	
	public void addBag()
	{
		Random generator = new Random();
		int threat = generator.nextInt(10);
		int newthreat = threat%5;
		
		if (newthreat == 0)
		{
			String bag11[] = {"shirt", "pants", "shoes", "gun"};
			for (int i = 0; i < bag11.length; i++)
				addToBag(bag11[i]);
		}
		
		if (newthreat == 1)
		{
			String bag13[] = {"shirt", "pants", "shoes", "bomb"};
			for (int i = 0; i < bag13.length; i++)
				addToBag(bag13[i]);
		}
		
		if (newthreat == 2)
		{
			String bag14[] = {"shirt", "pants", "shoes", "drugs"};
			for (int i = 0; i < bag14.length; i++)
				addToBag(bag14[i]);
		}
		
		else if (newthreat > 2)
		{
			String bag12[] = {"shirt", "pants", "shoes", "alcohol"};
			for (int i = 0; i < bag12.length; i++)
				addToBag(bag12[i]);
		}
	}
	
	public String[] getCarryOn()
	{
		return carryOn;
	}
	
	public String[] getBag()
	{
		String[] Bag = (String[])new String[numOfBagEntries];
		int index = 0;
			
		Node currentNode = firstNode;
		while ((index < numOfBagEntries) && (currentNode != null)) 
		{
			Bag[index] = currentNode.data;		
			currentNode = currentNode.next;
			index++;
		}
		return Bag;
	}
	
	public String[] showBag()
	{
		String[] Bag = (String[])new String[numOfBagEntries];
		int index = 0;
			
		Node currentNode = firstNode;
		while ((index < numOfBagEntries) && (currentNode != null)) 
		{
			Bag[index] = currentNode.data;		
			currentNode = currentNode.next;
			index++;
		}
		return Bag;
	}
	
	public String[] removeBag()
	{
		String[] result = (String[])new String[numOfBagEntries];
		int index = 0;
		
		Node currentNode = firstNode;
		while ((index < numOfBagEntries) && (currentNode != null)) 
		{
			result[index] = currentNode.data;
			currentNode.data = null;
			currentNode = currentNode.next;
			index++;
		}

		return result;
	}
	
	public void removeBomb()
	{
		for (int i = 0; i < carryOn.length; i++)
		{
			if (carryOn[i].equalsIgnoreCase("bombs"))
				carryOn[i] = null;
		}
		numOfCarryOnEntries--;
	}
	
	public void removeGun()
	{
		for (int i = 0; i < carryOn.length; i++)
		{
			if (carryOn[i].equalsIgnoreCase("guns"))
				carryOn[i] = null;
		}
		numOfCarryOnEntries--;
	}
	
	public void removeDrugs()
	{
		for (int i = 0; i < carryOn.length; i++)
		{
			if (carryOn[i].equalsIgnoreCase("drugs"))
				carryOn[i] = null;
		}
		numOfCarryOnEntries--;
	}
	
	private class Node 
	{
		private String data;
		private Node next;

		private Node(String dataPortion) 
		{
			this(dataPortion, null);
		}

		private Node(String dataPortion, Node nextNode) 
		{
			data = dataPortion;
			next = nextNode;
		}
	}
}
