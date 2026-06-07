import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo {

    public static void main(String[] args) {

        Random ran = new Random();
        ArrayList<Integer> list = new ArrayList<>();

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

  
        System.out.println("\n\nFirst: " + list.get(0));
        System.out.println("Last: " + list.get(list.size() - 1));

       
        list.add(0, 100);      
        list.add(200);       

        System.out.println("\nAfter adding 100 at beginning and 200 at end:");

        for(Integer num : list){
            System.out.print(num + "----->");
        }
    }
}
