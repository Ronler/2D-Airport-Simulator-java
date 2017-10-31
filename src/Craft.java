import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Craft extends Plane
{
	private String craft = "Ash.png";
	private int dx;
	private int dy;
	private int x;
	private int y;
	private Image image;
	private Passenger dude;
	private int tries = 0;
	private int planeNum = 0;
	private TicketBooth ticket;
	
	public Craft()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
		image = ii.getImage().getScaledInstance(35, 35, 0);
		dude = new Passenger("Cashmoney");
		x = 1200;
		y = 350;
		dude.addBag();
		dude.addCarryOn();
		ticket = new TicketBooth(0);
	}
	
	public void move()
	{
		if (x == 760)
		{
			// You can't go around! (both ways)
			if ((y > 420) || (y < 300))
			{
				dude.goBack();
				dx = 0;
				dy = 0;
				x = x + 5;
			}
		}
		
		if (x == 705)
		{
			// You can't go around! (both ways)
			if ((y > 420) || (y < 300))
			{
				dude.goBack();
				dx = 0;
				dy = 0;
				x--;
			}
			
		}
		
		// got to wait in line
		if (x == 760)
		{
			x = x + 10;
			dx = 0;
			dy = 0;
			//if (dude.simulate() == true);
			//{
				while ((dude.simulate() == false) && (x <= 770 && x > 750))
				{
					dx = 0;
					dy = 0;
				}
				
				x = x - 20;
				dx = 0;
				dy = 0;
			//}
			
		}
		
		// Security check for carry-on bag
		if (x == 710)
		{
			JOptionPane.showMessageDialog(null, "About time..");
			String checkIn = dude.whatsInTheBag(dude);	
				
			if ((y < 420) && (y > 300) && checkIn != null)
			{	
				JOptionPane.showMessageDialog(null, "Check your bag in first idiot...");
				x = x + 100;
				dx = 0;
				dy = 0;
			}
			
			else if ((y < 420) && (y > 300) && ticket.getTerminal() == 0)
			{
				JOptionPane.showMessageDialog(null, "You need a ticket to get through.");
				x = x + 20;
				dx = 0;
				dy = 0;
			}
			
			else if ((y < 420) && (y > 300) && checkIn == null)
			{
					// checks the carry-on bag for weapons, drugs, etc.
					boolean found = dude.checkCarryOn(dude);
				
					if (found)
					{
						if (tries == 2)
						{
							String threat = dude.whatWasIt(dude);
							JOptionPane.showMessageDialog(null, "You had " + threat + " in your bag!!\nGameOver!");
							y = y-400;
							dx = 0;
							dy = 0;
						}
										
						else if (tries <= 1)
						{
							JOptionPane.showMessageDialog(null, "Search the bag.\nMight have something weird.");
							tries++;
							dx = 0;
							dy = 0;
							x++;
						}
					}
				
					if (!found)
					{
						JOptionPane.showMessageDialog(null, "You're good.\nMove along.");
						dx = 0;
						dy = 0;
						x = x - 100;
					}				
				}
			}
		
		// Check-in bag station
		if ((y == 50) && (x <= 1150 && x >= 900))
		{
			String bagCheck = dude.whatsInTheBag(dude);
			planeNum = ticket.getTerminal();
			
			if (planeNum == 0)
			{
				JOptionPane.showMessageDialog(null, "You need a ticket first so we can put the bag on the right plane.");
				dx = 0;
				dy = 0;
				y++;	
			}
			
			// checks to see if you have a bag to check in
			if (bagCheck == null)
			{
				JOptionPane.showMessageDialog(null, "You don't have a bag man.");
				dx = 0;
				dy = 0;
				y++;		
			}
			
			else if (planeNum != 0)
			{
				// checks in the bag and the bag gets scanned for weapons, drugs, etc.				
				if (planeNum == 1)
				{
					JOptionPane.showMessageDialog(null, "Checked in.\nThank you!");
					String[] stuff = dude.removeBag();
					cargo1.push(stuff);
					dx = 0;
					dy = 0;
					y++;
				}
				
				if (planeNum == 2)
				{
					JOptionPane.showMessageDialog(null, "Checked in.\nThank you!");
					String[] stuff = dude.removeBag();
					cargo2.push(stuff);
					dx = 0;
					dy = 0;
					y++;
				}
				
				if (planeNum == 3)
				{
					JOptionPane.showMessageDialog(null, "Checked in.\nThank you!");
					String[] stuff = dude.removeBag();
					cargo3.push(stuff);
					dx = 0;
					dy = 0;
					y++;
				}
				
				if (planeNum == 4)
				{
					JOptionPane.showMessageDialog(null, "Checked in.\nThank you!");
					String[] stuff = dude.removeBag();
					cargo4.push(stuff);
					dx = 0;
					dy = 0;
					y++;
				}
				
			}
		}
		
		if (x == 1260)
		{
			JOptionPane.showMessageDialog(null, "You can't leave! \nMwahaha");
			dx = 0;
			dy = 0;
			x--;
		}
		
		// terminal 1
		if (x == 131 && (y >= 50 && y <= 170))
		{
			int terminal = ticket.getTerminal();
			if (terminal == 1)
			{
				addToPlane(dude.getCarryOn(), dude.getName());
				dx = 0;
				dy = 0;
				JOptionPane.showMessageDialog(null, "Getting on a plane! yyeeeaaaa!");
				x = x - 250;
				JOptionPane.showMessageDialog(null, "You hashed your carry-on to the plane.");
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Wrong plane.");
				dx = 0;
				dy = 0;
				x++;
			}
		}
		
		// terminal 2
		if (x == 131 && (y >= 210 && y <= 340))
		{
			int terminal = ticket.getTerminal();
			if (terminal == 2)
			{
				addToPlane2(dude.getCarryOn(), dude.getName());
				dx = 0;
				dy = 0;
				JOptionPane.showMessageDialog(null, "Getting on a plane! yyeeeaaaa!");
				x = x - 250;	
				JOptionPane.showMessageDialog(null, "You hashed your carry-on to the plane.");
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Wrong plane.");
				dx = 0;
				dy = 0;
				x++;
			}
		}
		
		// terminal 3
		if (x == 131 && (y >= 380 && y <= 510))
		{
			int terminal = ticket.getTerminal();
			if (terminal == 3)
			{
				addToPlane3(dude.getCarryOn(), dude.getName());
				dx = 0;
				dy = 0;
				JOptionPane.showMessageDialog(null, "Getting on a plane! yyeeeaaaa!");
				x = x - 250;	
				JOptionPane.showMessageDialog(null, "You hashed your carry-on to the plane.");
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Wrong plane.");
				dx = 0;
				dy = 0;
				x++;
			}
		}
		
		// terminal 4
		if (x == 131 && (y >= 550 && y <= 665))
		{
			int terminal = ticket.getTerminal();
			if (terminal == 4)
			{
				addToPlane4(dude.getCarryOn(), dude.getName());
				dx = 0;
				dy = 0;
				JOptionPane.showMessageDialog(null, "Getting on a plane! yyeeeaaaa!");
				x = x - 250;
				JOptionPane.showMessageDialog(null, "You hashed your carry-on to the plane.");
					
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Wrong plane.");
				dx = 0;
				dy = 0;
				x++;
			}
		}
		
		// Ticket booth
		if ((y == 600) && (x <= 1150 && x >= 900))
		{			
			if (ticket.getTerminal() == 0)
			{
				ticket = new TicketBooth();
				JOptionPane.showMessageDialog(null, "Here is your ticket.\nYou are in terminal: " + ticket.getTerminal());
			}
			else 
				JOptionPane.showMessageDialog(null, "You have a ticket already dummy.");
			
			dx = 0;
			dy = 0;
			y--;		
			
		}
		
		if (x >= 1 && y >= 1)
		{
			x += dx;
			y += dy;
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public int getTerm()
	{
		return ticket.getTerminal();
	}
	
	public Passenger getPass()
	{
		return dude;
	}
	
	public void doNotMove(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == e.getKeyCode())
		{
			dx = 0;
			dy = 0;
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
		{
			dx = -1;			
		}
		
		if (key == KeyEvent.VK_RIGHT)
		{
			dx = 1;
		}
		
		if (key == KeyEvent.VK_UP)
		{
			dy = -1;
		}
		
		if (key == KeyEvent.VK_DOWN)
		{
			dy = 1;
		}
		
		if (key == KeyEvent.VK_B)
		{	
			String show = dude.whatsInTheBag(dude);		
			if (show == null)
				JOptionPane.showMessageDialog(null, "You don't have a bag.");
			else
				JOptionPane.showMessageDialog(null, "This is in your bag: " + show);
		}
		
		if (key == KeyEvent.VK_N)
		{
			JOptionPane.showMessageDialog(null, "Name: " + dude.getName());	
		}
		
		if (key == KeyEvent.VK_C)
		{
			String show = dude.whatsInTheCarryOn(dude);
			JOptionPane.showMessageDialog(null, "Carry-On bag: " + show);
		}
		
		if (key == KeyEvent.VK_R)			
		{
			String threat = dude.removeThreat(dude);
			
			if (threat == "")
				JOptionPane.showMessageDialog(null, "You're clean buddy.");
			
			else if (threat == "bombs")
			{
				JOptionPane.showMessageDialog(null, "Shoot I have bombs.\nDumping bomb somewhere...");
				dude.removeBomb();
			}
			
			else if (threat == "gun")
			{
				JOptionPane.showMessageDialog(null, "Crap I have guns in my carry-on.\nGetting rid of them...");
				dude.removeGun();
			}
			
			else if (threat == "drugs")
			{
				JOptionPane.showMessageDialog(null, "I might have some droogs...\nGot to get rid of them.");
				dude.removeDrugs();
			}
		}
		
		if (key == KeyEvent.VK_G)
		{
			JOptionPane.showMessageDialog(null, "Crap I have guns in my carry-on.\nGetting rid of them...");
			dude.removeGun();
		}
		
		if (key == KeyEvent.VK_D)
		{
			JOptionPane.showMessageDialog(null, "I might have some droogs...\nGot to get rid of them.");
			dude.removeDrugs();
		}
		
		if (key == KeyEvent.VK_T)
		{
			if (ticket.getTerminal() != 0)
				JOptionPane.showMessageDialog(null, "Your terminal is: " + (ticket.getTerminal()));
			else 
				JOptionPane.showMessageDialog(null, "You dont have a ticket yet.");
		}
		
		if (key == KeyEvent.VK_P)
		{
			String show = "";
			if (planeNum == 1)
			{
				String[] myBag = cargo1.peek(); 
				show = showTheBag(myBag);
			}
			
			if (planeNum == 2)
			{
				String[] myBag2 = cargo2.peek(); 
				show = showTheBag(myBag2);	
			}
			
			if (planeNum == 3)
			{
				String[] myBag3 = cargo3.peek(); 
				show = showTheBag(myBag3);	
			}
			
			if (planeNum == 4)
			{
				String[] myBag4 = cargo4.peek();
				show = showTheBag(myBag4);
			}
			
			JOptionPane.showMessageDialog(null, "Plane " + planeNum + " contains my bag of: \n{" + show + "\n}");
		}
		
		if (key == KeyEvent.VK_S)
		{
			JOptionPane.showMessageDialog(null, "Sorting carry-on bag because i want to.") ;
			Arrays.sort(dude.getCarryOn());
		}
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
		{
			dx = 0;
		}
		
		if (key == KeyEvent.VK_RIGHT)
		{
			dx = 0;
		}
		
		if (key == KeyEvent.VK_UP)
		{
			dy = 0;
		}
		
		if (key == KeyEvent.VK_DOWN)
		{
			dy = 0;
		}
	}
}
