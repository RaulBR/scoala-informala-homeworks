package ro.sci.dbhomework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
 * This class handles the customer handling in a Db, it extends {@link AbstractModelDaor} and implements {@link CustomerDao}
 * 
 */
public class CustomerDaoImpl extends AbstractModelDaor implements CustomerDao {
	Map<Integer, String> map = new HashMap<>();

	/*
	 * This method creates a costumer in a DB.
	 * 
	 * @param costumerIdId -int
	 * 
	 * @param name -String
	 * 
	 * @param email -String
	 * 
	 * @see ro.sci.dbhomework.CustomerDao#createCostumer(int, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void createCostumer(int costumerIdId, String name, String email) {

		addRemoveDara("INSERT INTO public.customer( id, name, email) VALUES (" + costumerIdId + ",'" + name + "','"
				+ email + "')");

	}

	/*
	 * This method delets a costumer in a DB.
	 * 
	 * @param costumerIdId -int
	 * 
	 * @see ro.sci.dbhomework.CustomerDao#createCostumer(int, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void deleteCostumer(int costumerId) {

		String sqlQuery = "DELETE FROM public.customer WHERE id=" + costumerId;
		addRemoveDara(sqlQuery);

	}

	/*
	 * This method returns a costumer form DB
	 * 
	 * @param costumerId - int;
	 *
	 */
	@Override
	public Map<Integer, String> getCostumerById(int costumerId) {

		String sqlQuery = "SELECT *FROM public.customer WHERE id=" + costumerId;

		return getData(sqlQuery);

	}

	/*
	 * This method returns all costumer form DB(non-Javadoc)
	 * 
	 * @param costumerId - int;
	 *
	 */
	@Override
	public Map<Integer, String> getAllCostumers() {
		String sqlQuery = "SELECT *FROM public.customer";

		return getData(sqlQuery);

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
					map.put(rs.getInt("id"), rs.getString("name") + "," + rs.getString("email"));
				} while (rs.next());

			} else {
				System.out.println("no resoult");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("DB connection problem");
		} finally {
			try {
				if (getDbConnection() != null) {
					getDbConnection().close();
				}

			} catch (SQLException sqlee) {
				sqlee.printStackTrace();
			}
		}
		return map;

	}

}