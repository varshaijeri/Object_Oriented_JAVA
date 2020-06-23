import java.util.*;
class RotateCommand extends Command {
  private Vector itemList;
  private Vector itemListNew;
  public RotateCommand () {
    itemList = new Vector();
    itemList = (Vector)model.getSelectedItemList().clone();
  }
  public Enumeration getItems() {
    return itemList.elements();
  }
  public Vector getItemList(){
    return itemList;
  }
  public boolean undo() {
    model.update(itemList);
    return true;
  }
  public void setItemListNew(Vector v){
    itemListNew = (Vector)v.clone();
  }
  public boolean redo() {
    model.update(itemListNew);
    return true;
  }
  public void execute() {
  }
}