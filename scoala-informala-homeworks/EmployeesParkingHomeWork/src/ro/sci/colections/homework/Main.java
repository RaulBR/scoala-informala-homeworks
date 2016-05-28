package ro.sci.colections.homework;


import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args){
	
		
	Map<Integer,Employee> employee=new HashMap<>();


		 employee.put(1,new Manager("Vasile","22/02/2015", false));
		 employee.put(2,new CEO("Gigi","22/02/2011", true));
		 employee.put(3,new SrSoftwareEngineer("Andreea","22/02/2009", true));
		 employee.put(4,new JrSoftwareEngineer("Oana","22/02/2008", false));
		 employee.put(5,new JrSoftwareEngineer("Dani","20/02/2015", false));
		 employee.put(6,new JrSoftwareEngineer("Dani2","21/02/2015", false));
		 employee.put(7,new JrSoftwareEngineer("Dani3","24/02/2012", false));
		 employee.put(8,new JrSoftwareEngineer("Dani4","22/01/2015", true));
		 employee.put(9,new JrSoftwareEngineer("Dani5","23/02/2000", false));
		 employee.put(10,new JrSoftwareEngineer("Dani6","21/04/2015", false));
		 
		
					Company ern=new Company(employee);
					
					ern.printParking();
		// ern.printManager();
		// ern.printJrSoftwareEngineer();
	}

}
