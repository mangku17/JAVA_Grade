package Admin_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Main.*;

public class AdminPage_Main extends JFrame {
	static HashMap<String, Student_Data_Method> map2;
	static String id;

	public AdminPage_Main(String admin, HashMap<String, Student_Data_Method> map2) {
		this.id = admin;
		this.map2 = map2;
		getContentPane().setForeground(new Color(102, 51, 153));

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(new Color(255, 255, 255));

		JLabel idLabel = new JLabel(this.id); // ������ ID ���
		idLabel.setFont(new Font("����", Font.PLAIN, 13));
		idLabel.setBounds(647, 0, 135, 34);
		con.add(idLabel);

//		------------------------------------------------------------------------
//		���θ޴� Ÿ��Ʋ ����
//		------------------------------------------------------------------------
		JButton btnIfmSearch = new JButton("�л� ���� ��ȸ"); // ���� ��ȸ ��ư, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmSearch.setBackground(new Color(153, 255, 255));
		btnIfmSearch.setBounds(0, 90, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		btnIfmSearch.addActionListener(adminListner1);
		con.add(btnIfmSearch);
		
		JButton btnIfmDel = new JButton("�л� ���� �Է�"); // ���� ���� ��ư, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmDel.setBackground(new Color(153, 255, 255));
		btnIfmDel.setBounds(0, 140, 195, 34);
		btnIfmDel.setBorderPainted(false);
		btnIfmDel.addActionListener(adminListner2);
		con.add(btnIfmDel);
		
		JButton btnScInput = new JButton("�л� ���� ����"); // ���� �Է� ��ư, btnScInput
		btnScInput.setForeground(new Color(0, 0, 0));
		btnScInput.setFont(new Font("����", Font.PLAIN, 14));
		btnScInput.setBackground(new Color(153, 255, 255));
		btnScInput.setBounds(0, 190, 195, 34);
		btnScInput.setBorderPainted(false);
		btnScInput.addActionListener(adminListner3);
		con.add(btnScInput);
		
		JButton btnScRevise = new JButton("�л� ���� ����"); // ���� ���� ��ư, btnScRevise
		btnScRevise.setForeground(new Color(0, 0, 0));
		btnScRevise.setFont(new Font("����", Font.PLAIN, 14));
		btnScRevise.setBackground(new Color(153, 255, 255));
		btnScRevise.setBounds(0, 240, 195, 34);
		btnScRevise.setBorderPainted(false);
		btnScRevise.addActionListener(adminListner4);
		con.add(btnScRevise);
		
		JButton btnLogout = new JButton("�α׾ƿ�");
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setFont(new Font("����", Font.PLAIN, 14));
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(153, 255, 255));
		btnLogout.setBounds(0, 290, 195, 34);
		btnLogout.addActionListener(adminListner5);
		con.add(btnLogout);
		
		
		
//		------------------------------------------------------------------------
//		���θ޴� Ÿ��Ʋ ��
//		------------------------------------------------------------------------
		con.add(btnScRevise);

		JLabel lblNewLabel_1 = new JLabel("�ȳ��ϼ��� �����ڿ� ������ �Դϴ�"); // �ؽ��� �г��Դϴ� ���� x
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(264, 67, 503, 68);
		con.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("�޴��� ������ �ּ���");// �ؽ��� �г��Դϴ� ���� x
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(558, 118, 267, 62);
		con.add(lblNewLabel_2);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(153, 255, 255));
		panel1.setBounds(0, 0, 195, 371);
		getContentPane().add(panel1);

		JLabel lblNewLabel1 = new JLabel("MAIN MENU"); // ���θ޴� Ÿ��Ʋ �г��Դϴ�, ���� x
		panel1.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel1.setBackground(new Color(51, 0, 102));
		lblNewLabel1.setForeground(new Color(0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setBounds(194, 67, 600, 101);
		getContentPane().add(panel_1);

		setSize(800, 400); // ȭ�� ������
		setResizable(false);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new AdminPage_Main(id, map2);
	}
	
	ActionListener adminListner1 = new ActionListener() { // ��ư ���� action �Դϴ�.
		public void actionPerformed(ActionEvent e) {
			AdminPage_StudentCheck stuChe = new AdminPage_StudentCheck(id, map2);
		}
	};
	ActionListener adminListner2 = new ActionListener() { // ��ư ���� action �Դϴ�.
		public void actionPerformed(ActionEvent e) {
			AdminPage_Student_Input stuChe = new AdminPage_Student_Input(id, map2);
		}
	};

	ActionListener adminListner3 = new ActionListener() { // ��ư ���� action �Դϴ�.
		public void actionPerformed(ActionEvent e) {
			AdminPage_Student_Del stuChe = new AdminPage_Student_Del(id, map2);
		}
	};
	ActionListener adminListner4 = new ActionListener() { // ��ư ���� action �Դϴ�.
		public void actionPerformed(ActionEvent e) {
			AdminPage_Student_Sc_Input stuChe = new AdminPage_Student_Sc_Input(id, map2);

		}
	};
	ActionListener adminListner5 = new ActionListener() { // ��ư ���� action �Դϴ�.
		public void actionPerformed(ActionEvent e) {
			Login stuChe = new Login();

		}
	};
}
