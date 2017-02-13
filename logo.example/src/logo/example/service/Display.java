package logo.example.service;

import javax.swing.JFrame;

import org.eclipse.emf.ecore.EObject;


public class Display {
	public static void show(EObject turtle) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Logo example");
		frame.setVisible(true);
		frame.add(new Board(turtle));
	}
}
