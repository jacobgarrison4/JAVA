import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private final PaintPanel _paintPanel; // The actual part the user can interact with
	
	public MainFrame() {
		super("Hello Wednesday Morning!");
		setLayout(new FlowLayout());
		
		_paintPanel = new PaintPanel();
		_paintPanel.setPreferredSize(new Dimension(400, 400));
		add(_paintPanel);
	}
}