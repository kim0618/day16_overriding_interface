package casting;


class AAA{
	public String getText() {return "AAA클래스";}
}


public class Ex03 {
	public static void main(String[] args) {
		
		Object a = new AAA();
		AAA aa = (AAA)a;
		aa.getText();
		
		
		
		
		
	}
}
