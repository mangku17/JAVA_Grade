package Admin_package;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import Main.*;

public class AdminPage_Student_Del extends JFrame {

	static String id;
	static JTextField deleteField;
	static String title[] = { "이름", "학번", "PYTHON", "JAVA", "C", "총점", "평균", "학점" };
	static JButton btnDelete;
	static Object data[][] = new Object[50][8];
	static JTable table;
	static HashMap<String, Student_Data_Method> map2; // 선언

	AdminPage_Student_Del(String admin, HashMap<String, Student_Data_Method> map2) {

		this.id = admin;
		this.map2 = map2;
		Container con = getContentPane();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생 정보 삭제");
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
		btnIfmSearch.setBackground(new Color(153, 255, 255));
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
		btnScInput.setBackground(new Color(51, 255, 255));
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
		//btnLogout.addActionListener(adminListner5);
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

		JLabel dtLable = new JLabel("학생 이름"); // 학생이름 레이블
		dtLable.setFont(new Font("굴림", Font.BOLD, 15));
		dtLable.setBounds(289, 85, 79, 38);
		con.add(dtLable);

		deleteField = new JTextField();// 검색 텍스트필드
		deleteField.setBounds(380, 85, 137, 35);
		con.add(deleteField);
		deleteField.setColumns(10);

		btnDelete = new JButton("삭제"); // 검색버튼
		btnDelete.setBackground(new Color(176, 196, 222));
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
		btnDelete.setBounds(544, 85, 75, 34);
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(deleteListner);
		con.add(btnDelete);

		JButton data_view = new JButton("학생 정보 확인");
		data_view.setBackground(new Color(176, 196, 222));
		data_view.setForeground(new Color(0, 0, 0));
		data_view.setFont(new Font("굴림", Font.BOLD, 15));
		data_view.setBounds(544, 129, 150, 34);
		data_view.setBorderPainted(false);
		data_view.addActionListener(data_view_Listner);
		con.add(data_view);

		table = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table);
		JRadioButton box = new JRadioButton();
		table.setBounds(79, 159, 561, 174);
		sp.setBounds(207, 176, 575, 185);
		con.add(sp);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		sp.setColumnHeaderView(rdbtnNewRadioButton);

		setSize(800, 400);
		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		new AdminPage_Student_Del(id, map2);
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

	ActionListener deleteListner = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			

			String delete_data = deleteField.getText();

			Object[] st_temp = map2.keySet().toArray();
			String[] st = new String[st_temp.length];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}

			for (int i = 0; i < st_temp.length; i++) {
				if (st[i].equals(delete_data)) {
					map2.remove((st[i]));
				}
			}

			Object[] st_temp2 = map2.keySet().toArray();
			String[] st2 = new String[st_temp2.length];
			for (int i = 0; i < st_temp2.length; i++) {
				st2[i] = st_temp2[i].toString();
			}

			for (int k = 0; k < data.length; k++) {
				if (k < st2.length) {
					for (int i = 0; i < st2.length; i++) {
						for (int j = 0; j < data[i].length; j++) {
							switch (j) {
							case 0:
								data[i][j] = map2.get(st2[i]).get_name();
								break;
							case 1:
								data[i][j] = map2.get(st2[i]).get_num();
								break;
							case 2:
								data[i][j] = map2.get(st2[i]).get_python();
								break;
							case 3:
								data[i][j] = map2.get(st2[i]).get_c();
								break;
							case 4:
								data[i][j] = map2.get(st2[i]).get_java();
								break;
							case 5:
								data[i][j] = map2.get(st2[i]).get_total();
								break;
							case 6:
								data[i][j] = map2.get(st2[i]).get_avg();
								break;
							case 7:
								data[i][j] = map2.get(st2[i]).get_grades();
								break;
							default:
								break;

							}
						}
					}
				}else {
					for(int l=0; l<data[k].length;l++) 
						data[k][l]=null;			
				}
			}

			table.repaint();
			
			File_writer file_save = new File_writer(map2);
			file_save.file_wirting();
		}
	};

	ActionListener data_view_Listner = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			Object[] st_temp = map2.keySet().toArray();
			String[] st = new String[st_temp.length];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}
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
						data[i][j] = map2.get(st[i]).get_c();
						break;
					case 4:
						data[i][j] = map2.get(st[i]).get_java();
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
			table.repaint();
		}
	};
}