package org.example;

interface RunningBehavior {
    void run(int distance);
}

class CatRunning implements RunningBehavior {
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " метров.");
        } else {
            System.out.println("Кот устал и не смог преодолеть такое расстояние!");
        }
    }
}

class DogRunning implements RunningBehavior {
    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " метров.");
        } else {
            System.out.println("Собака устала и не смогла преодолеть такое расстояние!");
        }
    }
}

interface SwimmingBehavior {
    void swim(int distance);
}

class CatSwim implements SwimmingBehavior {
    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать!");
    }
}

class DogSwim implements SwimmingBehavior {
    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " метров.");
        } else {
            System.out.println("Собака устала и не смогла проплыть дальше!");
        }
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public void eatFromBowl(Cat cat, int amountToEat) {
        if (foodAmount >= amountToEat) { // Проверяем достаточно ли еды
            foodAmount -= amountToEat;
            cat.setSatiety(true); // Обновляем состояние сытости кота
            System.out.println(cat.getName() + " успешно поел и теперь сытый.");
        } else {
            System.out.println(cat.getName() + ": Еды недостаточно, кот остался голодным.");
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " единиц еды в миску. Теперь всего: " + foodAmount);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

abstract class Animal {
    private static int animalCount = 0;
    protected final String name;

    protected RunningBehavior runningBehavior;
    protected SwimmingBehavior swimmingBehavior;

    public Animal(String name) {
        this.name = name;
        incrementAnimalCount();
    }

    public abstract void setRunBehavior(RunningBehavior behavior);
    public abstract void setSwimBehavior(SwimmingBehavior behavior);

    public void performRun(int distance) {
        runningBehavior.run(distance);
    }

    public void performSwim(int distance) {
        swimmingBehavior.swim(distance);
    }

    private synchronized static void incrementAnimalCount() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety = false; // По умолчанию кот голоден

    public Cat(String name) {
        super(name);
        setRunBehavior(new CatRunning());
        setSwimBehavior(new CatSwim());
        incrementCatCount();
    }

    @Override
    public void setRunBehavior(RunningBehavior behavior) {
        this.runningBehavior = behavior;
    }

    @Override
    public void setSwimBehavior(SwimmingBehavior behavior) {
        this.swimmingBehavior = behavior;
    }

    private synchronized static void incrementCatCount() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSatiated() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        setRunBehavior(new DogRunning());
        setSwimBehavior(new DogSwim());
        incrementDogCount();
    }

    @Override
    public void setRunBehavior(RunningBehavior behavior) {
        this.runningBehavior = behavior;
    }

    @Override
    public void setSwimBehavior(SwimmingBehavior behavior) {
        this.swimmingBehavior = behavior;
    }

    private synchronized static void incrementDogCount() {
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}


