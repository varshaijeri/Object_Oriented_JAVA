
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RotateButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  private RotateCommand rotateCommand;
  private UndoManager undoManager;
  private Point pointStart = null; 
  private Vector itemList;
  private Model model;
 
  public RotateButton(UndoManager undoManager, View jFrame, JPanel jPanel,Model jModel) {
    super("Rotate");
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
	model = jModel;
	this.undoManager = undoManager;
    mouseHandler = new MouseHandler();
  }
  public Enumeration getItems() {
    return itemList.elements();
  }
  public Point getPointStart(){
     return pointStart;
  }
  public void actionPerformed(ActionEvent event) {
	rotateCommand = new RotateCommand();
	itemList = new Vector();
	itemList = (Vector)model.getSelectedItemList().clone();
	drawingPanel.addMouseListener(mouseHandler);
	drawingPanel.addMouseMotionListener(mouseHandler);
  }
  private class MouseHandler extends MouseAdapter {
    public void mousePressed(MouseEvent event) {
	    /*pointStart = event.getPoint();
		Enumeration enumeration1 = getItems();
		while (enumeration1.hasMoreElements()){ 
          ((Item)(enumeration1.nextElement())).computeLocation(pointStart);
	    }
        undoManager.beginCommand(rotateCommand);
		view.refresh();*/
    	undoManager.beginCommand(rotateCommand);
    	Enumeration enumeration1 = getItems();
		while (enumeration1.hasMoreElements()){
          ((Item)(enumeration1.nextElement())).rotateClockwise();
	    }
		model.update(itemList);
		rotateCommand.setItemListNew(itemList);
		undoManager.endCommand(rotateCommand);
		view.refresh();
    } 
  }
	/*public void mouseReleased(MouseEvent event){
        drawingPanel.removeMouseListener(this);
        Enumeration enumeration1 = getItems();
		while (enumeration1.hasMoreElements()){
          ((Item)(enumeration1.nextElement())).rotateClockwise(event.getPoint());
	    }
		//view.refresh();
		model.update(itemList);
		pointStart = null;
		rotateCommand.setItemListNew(itemList);
		undoManager.endCommand(rotateCommand);
		view.refresh();
		}
	public void mouseDragged(MouseEvent event){
	   
		Enumeration enumeration1 = getItems();
		while (enumeration1.hasMoreElements()){
          ((Item)(enumeration1.nextElement())).rotateClockwise(event.getPoint());
	    }
		view.refresh();
	}
   }  */
}
