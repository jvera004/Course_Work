package Game_Mechanics;

public class LinkedList {
    private Node head;
    private int size;
    private int hits;
    private int misses;
    
    public LinkedList(Node h)
    {   head = h;
        size = 1;
    }
    
    public LinkedList()
    {   head = null;
        size = 0;
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }
    
    public Node getHead()
    {   return head;        
    }
    
    public void setHead(Node h)
    {   head = h;        
    }
    
    public int getSize()
    {   return size;        
    }
    
    public void addLast(Node n)
    {   if (size == 0)
            head = n;
        else    
        {    //let's find the last one
            Node tmp = head;
            while (tmp.getNext()!=null)
                tmp = tmp.getNext();
            tmp.setNext(n);
        }
        size++;
    }
    
    public String printList()
    {   Node tmp = head;
        String out = "";
        int counter = 1;
        while (tmp!=null && counter <= size)
        {   
            out += counter + ".) ";
            out += tmp.toString();
            tmp = tmp.getNext();
            counter++;
        }
        return out;
    }

    public double getRatio(){
        Node tmp = head;
        while(tmp != null){
            if(tmp.getHitOrMiss()){
                hits++;
                tmp = tmp.getNext();
            }
            else{
                misses++;
                tmp = tmp.getNext();
            }
        }
        double hitCount = (double)hits/ (double)(hits + misses);
        return hitCount;
    }
}
