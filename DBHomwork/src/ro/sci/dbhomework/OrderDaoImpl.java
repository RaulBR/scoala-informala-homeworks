package ro.sci.dbhomework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
 * This class simulates a order handleling CRUD, it implements OrderDao and extends AbstractModelDaor
 */
public class OrderDaoImpl extends AbstractModelDaor implements OrderDao {
	Map<Integer, String> map = new HashMap<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.sci.dbhomework.OrderDao#createOrder(int, int, java.lang.String,
	 * boolean, int)
	 */
	@Override
	public void createOrder(int id, int value, String date, boolean confirmed, int customerId) {

		addRemoveDara("INSERT INTO public.orders(id, value, date, confirmed, id_customer) VALUES (" + id + ", " + value
				+ ", '" + date + "', " + confirmed + ", " + customerId + ")");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.sci.dbhomework.OrderDao#deleteOrder(int)
	 */
	@Override
	public void deleteOrder(int id) {

		addRemoveDara("DELETE FROM public.orders WHERE id=" + id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.sci.dbhomework.OrderDao#getOrderById(int)
	 */
	@Override
	public Map<Integer, String> getOrderById(int id) {

		return getData("SELECT id, value, date, confirmed, id_customer  FROM public.orders WHERE id=" + id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.sci.dbhomework.OrderDao#getAllOrder()
	 */
	@Override
	public Map<Integer, String> getAllOrder() {
		return getData("SELECT id, value, date, confirmed, id_customer  FROM public.orders");

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

					map.put(rs.getInt("id"), rs.getInt("value") + "," + rs.getString("date") + ","
							+ rs.getBoolean("confirmed") + "," + rs.getInt("id_customer"));
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
