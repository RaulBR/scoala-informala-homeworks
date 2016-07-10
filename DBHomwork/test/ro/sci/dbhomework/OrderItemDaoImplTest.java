package ro.sci.dbhomework;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class OrderItemDaoImplTest {
	@Test
	public void addOrderItemTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1,1,1");
		OrderItemImpl order = new OrderItemImpl();
		

		order.createOrderItem(1,1,1, 1);
		assertEquals(map, order.getOrderItemById(1));
		order.deleteOrderdItem(1);
	}
	@Test
	public void deleteOrderItemTest(){
		Map<Integer, String> map = new HashMap<>();

		OrderItemImpl order = new OrderItemImpl();
		order.createOrderItem(1, 1, 1, 1);
		order.deleteOrderdItem(1);
		assertEquals(map, order.getOrderItemById(1));
	}
	@Test
	public void getOrderItemTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1,1,1");
		OrderItemImpl order = new OrderItemImpl();
		order.deleteOrderdItem(1);
		order.createOrderItem(1, 1,1,1);
		assertEquals(map, order.getOrderItemById(1));
		order.deleteOrderdItem(1);
	}
	@Test
	public void getAllOrderItemTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1,1,1");
		map.put(2, "1,1,2");
		OrderItemImpl order = new OrderItemImpl();
		order.createOrderItem(1, 1,1, 1);
		order.createOrderItem(2,  1,1, 2);

		assertEquals(map, order.getAllOrderItems());
		order.deleteOrderdItem(1);
		order.deleteOrderdItem(2);
	}
}
