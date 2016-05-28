package ro.sci.colections.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This class the Company class.
 * <p>
 * it separates the employees my title, seniority and parking access.
 * </p>
 * 
 * @author Raul
 *
 */
public class Company {
	Date dNow = new Date();
	String pozition;

	private Map<Integer, Employee> employee = new TreeMap<>();
	private Collection<Manager> manager = new ArrayList<>();
	private Collection<CEO> ceo = new ArrayList<>();
	private Collection<SrSoftwareEngineer> srSoftwareEngineer = new ArrayList<>();
	private Collection<JrSoftwareEngineer> jrSoftwareEngineer = new ArrayList<>();

	Collection<Employee> noParking = new TreeSet<>();

	/**
	 * This constructor takes it the flowing parameters of type hashMap
	 * <Integer,Employee>
	 * 
	 * @param employees
	 *            hashMap<Integer,Employee>
	 */
	public Company(Map<Integer, Employee> employees) {

		this.employee = employees;
		sortEmployees(employees);
		getNoParkingEnployee();

	}

	private void sortEmployees(Map<Integer, Employee> employee) {
		for (Integer key : employee.keySet()) {
			if (employee.get(key) instanceof Manager) {
				manager.add((Manager) employee.get(key));
			}
			if (employee.get(key) instanceof CEO) {
				ceo.add((CEO) employee.get(key));
			}
			if (employee.get(key) instanceof JrSoftwareEngineer) {
				jrSoftwareEngineer.add((JrSoftwareEngineer) employee.get(key));
			}
			if (employee.get(key) instanceof SrSoftwareEngineer) {
				srSoftwareEngineer.add((SrSoftwareEngineer) employee.get(key));
			}

		}

	}

	/**
	 * This method prints the managers of the company
	 */
	public void printManager() {
		for (Manager person : manager) {
			System.out.println("Manager: " + person.getName());
		}
	}

	/**
	 * This method prints the CEO's of the company
	 */
	public void printtCeo() {
		for (CEO person : ceo) {
			System.out.println("CEO: " + person.getName());
		}
	}

	/**
	 * This method prints the senior software engineers of the company
	 */
	public void printSrSoftwareEngineer() {
		for (SrSoftwareEngineer person : srSoftwareEngineer) {
			System.out.println("SrSoftwareEngineer: " + person.getName());
		}
	}

	/**
	 * This method prints the junior software engineers of the company
	 */
	public void printJrSoftwareEngineer() {
		for (JrSoftwareEngineer person : jrSoftwareEngineer) {
			System.out.println("JrSoftwareEngineer: " + person.getName());
		}
	}

	private Collection<Employee> getNoParkingEnployee() {

		for (Integer key : employee.keySet()) {
			if (employee.get(key).isParking() == false) {
				noParking.add(employee.get(key));
			}
		}
		return noParking;
	}

	/**
	 * This method prints the employees that dont have acces at parking, by
	 * seniority.
	 */
	public void printParking() {

		for (Employee noPark : noParking) {
			System.out.println(noPark.getName() + " " + noPark.getHireDate());
		}

	}

	public Map<Integer, Employee> getEmployee() {
		return employee;
	}

	public Collection<Manager> getManager() {
		return manager;
	}

	public Collection<CEO> getCeo() {
		return ceo;
	}

	public Collection<SrSoftwareEngineer> getSrSoftwareEngineer() {
		return srSoftwareEngineer;
	}

	public Collection<JrSoftwareEngineer> getJrSoftwareEngineer() {
		return jrSoftwareEngineer;
	}

}
