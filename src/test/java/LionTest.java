import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Lion lion;

    

    @BeforeEach
    void setUp() {
        Feline feline = mock(Feline.class);
    }

    private static Stream<Arguments> provideLionManeTest() throws Exception {
        Lion lion1 = new Lion("Самец");
        Lion lion2 = new Lion("Самка");
        return Stream.of(
                Arguments.of(lion1, true),
                Arguments.of(lion2, false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideLionManeTest")
    public void lionManeTest(Lion lion, boolean bool) {

        Assertions.assertEquals(bool, lion.doesHaveMane());
    }

    @Test
    public void testWrongSex() {
    try {
        Lion lion = new Lion("Неверный пол");
    } catch (Exception text) {
        assertEquals("Используйте допустимые значения пола животного - самец или самка", text.getMessage());
    }
}

    @Test
    public void lionGetFoodTest() throws Exception {
        lion = new Lion("Самец");
        Assertions.assertEquals(expectedFood, lion.getFood());
    }


    @Test
    public void testLionMale() throws Exception {
        lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionFemale() throws Exception {
        lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void testLionGetKittens() throws Exception {
        Feline feline = new Feline();
        lion = new Lion("Самец");
        assertEquals(feline.getKittens(), lion.getKittens());
    }
}

