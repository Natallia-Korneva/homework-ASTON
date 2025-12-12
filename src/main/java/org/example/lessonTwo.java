package org.example;

import java.util.Arrays;

public class lessonTwo {
    //1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
    public void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
// которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль
// сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    public void checkSumSign() {
        int a = 10;
        int b = -20;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
// Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно)
// до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
    public void printColor() {
        int value = 150;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else { // Если value > 100
            System.out.println("Зеленый");
        }
    }

    //4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
// которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public void compareNumbers() {
        int a = 30;
        int b = 80;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
// если да – вернуть true, в противном случае – false.
    public boolean receivingSum() {
        int a = 0;
        int b = 15;
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return false;
    }

    // 6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли
    // число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void checkNumber() {
        int number = -20;
        if (number >= 0) {
            System.out.println("Число " + number + " является положительным (включая ноль).");
        } else {
            System.out.println("Число " + number + " является отрицательным.");
        }
    }

    // 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное,
    // и вернуть false если положительное. Замечание: ноль считаем положительным числом.
    static boolean moreThanZero() {
        int a = 0;
        if (a < 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return false;
    }

    //8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку,
    // указанное количество раз;
    public static void printStringNTimes() {
        String text = "Hallo";
        int count = 5;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        } else {
            System.out.println("Количество повторений должно быть положительным числом.");
        }
    }

    //9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean LeapYear() {
        int year = 2025;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("true");
                } else
                    System.out.println("false");
            }
            System.out.println("true");
        } else
            System.out.println("false");
        return false;
    }
    //10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void InvertArray() {
        int[] array = {0, 0, 0, 1, 1, 0, 1, 1, 0, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println( );
    }

    //11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    public static void Array() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        System.out.println( );
    }

    //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void Arraylength() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println( );
    }

    //13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    // заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
    // диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    public static void TwoArraylength() {
        int size = 7;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
       System.out.println("Массив с заполненной главной диагональю:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
        //14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
    // каждая ячейка которого равна initialValue.
        public static void createFilledArray () {
            int len = 5;
            int initialValue = 15;
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++){
                arr[i] = initialValue;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println( );
        }
}



