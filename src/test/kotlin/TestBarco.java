import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBarco {
    @Test
    public void testSize() {
        Barco barco = new Barco(0,3);
        Assertions.assertEquals(barco.getSize(),3);
    }

    @Test
    public void testHundido() {
        Barco barco = new Barco(0,2);
        barco.tocar();
        barco.tocar();
        Assertions.assertEquals(barco.isHundido(),true);
    }


    @Test
    public void testnoHundido() {
        Barco barco = new Barco(0,3);
        barco.tocar();
        barco.tocar();
        Assertions.assertEquals(barco.isHundido(),false);
    }
}
