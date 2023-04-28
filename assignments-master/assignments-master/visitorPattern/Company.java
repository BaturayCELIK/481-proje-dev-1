import java.util.Arrays;
import java.util.List;

/**
This program demonstrates the application of the visitor pattern.

The company's employees are organized into 4 units: Departments, Bosses, Employees and Senior Employees.
The goal of the CompanyHierarchy class is to print the current state of the company.

An example output from the CompanyHierarchy class (a visitor) is as follows:

	Dept:IK
		Employee: Orhan
		Boss: Ayse
			Employee: Zeki
		Dept:Operations
			Employee: Aziz
			Dept:Ankara
				Boss: Kemal
					Employee: Cem
					Senior Employee: Leyla
				Boss: Yasar
					Employee: Riza
					Employee: Ilhan


An example output from the CompanyStats class (another visitor) is as follows:

	Departments: 3
	Bosses: 3
	Employees: 6
	SeniorEmployees: 1
	Most influential boss: 
		Name: Kemal,
		Total Employees: 2,
		Influence Score: 2.20


*/

public class Company {


	public static void main(String[] args) {
		Dept d = new Dept("IK",
			new Employee("Orhan"),
			new Boss("Ayse", new Employee("Zeki")),
			new Dept(
				"Operations",
				new Employee("Aziz"),
				new Dept(
					"Ankara",
					new Boss(
						"Kemal", 
						new Employee("Cem"),
						new SeniorEmployee("Leyla")),
					new Boss(
						"Yasar",
						new Employee("Riza"),
						new Employee("Ilhan")))));
		CompanyHierarchy ch = new CompanyHierarchy();
		d.accept(ch);

		CompanyStats cs = new CompanyStats();
		d.accept(cs);
		cs.printResult();
	}

}