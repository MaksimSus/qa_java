import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedKittens;

    public FelineParameterizedTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                {1, 1},
                {5, 5},
                {10, 10},
                {0, 0},
                {-1, -1}
        };
    }

    @Test
    public void testGetKittensWithParameters() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(kittensCount));
    }
}
