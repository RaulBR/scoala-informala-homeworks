package ro.sci.colections.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

/**
 * This class is the Parent class of type Employee.
 * 
 * @author Raul
 *
 */
abstract class Employee implements Comparable<Employee>  {
	private String name;
	private boolean parking;
	private Date hireDate;
	private long diff;
	private String position;
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public Employee(String position, String name, String hireDate, boolean parking) {

		this.position = position;

		this.name = name;
		this.parking = parking;

		try {
			dateHandler(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is a handler class for date.
	 * <p>
	 * it parses the imput String in to date format.
	 * </p>
	 * <p>
	 * 
	 * @param hireDate
	 *            String of format dd/mm/yyyy.
	 * @throws ParseException
	 * 
	 */
	public void dateHandler(String hireDate) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
	

		this.hireDate = df.parse(hireDate);

		Date date = new Date();
		diff = date.getTime() - this.hireDate.getTime();
	}

	public String getHireDate() {
		return df.format(hireDate);
	}

	public boolean isParking() {
		return parking;
	}

	public String getName() {

		return name;
	}

	public String getPosition() {
		return position;
	}

	public long getDiff() {

		return diff;
	}

	public String getAll() {
		return getPosition() + " " + getName() + " " + getHireDate() + " " + isParking();
	}

	

}
