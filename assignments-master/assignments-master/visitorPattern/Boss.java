import java.util.Arrays;
import java.util.List;

public class Boss extends Employee {
	private List<Employee> employees;
	public Boss(String name, Employee... employees) {
		super(name);
		this.employees = Arrays.asList(employees);
	}
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	public List<Employee> employees() {
		return employees;
	}
	public void visitEmployees(IVisitor visitor) {
		employees().forEach(n -> n.accept(visitor));
		//employees().forEach(e -> visitor.visit(e)); // Incorrect Output.
	}
}
