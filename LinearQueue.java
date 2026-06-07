import java.util.Scanner;
public class LinearQueue{
    int front = -1;
    int rear = -1;
    int []queue = new int [5];

    boolean isFull(){
        return (rear == queue.length -1);
    }

    boolean isEmpty(){
        return (rear < front||(front ==-1));
    }

     void dequeue(){
        if(isEmpty()){
             System.out.println("The queue is empty.");
            
        }
        else{           

            System.out.println(queue[front]+" is dequeued.");
            queue[front]=0;
            front++;
        }


    }
    void enqueue(int d){
        if(!isFull()){
            if(front==-1){
                front++;
                rear++;

            }
            else{
                rear++;
                
            }
            queue[rear]=d;

        }
        else{
            System.out.println("The queue is full.");
        }

    }

    void peek(){
        if(!isEmpty()){
            for(int i = front; i<=rear; i++){
                System.out.print(queue[i]+" ");
            }
        }
        else{
            System.out.println("Your queue is empty");
        }

    }

    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
       
        System.out.println("1.Enqueue\n2.Dequeue\n3.Display\n4.Exit");
       LinearQueue linq = new LinearQueue();
        while (true){
             System.out.print("\n\nEnter your choice : ");
             int choice = sc.nextInt();
             

             switch(choice){
                case 1:{
                    System.out.print("Enter an integer : ");
                    int d = sc.nextInt();
                    linq.enqueue(d);
                    break;
                }

                case 2:{
                    linq.dequeue();
                    break;
                }

                case 3:{
                    linq.peek();
                    break;
                }

                case 4:{
                    System.out.println("Terminating successfully...");
                    return ;
                }

                default:{
                    System.out.println("Invalid option, press 4 if you want to exit.");
                }


             }


            
        }
    }
   


}
