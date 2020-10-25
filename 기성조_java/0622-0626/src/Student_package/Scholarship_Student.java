package Student_package;

import java.awt.BorderLayout;
import Main.*;
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
import javax.swing.JTextField;

public class Scholarship_Student extends JFrame {

	HashMap<String, Student_Data_Method> map2; // ����
	File_read data_load; // ���ϸ��� ����
	JButton btnNewButton_1;
	JLabel lblNewLabel_1;
	JTextField textField;
	String[] st;

	public Scholarship_Student() {
		getContentPane().setForeground(new Color(102, 51, 153));

		map2 = new HashMap<>(); // map2 �ʱ�ȭ
		data_load = new File_read(); // �ʱ�ȭ
		map2 = data_load.fil_reading(); // map2 = ���� �� �������

		Object[] st_temp = map2.keySet().toArray();
		st = new String[st_temp.length];
		for (int i = 0; i < st_temp.length; i++) {
			st[i] = st_temp[i].toString();
		}

//   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(new Color(255, 255, 255));

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(0, 160, 195, 55);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.getText().equals("Logout")) {
					new Login();
				}
			}
		});
		getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 195, 371);
		getContentPane().add(panel);

		textField = new JTextField();
		textField.setBounds(283, 68, 316, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("�̸� :");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel.setBounds(226, 68, 62, 33);
		getContentPane().add(lblNewLabel);

		btnNewButton_1 = new JButton("�˻�");
		btnNewButton_1.setBounds(607, 67, 87, 28);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(adminListner);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("�ü�", Font.BOLD, 35));
		lblNewLabel_1.setBounds(266, 125, 501, 197);
		getContentPane().add(lblNewLabel_1);

		setSize(800, 400); // ȭ�� ������
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Scholarship_Student();

	}

	ActionListener adminListner = new ActionListener() { // ��ư ���� action �Դϴ�.

		@Override
		public void actionPerformed(ActionEvent e) {
			String selbt = btnNewButton_1.getText();
			String selbt1 = textField.getText();
			String success = "A";
			String labelText = lblNewLabel_1.getText();
			for (int i = 0; i < st.length; i++) {
				if (selbt.equals("�˻�") && selbt1.equals((map2.get(st[i]).get_name()))) {

					if (selbt1.equals(map2.get(st[i]).get_name()) && success.equals(map2.get(st[i]).get_grades())) {
						lblNewLabel_1.setText(map2.get(st[i]).get_name() + "���� ���л����� ����");
						break;

					} else if (selbt1.equals(map2.get(st[i]).get_name()) && success != map2.get(st[i]).get_grades()) {
						lblNewLabel_1.setText(map2.get(st[i]).get_name() + "���� ������ ��ȸ��");
						break;
					}

				}

			}

		}
	};

}