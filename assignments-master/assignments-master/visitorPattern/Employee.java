public class Employee extends Unit {
	public Employee(String name) {
		super(name);
	}
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}