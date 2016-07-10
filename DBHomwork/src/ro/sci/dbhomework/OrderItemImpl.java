package ro.sci.dbhomework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/*
 * Thid class handles the Order Item CRUD it extends AbstractModelDaor and implemnts OrderItemDao
 */
public class OrderItemImpl extends AbstractModelDaor implements OrderItemDao {
	Map<Integer, String> map = new HashMap<>();
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.OrderItemDao#createOrderItem(int, int, int, int)
 */
	@Override
	public void createOrderItem(int id, int orderId, int quantity, int productId) {

		addRemoveDara("INSERT INTO public.orderitems(id, id_order, quantity, id_product) VALUES (" + id + "," + orderId
				+ "," + quantity + "," + productId + ")");

	}
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.OrderItemDao#deleteOrderdItem(int)
 */
	@Override
	public void deleteOrderdItem(int id) {

		addRemoveDara("DELETE FROM public.orderitems WHERE id=" + id);

	}
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.OrderItemDao#getOrderItemById(int)
 */
	@Override
	public Map<Integer, String> getOrderItemById(int id) {

		return getData("SELECT id, id_order, quantity, id_product  FROM public.orderitems WHERE id=" + id);

	}
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.OrderItemDao#getAllOrderItems()
 */
	@Override
	public Map<Integer, String> getAllOrderItems() {

		return getData("SELECT *FROM public.orderitems");

	}

	private Map<Integer, String> getData(String sqlQuery) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = getDbConnection().prepareStatement(sqlQuery);

			rs = ps.executeQuery();
			boolean hasResoult = rs.next();

			if (hasResoult) {

				do {

					map.put(rs.getInt("id"),
							rs.getInt("id_order") + "," + rs.getInt("quantity") + "," + rs.getInt("id_product"));
				} while (rs.next());

			} else {
				System.out.println("no resoult");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("DB connection problem");
		} finally {
			try {
				finalize();
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
		    }
		    
		
		return map;

	}

}
