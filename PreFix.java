import java.util.Scanner;
import java.util.Stack;




public class PreFix{
     Stack <Character> stack = new Stack<>();

     static Scanner sc = new Scanner(System.in);
     StringBuilder output = new StringBuilder();
     String input="";
     
     
     void getString(){
        System.out.println("Enter your infix expression :");
        String temp = sc.nextLine();
        for(int i=temp.length()-1;i>=0;i--){
            char c = temp.charAt(i);
            if(c=='(')
            input+=')';

            else if(c==')')
            input+='(';

            else
            input+=c;

        }
        

     }


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
        output.reverse();

       
        

    }

    public static void main(String []args){
        PreFix i2p = new PreFix();
        i2p.getString();
        i2p.conversion();
        System.out.println("\n\nThe prefix conversion is :\n"+i2p.output);

       

    }


}