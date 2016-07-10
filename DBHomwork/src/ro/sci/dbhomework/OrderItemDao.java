package ro.sci.dbhomework;

import java.util.Map;

/*
 * This interface facilitates the built of a orderd item handling CRUD
 * 
 */
public interface OrderItemDao {
	/*
	 * This method add's a orderd item in the database
	 * 
	 * @param id
	 * 
	 * @param OrderId
	 * 
	 * @patam Quantity
	 * 
	 * @param productId
	 */
	void createOrderItem(int id, int orderId, int quantity, int productId);

	/*
	 * This method delets a orderd item in the database
	 * 
	 * @param id
	 */
	void deleteOrderdItem(int id);

	/*
	 * This method returns a orderd item in the database
	 * 
	 * @param id
	 */
	Map<Integer, String> getOrderItemById(int id);

	/*
	 * This method returns all orderd item in the database
	 * 
	 * @param id
	 */
	Map<Integer, String> getAllOrderItems();

}
