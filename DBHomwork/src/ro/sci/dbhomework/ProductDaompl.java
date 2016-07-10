package ro.sci.dbhomework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/* 
 * This class handles the CRUD for products it implements ProductDao and extends AbstractModelDaor
 */
public class ProductDaompl extends AbstractModelDaor implements ProductDao {
	Map<Integer, String> map = new HashMap<>();
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.ProductDao#createProduct(int, java.lang.String, java.lang.String)
 */
	@Override
	public void createProduct(int productId, String name, String description) {

		addRemoveDara("INSERT INTO public.products(id, name, description) VALUES (" + productId + ",'" + name + "','"
				+ description + "')");

	}
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.ProductDao#deleteProduct(int)
 */
	@Override
	public void deleteProduct(int productId) {

		addRemoveDara("DELETE FROM public.products WHERE id=" + productId);

	}
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.ProductDao#getProductById(int)
 */
	@Override
	public Map<Integer, String> getProductById(int productId) {

		return getData("SELECT id, name, description  FROM public.products WHERE id=" + productId);

	}
/*
 * (non-Javadoc)
 * @see ro.sci.dbhomework.ProductDao#getAllProducts()
 */
	@Override
	public Map<Integer, String> getAllProducts() {

		return getData("SELECT id, name, description  FROM public.products");

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

					map.put(rs.getInt("id"), rs.getString("name") + "," + rs.getString("description"));
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
