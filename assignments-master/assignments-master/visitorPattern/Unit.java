public abstract class Unit {
	private String name;
	public Unit(String name) {
		this.name = name;
	}
	public String name() {
		return name;
	}
	abstract public void accept(IVisitor visitor);
}

