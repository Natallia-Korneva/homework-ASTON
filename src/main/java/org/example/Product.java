package org.example;

//1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем
public class Product {
    private String name;
    private String date;
    private String manufacturer;
    private String country;
    private int cost;
    private boolean reservation;

    public Product(String name, String date, String manufacturer, String country, int cost, boolean reservation) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.cost = cost;
        this.reservation = reservation;
    }

    public Product displayInfo() {
            System.out.println("Имя: " + this.name + "; Дата производства: " + this.date + "; Производитель: " + this.manufacturer + "; Страна происхождения: " + this.country +"; Цена: " + this.cost+"; Cостояние бронирования покупателем: " + this.reservation);
        return null;
    }
}
