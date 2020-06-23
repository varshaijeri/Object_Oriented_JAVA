
import java.awt.*;
public class Triangle extends Item {
	private Point point1;
	private Point point2;
	private Point point3;
	private int[] pts = new int[6];
	public Triangle(Point point1, Point point2, Point point3) {
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
	public Triangle(Point point1) {
		this.point1 = point1;
	}

	public Triangle() {
	}
	public boolean includes(Point point) {
		return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0) || (distance(point, point3 ) < 10.0));
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
	public void setPoint3(Point point) {
		point3 = point;
	}

	public void computeLocation(Point p){
		pts[0]=p.x - point1.x;
		pts[1]=p.y-point1.y;
		pts[2]=p.x - point2.x;
		pts[3]=p.y-point2.y;
		pts[4]=p.x - point3.x;
		pts[5]=p.y-point3.y;
	}
	public void moveTo(Point p){
		point1.setLocation(p.x - pts[0],p.y-pts[1]);
		point2.setLocation(p.x - pts[2],p.y-pts[3]);
		point3.setLocation(p.x - pts[4],p.y-pts[5]);
	}
	
	public void rotateClockwise()
	{
		/*point1.setLocation(pts[1],-1*pts[0]);
		point1.setLocation(pts[3],-1*pts[2]);
		point1.setLocation(pts[5],-1*pts[4]);*/
		
		point1.setLocation(point1.y,-point1.x);
		point1.setLocation(point2.y,-point2.x);
		point1.setLocation(point3.y,-point3.x);
		
	}

	public Point getPoint1() {
		return point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public Point getPoint3() {
		return point3;
	}

	public String toString() {
		return "Triangle  between three points "+ point1+ " | "+point2+" | "+point3;
	}
}

