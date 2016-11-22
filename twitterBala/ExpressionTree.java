package twitterBala;
import java.util.*;

public class ExpressionTree {

    public static String simpleExpression(String expression , String op){
        StringBuilder sb = new StringBuilder();

        op = reduceOp(op);
        for(int i = 0 ; i < op.length();i++){
            if(op.charAt(i) == 'R'){
                expression = reverse(expression);
            }
            else{
                expression = simplify(expression);
            }
        }
        return expression;
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1 ; i >=0 ; i--){
            if(s.charAt(i) == ')') sb.append('(');
            else if(s.charAt(i) =='(') sb.append(')');
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String simplify(String s){
        if(!s.contains("(") && !s.contains(")")) return s;
        StringBuilder sb = new StringBuilder();

        if(s.charAt(0) =='(') {
            int j = 0;
            int count = 0;
            while (true) {
                if (s.charAt(j) == '(') count++;
                else if (s.charAt(j) == ')') count--;
                if (count == 0) {
                        String temp  = s.substring(1, j) + s.substring(j + 1);
                        s = temp;
                        break;
                }
                j++;
            }
        }
        char prev = s.charAt(0);
        sb.append(s.charAt(0));
        int i = 1;
        while(i < s.length()){
            if (s.charAt(i)  =='(' && prev =='('){
                int parenthCount = 1;
                StringBuilder innerSb = new StringBuilder();
                while(true){
                    if(s.charAt(i) == '(') parenthCount++;
                    else if(s.charAt(i) == ')')parenthCount--;
                    if(parenthCount == 0) break;
                    innerSb.append(s.charAt(i));
                    i++;
                }
                sb.append(simplify(innerSb.toString()));
                i--;
            }
            else{
                sb.append(s.charAt(i));
            }

            prev = s.charAt(i);
            i++;
        }
           //System.out.println(sb.toString());
           return sb.toString();
    }

    public static String reduceOp(String op){

        StringBuilder reduceOp = new StringBuilder();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        stack.add(op.charAt(0));
        int iter = 1;
        while(iter < op.length()){
            if(!stack.empty() && stack.peek()=='R' && op.charAt(iter)== 'R' ){
                stack.pop();
            }
            else{
                stack.push(op.charAt(iter));
            }
            if(!stack.empty() && stack.peek() == 'S'){
                while(!stack.empty() && stack.peek() == 'S') {
                    stack.pop();
                }
                stack.push('S');
            }
            iter++;
        }
        while(!stack.empty())reduceOp.append(stack.pop());
        return reduceOp.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(simpleExpression("(AB)C((DE)F)", "RSR"));
    }
}
