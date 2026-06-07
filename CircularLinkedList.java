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

public class CircularLinkedList{
    Node head;
   Node tail;
    int size;

    CircularLinkedList(){
        head = tail = null;
        size = 0;
    }

    void addNode(int data){
        Node temp = new Node(data);

        if(head == null){
            head = tail = temp;
            tail.next = head;
        }
        else{
            tail.next = temp;
            tail = temp;
            tail.next = head;
        }
size++;
    }

    void deleteNode(int data){

        if(head == null) return;

        if(head.data == data){

            if(head == tail){
                head = tail = null;
            }
            else{
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node cur = head;

        while(cur.next != head){

            if(cur.next.data == data){

                if(cur.next == tail){
                    tail = cur;
                }

                cur.next = cur.next.next;
                tail.next = head;
                return;
            }

            cur = cur.next;
        }

        System.out.println("\n\nIt does not exist.\n\n");
    }

    void traverse(){

        if(head == null) return;

        Node cur = head;

        do{
            System.out.print(cur + "----->");
            cur = cur.next;
        }while(cur != head);
    }

    public static void main(String[] args){

        Random ran = new Random();
        CircularLinkedList cll = new CircularLinkedList();

        for(int i = 1; i < 15; i++){
            cll.addNode(ran.nextInt(i * 10));
        }

        cll.traverse();

        System.out.println();

        cll.deleteNode(9);

        cll.traverse();
    }
}
