package first;
import java.util.*;
public class ExpressionEvaluation {
	class Node {
        String s;
        int val; // the priority, not the number itself. e.g, number 2 has value of Inf.
        public Node(int val, String s) {
            this.val = val;
            this.s = s;
        }
    }
    public int evaluateExpression(String[] expression) {
        Stack<Node> priority = new Stack<Node>();
        Stack<Integer> res = new Stack<Integer>();
        int n = expression.length;
        if (n == 0) {
            return 0;
        }
        int base = 0;
        String operators = "+-*/";
        for (int i = 0; i <= n; i++) {
            Node curt = new Node(Integer.MIN_VALUE, "");
            if (i < n) {
                String curtString = expression[i];
                if (curtString.equals("(")) {
                    base += 10;
                    continue;
                } 
                if (curtString.equals(")")) {
                    base -= 10;
                    continue;
                }
                int curtValue = getValue(curtString, base);
                curt = new Node(curtValue, curtString);
            } 
            while (!priority.isEmpty() && curt.val <= priority.peek().val) {
                Node prev = priority.pop();
                if (!operators.contains(prev.s)) {
                    res.push(Integer.valueOf(prev.s));
                    continue;
                } else {
                    int a = res.pop();
                    int b = res.pop();
                    if (prev.s.equals("+")) {
                        res.push(b + a);
                    } else if (prev.s.equals("-")) {
                        res.push(b - a);
                    } else if (prev.s.equals("*")) {
                        res.push(b * a);
                    } else {
                        res.push(b / a);
                    }
                }
            }
            priority.push(curt);
        }
        if (res.isEmpty()) {
            return 0;
        }
        return res.pop();
    }
    
    public int getValue(String s, int base) {
        if (s.equals("+") || s.equals("-")) {
            return 1 + base;
        } else if (s.equals("*") || s.equals("/")) {
            return 2 + base;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    public static void main(String[] args) {
    	ExpressionEvaluation ee = new ExpressionEvaluation();
    	String[] e1 = {"2","*","6","-","3"};
    	String[] e2 = {"(","(","(","(","(",")",")",")",")",")"};
    	System.out.println(ee.evaluateExpression(e1));
    	System.out.println(ee.evaluateExpression(e2));
    }

}
