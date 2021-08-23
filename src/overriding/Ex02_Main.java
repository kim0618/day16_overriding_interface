package overriding;

import java.util.ArrayList;

class AA extends ArrayList{
	public void aa() {
		System.out.println("나만의 기능");
	}
	public Object get(int i) {
		return "내가 만든 기능";
	}
	public boolean add(Object o) {
		System.out.println("추가 하는 기능");
		return true;
	}
}

class BB {
	String s = new String();
	String ss;
	public void tesT() {
		
	}
}

class CC extends BB{
	
}

public class Ex02_Main {
		public static void main(String[] args) {
	
		AA a = new AA();
		a.add("안녕");
		System.out.println("저장값 : "+a.get(0));
	
	
}
	
	
}
