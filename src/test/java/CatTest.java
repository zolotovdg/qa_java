import com.example.Cat;
import com.example.Feline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Cat cat;

    @Mock
    Feline feline;

    @BeforeEach
    public void setup() {
        cat = new Cat(feline);
    }

    @Test
    public void catGetSoundTest() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void catGetFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
}
