package overriding;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;



class TimerQuiz extends Thread{
	private Date date;
	private SimpleDateFormat simpl;
	public void setDate(){
		date = new Date();
		simpl =	new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
	}
	public String getDate(){return simpl.format(date);}
	public void time(){
		for(int i=0;i<10;i++){
			setDate();
			String s=getDate();
			System.out.println(s);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
		}
	}
}

class Win7Quiz extends TimerQuiz{
	private String[] name;
	private String[] info;
	public Win7Quiz(String c,String m, String cPath,String mPath){
		name = new String[2];
		name[0]=c;name[1]=m;
		info = new String[2];
		info[0]=cPath;info[1]=mPath;
	}
	public void function(String funcName){
		String[] name = getName1();
		String[] info = getInfo();
		HashMap map = new HashMap();
		for(int i=0;i<name.length;i++){	map.put(name[i], info[i]); }
		if(map.containsKey(funcName)){
			System.out.println(map.get(funcName)+"사용 합니다");
		}else{System.out.println("없는 기능 입니다");}
	}
	public void funcPrint(){
		System.out.print("[사용가능] : ");
		String[] name = getName1();
		for(int i=0;i<name.length;i++){
			System.out.print(name[i]+"  ");
		}
		System.out.println();
	}
	public String[] getName1() {	return name;	}
	public String[] getInfo() {	return info;	}
	public void display(){
		Scanner input = new Scanner(System.in);
		System.out.println("===== 환 영 합 니 다 =====");
		int sel=0;
		String funcName=null;
		while(true){
			System.out.println("1.기 능");
			System.out.println("2.off");
			System.out.print("입력 >>>> ");
			sel = input.nextInt();
			switch(sel){
				case 1:
					funcPrint();
					System.out.print("사용할 기능 입력 : ");
					funcName=input.next();
					function(funcName);break;
				case 2:
					
					return;
			}
		}
	}
	
}

class Login extends Win7Quiz{
   
	private String userId=null,userPw=null;
	public boolean out(){	return false;	}
	public String getUserId() {	return userId;	}
	public void setUserId(String id) {	this.userId = id;	}
	public String getUserPw() {	return userPw;	}
	public void setUserPw(String pw) {	this.userPw = pw; }
	
	public Login(String c,String m,String cPath,String mPath){
    	super(c,m,cPath,mPath);
    }
    public int compare(String id,String pw){
        if(getUserId() != null  && getUserPw() != null)
            if(getUserId().equals(id) && getUserPw().equals(pw)) return 0;
            else return 1;
        return 1;
    }
    public void saveId_Pw(String id,String pw){
    	setUserId(id); setUserPw(pw); 
    	}
    
}
class MyJframe extends TimerQuiz{
	JFrame frame;
	Container c;
	JLabel label;
	Font font;
	public MyJframe(){
		frame = new JFrame("Time");
		c = frame.getContentPane();
		label = new JLabel();
		font = new Font(null,0,32);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		c.add(label);
		frame.setLocation(1000, 200);
		frame.setPreferredSize(new Dimension(800, 200));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void run(){		
		for(int i=0;;i++){
			try {
				Thread.sleep(1000);
				super.setDate();
				label.setText(super.getDate());
			} catch (InterruptedException e) {}
		}
	}
}

class runTime extends MyJframe {
	private int da;
	public static boolean check = true;
	public runTime() {da=0;}
	public void run(){		
		while(check){
			da++;
			try {
				Thread.sleep(1000);
				super.setDate();
				label.setText(super.getDate());
			} catch (InterruptedException e) {}
		}
		int reHour = da / (60*60);   //120
		int reSecond = da % (60*60);  //0
		int reMinute = reSecond / 60; //0
		reSecond = reSecond % 60;
		label.setText(reHour+"시 "+reMinute+"분 "+reSecond+"초 사용");
		System.out.println("총 시간 : "+da);
//		if(check = false) {
//		label.setText("시"+"분"+da+"초");
	//	System.out.println("총 시간 : "+da);}
	}
	
}


public class Quiz01 {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    runTime mf=null;
    int num=0,result=0; String inputId=null,inputPw=null;
    int m=0;

    Login lo = new Login("계산기","메모장","calc.exe","notepad.exe"); boolean flag=true;

    lo.time();
    while(flag){
        System.out.print("1.로그인  2.가 입  3.로그아웃 \n>>>"); 
        num = input.nextInt();
        switch(num){
            case 1:System.out.print("아이디 입력 : ");
            		inputId = input.next();
            		System.out.print("비밀번호 입력 : "); 
            		inputPw = input.next();
            		result = lo.compare(inputId,inputPw);
            if(result == 0){
            	System.out.println("인증 통과");
            	mf = new runTime();
            	mf.setDaemon(true);
            	mf.start();
            	lo.display();
            	System.out.println("프로그램 종료");
            	runTime.check=false;
            	return ;
            }
            else  {
            	System.out.println("인증 실패");
            	break;
            }
            case 2: System.out.print("가입 id : ");
            	inputId = input.next();
            	System.out.print("가입 pw : "); 
            	inputPw = input.next();
            	lo.saveId_Pw(inputId,inputPw); 
            	System.out.println("저장 완료");
            	break;
            case 3:
            	flag=lo.out();
            	System.out.println("종료 합니다");
        }
    }
}

}