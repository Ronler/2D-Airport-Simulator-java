import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class flyAway
{
	private String plane = "plane1.png";
	private int x;
	private int y;
	private Image image;
	
	public flyAway()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource(plane));
		image = ii.getImage();	
		x = 300;
		y = 1000;
	}
	
	public void FLY()
	{ 
		if (y == 0)
			JOptionPane.showMessageDialog(null, "See ya later!!");
		y--;
	}
	
	public int getX()
	{ return x; }
	
	public int getY()
	{ return y; }
	
	public Image getImage()
	{ return image; }
}

	
	
