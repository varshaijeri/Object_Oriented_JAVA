
import java.awt.*;
public class Line extends Item {
	private Point point1;
	private Point point2;
	private int[] pts = new int[6];
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	public Line(Point point1) {
		this.point1 = point1;
	}
	public Line() {
	}
	public boolean includes(Point point) {
		return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0));
	}
	public void render() {
		uiContext.draw(this);
	}
	public void setPoint1(Point point) {
		point1 = point;
	}
	public void setPoint2(Point point) {
		point2 = point;
	}
	public void computeLocation(Point p){
		pts[0]=p.x - point1.x;
		pts[1]=p.y-point1.y;
		pts[2]=p.x - point2.x;
		pts[3]=p.y-point2.y;
	}
	public void moveTo(Point p){
		point1.setLocation(p.x - pts[0],p.y-pts[1]);
		point2.setLocation(p.x - pts[2],p.y-pts[3]);
	}
	
	public void rotateClockwise(Point p)
	{
		point1.setLocation(-1*pts[0],pts[1]);
		point1.setLocation(-1*pts[2],pts[3]);
	}
	public Point getPoint1() {
		return point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public String toString() {
		return "Line  from " + point1 + " to " + point2;
	}
}

