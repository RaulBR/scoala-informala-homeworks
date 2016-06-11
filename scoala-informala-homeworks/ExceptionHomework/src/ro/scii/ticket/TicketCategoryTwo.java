package ro.scii.ticket;

/**
 * This class is a child class of{@link Ticket} and it models a category two
 * ticket.
 * 
 * @Raul
 */
public class TicketCategoryTwo extends Ticket {
	/**
	 * This method returns the pice of a ticket 80 lei
	 */
	public double ticketPrice() {

		return 80;

	}

	/**
	 * This method returns the category of the ticket "two".
	 */
	public String getCategory() {

		return "Two";
	}
}
