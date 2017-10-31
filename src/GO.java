

import javax.swing.JFrame;

public class GO extends JFrame 
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GO() 
	{	
        add(new board1());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1365, 725);
        setLocationRelativeTo(null);
        setTitle("Airport Simulator");
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new GO();
    }
}
