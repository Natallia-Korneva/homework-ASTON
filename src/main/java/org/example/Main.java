package org.example;
import java.util.Scanner;

import static org.example.Factorial.calculateFactorial;
import static org.example.TriangleArea.calculateTriangleArea;
import static org.example.CompareNumbers.compare;

public class Main {
    public static void main(String[] args) {
// факториал числа
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для вычисления факториала: ");
        int number = scanner.nextInt();
        long factorial = calculateFactorial(number);
        System.out.println("Факториал числа " + number + ": " + factorial);

//площадь треугольника
        System.out.println("--- Площадь треугольника ---");
        System.out.print("Введите длину первой стороны: ");
        double a = scanner.nextDouble();
        System.out.print("Введите длину второй стороны: ");
        double b = scanner.nextDouble();
        System.out.print("Введите длину третьей стороны: ");
        double c = scanner.nextDouble();

        double area = calculateTriangleArea(a, b, c);
        System.out.printf("Площадь треугольника: %.2f\n", area);

// арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение)
        Calculator calculator = new Calculator();
        System.out.println("--- Простой калькулятор ---");
        System.out.print("Введите первое целое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int num2 = scanner.nextInt();

        System.out.println("Выберите действие:\n1. Сложить\n2. Вычесть\n3. Умножить\n4. Разделить");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + calculator.add(num1, num2));
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + calculator.subtract(num1, num2));
                break;
            case 3:
                System.out.println(num1 + " * " + num2 + " = " + calculator.multiply(num1, num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println(num1 + " / " + num2 + " = " + calculator.divide(num1, num2));
                } else {
                    System.out.println("Ошибка деления на ноль!");
                }
                break;
            default:
                System.out.println("Неверный выбор.");
        }

        // сравнение двух целых чисел
        System.out.println("--- Сравнение чисел ---");
        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        System.out.println(compare(firstNumber, secondNumber));
    }
}