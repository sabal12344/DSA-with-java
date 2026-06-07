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

public class DoublyCircularLinkedList{

    Node head;
    Node tail;
    int size;

    DoublyCircularLinkedList(){
        head = tail = null;
        size = 0;
    }

    void addNode(int data){
        Node temp = new Node(data);

        if(head == null){
            head = tail = temp;

            head.next = head;
            head.prev = head;
        }
        else{
            temp.prev = tail;
            temp.next = head;

            tail.next = temp;
            head.prev = temp;

            tail = temp;
        }
    }

    void deleteNode(int data){

        if(head == null){
            System.out.println("\n\nThe item does not exist.\n\n");
            return;
        }

        Node cur = head;

        do{
            if(cur.data == data){

                if(head == tail){
                    head = tail = null;
                }
                else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;

                    if(cur == head)
                        head = head.next;

                    if(cur == tail)
                        tail = tail.prev;
                }

                return;
            }

            cur = cur.next;

        }while(cur != head);

        System.out.println("\n\nThe item does not exist.\n\n");
    }

    void traverse(){
        if(tail == null)
            return;

        Node cur = tail;

        do{
            System.out.print(cur.data + "----->");
            cur = cur.prev;
        }while(cur != tail);
    }

    public static void main(String[] args){

        Random ran = new Random();

        DoublyCircularLinkedList sll = new DoublyCircularLinkedList();

        for(int i = 1; i < 15; i++){
            sll.addNode(ran.nextInt(i * 10));
        }

        sll.traverse();

        System.out.println();

        sll.deleteNode(9);

        sll.traverse();
    }
}
