import java.util.LinkedList;
import java.util.Random;

public class LinkedListDemo {

    public static void main(String[] args) {

        Random ran = new Random();
        LinkedList<Integer> list = new LinkedList<>();

       
        for(int i = 1; i < 15; i++){
            list.add(ran.nextInt(i * 10));
        }

       
        System.out.println("Original List:");
        for(Integer num : list){
            System.out.print(num + "----->");
        }

       
        list.remove(Integer.valueOf(9));

        System.out.println("\n\nAfter deleting 9:");

        for(Integer num : list){
            System.out.print(num + "----->");
        }

        
        System.out.println("\n\nFirst: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        
        list.addFirst(100);
        list.addLast(200);

        System.out.println("\nAfter addFirst and addLast:");

        for(Integer num : list){
            System.out.print(num + "----->");
        }
    }
}
