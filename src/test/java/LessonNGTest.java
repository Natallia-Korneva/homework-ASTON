import org.testng.annotations.Test;
import org.testng.Assert;
import org.example.Calculator;
import static org.example.Factorial.calculateFactorial;
import org.example.TriangleArea;
import static org.example.CompareNumbers.compare;

public class LessonNGTest {
    // Факториал нуля равен единице
    @Test(description="Проверяем факториал нулевого значения")
    public void testZero() {
        Assert.assertEquals(calculateFactorial(0), 1);
    }

    // Проверка факториала единицы
    @Test(description="Проверяем факториал единицы")
    public void testOne() {
        Assert.assertEquals(calculateFactorial(1), 1);
    }

    // Проверка правильного результата для небольших значений
    @Test(description="Проверяем факториалы малых чисел")
    public void testSmallNumbers() {
        Assert.assertEquals(calculateFactorial(5), 120);
        Assert.assertEquals(calculateFactorial(3), 6);
    }

    // Проверка границы больших положительных чисел
    @Test(description="Проверяем большой положительный аргумент")
    public void testLargeNumber() {
        Assert.assertEquals(calculateFactorial(8), 40320);
    }

    // Проверка исключения при вводе отрицательных аргументов
    @Test(expectedExceptions=IllegalArgumentException.class,
            description="Проверяем обработку отрицательного аргумента")
    public void testNegativeInput() {
        calculateFactorial(-1);
    }

    @Test(expectedExceptions=ArithmeticException.class,
            description="Проверяем границу переполнения для long")
    public void testOverflow() {
        calculateFactorial(20);
    }

    // Проверка площади треугольника
    @Test(description = "Правильная площадь правильного треугольника")
    public void testCorrectTriangleArea() {
        double result = TriangleArea.calculateTriangleArea(3, 4, 5);
        Assert.assertEquals(result, 6.0, 0.001);
    }

    @Test(description = "Неверные размеры сторон треугольника приводят к ошибочной области")
    public void testInvalidTriangle() {
        double result = TriangleArea.calculateTriangleArea(1, 2, 4);
        Assert.assertEquals(result, Double.NaN);
    }

    @Test(description = "Корректная работа с границами")
    public void testEdgeCase() {
        double result = TriangleArea.calculateTriangleArea(5, 5, 8);
        Assert.assertEquals(result, 12.0, 0.001);
    }

    // Проверка базовых арифметических операций
    Calculator calculator = new Calculator();
    @Test(description = "Проверка операции сложения")
    public void testAddition() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test(description = "Проверка операции вычитания")
    public void testSubtraction() {
        Assert.assertEquals(calculator.subtract(2, 3), -1);
    }

    @Test(description = "Проверка операции умножения")
    public void testMultiplication() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(description = "Проверка деления на положительное число")
    public void testDivision() {
        Assert.assertEquals(calculator.divide(6, 3), 2.0);
    }

    @Test(description = "Проверка исключения при делении на ноль",
            expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calculator.divide(6, 0);
    }
    //Проверка сравнения двух целых чисел

    @Test(description = "Сравнение равных чисел")
    public void testEqualNumbers() {
        String output = compare(5, 5);
        Assert.assertTrue(output.contains("Числа равны"));
        }

    @Test(description = "Первое число больше второго")
    public void testFirstGreaterThanSecond() {
         String output = compare(10, 5);
         Assert.assertTrue(output.contains("больше"));
        }

    @Test(description = "Первое число меньше первого")
    public void testSecondGreaterThanFirst() {
        String output = compare(5, 10);
        Assert.assertTrue(output.contains("меньше"));
        }
}