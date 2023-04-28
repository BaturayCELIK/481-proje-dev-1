This program demonstrates the application of the visitor pattern.

The company's employees are organized into 4 units: *Departments*, *Bosses*, *Employees* and *Senior Employees*.
The goal of the CompanyHierarchy class is to print the current state of the company.

An example output from the __CompanyHierarchy__ class (a visitor) is as follows:
```
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
```

An example output from the __CompanyStats__ class (another visitor) is as follows:
```
	Departments: 3
	Bosses: 3
	Employees: 6
	SeniorEmployees: 1
	Most influential boss: 
		Name: Kemal,
		Total Employees: 2,
		Influence Score: 2.20
```

The formula for computing the influence Score of a boss is:

```
Number of employees + (1.2 * Number of senior employees)
```
