import java.util.Scanner;
import java.util.Stack;

public class PreFix{
     Stack <Character> stack = new Stack<>();

     static Scanner sc = new Scanner(System.in);
     StringBuilder output = new StringBuilder();
     String input="";
     String prefix="";

     int typeBracket(char c){
        if(c==('('))
        return 1;

        else if(c==')')
        return 2;

        else
        return 0;

    }

    boolean isSpace(char c){
        return c==' ';
    }

    boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='*'||c=='/'||c=='^');
    }

    int precedence(char c){
    if(c=='+'||c=='-')
    return 1;

    else if(c=='*'||c=='/')
    return 2;

    else if(c=='^')
    return 3;

    else
    return 0;    
    }

    String reverseExpression(String temp){
        Stack <String> stk2 = new Stack<>();
        StringBuilder current = new StringBuilder();
        String ireturn="";

        for(int i=0;i<temp.length();i++){            

            char c = temp.charAt(i);
     
            if(isSpace(c))
            continue;            

            if(isOperator(c)){
                if(current.length()>0)
                stk2.push(current.toString());
                current.setLength(0);
                stk2.push(c+"");
            }
            else{
                int a = typeBracket(c);
               if(a==0){
                current.append(c);
               }
               else{
                if(current.length()>0)
                stk2.push(current.toString());
                current.setLength(0);

                if(a==1)
                stk2.push(")");

                else
                stk2.push("(");
                
               }
            }          
           

        }
        if(current.length()>0)
        stk2.push(current.toString());

        while(!stk2.isEmpty()){
            ireturn+=stk2.pop() + " ";
        }
        return ireturn;
    }

     
     
     void getString(){
        System.out.println("Enter your infix expression :");
        String temp = sc.nextLine();
        input = reverseExpression(temp);
        
        System.out.println("The reverse is "+input);        

     }

    
    void conversion(){
        for(int i=0;i<input.length();i++){
            
            char c = input.charAt(i);
            if(isSpace(c))
            continue;
            if(isOperator(c)){
               while(!stack.isEmpty()&&precedence(stack.peek())>=precedence(c)&&c!='^'){
                output.append(stack.peek());
                stack.pop();
               }
               stack.push(c);
             

            }

            else{

                int a = typeBracket(c);
                switch(a){
                    case 1:{
                    stack.push(c);
                    break;
                }

                    case 2:{
                   
                    while((!stack.isEmpty())&&stack.peek()!='(') 
                    {
                    output.append(stack.peek());
                    stack.pop();
                                }

                                if(!stack.isEmpty())                               
                                stack.pop(); 
                                
                                break;

            
        }
        case 0:{
            output.append(c);
        }
                
                   

                }
            }

        }

        while(!stack.isEmpty()){
            output.append(stack.peek());
            stack.pop();
        }
        prefix = reverseExpression(output.toString());

       
        

    }

    public static void main(String []args){
        PreFix i2p = new PreFix();
        i2p.getString();
        i2p.conversion();
        System.out.println("\n\nThe prefix conversion is :\n"+i2p.prefix.trim());

       

    }


}
