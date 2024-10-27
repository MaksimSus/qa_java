import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensReturnsOneKittenByDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensReturnsSpecifiedKittenCount() {
        assertEquals(5, feline.getKittens(5));
    }

    // Добавлен тест для метода getKittens с нулевым значением, чтобы покрыть граничный случай
    @Test
    public void getKittensReturnsZeroForZeroInput() {
        assertEquals(0, feline.getKittens(0));
    }

    // Добавлен тест для метода getKittens с отрицательным значением, чтобы проверить поведение для отрицательных значений
    @Test
    public void getKittensReturnsNegativeValue() {
        assertEquals(-1, feline.getKittens(-1));
    }

    // Добавлен тест для проверки выброса исключения в методе getFood при недопустимом значении параметра animalKind
    @Test
    public void getFoodThrowsExceptionForUnknownAnimalKind() {
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестный"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}

