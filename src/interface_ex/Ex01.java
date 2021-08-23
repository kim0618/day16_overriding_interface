package interface_ex;

class A지상군{
	public void 공격() {
		System.out.println("지상군 공격 시작");
	}
	public void 방어() {
		System.out.println("지상군 방어 시작");
	}
}
class A공군{
	public void 미사일공격() {
		System.out.println("비행기 공격 시작");
	}
	public void 막기() {
		System.out.println("비행기 방어 시작");
	}
}


public class Ex01 {
	public static void main(String[] args) {
		
		A지상군 army = new A지상군();
		army.공격(); army.방어();
		A공군 air = new A공군();
		air.미사일공격(); air.막기();
		
		
		
		
	}
}
