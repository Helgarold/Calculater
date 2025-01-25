package org.example;

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
        if (!input.matches("\\d+ [\\+\\-*/] \\d+ [\\+\\-*/] \\d+")) {
            throw new Exception("Неправильное выражение");
        }

        String[] parts = input.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        int num3 = Integer.parseInt(parts[4]);
        char op1 = parts[3].charAt(0);
        char op = parts[1].charAt(0);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10 || num3 < 1 || num3 > 10) {
            throw new Exception("Числа вне диапазона 1-10");
        }

        // Реализация очереди выполнения операций
        if (op == '*' || op == '/') {
            num1 = getSomeResult(num1, num2, op);
            return String.valueOf(getSomeResult(num1, num3, op1));
        } else if (op1 == '*' || op1 == '/') {
            num2 = getSomeResult(num2, num3, op1);
            return String.valueOf(getSomeResult(num1, num2, op));
        } else {
            return String.valueOf(getSomeResult(getSomeResult(num1, num2, op), num3, op1));
        }
    }

    public static int getSomeResult(int num1, int num2, char op) throws Exception {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new Exception("Неизвестная операция: " + op);
        }
    }
}