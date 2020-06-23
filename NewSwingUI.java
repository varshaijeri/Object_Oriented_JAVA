
import java.awt.Graphics;
public class NewSwingUI implements UIContext {
	private Graphics graphics;
	private static NewSwingUI swingUI;
	private NewSwingUI() {
	}
	public static NewSwingUI getInstance() {
		if (swingUI == null) {
			swingUI = new NewSwingUI();
		}
		return swingUI;
	}
	public  void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	public void draw(Label label) {
		if (label.getStartingPoint() != null) {
			if (label.getText() != null) {
				graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
			}
		}
		int length = graphics.getFontMetrics().stringWidth(label.getText());
		graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
	}
	public void draw(Line line) {
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		if (line.getPoint1() != null) {
			i1 = Math.round((float) (line.getPoint1().getX()));
			i2 = Math.round((float) (line.getPoint1().getY()));
			if (line.getPoint2() != null) {
				i3 = Math.round((float) (line.getPoint2().getX()));
				i4 = Math.round((float) (line.getPoint2().getY()));
			} else {
				i3 = i1;
				i4 = i2;
			}
			graphics.drawLine(i1, i2, i3, i4);
		}
	}
	public void draw(Triangle triangle) {
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;
		int i6 = 0;
		if (triangle.getPoint1() != null) {
			i1 = Math.round((float) (triangle.getPoint1().getX()));
			i2 = Math.round((float) (triangle.getPoint1().getY()));
			if (triangle.getPoint2() != null) {
				i3 = Math.round((float) (triangle.getPoint2().getX()));
				i4 = Math.round((float) (triangle.getPoint2().getY()));
			} else {
				i3 = i1;
				i4 = i2;
			}
			graphics.drawLine(i1, i2, i3, i4);
		}
		if (triangle.getPoint2() != null) {
			if (triangle.getPoint3() != null) {
				i5 = Math.round((float) (triangle.getPoint3().getX()));
				i6 = Math.round((float) (triangle.getPoint3().getY()));
			} else {
				i5 = i3;
				i6 = i4;
			}
			graphics.drawLine(i3, i4, i5,i6);
		}
		if (triangle.getPoint3() != null) {
			graphics.drawLine(i1, i2, i5,i6);
		}

	}

	public void draw(Item item) {
		System.out.println( "Cant draw unknown Item \n");
	}
}