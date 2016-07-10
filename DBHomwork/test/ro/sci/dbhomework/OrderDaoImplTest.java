package ro.sci.dbhomework;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class OrderDaoImplTest {
	@Test
	public void addOrderTest() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1,2015-02-10,true,1");
		OrderDaoImpl order = new OrderDaoImpl();
		

		order.createOrder(1, 1, "2-10-15", true, 1);
		assertEquals(map, order.getOrderById(1));
		order.deleteOrder(1);
	}

	@Test
	public void deleteOrderTest() {
		Map<Integer, String> map = new HashMap<>();

		OrderDaoImpl order = new OrderDaoImpl();
		order.createOrder(1, 1, "2-10-15", false, 1);
		order.deleteOrder(1);
		assertEquals(map, order.getOrderById(1));
	}

	@Test
	public void getOrderTest() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1,2015-02-10,true,1");
		OrderDaoImpl order = new OrderDaoImpl();
		order.deleteOrder(1);
		order.createOrder(1, 1, "2-10-15", true, 1);
		assertEquals(map, order.getOrderById(1));
		order.deleteOrder(1);
	}
	
	@Test
	public void getAllOrderTest() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1,2015-02-10,true,1");
		map.put(2, "2,2015-02-10,true,2");
		OrderDaoImpl order = new OrderDaoImpl();
		order.createOrder(1, 1, "2-10-15", true, 1);
		order.createOrder(2, 2, "2-10-15", true, 2);

		assertEquals(map, order.getAllOrder());
		order.deleteOrder(1);
		order.deleteOrder(2);
	}
}
