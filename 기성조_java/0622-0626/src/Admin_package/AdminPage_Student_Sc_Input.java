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

public class AdminPage_Student_Sc_Input extends JFrame {
	static HashMap<String, Student_Data_Method> map2;
	static String id;
	static String title[] = { "�̸�", "�й�", "PYTHON", "JAVA", "C", "����", "���", "����" };
	static Object data[][] = new Object[50][8];
	static JTable table;
	static JTextField text_Name_data, text_Java_score, text_Python_score, text_C_score;
	static JTextField text_Data_search;

	AdminPage_Student_Sc_Input(String admin, HashMap<String, Student_Data_Method> map2) {

		this.id = admin;
		this.map2 = map2;
		Container con = getContentPane();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�л����� �Է�");
		con.setLayout(null);
		con.setBackground(Color.WHITE);
		
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
		btnScRevise.setBackground(new Color(51, 255, 255));
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
		;
		
		
//		------------------------------------------------------------------------
//		���θ޴� Ÿ��Ʋ ��
//		------------------------------------------------------------------------
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 195, 371);
		con.add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // ���θ޴� Ÿ��Ʋ �г��Դϴ�, ���� x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		

		JLabel lblNewLabel1 = new JLabel("�л� �̸�"); // �̸� �ٽ�
		lblNewLabel1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel1.setBounds(240, 44, 120, 15);
		con.add(lblNewLabel1);
		text_Name_data = new JTextField();
		text_Name_data.setBounds(240, 59, 96, 15);
		con.add(text_Name_data);
		text_Name_data.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("PYTHON ����");
		lblNewLabel_1_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(360, 44, 120, 15);
		con.add(lblNewLabel_1_1);
		text_Python_score = new JTextField();
		text_Python_score.setBounds(360, 59, 96, 15);
		con.add(text_Python_score);
		text_Python_score.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("C ����");
		lblNewLabel_1_1_2.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(480, 44, 120, 15);
		con.add(lblNewLabel_1_1_2);
		text_C_score = new JTextField();
		text_C_score.setBounds(480, 59, 96, 15);
		con.add(text_C_score);
		text_C_score.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("JAVA ����");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1.setBounds(600, 44, 120, 15);
		con.add(lblNewLabel_1);
		text_Java_score = new JTextField();
		text_Java_score.setBounds(600, 59, 96, 15);
		con.add(text_Java_score);
		text_Java_score.setColumns(10);


		
		JLabel lblNewLabel_data_search = new JLabel("�л� ���� Ȯ��");
		lblNewLabel_data_search.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_data_search.setBounds(240, 106, 120, 15);
		con.add(lblNewLabel_data_search);
		text_Data_search = new JTextField();
		text_Data_search.setBounds(240, 126, 96, 15);
		con.add(text_Data_search);
		text_Data_search.setColumns(10);
		
		
		JButton scoreInput = new JButton("���� ����");
		scoreInput.addActionListener(adminListner);
		scoreInput.setBackground(new Color(176, 196, 222));
		scoreInput.setBounds(594, 125, 100, 25);
		con.add(scoreInput);

		JButton scoreView = new JButton("���� Ȯ��");
		scoreView.addActionListener(adminListner_data_view);
		scoreView.setBackground(new Color(176, 196, 222));
		scoreView.setBounds(460, 125, 100, 25);
		con.add(scoreView);

		table = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table);
		JRadioButton box = new JRadioButton();
		table.setBounds(79, 159, 561, 174);
		sp.setBounds(207, 176, 575, 185);
		con.add(sp);

		setSize(800, 400);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new AdminPage_Student_Sc_Input(id, map2);
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
	
	ActionListener adminListner = new ActionListener() { // ��ư ���� action �Դϴ�.

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] set_Student_data = new String[4];
			set_Student_data[0]= text_Name_data.getText();
			set_Student_data[1]= text_Java_score.getText();
			set_Student_data[2]= text_Python_score.getText();
			set_Student_data[3]= text_C_score.getText();
			
			String[] st = key_String_list();
			
			for(int i=0;i<st.length;i++) {
				if(st[i].equals(set_Student_data[0])) {
					map2.get(st[i]).set_java(Integer.parseInt(set_Student_data[1]));
					map2.get(st[i]).set_python(Integer.parseInt(set_Student_data[2]));
					map2.get(st[i]).set_c(Integer.parseInt(set_Student_data[3]));
					map2.get(st[i]).set_total();
					map2.get(st[i]).set_avg();
					map2.get(st[i]).rank_grades();
				}
			}
			
			File_writer file_save = new File_writer(map2);
			file_save.file_wirting();
		}
		
		String[] key_String_list() {
			Object[] st_temp = map2.keySet().toArray();
			String[] st = new String[st_temp.length];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}
			return st;
		}

	};

	ActionListener adminListner_data_view = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String search_data = text_Data_search.getText();
			String[] st = key_String_list();
			
			table_data_set(st, search_data);

		}
		
		String[] key_String_list() {
			Object[] st_temp = map2.keySet().toArray();
			String[] st = new String[st_temp.length];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}
			return st;
		}

		void table_data_set(String[] st, String search_data) {

			if (search_data.equals("����л�") || search_data.equals("��� �л�") || search_data.equals("all")
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