package be.thomasmore.happyhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyTicketTest {
    @Test
    public void emptyOrder() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(0.0, partyTicket.buyTickets(0,0));
    }
    @Test
    public void emptyOrderHappy() {
        PartyTicket partyTicket = new PartyTicket(true);
        assertEquals(0.0, partyTicket.buyTickets(0,0));
    }
    @Test
    public void red4() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(8.0, partyTicket.buyTickets(4,0));
    }
    @Test
    public void red4Happy() {
        PartyTicket partyTicket = new PartyTicket(true);
        assertEquals(6.4, partyTicket.buyTickets(4,0));
    }
    @Test
    public void blue4() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(12.0, partyTicket.buyTickets(0,4));
    }
    @Test
    public void blue4Happy() {
        PartyTicket partyTicket = new PartyTicket(true);
        assertEquals(9.6, partyTicket.buyTickets(0,4));
    }
    @Test
    public void red2AndBlue5() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(19.0, partyTicket.buyTickets(2,5));
    }
    @Test
    public void red2AndBlue5Happy() {
        PartyTicket partyTicket = new PartyTicket(true);
        assertEquals(15.2, partyTicket.buyTickets(2,5));
    }
    @Test
    public void red10() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(18, partyTicket.buyTickets(10,0));
    }
    @Test
    public void red10Happy() {
        PartyTicket partyTicket = new PartyTicket(true);
        assertEquals(14.4, partyTicket.buyTickets(10,0));
    }
    @Test
    public void red20() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(38, partyTicket.buyTickets(20,0));
    }
    @Test
    public void blue10() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(27, partyTicket.buyTickets(0,10));
    }
    @Test
    public void blue10Happy() {
        PartyTicket partyTicket = new PartyTicket(true);
        assertEquals(21.6, partyTicket.buyTickets(0,10));
    }
    @Test
    public void blue20() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(57, partyTicket.buyTickets(0,20));
    }
    @Test
    public void red10AndBlue10() {
        PartyTicket partyTicket = new PartyTicket(false);
        assertEquals(45, partyTicket.buyTickets(10,10));
    }

}
