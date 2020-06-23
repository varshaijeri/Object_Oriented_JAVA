
import java.awt.*;
public class Label extends Item {
	private Point startingPoint;
	private String text = "";
	private int[] pts = new int[2];
	public Label(Point point) {
		startingPoint = point;
	}
	public void addCharacter(char character) {
		text += character;
	}
	public void removeCharacter() {
		if (text.length() > 0) {
			text = text.substring(0, text.length() - 1);
		}
	}
	public boolean includes(Point point) {
		return distance(point, startingPoint) < 10.0;
	}
	public void render() {
		uiContext.draw(this);
	}
	public void computeLocation(Point p){
		pts[0]=p.x - startingPoint.x;
		pts[1]=p.y-startingPoint.y;
	}
	public void moveTo(Point p){
		startingPoint.setLocation(p.x - pts[0],p.y-pts[0]);
	}
	public String getText() {
		return text;
	}
	public Point getStartingPoint() {
		return startingPoint;
	}
	/*@Override
	public void rotateClockwise(Point p) {
		// TODO Auto-generated method stub
		
	}*/
}