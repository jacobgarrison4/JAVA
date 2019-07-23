import java.awt.Graphics;

public class PaintPoint {
	public static final int CIRCLE_SHAPE = 0;
	public static final int SQUARE_SHAPE = 1;
	
	private static final int SIZE = 10;
	
	private final int _x;
	private final int _y;
	private final int _shape;
	
	public PaintPoint(int x, int y, int shape) {
		_x = x;
		_y = y;
		_shape = shape;
	}
	
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public int getShape() {
		return _shape;
	}
	
	public void draw(Graphics g) {
		switch (_shape) {
		case CIRCLE_SHAPE:
			g.fillOval(_x, _y, SIZE, SIZE);
			break;
		case SQUARE_SHAPE:
			g.fillRect(_x, _y, SIZE, SIZE);
			break;
		}
	}
}