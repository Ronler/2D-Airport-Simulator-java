

import java.awt.Image;
import java.util.Hashtable;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Plane3 extends Plane4
{
	private String plane = "plane.png";
	private int x;
	private int y;
	private Image image;
	protected Stack<String[]> cargo3;
	private Hashtable<Integer, String[]> storage3;
	
	public Plane3()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource(plane));
		image = ii.getImage().getScaledInstance(100, 100, 0);
		x = 20;
		y = 400;
		storage3 = new Hashtable<Integer, String[]>();
		
		Stack<String[]> tempStack = new Stack<String[]>();
		cargo3 = tempStack;
	}
	
	public void addToPlane3(String[] carry, String name)
	{
		int code = name.hashCode();
		storage3.put(code, carry);
	}
	
	public String showCarry3(String name)
	{	
		int code = name.hashCode();
		String str1 = "";
		String[] str = storage3.get(code);
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
