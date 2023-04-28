import com.example.Feline;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testGetFamily() {
        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        int expectedResult = 1;
        assertEquals(expectedResult, feline.getKittens());
    }

    @Test
    public void testGetKittensWithArgument() {
        int expectedResult = 3;
        assertEquals(expectedResult, feline.getKittens(3));
    }

    @Test
    public void testEatMeatException() throws Exception {
        feline = new Feline();
        List<String> actual = feline.eatMeat();
        assertEquals(expectedFood, actual);
    }
}



