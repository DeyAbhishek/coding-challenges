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
        
        if(map.containsKey(pageNumber)){
            Node node = map.get(pageNumber);
            node.pageContent = pagecontent;  //refresh content;
            remove(node);
            attachFront(node);
            map.put(pageNumber, node);
            return;
        }
        count++;
         Node node = new Node();
         node.pageNumber = pageNumber; 
         node.pageContent = pageContent;
        if(count == 1){
            node.prev = null;
            node.next = null;
            head = node;
            tail = node;
            map.put(pageNumber, node);
            return;
        }
        
        attachFront(node);
        map.put(pageNumber, node);
        
        if(count > size){
            map.remove(tail.pageNumber);
            remove(tail);
            count--;
        }
        
    }
    
    private void remove(Node node){
        if(node.pageNumber == tail.pageNumber){
            node.prev.next = null;
            tail = tail.prev;
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
