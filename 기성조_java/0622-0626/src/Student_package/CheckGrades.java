package Student_package;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;
import Main.*;

public class CheckGrades extends JFrame {

	CheckGrades() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);

		DrawingPanel drawingPanel = new DrawingPanel();
		drawingPanel.setBounds(220, 25, 500, 300);
		con.add(drawingPanel);

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 195, 371);
		con.add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // 메인메뉴 타이틀 패널입니다, 동작 x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));

		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(200, 320, 590, 40);
		controlPanel.setBackground(Color.white);
		JTextField tfName = new JTextField(10);
		JButton btnCheck = new JButton("확인");
		controlPanel.add(new JLabel("학생 이름"));
		controlPanel.add(tfName);
		controlPanel.add(btnCheck);
		con.add(controlPanel);
		btnCheck.addActionListener(new DrawActionListener(tfName, drawingPanel));

		// "그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
		setSize(800, 400);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		new CheckGrades();
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

//그래프를 그리는 패널 클래스
class DrawingPanel extends JPanel {
	int score_java, score_python, score_cs;
	float score_avg;

	// 막대 그래프 그리는곳
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(30, 250, getWidth(), 250); // 그래프 x,y
		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt * 10 + "", 0, 255 - 20 * cnt); // y축 눈금단위
			g.drawLine(30, 250 - 20 * cnt, 750, 250 - 20 * cnt); // y축 눈금선
		}
		g.drawLine(30, 30, 30, 250);
		g.drawString("Java_score", 75, 270);
		g.drawString("Python_score", 200, 270);
		g.drawString("C_score", 330, 270);
		g.drawString("Avreage", 430, 270);
		g.setColor(Color.DARK_GRAY);

		if (score_java > 0) {
			g.fillRect(90, 250 - score_java * 2, 30, score_java * 2); // 자바 막대그래프
			g.drawString(Integer.toString(score_java), 95, (250 - score_java * 2) - 3); // 자바 점수 표시
		}
		if (score_python > 0) {
			g.fillRect(220, 250 - score_python * 2, 30, score_python * 2); // 파이썬 막대그래프
			g.drawString(Integer.toString(score_python), 228, (250 - score_python * 2) - 3); // 파이썬 점수 표시
		}
		if (score_cs > 0) {
			g.fillRect(340, 250 - score_cs * 2, 30, score_cs * 2); // c 막대그래프
			g.drawString(Integer.toString(score_cs), 345, (250 - score_cs * 2) - 3); // C 점수 표시
		}
		if (score_avg > 0) {
			g.fillRect(440, 250 - (int) (score_avg) * 2, 30, (int) (score_avg) * 2); // 평균 막대그래프
			g.drawString(Float.toString(score_avg), 445, (250 - (int) (score_avg) * 2) - 3); // 평균 점수 표시
		}
	}

	// 점수 받아오는 함수
	void setScores(int score_java, int score_python, int score_cs, float score_avg) {
		this.score_java = score_java;
		this.score_python = score_python;
		this.score_cs = score_cs;
		this.score_avg = score_avg;
	}
}

//버튼 눌렀을때 동작하는 리스너
class DrawActionListener implements ActionListener {
	JTextField name;
	DrawingPanel drawingPanel;
	String check_name;
	int c;
	int java;
	int python;
	float avg;

	DrawActionListener(JTextField name, DrawingPanel drawingPanel) {
		this.name = name;
		this.drawingPanel = drawingPanel;
	}

	public void actionPerformed(ActionEvent e) {

		HashMap<String, Student_Data_Method> map2; // 선언
		File_read data_load; // 파일리드 선언
		map2 = new HashMap<>(); // map2 초기화
		data_load = new File_read(); // 초기화
		map2 = data_load.fil_reading(); // map2 = 엑셀 다 집어넣음
		Object[] st_temp = map2.keySet().toArray();
		String[] st = new String[st_temp.length];
		for (int i = 0; i < st_temp.length; i++) {
			st[i] = st_temp[i].toString();
		}

		for (int i = 0; i < st.length; i++) {
			if (name.getText().equals(map2.get(st[i]).get_name())) {
				c = map2.get(st[i]).get_c();
				java = map2.get(st[i]).get_java();
				python = map2.get(st[i]).get_python();
				avg = map2.get(st[i]).get_avg();
				avg = (float) (Math.round(avg * 100) / 100.0);
			}
		}
		drawingPanel.setScores(c, java, python, avg);
		drawingPanel.repaint();

	}
}