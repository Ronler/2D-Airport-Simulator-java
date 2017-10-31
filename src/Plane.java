

import java.awt.Image;
import java.util.Hashtable;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Plane extends Plane2
{
	private String plane = "plane.png";
	private int x;
	private int y;
	private Image image;
	protected Stack<String[]> cargo1;
	private Hashtable<Integer, String[]> storage;
	
	public Plane()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource(plane));
		image = ii.getImage().getScaledInstance(100, 100, 0);
		x = 20;
		y = 60;
		
		storage = new Hashtable<Integer, String[]>();
		
		Stack<String[]> tempStack = new Stack<String[]>();
		cargo1 = tempStack;
	}
		
	public void addToPlane(String[] carry, String name)
	{
		int code = name.hashCode();
		storage.put(code, carry);
	}
	
	public String showCarry(String name)
	{	
		int code = name.hashCode();
		String str1 = "";
		String[] str = storage.get(code);
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
	
	public String showTheBag(String[] stuff)
	{
		String show = "";
		for (int i = 0; i < stuff.length; i++)
		{
			if (stuff[0] == null)
				break;
			else
				show += "\n" + stuff[i];	
		}	
		return show;
	}

}
