import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private final ArrayList<PaintPoint> _points;
	
	public PaintPanel() {
		_points = new ArrayList<>();
		
		MouseAdapter adapter = new MouseAdapter() {
			@Override
		    public void mouseDragged(MouseEvent e){
				PaintPoint point = new PaintPoint(e.getX(), e.getY(),
						PaintPoint.SQUARE_SHAPE);
				_points.add(point);
				repaint();
			}
		};
		
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (PaintPoint point : _points) {
			point.draw(g);
		}
	}
}