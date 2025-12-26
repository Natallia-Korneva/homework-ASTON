package org.example;
import java.util.Arrays;
import java.awt.Color;
import java.util.*;
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
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true).displayInfo();
        productsArray[1] = new Product("LG20", "10.01.2023", "LG Corp.", "Korea", 6600, true).displayInfo();
        productsArray[2] = new Product("TLC65QLED780K", "01.01.2024", "Issy-Les Moulineaux", "France", 7000, true).displayInfo();
        productsArray[3] = new Product("FOX 42WOS640E", "24.03.2020", "JIN PIN ELECTRICAL COMPANY LTD", "China", 9900, true).displayInfo();
        productsArray[4] = new Product("Haier 65 Mini LED", "01.02.2025", "Haier Overseas Electric Appliances Corp.", "Chinaa", 7878, true).displayInfo();

        Park.Attraction attraction = new Park("Парк Горького").new Attraction("Круглосуточно (павильоны и каток: 10:00 – 23:00)", "Вход бесплатный; прокат инвентаря и аттракционы — платно").displayInfo();

        System.out.println("-----------------------------------------------------------------------------------");

        Cat catBarsik = new Cat("Барсик");
        Cat catBoris = new Cat("Борис");
        Dog dogBobik = new Dog("Бобик");

        // Выполняем действия
        catBarsik.performRun(180);
        catBarsik.performSwim(5);
        catBoris.performRun(1000);
        dogBobik.performRun(450);
        dogBobik.performSwim(8);

        // Подсчет количества животных
        System.out.println("Всего создано животных: " + Animal.getAnimalCount());
        System.out.println("Количество кошек: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());

        Cat[] cats = new Cat[]{
                new Cat("Барсик"),
                new Cat("Васёк"),
                new Cat("Матроскин")
        };

        Bowl bowl = new Bowl(25);

        bowl.eatFromBowl(cats[0], 15);

        Arrays.stream(cats)
                .forEach(cat -> System.out.println(cat.getName() + " сыт: " + cat.isSatiated()));

        bowl.addFood(10); // добавляем ещё еды


        System.out.println("-----------------------------------------------------------------------------------");


        ColoredShape circle = new Circle(5, Color.BLUE, Color.RED); // Радиус 5 см, синий фон, красная граница
        ColoredShape rectangle = new Rectangle(8, 4, Color.GREEN, Color.BLACK); // Ширина 8 см, высота 4 см, зеленый фон, черная граница
        ColoredShape triangle = new Triangle(3, 4, 5, Color.YELLOW, Color.ORANGE); // Стороны 3, 4, 5 см, желтый фон, оранжевая граница

        ShapePrinter.printShapeInfo(circle);
        ShapePrinter.printShapeInfo(rectangle);
        ShapePrinter.printShapeInfo(triangle);

        System.out.println("-----------------------------------------------------------------------------------");

        // В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
        String[][] validArray = {{"1", "2", "3", "4"},
                {"7", "7", "7", "7"},
                {"10", "10", "10", "10"},
                {"12", "12", "12", "12"}};

        String[][] invalidSizeArray = {{"1", "2"}, {"3", "4"}};

        String[][] invalidDataArray = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "f", "15", "16"}};
// Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
        int[] myArray = {1, 2, 3};

        try {
            System.out.println(processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getClass().getSimpleName());
        }

        try {
            System.out.println(processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e);
        }

        try {
            System.out.println(myArray[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Возникло исключение: " + e.getMessage());
        }

        // Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
        // Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
        Set<Student> students = new HashSet<>();
        students.add(new Student("Соловей Разбойник", "А1", 1));
        students.add(new Student("Добрыня Никитич", "А1", 2));
        students.add(new Student("Илья Муромец", "Б2", 3));

        students.forEach(student -> student.addGrade("Математика", 4));
        students.forEach(student -> student.addGrade("Программирование", 3));
        students.forEach(student -> student.addGrade("Английский", 5));

        removeLowPerformingStudents(students);
        promoteEligibleStudents(students);
        printStudents(students, 2);
    }

    public static void removeLowPerformingStudents(Collection<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if(s.averageGrade() < 3) {
                iterator.remove(); // удаление студента из коллекции
            }
        }

        // Заполняем справочником
        PhoneBook book = new PhoneBook();

        book.add("Добрынин", "+375296666666");
        book.add("Добрынин", "+375293662525");
        book.add("Долина", "++375295553636");
        book.add("Кадышева", "+375251112222");

        System.out.println(book.get("Добрынин"));
        System.out.println(book.get("Долина"));
        System.out.println(book.get("Мартин"));
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4)
            throw new MyArraySizeException();

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("[" + i + ", " + j + "]");
                }
            }
        }
        return sum;
    }

    public static void promoteEligibleStudents(Collection<Student> students) {
        for(Student s : students) {
            if(s.averageGrade() >= 3 && s.getCourse() != 5) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + "-го курса:");
        boolean found = false;
        for(Student s : students) {
            if(s.getCourse() == course) {
                System.out.println(s.getName());
                found = true;
            }
        }
        if(!found) {
            System.out.println("Нет студентов на указанном курсе.");
        }
    }
    }