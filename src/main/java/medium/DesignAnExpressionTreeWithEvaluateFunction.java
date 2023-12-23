package medium;

import java.util.Stack;

public class DesignAnExpressionTreeWithEvaluateFunction {
    public static void main(String[] args) {
        System.out.println(new MyNode(new String[] {"4","5","2","7","+","-","*"}).evaluate());
    }

    static
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

    static
        class MyNode extends Node {
            String[] postfix;

            public MyNode(String[] postfix) {
                this.postfix = postfix;
            }

            public int evaluate() {
                Stack<Node> stack = new Stack<>();
                for (String val : postfix) {
                    switch (val) {
                        case "+":
                            int plusRez = new PlusNode(stack.pop().evaluate(), stack.pop().evaluate()).evaluate();
                            stack.push(new IntNode(plusRez));
                            break;
                        case "-":
                            int minusRez = new MinusNode(stack.pop().evaluate(), stack.pop().evaluate()).evaluate();
                            stack.push(new IntNode(minusRez));
                            break;
                        case "*":
                            int multiRez = new MultiNode(stack.pop().evaluate(), stack.pop().evaluate()).evaluate();
                            stack.push(new IntNode(multiRez));
                            break;
                        case "/":
                            int divRez = new DivNode(stack.pop().evaluate(), stack.pop().evaluate()).evaluate();
                            stack.push(new IntNode(divRez));
                            break;
                        default: {
                            int intVal = Integer.parseInt(val);
                            stack.push(new IntNode(intVal));
                        }
                    }
                }

                return stack.pop().evaluate();
            }

            class IntNode extends Node {
                int int1;

                public IntNode(int int1) {
                    this.int1 = int1;
                }

                public int evaluate() {
                    return int1;
                }

            }

            class PlusNode extends Node {
                int int1, int2;

                public PlusNode(int int1, int int2) {
                    this.int1 = int1;
                    this.int2 = int2;
                }

                public int evaluate() {
                    return int1 + int2;
                }
            }

            class MinusNode extends Node {
                int int1, int2;

                public MinusNode(int int1, int int2) {
                    this.int1 = int1;
                    this.int2 = int2;
                }

                public int evaluate() {
                    return int2 - int1;
                }
            }

            class MultiNode extends Node {
                int int1, int2;

                public MultiNode(int int1, int int2) {
                    this.int1 = int1;
                    this.int2 = int2;
                }

                public int evaluate() {
                    return int1 * int2;
                }
            }

            class DivNode extends Node {
                int int1, int2;

                public DivNode(int int1, int int2) {
                    this.int1 = int1;
                    this.int2 = int2;
                }

                public int evaluate() {
                    return int2 / int1;
                }
            }
        }
}
