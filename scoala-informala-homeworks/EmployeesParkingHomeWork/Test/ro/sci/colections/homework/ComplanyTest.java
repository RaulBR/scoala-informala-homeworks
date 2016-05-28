package ro.sci.colections.homework;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ComplanyTest {

	@Test
	public void addEmployeeTest() {
		Map<Integer, Employee> map = new HashMap<>();
		Company company = new Company(map);

		assertEquals(0, company.getEmployee().size(), 0.001);
	}

	@Test
	public void addManagerEmployeeToCompanyTest() {
		Map<Integer, Employee> map = new HashMap<>();
		map.put(1, new Manager("vasile", "22/22/2015", false));
		Company company = new Company(map);

		assertEquals(1, company.getEmployee().size(), 0.001);
	}

	@Test
	public void addManagerEmployeeGetManagerListTest() {
		Map<Integer, Employee> map = new HashMap<>();
		map.put(1, new Manager("vasile", "22/22/2015", false));
		Company company = new Company(map);

		assertEquals(1, company.getManager().size(), 0.001);
	}
	
	
}