package ro.sci.dbhomework;

import java.util.Map;
/*
 * This interface facilitates the built of a order handling CRUD
 * 
 */
public interface OrderDao {
	/*
	 * This method crates a order in the database
	 * @param id
	 * @param value
	 * @param date format (dd-mm-yyyy)
	 * @param customerId
	 * 
	 */
	void createOrder(int id, int value, String date, boolean confirmed, int customerId);
	/*
	 * This method delets a order in the database
	 * @param id
	 */

	void deleteOrder(int id);
	/*
	 * This method returns a order in the database
	 * @param id
	 */
	Map<Integer, String> getOrderById(int id);
	/*
	 * This method returns all order in the database
	 * @param id
	 */
	Map<Integer, String> getAllOrder();
}
