import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

interface intTree {
    void build_expression_tree(String input);
    void evaluate_expression_tree();
}

class Node {

    char val;
    Node left, right;

    Node(char item) {
        val = item;
        left = right = null;
    }
}

class expTree implements intTree {
    @Override
    public void build_expression_tree(String input){
        String[] parsed = input.split("\\s");
        // for (int i = 0; i < parsed.length; i++) {
        // 	System.out.println(parsed[i]);
        // }
        // List<String> parsedList = Arrays.asList(parsed);
        // System.out.println(parsedList);

        for (String el: parsed
             ) {
            System.out.println(el);

        }
    }

    @Override
    public void evaluate_expression_tree(){

    }

//    public expTree() {
//        System.out.println("hsdgsf");
//    }
}

public class p2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        expTree ob1 = new expTree();
        while(!input.equals("exit"))
        {
            System.out.println("The input is: "+input);
            ob1.build_expression_tree(input);
            ob1.evaluate_expression_tree();
            input = reader.readLine();
        }



    }


}

