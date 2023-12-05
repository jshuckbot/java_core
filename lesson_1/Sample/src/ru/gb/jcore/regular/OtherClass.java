package ru.gb.jcore.regular;

public class OtherClass {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }
    
    public static int mul(int a, int b) {
        return a * b;
    }
    
    public static int div(int a, int b) {
        if (b == 0) return 0;
        
        return a / b;
    }
}