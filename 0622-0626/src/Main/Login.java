package Main;

import java.awt.Color;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Admin_package.*;
import Student_package.*;

class TimerThread extends Thread{
	JFrame jf = new JFrame();
	int i=1;
	public JLabel timerLabel;
	public TimerThread(JLabel timerLabel) {
		this.timerLabel=timerLabel;
	}
	public TimerThread(int i) {
	    this.i = i;
	   }
	
	public void run() {
		int n = 20;
		while(n != 0) {
			if(n==20)
		    JOptionPane.showMessageDialog(null, "20초안에 로그인을 해주세요");
			timerLabel.setText(Integer.toString(n)+" "+"Sec");
			n--;
			try {
				Thread.sleep(1000);
				
			}
			catch(InterruptedException e) {
				return;
			}
			if(n==0) {
				jf.dispose();
			}
			if(n==10) {
//				JOptionPane.showMessageDialog(null, "경고:20초안에 로그인을 해주세요");
			}
		}
	}
}


public class Login extends JFrame {
	
	JRadioButton rdStudent;
	JRadioButton rdAdmin;
	JTextField tfID;
	JTextField tfPW;
	JButton btnEnter;
	JButton btnExit; 
	manager input_ad = new manager();
	
	HashMap<String, Student_Data_Method> map2; // 선언
	File_read data_load; // 파일리드 선언
	
	public JLabel timer_Label;
	
	public Login() {
		
		map2 = new HashMap<>(); //map2 초기화
	    data_load = new File_read(); // 초기화
	    map2=data_load.fil_reading(); // map2 = 엑셀 다 집어넣음
	    
		TimerThread tr = new TimerThread(timer_Label);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("성적관리프로그램");
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);
		
		btnEnter = new JButton("로그인");  //로그인버튼
		btnEnter.setBounds(246, 266, 104, 37);
		con.add(btnEnter);
		btnEnter.addActionListener(loginListener);//로그인 액션
		
		btnExit = new JButton("종료");	//프로그램 종료버튼
		btnExit.setBounds(405, 266, 104, 37);
		con.add(btnExit);
		btnExit.addActionListener(ExitListener);//종료 액션

		ButtonGroup bg = new ButtonGroup();

		rdStudent = new JRadioButton("학생");//학생 라디오버튼
		rdStudent.setBackground(Color.WHITE);
		rdStudent.setBounds(228, 42, 179, 48);
		bg.add(rdStudent);
		con.add(rdStudent);
		


		rdAdmin = new JRadioButton("관리자");//관리자 라디오버튼
		rdAdmin.setBackground(Color.WHITE);
		rdAdmin.setBounds(447, 42, 179, 48);
		bg.add(rdAdmin);
		con.add(rdAdmin);

		tfID = new JTextField();//id 텍스트필드
		tfID.setBounds(246, 112, 263, 55);
		con.add(tfID);

		tfPW = new JTextField();//pw 텍스트필드
		tfPW.setBounds(245, 175, 263, 55);
		con.add(tfPW);

		JLabel laID = new JLabel("ID");//id 레이블
		laID.setFont(new Font("Arial", Font.BOLD, 30));
		laID.setBounds(167, 119, 68, 37);
		con.add(laID);

		JLabel laPW = new JLabel("PW");//pw 레이블
		laPW.setFont(new Font("Arial", Font.BOLD, 30));
		laPW.setBounds(168, 178, 68, 37);
		con.add(laPW);
		
		
		JLabel timerLabel = new JLabel();;//time 레이블
		timerLabel.setBounds(646, 10, 128, 98);
		timerLabel.setFont(new Font("Arial", Font.BOLD, 30));
		con.add(timerLabel);
		TimerThread th = new TimerThread(timerLabel);
		th.start();
		
		setSize(800, 400);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

	//로그인 액션함수
	ActionListener loginListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			boolean selSt = rdStudent.isSelected();
			boolean selAd = rdAdmin.isSelected();
			boolean selbt1= btnEnter.isSelected();
					
			String input_data1=tfID.getText();	
			String input_data2=tfPW.getText();
			
			 	
			Object[] st_temp = map2.keySet().toArray(); 
	        String[] st = new String[st_temp.length];
	         for (int i = 0; i < st_temp.length; i++) {
	            st[i] = st_temp[i].toString();
	         }
	         
		    int j=1;
		    
		    //학생라디오버튼,id,pw,로그인버튼 비교
		    for(int i=0;i<st.length;i++) {
				if(selAd==true&&selbt1==false&&input_ad.id.equals(input_data1)&&input_data2.equals(input_ad.pw)){
					AdminPage_Main admin_run = new AdminPage_Main(input_ad.id, map2);
					dispose();
					break;
				}
			//관리자라디오버튼,id,pw,로그인버튼 비교 (관리자id:adminstor pw:0000)
				else if(selSt==true&&selbt1==false&&(input_data1.equals(map2.get(st[i]).get_name()))&&(input_data2.equals(String.valueOf(map2.get(st[i]).get_pw())))){
					System.out.println("학생모드");
					dispose();
					StudentPage Student_run = new StudentPage();
					Student_run.idLabel.setText(map2.get(st[i]).get_name()+"님 환영합니다.");
					//map2.get(st[i]).get_name()
					break;
				}
		    }
		}
	};
	//프로그램 종료 액션함수
	ActionListener ExitListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String selbt2= btnExit.getText();
			if(selbt2 == "종료")
				System.exit(0);
		}
	};
	
}
