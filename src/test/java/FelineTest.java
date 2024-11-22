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
    public void getKittensReturnsNegativeValue() {
        assertEquals(-1, feline.getKittens(-1));
    }

    @Test
    public void getFoodThrowsExceptionForUnknownAnimalKind() {
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестный"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}

