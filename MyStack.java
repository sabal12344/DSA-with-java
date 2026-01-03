import java.util.Scanner;
public class MyStack{
     
    int [] stack = new int [100];
    int tos = -1;

    boolean isEmpty(){
        return (tos==-1);
    }

    boolean isFull(){
        return (tos==stack.length-1);

    }
    void pop(){
        if(!isEmpty()){
            System.out.println(stack[tos]+" is popped from the stack.");
            stack[tos]=0;
            tos--;
        }
        else{
            System.out.println("Stack underflow...please exit the program");
        }


    }
    void push(int d){
        if(!isFull()){
            tos++;
            stack[tos]=d;
            System.out.println(stack[tos]+" is pushed to the stack.");

        }
        else{
            System.out.println("Stack overflow...please exit.");
        }

    }

    void peek(){
        if(!isEmpty()){
            
                System.out.print(stack[tos]+" is on top.");
            
        }
        else{
            System.out.println("Your stack is empty");
        }

    }
    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
       
        System.out.println("1.Push\n2.Pop\n3.Peek\n4.Exit");
       MyStack stk = new MyStack();
        while (true){
             System.out.print("\n\nEnter your choice : ");
             int choice = sc.nextInt();
             

             switch(choice){
                case 1:{
                    System.out.print("Enter an integer : ");
                    int d = sc.nextInt();
                    stk.push(d);
                    break;
                }

                case 2:{
                    stk.pop();
                    break;
                }

                case 3:{
                    stk.peek();
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
