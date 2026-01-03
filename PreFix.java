import java.util.Scanner;
import java.util.Stack;




public class PreFix{
      Stack<String> stk2 = new Stack<>();
     Stack <String> stack = new Stack<>();

     static Scanner sc = new Scanner(System.in);
     StringBuilder output = new StringBuilder();
     String input="";
    

     int typeBracket(String c){
        switch(c){
            case "(":
            return 1;

            case ")":
            return 2;

        
        }
        return 0;
    }


 

    boolean isOperator(String str){
        return (str.equals("+")||str.equals("-") ||str.equals("*") ||str.equals("/") ||str.equals("^") );
    }

    int precedence(String c){
        switch(c){
            case "+" : case "-" :
            return 1;

            case "/" : case "*" :
            return 2;

            case "^":
            return 3;
        }
        return 0;
    }
    void reverseExpression(String temp){
        
        StringBuilder current = new StringBuilder();
        String ireturn="";

        for(int i=0;i<temp.length();i++){

            

            char c = temp.charAt(i);
     
            if(c==' ')
            continue;
            

            if(isOperator(c+"")){
                if(current.length()>0)
                stk2.push(current.toString());
                current.setLength(0);
                stk2.push(c+"");
            }
            else{
                int a = typeBracket(c+"");
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

       
        


    }

     
     
     void getString(){
        System.out.println("Enter your infix expression :");
        String temp = sc.nextLine();
       
        reverseExpression(temp);
       
        conversion();
        

     }


    
    void conversion(){
        //StringBuilder sb = new StringBuilder();
        while(!stk2.isEmpty()){
            String cur = stk2.peek();
            if(isOperator(cur)){
                while(!stack.isEmpty()&&precedence(stack.peek())>=precedence(cur)&&!cur.equals("^")){
                    output.append(stack.pop());

                }
                stack.push(cur);

            }
            else{
                int a = typeBracket(cur);
                switch(a){
                    case 0:{
                        output.append(cur);
                        break;

                    }

                    case 1:{
                        stack.push(cur);
                        break;
                    }

                    
                    case 2:{
                        while(!stack.isEmpty()&&!stack.peek().equals("(")){
                            output.append(stack.pop());
                        }
                        if(!stack.isEmpty())
                        stack.pop();


                    }

                    

                }
            }
            stk2.pop();

        }
       

        while(!stack.isEmpty()){
            output.append(stack.peek());
            stack.pop();
        }
        reverseExpression(output.toString());
       

       
        

    }

    public static void main(String []args){
        PreFix i2p = new PreFix();
        i2p.getString();
      String prefix = "";

      while(!i2p.stk2.isEmpty()){
        prefix+=i2p.stk2.pop()+" ";
      }
        
        System.out.println("\n\nThe prefix conversion is :\n"+prefix);

       

    }


}
