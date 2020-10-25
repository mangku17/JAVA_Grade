package Admin_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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

public class AdminPage_Student_Input extends JFrame {
	static HashMap<String, Student_Data_Method> map2;
	static String id;
	static JTextField txt1;
	String title[] = { "�̸�", "�й�", "PW" };
	Object data[][] = new Object[50][3];
	static JTable table;
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;

	AdminPage_Student_Input(String admin, HashMap<String, Student_Data_Method> map2) {

		this.id = admin;
		this.map2 = map2;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
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
		btnIfmDel.setBackground(new Color(51, 255, 255));
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 195, 371);
		con.add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // ���θ޴� Ÿ��Ʋ �г��Դϴ�, ���� x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));

//	  ---------------------------------------------------------------------------------------
//	 	 ���⼭ ���� �̸� �й� �н����� �Է� �ؽ�Ʈ �ʵ� �Դϴ�.
//	  ---------------------------------------------------------------------------------------

		JLabel labelStName = new JLabel("�̸�"); // �л� �̸� ���Դϴ�, labelStName, ���� x
		labelStName.setFont(new Font("����", Font.BOLD, 18));
		labelStName.setBackground(new Color(204, 255, 255));
		labelStName.setBounds(268, 74, 48, 34);
		con.add(labelStName);

		textField = new JTextField(); // �л� �̸� �ؽ�Ʈ �ʵ� �Դϴ�. ���� �Է�!
		textField.setBounds(326, 74, 135, 29);
		con.add(textField);
		textField.setColumns(10);

		JLabel labelStNum = new JLabel("�й�"); // �й� ���Դϴ�, labelStNum, ���� x
		labelStNum.setFont(new Font("����", Font.BOLD, 18));
		labelStNum.setBackground(new Color(204, 255, 255));
		labelStNum.setBounds(522, 74, 48, 34);
		con.add(labelStNum);

		textField_1 = new JTextField(); // �й� �ؽ�Ʈ �ʵ� �Դϴ�. ���� �Է�!
		textField_1.setColumns(10);
		textField_1.setBounds(580, 74, 135, 29);
		con.add(textField_1);

		JLabel labelStPw = new JLabel("PW"); // �н����� ���Դϴ�, labelStPw, ���� x
		labelStPw.setFont(new Font("����", Font.BOLD, 18));
		labelStPw.setBackground(new Color(204, 255, 255));
		labelStPw.setBounds(268, 118, 48, 34);
		con.add(labelStPw);

		textField_2 = new JTextField(); // �н����� �ؽ�Ʈ �ʵ� �Դϴ�. ���� �Է�!
		textField_2.setColumns(10);
		textField_2.setBounds(326, 118, 135, 29);
		con.add(textField_2);

		JButton btnStInput = new JButton("���� �Է�"); // ���� �Է� ��ư�Դϴ�, btnStInput,
		btnStInput.setFont(new Font("����", Font.BOLD, 12));
		btnStInput.setBackground(new Color(176, 196, 222));
		btnStInput.setBounds(522, 118, 100, 29);
		con.add(btnStInput);
		btnStInput.addActionListener(adminListner);
		
		JButton btnStCheck = new JButton("���� Ȯ��"); // ���� Ȯ�� ��ư�Դϴ�, 
		btnStCheck.setFont(new Font("����", Font.BOLD, 12));
		btnStCheck.setBackground(new Color(176, 196, 222));
		btnStCheck.setBounds(630, 118, 100, 29);
		con.add(btnStCheck);
		btnStCheck.addActionListener(data_view_Listner);
		/*
		 * JTable �Դϴ�.
		 */

		table = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table);
		JRadioButton box = new JRadioButton();

		table.setBounds(79, 159, 561, 174);
		sp.setBounds(207, 176, 575, 185);
		con.add(sp);

		setSize(800, 400); // ȭ�� ������
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new AdminPage_Student_Input(id, map2);
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


	ActionListener adminListner = new ActionListener() { // ���� �з¹�ư ���� action �Դϴ�.

		public void actionPerformed(ActionEvent e) {

			String name_data = textField.getText();
			String num_data = textField_1.getText();
			String pw_data = textField_2.getText();

			String[] st = key_String_list();

			for (int i = 0; i < st.length; i++) {
				if (st[i].contains((CharSequence) name_data)) {
					String compare_str;
					for (int j = 1; j < st.length; j++) {
						if (name_data.contains("_")) {
							compare_str = name_data;
							if (st[i].equals(compare_str)) {
								compare_str = name_data + "_" + Integer.toString(j);
								name_data = compare_str;
								break;
							} else {
								name_data = compare_str + "_" + Integer.toString(j);
								break;
							}
						}else {
							compare_str = name_data + "_" + Integer.toString(j);
							name_data = compare_str;
							break;
						}
					}
				}
			}

			Student_Data_Method new_student = new Student_Data_Method(name_data, Integer.parseInt(num_data),
					Integer.parseInt(pw_data));

			map2.put(new_student.get_name(), new_student);
			
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
						data[i][j] = map2.get(st[i]).get_pw();
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
