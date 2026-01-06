import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Calculator;
import static org.example.Factorial.calculateFactorial;
import org.example.TriangleArea;
import static org.example.CompareNumbers.compare;

public class LessonJunitTest {
    //1. юнит-тест для тестирования факториала
    @Test
    void testFactorialOfZero() {
        assertEquals(1, calculateFactorial(0), "Факториал 0 должен быть 1");
    }

    // Факториал 1!
    @Test
    void testFactorialOfOne() {
        assertEquals(1, calculateFactorial(1), "Факториал 1 должен быть 1");
    }

    // Положительное число
    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, calculateFactorial(5), "Факториал 5 должен быть 120");
    }

    // Другое положительное число
    @Test
    void testFactorialOfAnotherPositiveNumber() {
        assertEquals(720, calculateFactorial(6), "Факториал 6 должен быть 720");
    }

    // Отрицательный ввод
    @Test
    void testFactorialOfNegativeNumber() {
        // Проверяем, что при отрицательном входе выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> {
            calculateFactorial(-1);
        }, "Должно быть выброшено исключение для отрицательных чисел");
    }

    // Большой факториал
    @Test
    void testFactorialOfLargeNumber() {
        assertEquals(2432902008176640000L, calculateFactorial(20), "Факториал 20");
    }
//2. юнит-тест для тестирования площади треугольника
    @Test
    void testCalculateTriangleAreaValidInput() {
        double expectedArea = 6;
        double actualArea = TriangleArea.calculateTriangleArea(3, 4, 5);
        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test
    void testCalculateTriangleAreaInvalidInput() {
        // Некорректные значения
        double invalidArea = TriangleArea.calculateTriangleArea(1, 2, 4);
        assertEquals(Double.NaN, invalidArea);
    }

    @Test
    void testCalculateTriangleAreaEdgeCase() {
        // Равнобедренный треугольник
        double expectedArea = 12.0;
        double actualArea = TriangleArea.calculateTriangleArea(5, 5, 8);
        assertEquals(expectedArea, actualArea, 0.001);
    }

    // 3. юнит-тест для тестирования арифметических действий
    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(3, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(-2, calculator.subtract(3, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Должно быть брошено исключение IllegalArgumentException");
    }

    //4. юнит-тест для тестирования сравнения целых чисел
    @Test
    void testFirstNumberIsGreater() {
        int firstNumber = 5;
        int secondNumber = 3;
        String result = compare(firstNumber, secondNumber);
        assertEquals(firstNumber + " больше " + secondNumber, result, "Тест 1: Первое больше второго");
    }

    @Test
    void testSecondNumberIsGreater() {
        int firstNumber = 2;
        int secondNumber = 7;
        String result = compare(firstNumber, secondNumber);
        assertEquals(firstNumber + " меньше " + secondNumber, result, "Тест 2: Первое меньше второго");
    }

    @Test
    void testNumbersAreEqual() {
        int firstNumber = 4;
        int secondNumber = 4;
        String result = compare(firstNumber, secondNumber);
        assertEquals("Числа равны", result, "Тест 3: Числа равны");
    }
}