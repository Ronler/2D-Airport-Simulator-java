

import java.util.Random;

public class TicketBooth 
{
	// give passenger terminal number and number within queue
	private int terminal;
	
	public TicketBooth()
	{
		Random random = new Random();
		setTerminal(random.nextInt(4) + 1);
	}
	
	public TicketBooth(int term)
	{
		terminal = term;
	}

	public int getTerminal() 
	{
		return terminal;
	}

	public void setTerminal(int terminal) 
	{
		this.terminal = terminal;
	}
}
