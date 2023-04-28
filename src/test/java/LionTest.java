import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Lion lion;

    @Mock
    Feline feline;

    private static Stream<Arguments> provideLionManeTest() throws Exception {
        Feline feline = new Feline();
        Lion lion1 = new Lion("Самец", feline);
        Lion lion2 = new Lion("Самка", feline);
        return Stream.of(
                Arguments.of(lion1, true),
                Arguments.of(lion2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLionManeTest")
    public void lionManeTest(Lion lion, boolean haveMane) {
        assertEquals(haveMane, lion.doesHaveMane());
    }

    @Test
    public void testWrongSex() {
        Exception thrown = assertThrows(Exception.class,
                () -> lion = new Lion("Неверный пол", feline)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testLionGetKittens() throws Exception {
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }
}

