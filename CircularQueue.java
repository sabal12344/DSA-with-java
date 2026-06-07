import java.util.Scanner;
public class CircularQueue{
    int front = -1;
    int rear = -1;
    int []queue = new int [4];

    boolean isFull(){
        return (rear == front && rear!=-1);
    }

    boolean isEmpty(){
        return (front ==-1);
    }

     void dequeue(){
        if(isEmpty()){
             System.out.println("The queue is empty.");
            
        }
        else{           

            System.out.println(queue[front]+" is dequeued.");
            queue[front]=0;

            if(front==rear){
                front =  rear = -1;
            }
            else
            front = (front+1)%queue.length;


        }


    }
    void enqueue(int d){
        if(!isFull()){
            if(front==-1) {
                front++;
                rear++;}               
           
                queue[rear]=d;
                rear = (rear +1)%queue.length;
                
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
       CircularQueue cirq = new CircularQueue();
        while (true){
             System.out.print("\n\nEnter your choice : ");
             int choice = sc.nextInt();
             

             switch(choice){
                case 1:{
                    System.out.print("Enter an integer : ");
                    int d = sc.nextInt();
                    cirq.enqueue(d);
                    break;
                }

                case 2:{
                    cirq.dequeue();
                    break;
                }

                case 3:{
                    cirq.peek();
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
