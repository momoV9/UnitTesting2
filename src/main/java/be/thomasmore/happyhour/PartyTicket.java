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
        if (amountRed >= 10) {

            if (10 > amountBlue) {


                if (ok) {

                        return (amountRed - 1) * PRICE_RED + amountBlue * PRICE_BLUE - (amountRed - 1) * (double) PRICE_RED / 5 - amountBlue * (double) PRICE_BLUE / 5;

                }
                return (amountRed - 1) * PRICE_RED + amountBlue * PRICE_BLUE;
            } else {

                if (ok) {
                    return (amountRed - 1) * PRICE_RED + (amountBlue - 1) * PRICE_BLUE - (amountRed - 1) * (double) PRICE_RED / 5 - (amountBlue - 1) * (double) PRICE_BLUE / 5;
                }return (amountRed - 1) * PRICE_RED + (amountBlue - 1) * PRICE_BLUE;
            }
        } else {

            if (10 > amountBlue) {
                v = v + amountBlue * PRICE_BLUE;
                if (ok) {
                    v = v - amountRed * (double) PRICE_RED / 5;
                    v = v - amountBlue * (double) PRICE_BLUE / 5;

                }
            } else {
                v = getV(amountBlue, v, amountRed);
            }
        }
        return v;
    }

    private double getV(int amountBlue, double v, int amountRed) {

        v = v + (amountBlue - 1) * PRICE_BLUE;

        if (ok) {
            v = v - amountRed * (double) PRICE_RED / 5;
            v = v - (amountBlue-1) * (double) PRICE_BLUE / 5;
        }
        return v;
    }
}
