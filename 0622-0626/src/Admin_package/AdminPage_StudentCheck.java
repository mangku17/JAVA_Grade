package Admin_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;

import Main.*;

public class AdminPage_StudentCheck extends JFrame {
	static HashMap<String, Student_Data_Method> map2;
	static String id;
	static JTextField txt1;
	static String title[] = { "이름", "학번", "PYTHON", "JAVA", "C", "총점", "평균", "학점" };
	static Object data[][] = new Object[50][8];
	static JTable table;

	AdminPage_StudentCheck(String admin, HashMap<String, Student_Data_Method> map2) {
		this.id = admin;
		this.map2 = map2;
		Container con = getContentPane();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(null);
		con.setBackground(Color.WHITE);
		
		JLabel idLabel = new JLabel(this.id); // 관리자 ID 출력
		idLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		idLabel.setBounds(647, 0, 135, 34);
		con.add(idLabel);

//		------------------------------------------------------------------------
//		메인메뉴 타이틀 시작
//		------------------------------------------------------------------------
		JButton btnIfmSearch = new JButton("학생 정보 조회"); // 정보 조회 버튼, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmSearch.setBackground(new Color(51, 255, 255));
		btnIfmSearch.setBounds(0, 90, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		btnIfmSearch.addActionListener(adminListner1);
		con.add(btnIfmSearch);
		
		JButton btnIfmDel = new JButton("학생 정보 입력"); // 정보 삭제 버튼, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmDel.setBackground(new Color(153, 255, 255));
		btnIfmDel.setBounds(0, 140, 195, 34);
		btnIfmDel.setBorderPainted(false);
		btnIfmDel.addActionListener(adminListner2);
		con.add(btnIfmDel);
		
		JButton btnScInput = new JButton("학생 정보 삭제"); // 성적 입력 버튼, btnScInput
		btnScInput.setForeground(new Color(0, 0, 0));
		btnScInput.setFont(new Font("굴림", Font.PLAIN, 14));
		btnScInput.setBackground(new Color(153, 255, 255));
		btnScInput.setBounds(0, 190, 195, 34);
		btnScInput.setBorderPainted(false);
		btnScInput.addActionListener(adminListner3);
		con.add(btnScInput);
		
		JButton btnScRevise = new JButton("학생 성적 수정"); // 성적 수정 버튼, btnScRevise
		btnScRevise.setForeground(new Color(0, 0, 0));
		btnScRevise.setFont(new Font("굴림", Font.PLAIN, 14));
		btnScRevise.setBackground(new Color(153, 255, 255));
		btnScRevise.setBounds(0, 240, 195, 34);
		btnScRevise.setBorderPainted(false);
		btnScRevise.addActionListener(adminListner4);
		con.add(btnScRevise);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setFont(new Font("굴림", Font.PLAIN, 14));
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(153, 255, 255));
		btnLogout.setBounds(0, 290, 195, 34);
		btnLogout.addActionListener(adminListner5);
		con.add(btnLogout);
		
		
		
//		------------------------------------------------------------------------
//		메인메뉴 타이틀 끝
//		------------------------------------------------------------------------
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 195, 371);
		con.add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // 메인메뉴 타이틀 패널입니다, 동작 x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		

		JLabel labelName = new JLabel("학생 이름");
		labelName.setFont(new Font("굴림", Font.BOLD, 20));
		labelName.setBounds(232, 78, 104, 22);
		con.add(labelName);

		txt1 = new JTextField();
		txt1.setBounds(374, 78, 181, 34);
		con.add(txt1);
		txt1.setColumns(10);

		JButton btnIfmInput1 = new JButton("검색"); // 정보입력 버튼 ,btnIfmInput1
		btnIfmInput1.setBackground(new Color(176, 196, 222));
		btnIfmInput1.setForeground(new Color(0, 0, 0));
		btnIfmInput1.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmInput1.setBounds(567, 78, 149, 34);
		btnIfmInput1.setBorderPainted(false);
		btnIfmInput1.addActionListener(adminListner);
		con.add(btnIfmInput1);

		// model = new DefaultTableModel(data, title);
		table = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table);
		// JRadioButton box = new JRadioButton();
		table.setBounds(79, 159, 561, 174);
		sp.setBounds(207, 176, 575, 185);
		con.add(sp);

		setSize(800, 400);
		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		new AdminPage_StudentCheck(id, map2);
	}

	ActionListener adminListner1 = new ActionListener() { // 버튼 동작 action 입니다.
		public void actionPerformed(ActionEvent e) {
			AdminPage_StudentCheck stuChe = new AdminPage_StudentCheck(id, map2);
		}
	};
	ActionListener adminListner2 = new ActionListener() { // 버튼 동작 action 입니다.
		public void actionPerformed(ActionEvent e) {
			AdminPage_Student_Input stuChe = new AdminPage_Student_Input(id, map2);
		}
	};

	ActionListener adminListner3 = new ActionListener() { // 버튼 동작 action 입니다.
		public void actionPerformed(ActionEvent e) {
			AdminPage_Student_Del stuChe = new AdminPage_Student_Del(id, map2);
		}
	};
	ActionListener adminListner4 = new ActionListener() { // 버튼 동작 action 입니다.
		public void actionPerformed(ActionEvent e) {
			AdminPage_Student_Sc_Input stuChe = new AdminPage_Student_Sc_Input(id, map2);

		}
	};
	ActionListener adminListner5 = new ActionListener() { // 버튼 동작 action 입니다.
		public void actionPerformed(ActionEvent e) {
			Login stuChe = new Login();

		}
	};

	ActionListener adminListner = new ActionListener() { // 버튼 동작 action 입니다.

		public void actionPerformed(ActionEvent e) {
			String search_data = txt1.getText();
			Object[] st_temp = map2.keySet().toArray();
			String[] st = new String[st_temp.length];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}

			table_data_set(st,search_data);

		}
		void table_data_set(String[] st, String search_data) {

			
			if (search_data.equals("모든학생") || search_data.equals("모든 학생") || search_data.equals("all")
					|| search_data.equals("All")) {
				for (int i = 0; i < st.length; i++) {
					for (int j = 0; j < data[i].length; j++) {
						switch (j) {
						case 0:
							data[i][j] = map2.get(st[i]).get_name();
							break;
						case 1:
							data[i][j] = map2.get(st[i]).get_num();
							break;
						case 2:
							data[i][j] = map2.get(st[i]).get_python();
							break;
						case 3:
							data[i][j] = map2.get(st[i]).get_java();
							break;
						case 4:
							data[i][j] = map2.get(st[i]).get_c();
							break;
						case 5:
							data[i][j] = map2.get(st[i]).get_total();
							break;
						case 6:
							data[i][j] = map2.get(st[i]).get_avg();
							break;
						case 7:
							data[i][j] = map2.get(st[i]).get_grades();
							break;
						default:
							break;
						}
					}
				}
			} else {
				for (int i = 0; i < st.length; i++) {
					if (st[i].equals(search_data)) {
						for (int j = 0; j < data[0].length; j++) {
							switch (j) {
							case 0:
								data[0][j] = map2.get(st[i]).get_name();
								break;
							case 1:
								data[0][j] = map2.get(st[i]).get_num();
								break;
							case 2:
								data[0][j] = map2.get(st[i]).get_python();
								break;
							case 3:
								data[0][j] = map2.get(st[i]).get_c();
								break;
							case 4:
								data[0][j] = map2.get(st[i]).get_java();
								break;
							case 5:
								data[0][j] = map2.get(st[i]).get_total();
								break;
							case 6:
								data[0][j] = map2.get(st[i]).get_avg();
								break;
							case 7:
								data[0][j] = map2.get(st[i]).get_grades();
								break;
							default:
								break;
							}
						}
					}

				}
				for (int k = 1; k < data.length; k++) {
					for (int l = 0; l < data[k].length; l++)
						data[k][l] = null;
				}
			}

			table.repaint();
		}
		
	};
}