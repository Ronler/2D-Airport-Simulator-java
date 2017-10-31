

import java.awt.Image;
import java.util.Hashtable;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Plane4
{
	private String plane = "plane.png";
	private int x;
	private int y;
	private Image image;
	protected Stack<String[]> cargo4;
	private Hashtable<Integer, String[]> storage4;
	
	public Plane4()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource(plane));
		image = ii.getImage().getScaledInstance(100, 100, 0);
		x = 20;
		y = 570;
		storage4 = new Hashtable<Integer, String[]>();
		
		Stack<String[]> tempStack = new Stack<String[]>();
		cargo4 = tempStack;
	}
	
	public void addToPlane4(String[] carry, String name)
	{
		int code = name.hashCode();
		storage4.put(code, carry);
	}
	
	public String showCarry4(String name)
	{	
		int code = name.hashCode();
		String str1 = "";
		String[] str = storage4.get(code);
		for (int i = 0; i < str.length; i++)
		{
			if (str[i] == null)
				break;
			else
				str1 += "\n" + str[i];
		}
		return str1;
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

	public void leave()
	{
		x--;	
	}
}
