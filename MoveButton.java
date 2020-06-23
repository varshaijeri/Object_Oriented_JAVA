
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoveButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  private MoveCommand moveCommand;
  private UndoManager undoManager;
  private Point pointStart = null; 
  private Vector itemList;
  private Model model;
 
  public MoveButton(UndoManager undoManager, View jFrame, JPanel jPanel,Model jModel) {
    super("Move");
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
    moveCommand = new MoveCommand();
	itemList = new Vector();
	itemList = (Vector)model.getSelectedItemList().clone();
	drawingPanel.addMouseListener(mouseHandler);
	drawingPanel.addMouseMotionListener(mouseHandler);
  }
  private class MouseHandler extends MouseAdapter {
    public void mousePressed(MouseEvent event) {
	    pointStart = event.getPoint();
		Enumeration enumeration1 = getItems();
		while (enumeration1.hasMoreElements()){ 
          ((Item)(enumeration1.nextElement())).computeLocation(pointStart);
	    }
        undoManager.beginCommand(moveCommand);
		view.refresh();
    } 
	public void mouseReleased(MouseEvent event){
        drawingPanel.removeMouseListener(this);
		model.update(itemList);
		pointStart = null;
		moveCommand.setItemListNew(itemList);
		undoManager.endCommand(moveCommand);
		view.refresh();
		}
	public void mouseDragged(MouseEvent event){
	   
		Enumeration enumeration1 = getItems();
		while (enumeration1.hasMoreElements()){
          ((Item)(enumeration1.nextElement())).moveTo(event.getPoint());
	    }
		view.refresh();
	}
   }  
}
