package casting;

class Parents{
	public void familyName() {
		System.out.print("이 ");
	}
	public void name() {
		familyName();
		System.out.println("순신");
	}
}

class Daughter extends Parents{
	public void name() {
		familyName();
		System.out.println("국주");
	}
}
class Son extends Parents{
	public void name() {
		familyName();
		System.out.println("이광");
		}
}


public class Ex02 {
	public static void main(String[] args) {
		Parents p = new Parents();
		p.name();
		p = new Daughter();
		p.name();
		p = new Son();
		p.name();
	}
}
