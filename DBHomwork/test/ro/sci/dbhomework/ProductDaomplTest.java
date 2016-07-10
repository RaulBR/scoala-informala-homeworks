package ro.sci.dbhomework;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class ProductDaomplTest {
	
	@Test
	public void addProductTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "sony,frumos");
		ProductDaompl order = new ProductDaompl();
		

		order.createProduct(1, "sony","frumos");
		assertEquals(map, order.getProductById(1));
		order.deleteProduct(1);
	}
	@Test
	public void delleteProductTest(){
		Map<Integer, String> map = new HashMap<>();

		ProductDaompl order = new ProductDaompl();
		order.createProduct(1, "sony","frumos");
		order.deleteProduct(1);
		assertEquals(map, order.getProductById(1));
	}
	@Test
	public void returnProductTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "sony,frumos");
		ProductDaompl order = new ProductDaompl();
		order.deleteProduct(1);
		order.createProduct(1, "sony","frumos");
		assertEquals(map, order.getProductById(1));
		order.deleteProduct(1);
	}
	@Test
	public void returnAllProductTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "sony,frumos");
		map.put(2, "samsung,frumos");
		ProductDaompl order = new ProductDaompl();
		order.createProduct(1, "sony","frumos");
		order.createProduct(2, "samsung","frumos");

		assertEquals(map, order.getAllProducts());
		order.deleteProduct(1);
		order.deleteProduct(2);
	}

}
