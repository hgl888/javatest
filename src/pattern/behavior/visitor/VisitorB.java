package pattern.behavior.visitor;

public class VisitorB implements Visitor {
	@Override
	public void visit( NodeA node ){
		System.out.println(node.operationA());
	}
	
	@Override
	public void visit( NodeB node ){
		System.out.print(node.operationB());
	}
}
