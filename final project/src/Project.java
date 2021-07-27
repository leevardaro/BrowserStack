import java.awt.*;

import javax.swing.JFrame;
public class Project {

	public static void main(String[] args) {
	JFrame frame = new JFrame("Flappy");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ProjectPanel());
    frame.pack();
    frame.setVisible(true);
 }

	}

}
