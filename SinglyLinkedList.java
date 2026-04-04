import java.util.Random;

class Node{
    int data;
    Node next;
    Node(int data){
         this.data = data;
         next = null;
    }
    @Override
    public String toString(){
        return data + " bhako node";
    }
}
public class SinglyLinkedList{
    Node head;
    Node tail;
    int size;
    SinglyLinkedList(){
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
        Node cur = head;
      
     
        
        while(cur!= null){
            System.out.print(cur+"----->");
            cur = cur.next;
          
        }
    
        


    }
    public static void main(String [] args){
        Random ran = new Random();
        SinglyLinkedList sll = new SinglyLinkedList();
        for(int i =1; i<15; i++){
            sll.addNode(ran.nextInt(i*10));

        
        }
        sll.traverse();

        sll.deleteNode(9);
        sll.traverse();


    }

}
