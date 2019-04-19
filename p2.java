import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

interface intTree {
    Node build_expression_tree(String[] parsed);
    int evaluate_expression_tree(Node tRoot);
}

class Node {
    String val;
    Node left, right;

    Node(String item) {
        val = item;
        left = right = null;
    }
}

class expTree implements intTree {
    public Node build_expression_tree(String[] parsed) {
        //String[] parsed = input.split("\\s");
        // for (int i = 0; i < parsed.length; i++) {
        // System.out.println(parsed[i]);
        // }
        // List<String> parsedList = Arrays.asList(parsed);
        // System.out.println(parsedList);

        Stack<Node> treeStack = new Stack();
        Node tRoot, tRight, tLeft;

        for (String op : parsed) {
            System.out.println(op);
            if (!(op == "+" || op == "-" || op == "/" || op == "*")) {
                tRoot = new Node(op);
                treeStack.push(tRoot);
            } else {
                tRoot = new Node(op);

                tRight = treeStack.pop();
                tLeft = treeStack.pop();

                tRoot.right = tRight;
                tRoot.left = tLeft;

                treeStack.push(tRoot);
            }
        }
        tRoot = treeStack.peek();
        treeStack.pop();

        return tRoot;
    }

    public int evaluate_expression_tree(Node tRoot) {
        if (tRoot != null) {
//            if (tRoot.left == null && tRoot.right == null) {
//                return Integer.valueOf(tRoot.val);
//            }

            int leftVal = evaluate_expression_tree(tRoot.left);
            int rightVal = evaluate_expression_tree(tRoot.right);

            if (tRoot.val == "+") {
                return leftVal + rightVal;
            }

            if (tRoot.val == "-") {
                return leftVal - rightVal;
            }

            if (tRoot.val == "*") {
                return leftVal * rightVal;
            }

            if (tRoot.val == "/") {
                return leftVal / rightVal;
            }
        }
        return 0;
    }
}

public class p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] parsed = input.split("\\s");

        expTree builtTree = new expTree();
        Node root = builtTree.build_expression_tree(parsed);
        System.out.println("infix expression is");
        builtTree.evaluate_expression_tree(root);

        while (!input.equals("exit")) {
            System.out.println("The input is: " + input);
            builtTree.build_expression_tree(parsed);
            int output = builtTree.evaluate_expression_tree(root);
            System.out.println("The output of the expression is: " + output);
            input = reader.readLine();
        }

    }
}
