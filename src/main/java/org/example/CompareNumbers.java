package org.example;

public class CompareNumbers {
    public static String compare(int x, int y) {
        if(x > y) {
           return x + " больше " + y;
        } else if(x < y) {
           return x + " меньше " + y;
        } else {
           return  "Числа равны";
        }
    }
}