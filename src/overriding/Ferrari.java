package overriding;

public class Ferrari {
	private int ye, speed;

	public int getYe() {
		return ye;
	}

	public int getSpeed() {
		return speed;
	}

	public Ferrari(int ye, int speed) {
		this.ye = ye;
		this.speed = speed;
	}

	public void speed() {
		System.out.println(ye+"년 페라리 속도 "+speed+"km 입니다");	}
	
	
}
