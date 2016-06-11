package ro.scii.ticket;

/**
 * This class is a child class of{@link Ticket} and it models a category one
 * ticket.
 * 
 * @Raul
 */
public class TicketCategoryOne extends Ticket {
	/**
	 *This method returns the pice of a ticket 120 lei
	 */
	public double ticketPrice() {

		return 120;
	}
	/**
	 *This method returns the category of the ticket "one".
	 */

	public String getCategory() {

		return "One";
	}
}