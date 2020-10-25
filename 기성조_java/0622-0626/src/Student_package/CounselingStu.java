package Student_package;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CounselingStu extends JFrame {
	static JTextField textfield = new JTextField(50);
	static JTextArea textarea = new JTextArea("��� ��û ���Դϴ�. ��ø� ��ٷ��ּ���!\n");
	static BufferedReader bfReader; // �����κ��� �� �޽����� �о�帱 �б����
	static BufferedWriter bfWriter;
	static ServerSocket listener = null; // ���ϸ�����
	static Socket socket = null; // ����
	static String outputMessage;

	CounselingStu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);

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

		JScrollPane sp = new JScrollPane(textarea);
		sp.setBackground(Color.white);
		sp.setBounds(250, 30, 490, 220);
		con.add(sp);

//ä�� ��ȭ �׼��Լ�		
		textfield.setBounds(250, 260, 490, 30);
		textfield.setBackground(Color.lightGray);
		textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMessage = textfield.getText();
				try {
					// ���
					bfWriter.write(outputMessage + "\n");
					bfWriter.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// �ؽ�Ʈ���� ���
				textarea.append("[�л�] " + outputMessage + "\n");
				textfield.selectAll();
			}
		});
		con.add(textfield);

		JButton btnBefore = new JButton("����");
		btnBefore.setBounds(450, 300, 100, 30);
		btnBefore.addActionListener(exitListener);
		con.add(btnBefore);

		setSize(800, 400);
		setResizable(false);
		setVisible(true);

	}

//�л� ���� ����	
	public void setSocket() {
		try {
			listener = new ServerSocket(5000); // ���� ����
			socket = listener.accept();
			textarea.append("[�˸�] ����� ���۵Ǿ����ϴ�.\n");
			textarea.append(
					"-------------------------------------------------------------------\n1.�Ʒ��� ��㳻���� ��������.\n2. Enter ������ ��ȭâ�� �Էµ˴ϴ�.\n");
			textarea.append("-------------------------------------------------------------------\n");
			OutputStream out = socket.getOutputStream();
			bfWriter = new BufferedWriter(new OutputStreamWriter(out));
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (socket == null) {
					socket.close();
					listener.close();
				}
			} catch (IOException e2) {
				textarea.append("������ ä�� �� ������ �߻��߽��ϴ�.");
			}
		}
	}

//������ ������ �о���� �Լ�
	void reader() {
		try {
			while (true) {
				bfReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream())); // ���� �Է� ��Ʈ��
				String next = bfReader.readLine();
				textarea.append("[����] " + next + "\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("TTTT");
		}
	}

//main�Լ�	
	public static void main(String[] args) {
		CounselingStu cs = new CounselingStu();
		cs.setSocket(); // �л� ���� ����
		System.out.println("dfdfdf");
		cs.reader(); // �л� ����~~
	}

//����û&���� ��ư �׼�
	ActionListener exitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) e.getSource();
			if (btn.getText() == "����") {
				System.exit(0);
			}
		}
	};

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
