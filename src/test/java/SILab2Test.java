import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryBranch(){
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null,500));

        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(new Item("Frutiko", null, 350, 0.05F)), 500));

        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(new Item("Frutiko","ASD1434125",350,0.05F)), 500));

        assertTrue(SILab2.checkCart(List.of(new Item("Frutiko","123512",350,0.05F)), 500));

        assertFalse(SILab2.checkCart(List.of(new Item("Frutiko","0412315",350,0.05F),
                new Item(null,"5412315",1000,0)), 500));
    }

    @Test
    void testMultipleCase(){
        assertFalse(SILab2.checkCart(List.of(new Item("RESEN","223512",100,0.05F)), 500));

        assertFalse(SILab2.checkCart(List.of(new Item("NAJDOBRI","023512",350,0)), 500));

        assertFalse(SILab2.checkCart(List.of(new Item("Frutiko","223512",350,0.05F)), 500));

        assertTrue(SILab2.checkCart(List.of(new Item("Frutiko","023512",350,0.05F)), 500));
    }
}
