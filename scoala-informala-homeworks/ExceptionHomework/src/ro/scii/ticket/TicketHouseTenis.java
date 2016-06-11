package ro.scii.ticket;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a TicketHouse and it does the flowing:
 * <p>
 * Takes a number of tickets and splits it in to three category's (0ne- 15%,
 * two-35%, three-50%). Every category has a price.
 * </p>
 * <p>
 * Simulates the selling of the tickets, by selling form category three to
 * category one , every 17th buyer it sells 3 tickets
 * </p>
 * 
 * @Raul
 */
public class TicketHouseTenis {
	private Map<String, Double> tickets = new HashMap<>();
	private Map<String, Double> price = new HashMap<>();
	private Ticket three = new TicketCategoryThree();
	private Ticket two = new TicketCategoryTwo();
	private Ticket one = new TicketCategoryOne();

	/**
	 * The constructor takes as a parameter a number of tickers and splits the
	 * tickets in three maps and sells the tickets by category
	 * and prints out the results.
	 * <p>
	 * 
	 * @param double
	 *            numberOftickets
	 *            </p>
	 */
	public TicketHouseTenis(double numberOftickets) {

		tickets.put("three", (numberOftickets * 0.5));
		tickets.put("two", (numberOftickets * 0.35));
		tickets.put("one", (numberOftickets * 0.15));

		try {
			ticketHandlerCategoryThree(numberOftickets + 13, "three");

		} catch (CategoryTicketsSoldoutException e) {

			e.printStackTrace();
		}
		try {
			ticketHandlerCategoryTwo(numberOftickets + 13, "two");
		} catch (CategoryTicketsSoldoutException e) {

			e.printStackTrace();

		}
		try {
			ticketHandlerCategoryOne(numberOftickets + 13, "one");
		} catch (SoldoutException e) {

			e.printStackTrace();

		}

		print();

	}

	private void print() {
		printFinal("three");
		printFinal("two");
		printFinal("one");
		double total = price.get("three") + price.get("two") + price.get("one");
		System.out.println("Total: " + total);
	}

	private void printFinal(String o) {

		System.out.println("Ticket category: " + o + ", Money made:  " + price.get(o));

	}

	/**
	 * This method sells thickets of category three. And it calculates the price
	 * per ticket category
	 */
	public void ticketHandlerCategoryThree(double d, String category) throws CategoryTicketsSoldoutException {

		int ticketSold = 0;
		int counter = 0;

		for (int i = 0; i < d; i++) {
			int thicketNumbers = tickets.get(category).intValue();

			counter++;

			if (counter != 17) {
				ticketSold++;
				tickets.put(category, (double) (thicketNumbers - 1));

			} else if (counter == 17 && thicketNumbers == 0) {

				tickets.put(category, (double) (thicketNumbers - 0));

				counter = 0;
			} else if (counter == 17 && thicketNumbers == 1) {

				tickets.put(category, (double) (thicketNumbers - 1));
				ticketSold++;
				counter = 0;
			} else if (counter == 17 && thicketNumbers == 2) {
				tickets.put(category, (double) (thicketNumbers - 2));
				ticketSold = ticketSold + 2;
				counter = 0;
			} else if (counter == 17) {
				tickets.put(category, (double) (thicketNumbers - 3));
				ticketSold = ticketSold + 3;
				counter = 0;
			}

			System.out.println("Thicket Category" + category + " price:" + three.ticketPrice() + " lei"
					+ ", available :" + thicketNumbers);

			if (thicketNumbers == 0) {
				tickets.put(category, (double) 0);

				throw new CategoryTicketsSoldoutException("Nu mai sunt bilete la categoria " + category);

			}

			price.put(category, ticketSold * three.ticketPrice());

		}
	}

	/**
	 * This method sells thickets of category two. And it calculates the price
	 * per ticket category
	 */
	public void ticketHandlerCategoryTwo(double d, String category) throws CategoryTicketsSoldoutException {

		int ticketSold = 0;
		int counter = 0;

		for (int i = 0; i < d; i++) {
			int thicketNumbers = tickets.get(category).intValue();

			counter++;

			if (counter != 17) {
				ticketSold++;
				tickets.put(category, (double) (thicketNumbers - 1));

			} else if (counter == 17 && thicketNumbers == 0) {

				tickets.put(category, (double) (thicketNumbers - 0));

				counter = 0;
			} else if (counter == 17 && thicketNumbers == 1) {

				tickets.put(category, (double) (thicketNumbers - 1));
				ticketSold++;
				counter = 0;
			} else if (counter == 17 && thicketNumbers == 2) {
				tickets.put(category, (double) (thicketNumbers - 2));
				ticketSold = ticketSold + 2;
				counter = 0;
			} else if (counter == 17) {
				tickets.put(category, (double) (thicketNumbers - 3));
				ticketSold = ticketSold + 3;
				counter = 0;
			}

			System.out.println("Thicket Category" + category + " price:" + two.ticketPrice() + " lei" + ", available :"
					+ thicketNumbers);

			if (thicketNumbers == 0) {
				tickets.put(category, (double) 0);

				throw new CategoryTicketsSoldoutException("Nu mai sunt bilete la categoria " + category);

			}

			price.put(category, ticketSold * two.ticketPrice());

		}
	}

	/**
	 * This method sells thickets of category one. And it calculates the price
	 * per ticket category
	 */
	public double moneyPerCategory(String category) {
		return price.get(category);

	}

	public void ticketHandlerCategoryOne(double d, String category) throws SoldoutException {

		int ticketSold = 0;
		int counter = 0;

		for (int i = 0; i < d; i++) {
			int thicketNumbers = tickets.get(category).intValue();

			counter++;

			if (counter != 17) {
				ticketSold++;
				tickets.put(category, (double) (thicketNumbers - 1));

			} else if (counter == 17 && thicketNumbers == 0) {

				tickets.put(category, (double) (thicketNumbers - 0));

				counter = 0;
			} else if (counter == 17 && thicketNumbers == 1) {

				tickets.put(category, (double) (thicketNumbers - 1));
				ticketSold++;
				counter = 0;
			} else if (counter == 17 && thicketNumbers == 2) {
				tickets.put(category, (double) (thicketNumbers - 2));
				ticketSold = ticketSold + 2;
				counter = 0;
			} else if (counter == 17) {
				tickets.put(category, (double) (thicketNumbers - 3));
				ticketSold = ticketSold + 3;
				counter = 0;
			}

			System.out.println("Thicket Category" + category + " price:" + one.ticketPrice() + " lei" + ", available :"
					+ thicketNumbers);

			if (thicketNumbers == 0) {
				tickets.put(category, (double) 0);

				throw new SoldoutException("Toate bilete au fost vandude.");

			}

			price.put(category, ticketSold * one.ticketPrice());

		}
	}

	/**
	 * This method gives the number of tickets per category.
	 */
	public double getTicket(String category) {
		return tickets.get(category);
	}

}
