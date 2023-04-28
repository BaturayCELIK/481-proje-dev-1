import java.util.Arrays;
import java.util.List;

public class Dept extends Unit {
	private List<Unit> units;
	public Dept(String name, Unit... units) {
		super(name);
		this.units = Arrays.asList(units);
	}
	public List<Unit> units() { return units; }

	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	public void visitUnits(IVisitor visitor) {
		units().forEach(u -> u.accept(visitor));
		//units().forEach(u -> visitor.visit(u)); // Compiler error.
	}
}