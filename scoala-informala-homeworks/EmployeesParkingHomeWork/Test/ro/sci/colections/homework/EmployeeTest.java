package ro.sci.colections.homework;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void CreateEmployeeNameTest() {

		Employee employee = new Manager("Vasile", "22/12/2015", false);

		assertEquals("Vasile", employee.getName());
	}

	@Test
	public void CreateEmployeeHireDateTest() {

		Employee employee = new Manager("Vasile", "22/12/2015", false);

		assertEquals("22/12/2015", employee.getHireDate());
	}

	@Test
	public void CreateEmployeeParkingTest() {

		Employee employee = new Manager("Vasile", "22/12/2015", false);

		assertEquals(false, employee.isParking());

	}

	@Test(expected = ParseException.class)
	public void CreateEmployeeDateExceptionTest() throws ParseException {

		Employee employee = new Manager("Vasile", "22/12/2015", false);
		employee.dateHandler("22/22.2014");

	}

	@Test
	public void CreateEmployeeGetTitleTest() {

		Employee employee = new Manager("Vasile", "22/12/2015", false);

		assertEquals("Manager", employee.getPosition());

	}
}
