package org.example;

import java.awt.Color;

// Основной интерфейс формы с методами для площади и периметра
interface Shape {
    default double calculatePerimeter() {
        throw new UnsupportedOperationException("Метод должен быть переопределён в конкретной фигуре.");
    }

    default double calculateArea() {
        throw new UnsupportedOperationException("Метод должен быть переопределён в конкретной фигуре.");
    }
}

// Расширенный интерфейс ColoredShape добавляет свойства цветов
interface ColoredShape extends Shape {
    Color getFillColor(); // Цвет заливки
    Color getBorderColor(); // Цвет границы
}

class Circle implements ColoredShape {
    private final double radius;
    private final Color fillColor;
    private final Color borderColor;

    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements ColoredShape {
    private final double width;
    private final double height;
    private final Color fillColor;
    private final Color borderColor;

    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

class Triangle implements ColoredShape {
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final Color fillColor;
    private final Color borderColor;

    public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
        if (!isValidTriangle(sideA, sideB, sideC)) throw new IllegalArgumentException("Неверные стороны");

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double calculateArea() { // Формула Герона
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

class ShapePrinter {
    public static void printShapeInfo(ColoredShape shape) {
        System.out.println("Характеристика:");
        System.out.printf("\tПлощадь: %.2f\n", shape.calculateArea());
        System.out.printf("\tПериметр: %.2f\n", shape.calculatePerimeter());
        System.out.printf("\tЦвет заливки: %s\n", colorToHex(shape.getFillColor()));
        System.out.printf("\tЦвет границы: %s\n", colorToHex(shape.getBorderColor()));
        System.out.println();
    }

    // Метод конвертирует цвет Java AWT в шестнадцатиричный формат
    private static String colorToHex(Color color) {
        return "#" +
                Integer.toHexString(color.getRed()) +
                Integer.toHexString(color.getGreen()) +
                Integer.toHexString(color.getBlue());
    }
}
