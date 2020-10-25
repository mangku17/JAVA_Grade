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

		idLabel = new JLabel("학생 아이디 출력"); // 오른쪽 위 레이블 입니다 변수:idLabel
		idLabel.setBounds(647, 23, 135, 34);
		con.add(idLabel);

		JButton btnIfmInput = new JButton("만족도 조사"); // 만족도 조사 버튼 ,btnIfmInput
		btnIfmInput.setBackground(Color.ORANGE);
		btnIfmInput.setForeground(new Color(0, 0, 0));
		btnIfmInput.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmInput.setBounds(0, 85, 195, 34);
		btnIfmInput.setBorderPainted(false);
		btnIfmInput.addActionListener(adminListner);
		con.add(btnIfmInput);

		JButton btnIfmSearch = new JButton("학생 성적 열람"); // 학생 성적 열람, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmSearch.setBackground(Color.ORANGE);
		btnIfmSearch.setBounds(0, 129, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		btnIfmSearch.addActionListener(adminListner);
		con.add(btnIfmSearch);

		JButton btnIfmDel = new JButton("교수 상담"); // 교수 상담 버튼, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmDel.setBackground(Color.ORANGE);
		btnIfmDel.setBounds(0, 173, 195, 34);
		btnIfmDel.setBorderPainted(false);
		btnIfmDel.addActionListener(adminListner);
		con.add(btnIfmDel);

		JLabel lblNewLabel_1 = new JLabel("안녕하세요 학생용 페이지 입니다"); // 텍스터 패널입니다 동작 x
		lblNewLabel_1.setBackground(new Color(255, 218, 185));
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(264, 67, 503, 68);
		con.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("메뉴를 선택해 주세요");// 텍스터 패널입니다 동작 x
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(558, 118, 267, 62);
		con.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 195, 371);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // 메인메뉴 타이틀 패널입니다, 동작 x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		panel_1.setBounds(194, 67, 600, 101);
		getContentPane().add(panel_1);

		setSize(800, 400); // 화면 사이즈
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentPage();
	}

	ActionListener adminListner = new ActionListener() { // 버튼 동작 action 입니다.

		@Override
		public void actionPerformed(ActionEvent e) {

			String[] arr = { "만족도 조사", "학생 성적 열람", "교수 상담" };
			// 아래 for문에 버튼 이름을 넣기 위한 배열입니다!\

			JButton btn = (JButton) e.getSource();
			if (btn.getText().equals("만족도 조사")) {
				new SatisfactionSurvey();
			} else if (btn.getText().equals("학생 성적 열람")) {
				new CheckGrades();
			} else if (btn.getText().equals("교수 상담")) {
				new CounselingStu();
			}
		}
	};
}