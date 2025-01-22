package org.example;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression in the format 'number operation number':");
        String expression = scanner.nextLine();
        // Разбиваем строку на отдельные компоненты
        String[] part = expression.split(" ");

        /* Проверяем что в поступающей информации два числа
        и алгебраическая операция
         */
        if (part.length != 3) {
            System.out.println("Invalid expression format. Try again");
            return;
        }
        // Присваиваем переменным значения
        int num1 = Integer.parseInt(part[0]);
        int num2 = Integer.parseInt(part[2]);
        String operation = part[1];

        //Выполняем операцию на основе значения operation
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Operation '" + operation + "' not found");
                return;
        }
        System.out.println("Result operation: " + result);
    }
}