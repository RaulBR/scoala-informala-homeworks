package ro.sci.dbhomework;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CustomerDaoImplTest {
	@Test
	public void addCustomerTest(){
		Map<Integer,String> map=new HashMap<>();
		map.put(1,"1,ion@ion.com");
		CustomerDaoImpl customer=new CustomerDaoImpl();
		customer.deleteCostumer(1);
		customer.createCostumer(1, "1", "ion@ion.com");
		assertEquals(map, customer.getCostumerById(1));
		customer.deleteCostumer(1);
	}
	@Test
	public void deleteCustomerTest(){
		Map<Integer,String> map=new HashMap<>();
		
		CustomerDaoImpl customer=new CustomerDaoImpl();
		customer.createCostumer(1, "1", "ion@ion.com");
		customer.deleteCostumer(1);
		assertEquals(map, customer.getCostumerById(1));
	
	}
	@Test
	public void getCustomerTest(){
		Map<Integer,String> map=new HashMap<>();
		map.put(1,"1,ion@ion.com");
		CustomerDaoImpl customer=new CustomerDaoImpl();
		customer.createCostumer(1, "1", "ion@ion.com");
		
		assertEquals(map, customer.getCostumerById(1));
		customer.deleteCostumer(1);
		
	}
	@Test
	public void getAllCustomerTest(){
		Map<Integer,String> map=new HashMap<>();
		map.put(1,"1,ion@ion.com");
		map.put(2,"2,ion@ion.com");
		CustomerDaoImpl customer=new CustomerDaoImpl();
		customer.createCostumer(1, "1", "ion@ion.com");
		customer.createCostumer(2, "2", "ion@ion.com");
		
		assertEquals(map, customer.getAllCostumers());
		customer.deleteCostumer(1);
		customer.deleteCostumer(2);
				
	}
}
