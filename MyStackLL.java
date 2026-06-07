import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MyStackLL {

    Node top = null;

    boolean isEmpty() {
        return (top == null);
    }

    boolean isFull() {
        return false; // Linked list stack grows dynamically
    }

    void pop() {
        if (!isEmpty()) {
            System.out.println(top.data + " is popped from the stack.");
            top = top.next;
        } else {
            System.out.println("Stack underflow...please exit the program");
        }
    }

    void push(int d) {
        if (!isFull()) {
            Node newNode = new Node(d);
            newNode.next = top;
            top = newNode;

            System.out.println(top.data + " is pushed to the stack.");
        } else {
            System.out.println("Stack overflow...please exit.");
        }
    }

    void peek() {
        if (!isEmpty()) {
            System.out.print(top.data + " is on top.");
        } else {
            System.out.println("Your stack is empty");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Push\n2.Pop\n3.Peek\n4.Exit");
        MyStackLL stk = new MyStackLL();

        while (true) {
            System.out.print("\n\nEnter your choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter an integer : ");
                    int d = sc.nextInt();
                    stk.push(d);
                    break;
                }

                case 2: {
                    stk.pop();
                    break;
                }

                case 3: {
                    stk.peek();
                    break;
                }

                case 4: {
                    System.out.println("Terminating successfully...");
                    return;
                }

                default: {
                    System.out.println("Invalid option, press 4 if you want to exit.");
                }
            }
        }
    }
}
