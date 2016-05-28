package ro.sci.colections.homework;

/**
 * This class is child class of {@link Employee}.
 * <p>
 * It creates senior software engineers.
 * </p>
 * 
 * @author Raul
 *
 */
public class SrSoftwareEngineer extends Employee {


	public SrSoftwareEngineer(String name, String hireDate, boolean parking) {
		super("Sr Software Engineers", name, hireDate, parking);
	
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
