public class SeniorEmployee extends Employee {
	public SeniorEmployee(String name) {
		super(name);
	}
	/*If reuses Employee's accept, then double dispatch does not work. */
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}