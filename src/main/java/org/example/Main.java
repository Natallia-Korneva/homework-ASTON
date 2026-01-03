package org.example;

public class Main {
    public static void main(String[] args) {
        lessonTwo lessonTwo = new lessonTwo();
        lessonTwo.printThreeWords();
        lessonTwo.checkSumSign();
        lessonTwo.printColor();
        lessonTwo.compareNumbers();
        System.out.println(lessonTwo.isSumInRange(15, 5));
        lessonTwo.checkNumber(0);
        System.out.println(lessonTwo.moreThanZero(-9));
        lessonTwo.printStringNTimes("Hallo", 4);
        System.out.println(lessonTwo.leapYear(704));
        lessonTwo.invertArray();
        lessonTwo.array();
        lessonTwo.arraylength();
        lessonTwo.twoArraylength();
        int[] myArray = lessonTwo.createFilledArray(7, 5);

        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }
}