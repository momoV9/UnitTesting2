package be.thomasmore.happyhour;

public class PartyTicket {

    private static final int PRICE_RED = 2;
    private static final int PRICE_BLUE = 3;
    private final boolean ok;

    public PartyTicket(boolean happyHourActive) {
        this.ok = happyHourActive;
    }

    public double buyTickets(int amountRed, int amountBlue) {
        double v = 0;
        int a = 0;
        int b = 0;
        double discount = 20;
        if (amountRed >= 10) {
            a = amountRed - 1;
            v = v + a * PRICE_RED;
            if (10 > amountBlue) {
                b = amountBlue;
                v = v + b * PRICE_BLUE;
                if (ok) {
                    v = v - a * (double) PRICE_RED / 5;
                    v = v - b * (double) PRICE_BLUE / 5;
                } else
                    discount = 0;
            } else {
                v = v + (amountBlue - 1) * PRICE_BLUE;
                b = amountBlue - 1;
                if (ok) {
                    v = v - a * (double) PRICE_RED / 5;
                    v = v - b * (double) PRICE_BLUE / 5;
                } else
                    discount = 0;
                if (a < 10) {
                    return v;
                }
            }
        } else {
            a = amountRed;
            b = amountBlue;
            v = v + amountRed * PRICE_RED;
            if (10 > amountBlue) {
                v = v + amountBlue * PRICE_BLUE;
                if (ok) {
                    v = v - a * (double) PRICE_RED / 5;
                    v = v - b * (double) PRICE_BLUE / 5;

                }  else discount +=20;
            } else {
                v = v + (amountBlue - 1) * PRICE_BLUE;
                b = amountBlue - 1;
                if (ok) {
                    v = v - a * (double) PRICE_RED / 5;
                    v = v - b * (double) PRICE_BLUE / 5;
                }
            }
        }
        return v;
    }
}
