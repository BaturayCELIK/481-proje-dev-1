/**
* A visitor that prints the company hierarchy.
*/
public class CompanyHierarchy implements IVisitor {
	int tabCount = 0;

	public void visit(Employee employee) {
		_indent();
		System.out.println("Employee: " + employee.name());
	}
	public void visit(Dept dept) {
		_indent();
		System.out.println("Dept:" + dept.name());
		tabCount++;
		dept.visitUnits(this);
		//dept.units().forEach(n -> n.accept(this));
		tabCount--;
	}
	public void visit(Boss boss) {
		_indent();
		System.out.println("Boss: " + boss.name());
		tabCount++;
		boss.visitEmployees(this);
		//boss.employees().forEach(n -> n.accept(this));
		tabCount--;
	}
	public void visit(SeniorEmployee employee) {
		_indent();
		System.out.println("Senior Employee: " + employee.name());
	}
	protected void _indent() {
		for (int i = 0; i < tabCount; i++) {
			System.out.print("\t");
		}
	}
}