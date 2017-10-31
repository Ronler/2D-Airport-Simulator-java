

import java.awt.Image;
import java.util.Hashtable;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Plane2 extends Plane3
{
	private String plane = "plane.png";
	private int x;
	private int y;
	private Image image;
	protected Stack<String[]> cargo2;
	private Hashtable<Integer, String[]> storage2;
	
	public Plane2()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource(plane));
		image = ii.getImage().getScaledInstance(100, 100, 0);
		x = 20;
		y = 230;
		storage2 = new Hashtable<Integer, String[]>();
		
		Stack<String[]> tempStack = new Stack<String[]>();
		cargo2 = tempStack;
	}
	
	public void addToPlane2(String[] carry, String name)
	{
		int code = name.hashCode();
		storage2.put(code, carry);
	}
	
	public String showCarry2(String name)
	{	
		int code = name.hashCode();
		String str1 = "";
		String[] str = storage2.get(code);
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
