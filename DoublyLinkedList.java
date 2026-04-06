import java.util.Random;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
         this.data = data;
         next = null;
         prev = null;
    }
    
}
public class DoublyLinkedList{
    Node head;
    Node tail;
    int size;
    DoublyLinkedList(){
        head = tail = null;
        size = 0;

    }

    void addNode(int data){
        Node temp = new Node(data);
        if(head==null){
            tail = head = temp;

        }
        else{
            tail.next = temp;
           temp.prev = tail;
            tail = temp;

        }

    }

    void deleteNode(int data){
        Node cur = head;
        

        while(cur!=null && cur.next!=null){
            if(cur.next.data == data){
                cur.next = cur.next.next;
                return;
                
            }
            cur = cur.next;

        }
        System.out.println("\n\nThe item does not exist.\n\n");


    }

    void traverse(){
        Node cur = tail;
      
     
        
        while(cur!= null){
            System.out.print(cur.data + "----->");
            cur = cur.prev;
          
        }  
    }
    public static void main(String [] args){
        Random ran = new Random();
        DoublyLinkedList sll = new DoublyLinkedList();
        for(int i =1; i<15; i++){
            sll.addNode(ran.nextInt(i*10));
        
        }
        sll.traverse();

        sll.deleteNode(9);
        sll.traverse();


    }

}
