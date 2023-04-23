import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Feline feline;
    @Before
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



