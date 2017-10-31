

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class Security extends WaitLine
{
	private WaitLine line;
	
	public boolean checkCarryOn(Passenger person)
	{
		
		String[] bag = person.getCarryOn();
		Boolean found = false;
	
		if (bag != null)
		{
			for (int i = 0; i < bag.length; i++)
			{	
				if(bag[i] == "guns" || bag[i] == "bombs" || bag[i] == "drugs")
					found = true;
			}	
		}
		return found;
	}
	
	public boolean checkCheckIn(Passenger peep)
	{
		String[] bag = peep.getBag();
		Boolean found = false;
	
		if (bag != null)
		{
			for (int i = 0; i < bag.length; i++)
			{	
				if(bag[i] == "guns" || bag[i] == "bombs" || bag[i] == "drugs")
					found = true;
			}
		}
		return found;
	}
	
	public void goBack()
	{
		JOptionPane.showMessageDialog(null, "Can't go that way!");
	}
	
	public String whatsInTheBag(Passenger person)
	{
		String[] bag = person.getBag();
		String show = "";
		
		if (bag[0] == null)
			return null;
		
		for (int i = 0; i < bag.length; i++)
		{	
			if (bag[i] == null)
				break;
			else
				show += "\n" + bag[i];	
		}
		return show;
	}
	
	public String whatsInTheCarryOn(Passenger person)
	{
		String[] carryOn = person.getCarryOn();
		String show = "";
		
		if (carryOn[0] == "")
			return null;
		
		for (int i = 0; i < carryOn.length; i++)
		{	
			if (carryOn[i] == null)
				break;
			else
				show += "\n" + carryOn[i];	
		}
		return show;
	}
	
	public String whatWasIt(Passenger dude) 
	{
		String[] carry = dude.getCarryOn();
		String something = "";
		
		for (int i = 0; i < carry.length; i++)
		{
			if (carry[i] == "guns" || carry[i] == "bombs" || carry[i] == "drugs")
				something = carry[i];
		}
		return something;
	}
	
	public String removeThreat(Passenger dude)
	{
		String[] carry = dude.getCarryOn();
		String threat = "";
		
		for (int i = 0; i < carry.length; i++)
		{
			if (carry[i] == "guns")
				threat = carry[i];
			
			else if (carry[i] == "bombs")
				threat = carry[i];
			
			else if (carry[i] == "drugs")
				threat = carry[i];
		}
		return threat;
	}
	
	public boolean simulate()
	{
		line = new WaitLine();
		line.enqueue(1);
		line.enqueue(2);
		line.enqueue(3);
		line.enqueue(4);
		line.enqueue(5);
		Timer timer = new Timer();
		MyTask t = new MyTask();
		timer.schedule(t, 0, 2000);
		boolean done = false;
		if (isEmpty())
			done = true;
		
		return done;
	}
	
	class MyTask extends TimerTask 
	{
		private int times = 0;
	    public void run()
	    {
	    	times++;
	    	if (line.getFront() != null && times <= 5)
			{
	    		JOptionPane.showMessageDialog(null, "Passenger " + line.dequeue() + " has been searched.");
			}
	    }
		
	}
}
