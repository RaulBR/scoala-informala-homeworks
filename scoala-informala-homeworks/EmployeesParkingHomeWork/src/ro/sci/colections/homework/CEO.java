package ro.sci.colections.homework;

import java.text.ParseException;

/**
 * This class is child class of {@link Employee}.
 * <p>
 * It creates CEO's.
 * </p>
 * 
 * @author Raul
 *
 */
public class CEO extends Employee {

	public CEO(String name, String hireDate, boolean parking) {
		super("CEO", name, hireDate, parking);
		try {
			dateHandler(hireDate);
		} catch (ParseException e) {
			System.err.println("Date format is dd/MM/yyyy");
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
