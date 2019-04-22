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

        Stack<Node> treeStack = new Stack();
        Node tRoot, tRight, tLeft;

        for (String op : parsed) {

            if (op.charAt(0) != '+' && op.charAt(0) != '-' && op.charAt(0) != '/' && op.charAt(0) != '*') {

                tRoot = new Node(op);
                treeStack.push(tRoot);
            }

            else {

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

    static String infix = "";

    public int evaluate_expression_tree(Node tRoot) {

        if (tRoot.left == null && tRoot.right == null){

            infix += tRoot.val + " ";
            return Integer.valueOf(tRoot.val);
        }

        int leftTree = evaluate_expression_tree(tRoot.left);
        infix += tRoot.val + " ";
        int rightTree = evaluate_expression_tree(tRoot.right);

        if (tRoot.val.charAt(0) == '+') {

            return leftTree + rightTree;
        }

        else if (tRoot.val.charAt(0) == '-') {

            return leftTree - rightTree;
        }

        else if (tRoot.val.charAt(0) == '*') {

            return leftTree * rightTree;
        }

        else if (tRoot.val.charAt(0) == '/') {

            return leftTree / rightTree;
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

        while (!input.equals("exit")) {

            System.out.println("The input is: " + input);
            Node root = builtTree.build_expression_tree(parsed);
            int output = builtTree.evaluate_expression_tree(root);
            System.out.println("The infix traversal is: " + expTree.infix);
            System.out.println("The output of the expression is: " + output);
            input = reader.readLine();
        }
    }
}