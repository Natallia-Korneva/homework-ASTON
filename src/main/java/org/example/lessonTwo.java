package org.example;

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

}

