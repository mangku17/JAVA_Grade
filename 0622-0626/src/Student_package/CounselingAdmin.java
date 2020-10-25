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
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CounselingAdmin extends JFrame {
	static JTextField textfield = new JTextField(10);
	static JTextArea textarea = new JTextArea();
	static BufferedReader bfReader = null;
	static BufferedWriter bfWriter = null;
	static PrintWriter writer; // �޽����� ���� ��Ʈ���� ���� ���� ��Ʈ��
	static Socket socket = null;; // ����
	static String outputMessage;

	CounselingAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);

		JButton btnIfmInput = new JButton("������ ����"); // ������ ���� ��ư ,btnIfmInput
		btnIfmInput.setBackground(Color.cyan);
		btnIfmInput.setForeground(new Color(0, 0, 0));
		btnIfmInput.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmInput.setBounds(0, 85, 195, 34);
		btnIfmInput.setBorderPainted(false);
		con.add(btnIfmInput);

		JButton btnIfmSearch = new JButton("�л� ���� ����"); // �л� ���� ����, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmSearch.setBackground(Color.cyan);
		btnIfmSearch.setBounds(0, 129, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		con.add(btnIfmSearch);

		JButton btnIfmDel = new JButton("���� ���"); // ���� ��� ��ư, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("����", Font.PLAIN, 14));
		btnIfmDel.setBackground(Color.cyan);
		btnIfmDel.setBounds(0, 173, 195, 34);
		btnIfmDel.setBorderPainted(false);
		con.add(btnIfmDel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
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

		textfield.setBounds(250, 260, 490, 30);
		textfield.setBackground(Color.LIGHT_GRAY);
//��ȭâ ���� �׼� + �۽�
		textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMessage = textfield.getText();
				try {
					// ���� ���
					bfWriter.write(outputMessage + "\n");
					bfWriter.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// �ؽ�Ʈ���� ���
				textarea.append("[����] " + outputMessage + "\n");
				textfield.selectAll();
			}
		});
		con.add(textfield);

		JButton btnBefore = new JButton("����");
		btnBefore.setBounds(450, 300, 100, 30);
		btnBefore.addActionListener(exitListener);
		con.add(btnBefore);
		
//�����ھȿ��� ���� ����		
		try {
			// ���� ��ü ����
			socket = new Socket("localhost", 5000);
			OutputStream out = socket.getOutputStream();
			bfWriter = new BufferedWriter(new OutputStreamWriter(out));
			textarea.append("[�˸�] �л��� ������ �Ǿ����ϴ�.\n");
			textarea.append("-------------------------------------------------------------------\nEnter ������ ��ȭâ�� �Էµ˴ϴ�.\n");
			textarea.append("-------------------------------------------------------------------\n");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try { // ���� ������󤿤������������ƾƤ�����������
				if (socket == null) {
					socket.close();
				}
			} catch (IOException e2) {
				textarea.append("������ ä�� �� ������ �߻��߽��ϴ�.");
			}
		}
		setSize(800, 400);
		setResizable(false);
		setVisible(true);
	}
//������ �����°� �д� �Լ� + ����
	public void reader() {
		try {
			while (true) {
				bfReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream())); // ���� �Է� ��Ʈ��
				String next = bfReader.readLine();
				textarea.append("[�л�] " + next + "\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("TTTT");
		} finally {

		}
	}
//main
	public static void main(String[] args) {
		CounselingAdmin ca = new CounselingAdmin(); //�����ڿ��� ���� ����
		System.out.println("fsdfsf");
		ca.reader(); //������ ����
	}
	
// ����û&���� ��ư �׼�
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
}
