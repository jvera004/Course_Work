package Game_Mechanics;

public class Node {
    private int x;
    private int y;
    private boolean hitOrMiss;
    private Node next;
    
    public Node(int xCol, int yRow, boolean hitOrMissFlag){
        x = xCol;
        y = yRow;
        hitOrMiss = hitOrMissFlag;
        next = null;
    }
    
    public Node(int x, int y, boolean hitOrMiss, Node next){

        this.hitOrMiss = hitOrMiss;
        this.next = next;
    }
    
    public Node getNext(){
        return next;
    }

    public boolean getHitOrMiss(){
        return hitOrMiss;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    @Override
    public String toString(){
        return  "Coordinates: (" + x + "," + y + ")\tHit Successful: " + hitOrMiss + "\n";
    }
}
