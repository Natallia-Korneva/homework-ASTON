package org.example;

// Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
public class MyArrayDataException extends Exception {
    private final String cellInfo;

    public MyArrayDataException(String cellInfo) {
        this.cellInfo = cellInfo;
    }

    @Override
    public String toString() {
        return "Ошибка преобразования значения ячейки (" + cellInfo + ")";
    }
}
