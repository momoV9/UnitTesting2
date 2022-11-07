
package be.thomasmore.splitwise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitWiseTest {
    private static SplitWise sw;

    @BeforeAll
    static void setup() {
        sw = new SplitWise(new String[]{"Jan", "Jos", "Mieke", "Tamara"});
    }

    @Test
    public void everyoneDrinksCoffee(){
        sw.pay("Jan", 40);
        sw.pay("Jan",10);

        assertEquals(30, sw.billFor("Jan"));
        assertEquals(-10, sw.billFor("Jos"));
        assertEquals(-10, sw.billFor("Mieke"));
        assertEquals(-10, sw.billFor("Tamara"));
    }

    @Test
    public void MiekeBuysCookies(){
        sw.pay("Mieke",10);

    }

}
