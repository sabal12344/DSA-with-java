

import java.util.Scanner;
class Queuee{
    int rear, front;
    int [] arr = new int [50];
    Queuee(){
        rear = -1;
        front = -1;
        
    }

    boolean isEmpty(){
        return (rear == -1 && front == -1) || (front>rear);

    }

    boolean isFull(){
        return rear == arr.length - 1;

    }

    void  enqueue(int data){
        if(isFull()){
            System.out.println("The queue is full.");
            
        }
        else{
            if(isEmpty()){
                front++;
                
            }
            rear++;
            arr[rear] = data;
        }
              

    }

    int dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return 0;

        }

        else{
            
           
            front++;
            
        }
        return arr[front-1];
    }





}



public class RadixSort{
    public static void main (String [] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        
        int [] a = new int [size];
        System.out.println("Now enter those "+size+" elements :");
        for(int i = 0; i<a.length;i++){
            a[i] = sc.nextInt();
        }

      
        int highest = a[0];


        for(int i : a){
              if(i>highest){
                highest = i;
              }               

            }
            int digit = 0;
            int temp = highest;



            int divisor = 1;


            while(temp>0){
                digit++;
                temp/=10;
            }

            


            int [][] pass = new int [digit+1][];

            pass [0] = a;

            int ite = 0;


    while(ite<pass.length-1){
                Queuee [] sortArray = new Queuee[10];

                 for (int j = 0; j < 10; j++) {
            sortArray[j] = new Queuee();
            
        }




                for(int i : pass[ite]){                
                int tempo = i/divisor;
                

                int rem = tempo %10;
                sortArray[rem].enqueue(i);

            }



            int [] array = new int [size];
            int b = 0;
            for(int k =0 ; k<size; k++){
                
               while(b<=sortArray.length){
                if(!sortArray[b].isEmpty()){
                    array[k]= sortArray[b].dequeue();
                    break;

                }
                else{
                    b++;
                }
               }

            }
            pass[ite+1] = array;

            ite++;
            divisor *= 10;

            }

            System.out.println("The sorted form is : ");

            for(int i : pass[pass.length-1]){
                System.out.print(i + " ");
            }
        
           




            
        }
    }
        


    
