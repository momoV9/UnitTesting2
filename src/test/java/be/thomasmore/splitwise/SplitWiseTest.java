
package be.thomasmore.splitwise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitWiseTest {
    private static SplitWise sw, sw2;

    @BeforeAll
    static void setup() {
        sw = new SplitWise(new String[]{"Jan", "Jos", "Mieke", "Tamara"});
        sw2 = new SplitWise(new String[]{"Jan", "Jos", "Mieke", "Tamara", "Pieter"});
    }

    @Test
    public void everyoneDrinksCoffee(){
        sw.pay("Jan", 40);
        sw.pay("Jan",10);

        assertEquals(30, sw.billFor("Jan"),0.001);
        assertEquals(-10, sw.billFor("Jos"),0.001);
        assertEquals(-10, sw.billFor("Mieke"),0.001);
        assertEquals(-10, sw.billFor("Tamara"),0.001);
    }

    @Test
    public void NoCoffee(){
        sw.pay("Jan", 0);
        sw.pay("Jan",0);

        assertEquals(0, sw.billFor("Jan"),0.001);
        assertEquals(0, sw.billFor("Jos"),0.001);
        assertEquals(0, sw.billFor("Mieke"),0.001);
        assertEquals(0, sw.billFor("Tamara"),0.001);

    }


    @Test
    public void MiekeBuysCookies(){
        sw.pay("Mieke",10);
        sw.pay("Mieke", 2.5);

        assertEquals(7.5, sw.billFor("Mieke"), 0.001);
        assertEquals(-2.5, sw.billFor("Jan"), 0.001);
        assertEquals(-2.5, sw.billFor("Jos"),0.001);
        assertEquals(-2.5, sw.billFor("Tamara"),0.001);

    }
    @Test
    public void PieterJoins(){
        sw2.pay("Pieter",10);
        sw2.pay("Pieter", 2);

        assertEquals(8, sw2.billFor("Pieter"), 0.001);
        assertEquals(-2, sw2.billFor("Jan"), 0.001);
        assertEquals(-2, sw2.billFor("Jos"),0.001);
        assertEquals(-2, sw2.billFor("Tamara"),0.001);
        assertEquals(-2, sw2.billFor("Mieke"),0.001);
    }
}

