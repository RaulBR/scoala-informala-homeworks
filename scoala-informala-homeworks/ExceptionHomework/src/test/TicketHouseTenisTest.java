package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ro.scii.ticket.CategoryTicketsSoldoutException;
import ro.scii.ticket.SoldoutException;
import ro.scii.ticket.TicketHouseTenis;

public class TicketHouseTenisTest {
	// (expected = CategoryTicketsSoldoutException.class)
	@Test
	public void AllTicketsOfCategoryThHreeSoledTest() {

		TicketHouseTenis tic = new TicketHouseTenis(100);
		assertEquals(0, tic.getTicket("three"), 1);

	}

	@Test
	public void TicketsSoledCategoryThree() {
		TicketHouseTenis tenis = new TicketHouseTenis(100);
		try {
			tenis.ticketHandlerCategoryThree(113, "three");
		} catch (CategoryTicketsSoldoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(2500, tenis.moneyPerCategory("three"), 1);

	}
	@Test
	public void TicketsSoledCategoryTwo() {
		TicketHouseTenis tenis = new TicketHouseTenis(100);
		try {
			tenis.ticketHandlerCategoryThree(113, "two");
		} catch (CategoryTicketsSoldoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(2800, tenis.moneyPerCategory("two"), 1);

	}
	@Test
	public void TicketsSoledCategory0ne() {
		TicketHouseTenis tenis = new TicketHouseTenis(100);
		try {
			tenis.ticketHandlerCategoryThree(113, "one");
		} catch (CategoryTicketsSoldoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(1800, tenis.moneyPerCategory("one"), 1);

	}

	@Test(expected = CategoryTicketsSoldoutException.class)
	public void TicketsSoledOutCategoryThree() throws CategoryTicketsSoldoutException {
		TicketHouseTenis tenis = new TicketHouseTenis(100);

		tenis.ticketHandlerCategoryThree(113, "three");

	}
	@Test(expected = CategoryTicketsSoldoutException.class)
	public void TicketsSoledOutCategoryTwo() throws CategoryTicketsSoldoutException {
		TicketHouseTenis tenis = new TicketHouseTenis(100);

		tenis.ticketHandlerCategoryThree(113, "two");

	}
	@Test(expected = SoldoutException.class)
	public void TicketsSoledOutCategoryOne() throws SoldoutException {
		TicketHouseTenis tenis = new TicketHouseTenis(100);

		tenis.ticketHandlerCategoryOne(113, "one");

	}

}
