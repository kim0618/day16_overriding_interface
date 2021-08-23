package abstract_ex;

abstract class Abstract{
	protected int num;
	public void setNum(int num) {
		this.num=num;
	}
	public void combo() {
		System.out.println(num+" 단 콤보 공격");
	}
}

class NewAbstract extends Abstract{
	public void combo() {
		System.out.println(num+" 단 콤보 공격 & 2대 더 때리기");
	}
}

public class Ex01 {
	public static void main(String[] args) {
		
		// abstract = 무조건 오버라이팅을 해줘야 에러가 안남 (추상화 = 코드가없는거)
		// 			  필수적인 요소를 미리 정의하는거
		
		Abstract a = new NewAbstract();
		a.setNum(3);
		a.combo();
		
	}
}
