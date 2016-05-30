package pattern.behavior.memento;

public class MementoTest {
	public static void main( String[] args ){
		Original origin = new Original("egg");
		
		Storage storage = new Storage( origin.createMemento());
		System.out.println("��ʼ��״̬Ϊ:" + origin.getValue() );
		origin.setValue("niu");
		System.out.println("�޸ĺ��״̬Ϊ:" + origin.getValue() );
		
		origin.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬:" + origin.getValue());
		return;
	}
}
