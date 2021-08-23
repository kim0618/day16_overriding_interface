package casting;

class A01{
	public void getText() {
		System.out.println("A클래스");
	}
}

class B01 extends A01{
	public void getText() {
		System.out.println("B클래스");
	}
}

class C01 extends A01{
	public void getText() {
		System.out.println("C클래스");
	}
}

public class Ex01 {
	public static void main(String[] args) {
		
		/*
		 up casting(형변환)
		 - 자식 형태의 값을 부모 형태로 변환하는 것
		 down casting(형변환)
		 - 부모 형태에서 자식형태로 변환하는 것
		 */
		
		B01 b = new B01();
		b.getText();
		C01 c = new C01();
		c.getText();
									//위아래 둘다 같은거 밑에가 up casting
		A01 a = new B01();
		a.getText();
		a = new C01();
		a.getText();
		
		
	}
}
