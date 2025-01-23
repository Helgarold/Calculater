package org.example;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        if (!input.matches("\\d+ [\\+\\-*/] \\d+")) {
            throw new Exception("Неправильное выражение");
        }

        String[] parts = input.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        char op = parts[1].charAt(0);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа вне диапазона 1-10");
        }

        switch (op) {
            case '+':
                return String.valueOf("Результат операции: " + (num1 + num2));
            case '-':
                return String.valueOf("Результат операции: " + (num1 - num2));
            case '*':
                return String.valueOf("Результат операции: " + (num1 * num2));
            case '/':
                return String.valueOf("Результат операции: " + (num1 / num2));
            default:
                throw new Exception("Неизвестная операция");
        }
    }
}
