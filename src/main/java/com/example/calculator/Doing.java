package com.example.calculator;

public class Doing {
    public static int firstI = 0;
    public static int secondI = 0;

    public static String calculate(String first, String second, String operationText){
        int ans = 0;
        // String first, second -> to integer
        try {
            firstI = Integer.valueOf(first);
            secondI = Integer.valueOf(second);
        } catch (NumberFormatException nfe){
            System.out.println("NumberFormatException: Cannot parse null string");
        }

        // Switch z operatami
        switch(operationText){
            case "+" -> ans = firstI + secondI;
            case "-" -> ans = firstI - secondI;
            case "*" -> ans = firstI * secondI;
            case "/" -> ans = firstI / secondI;
            case "^" -> ans = (int) Math.pow(firstI, secondI);
            case "√" -> ans = (int) Math.sqrt(firstI);
        }
        // Zwrot odpowiedzi
        return Integer.toString(ans);
    }
}
