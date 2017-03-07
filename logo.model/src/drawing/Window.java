package drawing;

import javax.swing.JFrame;

import vmlogo.Turtle;

public class Window {
	
	JFrame frame;
	
	public Window(Turtle t){
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Logo example");
		frame.setVisible(true);
		frame.add(new Board(t));
	}
}
