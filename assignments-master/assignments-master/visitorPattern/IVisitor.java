public interface IVisitor {
	void visit(Employee employee);
	void visit(SeniorEmployee employee);
	void visit(Dept dept);
	void visit(Boss boss);
}