package org.example;

public class Main {
    public static void main(String[] args) {
        lessonTwo lessonTwo = new lessonTwo();
        lessonTwo.printThreeWords();
        lessonTwo.checkSumSign();
        lessonTwo.printColor();
        lessonTwo.compareNumbers();
        lessonTwo.receivingSum();
        lessonTwo.checkNumber();
        lessonTwo.moreThanZero();
        lessonTwo.printStringNTimes();
        lessonTwo.LeapYear();
        lessonTwo.InvertArray();
        lessonTwo.Array();
        lessonTwo.Arraylength();
        lessonTwo.TwoArraylength();

        //2. Создать массив из 5 товаров.
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025","Samsung Corp.", "Korea", 5599, true).displayInfo();
        productsArray[1] = new Product("LG20", "10.01.2023","LG Corp.", "Korea", 6600, true).displayInfo();
        productsArray[2] = new Product("TLC65QLED780K", "01.01.2024","Issy-Les Moulineaux", "France", 7000, true).displayInfo();
        productsArray[3] = new Product("FOX 42WOS640E", "24.03.2020","JIN PIN ELECTRICAL COMPANY LTD", "China", 9900, true).displayInfo();
        productsArray[4] = new Product("Haier 65 Mini LED", "01.02.2025","Haier Overseas Electric Appliances Corp.", "Chinaa", 7878, true).displayInfo();

        Park.Attraction attraction = new Park("Парк Горького").new Attraction("Круглосуточно (павильоны и каток: 10:00 – 23:00)", "Вход бесплатный; прокат инвентаря и аттракционы — платно").displayInfo();
    }
}