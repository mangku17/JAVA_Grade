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
		    JOptionPane.showMessageDialog(null, "20�ʾȿ� �α����� ���ּ���");
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
//				JOptionPane.showMessageDialog(null, "���:20�ʾȿ� �α����� ���ּ���");
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
	
	HashMap<String, Student_Data_Method> map2; // ����
	File_read data_load; // ���ϸ��� ����
	
	public JLabel timer_Label;
	
	public Login() {
		
		map2 = new HashMap<>(); //map2 �ʱ�ȭ
	    data_load = new File_read(); // �ʱ�ȭ
	    map2=data_load.fil_reading(); // map2 = ���� �� �������
	    
		TimerThread tr = new TimerThread(timer_Label);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�����������α׷�");
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);
		
		btnEnter = new JButton("�α���");  //�α��ι�ư
		btnEnter.setBounds(246, 266, 104, 37);
		con.add(btnEnter);
		btnEnter.addActionListener(loginListener);//�α��� �׼�
		
		btnExit = new JButton("����");	//���α׷� �����ư
		btnExit.setBounds(405, 266, 104, 37);
		con.add(btnExit);
		btnExit.addActionListener(ExitListener);//���� �׼�

		ButtonGroup bg = new ButtonGroup();

		rdStudent = new JRadioButton("�л�");//�л� ������ư
		rdStudent.setBackground(Color.WHITE);
		rdStudent.setBounds(228, 42, 179, 48);
		bg.add(rdStudent);
		con.add(rdStudent);
		


		rdAdmin = new JRadioButton("������");//������ ������ư
		rdAdmin.setBackground(Color.WHITE);
		rdAdmin.setBounds(447, 42, 179, 48);
		bg.add(rdAdmin);
		con.add(rdAdmin);

		tfID = new JTextField();//id �ؽ�Ʈ�ʵ�
		tfID.setBounds(246, 112, 263, 55);
		con.add(tfID);

		tfPW = new JTextField();//pw �ؽ�Ʈ�ʵ�
		tfPW.setBounds(245, 175, 263, 55);
		con.add(tfPW);

		JLabel laID = new JLabel("ID");//id ���̺�
		laID.setFont(new Font("Arial", Font.BOLD, 30));
		laID.setBounds(167, 119, 68, 37);
		con.add(laID);

		JLabel laPW = new JLabel("PW");//pw ���̺�
		laPW.setFont(new Font("Arial", Font.BOLD, 30));
		laPW.setBounds(168, 178, 68, 37);
		con.add(laPW);
		
		
		JLabel timerLabel = new JLabel();;//time ���̺�
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

	//�α��� �׼��Լ�
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
		    
		    //�л�������ư,id,pw,�α��ι�ư ��
		    for(int i=0;i<st.length;i++) {
				if(selAd==true&&selbt1==false&&input_ad.id.equals(input_data1)&&input_data2.equals(input_ad.pw)){
					AdminPage_Main admin_run = new AdminPage_Main(input_ad.id, map2);
					dispose();
					break;
				}
			//�����ڶ�����ư,id,pw,�α��ι�ư �� (������id:adminstor pw:0000)
				else if(selSt==true&&selbt1==false&&(input_data1.equals(map2.get(st[i]).get_name()))&&(input_data2.equals(String.valueOf(map2.get(st[i]).get_pw())))){
					System.out.println("�л����");
					dispose();
					StudentPage Student_run = new StudentPage();
					Student_run.idLabel.setText(map2.get(st[i]).get_name()+"�� ȯ���մϴ�.");
					//map2.get(st[i]).get_name()
					break;
				}
		    }
		}
	};
	//���α׷� ���� �׼��Լ�
	ActionListener ExitListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String selbt2= btnExit.getText();
			if(selbt2 == "����")
				System.exit(0);
		}
	};
	
}
