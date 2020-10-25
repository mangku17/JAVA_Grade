package Student_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StudentPage extends JFrame {
	public JLabel idLabel;

	public StudentPage() {
		getContentPane().setForeground(new Color(102, 51, 153));

//	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(new Color(255, 255, 255));

		idLabel = new JLabel("�л� ���̵� ���"); // ������ �� ���̺� �Դϴ� ����:idLabel
		idLabel.setBounds(647, 23, 135, 34);
		con.add(idLabel);

		JButton btnIfmInput = new JButton("������ ����"); // ������ ���� ��ư ,btnIfmInput
		btnIfmInput.setBackground(Color.ORANGE);
		btnIfmInput.setForeground(new Color(0, 0, 0));
		btnIfmInput.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmInput.setBounds(0, 85, 195, 34);
		btnIfmInput.setBorderPainted(false);
		btnIfmInput.addActionListener(adminListner);
		con.add(btnIfmInput);

		JButton btnIfmSearch = new JButton("�л� ���� ����"); // �л� ���� ����, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmSearch.setBackground(Color.ORANGE);
		btnIfmSearch.setBounds(0, 129, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		btnIfmSearch.addActionListener(adminListner);
		con.add(btnIfmSearch);

		JButton btnIfmDel = new JButton("���� ���"); // ���� ��� ��ư, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmDel.setBackground(Color.ORANGE);
		btnIfmDel.setBounds(0, 173, 195, 34);
		btnIfmDel.setBorderPainted(false);
		btnIfmDel.addActionListener(adminListner);
		con.add(btnIfmDel);

		JLabel lblNewLabel_1 = new JLabel("�ȳ��ϼ��� �л��� ������ �Դϴ�"); // �ؽ��� �г��Դϴ� ���� x
		lblNewLabel_1.setBackground(new Color(255, 218, 185));
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(264, 67, 503, 68);
		con.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("�޴��� ������ �ּ���");// �ؽ��� �г��Դϴ� ���� x
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(558, 118, 267, 62);
		con.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 195, 371);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // ���θ޴� Ÿ��Ʋ �г��Դϴ�, ���� x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		panel_1.setBounds(194, 67, 600, 101);
		getContentPane().add(panel_1);

		setSize(800, 400); // ȭ�� ������
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentPage();
	}

	ActionListener adminListner = new ActionListener() { // ��ư ���� action �Դϴ�.

		@Override
		public void actionPerformed(ActionEvent e) {

			String[] arr = { "������ ����", "�л� ���� ����", "���� ���" };
			// �Ʒ� for���� ��ư �̸��� �ֱ� ���� �迭�Դϴ�!\

			JButton btn = (JButton) e.getSource();
			if (btn.getText().equals("������ ����")) {
				new SatisfactionSurvey();
			} else if (btn.getText().equals("�л� ���� ����")) {
				new CheckGrades();
			} else if (btn.getText().equals("���� ���")) {
				new CounselingStu();
			}
		}
	};
}