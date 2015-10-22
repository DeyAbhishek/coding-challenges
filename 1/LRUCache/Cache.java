public class Node{
    public String pageNumber;
    public String pageContent;
    public Node prev;
    public Node next;
}

public Class Cache{
    private int size;
    private int count;
    private HashMap<String, Node> map;
    private Node head, tail;

    public Cache(int size){
        this.size = size;
        count = 0;
        map = new HashMap<String, Node>();
        head = null;
        tail = null;
    }
    
    public String getContent(String pageNumber){
        if(!map.containsKey(pageNumber)){
            return null;
        }
        Node node = map.get(pageNumber);
        remove(node);
        attachFirst(node);
        return node.pageContent;
    }
    
    public void insertContent(String pageNumber, String pageContent){
        count++;
        if(count == 1){
            Node node = new Node();
            node.pageNumber = pageNumber; 
            node.pageContent = pageContent;
            node.prev = null;
            node.next = null;
            head = node;
            tail = node;
            map.put(pageNumber, node);
            return;
        }
        
        if(count == 2){
            //TODO
        }
        
        //TODO
    }
    
    private void remove(Node node){
        if(node.pageNumber == tail.pageNumber){
            node.prev.next = null;
            return;
        } 
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void attachFirst(Node node){
        node.next = head;
        node.prev = null;
        head = node;
    }    
}
