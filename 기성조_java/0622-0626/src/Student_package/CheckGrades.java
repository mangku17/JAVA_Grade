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

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 195, 371);
		con.add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // ���θ޴� Ÿ��Ʋ �г��Դϴ�, ���� x
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 0));

		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(200, 320, 590, 40);
		controlPanel.setBackground(Color.white);
		JTextField tfName = new JTextField(10);
		JButton btnCheck = new JButton("Ȯ��");
		controlPanel.add(new JLabel("�л� �̸�"));
		controlPanel.add(tfName);
		controlPanel.add(btnCheck);
		con.add(controlPanel);
		btnCheck.addActionListener(new DrawActionListener(tfName, drawingPanel));

		// "�׷��� �׸���" ��ư�� �������� �۵� �� �����͵��
		setSize(800, 400);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		new CheckGrades();
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

//�׷����� �׸��� �г� Ŭ����
class DrawingPanel extends JPanel {
	int score_java, score_python, score_cs;
	float score_avg;

	// ���� �׷��� �׸��°�
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(30, 250, getWidth(), 250); // �׷��� x,y
		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt * 10 + "", 0, 255 - 20 * cnt); // y�� ���ݴ���
			g.drawLine(30, 250 - 20 * cnt, 750, 250 - 20 * cnt); // y�� ���ݼ�
		}
		g.drawLine(30, 30, 30, 250);
		g.drawString("Java_score", 75, 270);
		g.drawString("Python_score", 200, 270);
		g.drawString("C_score", 330, 270);
		g.drawString("Avreage", 430, 270);
		g.setColor(Color.DARK_GRAY);

		if (score_java > 0) {
			g.fillRect(90, 250 - score_java * 2, 30, score_java * 2); // �ڹ� ����׷���
			g.drawString(Integer.toString(score_java), 95, (250 - score_java * 2) - 3); // �ڹ� ���� ǥ��
		}
		if (score_python > 0) {
			g.fillRect(220, 250 - score_python * 2, 30, score_python * 2); // ���̽� ����׷���
			g.drawString(Integer.toString(score_python), 228, (250 - score_python * 2) - 3); // ���̽� ���� ǥ��
		}
		if (score_cs > 0) {
			g.fillRect(340, 250 - score_cs * 2, 30, score_cs * 2); // c ����׷���
			g.drawString(Integer.toString(score_cs), 345, (250 - score_cs * 2) - 3); // C ���� ǥ��
		}
		if (score_avg > 0) {
			g.fillRect(440, 250 - (int) (score_avg) * 2, 30, (int) (score_avg) * 2); // ��� ����׷���
			g.drawString(Float.toString(score_avg), 445, (250 - (int) (score_avg) * 2) - 3); // ��� ���� ǥ��
		}
	}

	// ���� �޾ƿ��� �Լ�
	void setScores(int score_java, int score_python, int score_cs, float score_avg) {
		this.score_java = score_java;
		this.score_python = score_python;
		this.score_cs = score_cs;
		this.score_avg = score_avg;
	}
}

//��ư �������� �����ϴ� ������
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

		HashMap<String, Student_Data_Method> map2; // ����
		File_read data_load; // ���ϸ��� ����
		map2 = new HashMap<>(); // map2 �ʱ�ȭ
		data_load = new File_read(); // �ʱ�ȭ
		map2 = data_load.fil_reading(); // map2 = ���� �� �������
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