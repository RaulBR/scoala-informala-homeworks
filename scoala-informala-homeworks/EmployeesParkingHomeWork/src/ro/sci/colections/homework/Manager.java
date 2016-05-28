package ro.sci.colections.homework;

/**
 * This class is child class of {@link Employee}.
 * <p>
 * It creates managers.
 * </p>
 * 
 * @author Raul
 *
 */
public class Manager extends Employee {

	public Manager(String name, String hireDate, boolean parking) {
		super("Manager", name, hireDate, parking);

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
