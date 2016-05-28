package ro.sci.colections.homework;

import java.text.ParseException;

/**
 * This class is child class of {@link Employee}.
 * <p>
 * It creates junior software engineers.
 * </p>
 * 
 * @author Raul
 *
 */
public class JrSoftwareEngineer extends Employee {

	public JrSoftwareEngineer(String name, String hireDate, boolean parking) {
		super("Jr Software Engineer", name, hireDate, parking);
		try {
			dateHandler(hireDate);
		} catch (ParseException e) {
			System.err.println("Date format is dd/mm/yyyy");
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(Employee o) {
		if (getDiff() > o.getDiff()) {
			return -1;
		}
		if (getDiff() < o.getDiff()) {
			return 1;
		}
		return 0;
	}

	
}
