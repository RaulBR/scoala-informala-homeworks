package ro.sci.dbhomework;

import java.util.Map;
/*
 * This interface Facicitates the built ff a Customer handling CRUD
 * 
 */
public interface CustomerDao {
	void createCostumer(int productId, String name, String email);

	void deleteCostumer(int productId);

	Map<Integer,String> getCostumerById(int productId);

	Map<Integer,String> getAllCostumers();

}
