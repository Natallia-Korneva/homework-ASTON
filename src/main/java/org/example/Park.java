package org.example;

//3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
public class Park {
    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String name;
        private String openingTime;
        private String price;

        public Attraction(String openingTime, String price) {
            this.name = parkName;
            this.openingTime = openingTime;
            this.price = price;
        }

        public Attraction displayInfo() {
            System.out.println("Аттракцион: " + name + "; Время работы: " + openingTime + "; Стоимость: " + price);
            return null;
        }
    }
}