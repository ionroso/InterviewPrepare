package org.example;

/*
Write a C program that prints the numbers 1 to 100.
For multiples of three print the string “Fizz” instead of the number.
For multiples of five print the string “Buzz” instead of the number.
For multiples of both three and five, print the string FizzBuzz instead of the number.
 */

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            if(i % 5 == 0 && i % 3 == 0){
                System.out.println("FizzBuzz");
            } else if(i % 3 == 0){
                System.out.println("Fizz");
            } else if(i % 5 == 0){
                System.out.println("Buzz");
            } else{
                System.out.println(i);
            }
        }
    }
}
