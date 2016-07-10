package ro.sci.dbhomework;

import java.util.Map;
/*
 * This interface facilitates the built of a product handling CRUD
 * 
 */
public interface ProductDao {
	/*
	 * This method creats a product in a DB.
	 * @param productId
	 * @param name
	 * @param description
	 */
	void createProduct(int productId, String name, String description);
	/*
	 * This method delets a product in a DB.
	 * @param productId
	 */
	void deleteProduct(int productId);
	/*
	 * This method returns a product in a DB.
	 * @param productId
	 */
	Map<Integer,String> getProductById(int productId);
	/*
	 * This method returns all product in a DB.
	 */
	Map<Integer,String> getAllProducts();

}
