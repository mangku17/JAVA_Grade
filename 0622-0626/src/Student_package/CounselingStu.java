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
	static JTextArea textarea = new JTextArea("상담 신청 중입니다. 잠시만 기다려주세요!\n");
	static BufferedReader bfReader; // 서버로부터 온 메시지를 읽어드릴 읽기버퍼
	static BufferedWriter bfWriter;
	static ServerSocket listener = null; // 소켓리스너
	static Socket socket = null; // 소켓
	static String outputMessage;

	CounselingStu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);

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

		JScrollPane sp = new JScrollPane(textarea);
		sp.setBackground(Color.white);
		sp.setBounds(250, 30, 490, 220);
		con.add(sp);

//채팅 대화 액션함수		
		textfield.setBounds(250, 260, 490, 30);
		textfield.setBackground(Color.lightGray);
		textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMessage = textfield.getText();
				try {
					// 출력
					bfWriter.write(outputMessage + "\n");
					bfWriter.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 텍스트내용 출력
				textarea.append("[학생] " + outputMessage + "\n");
				textfield.selectAll();
			}
		});
		con.add(textfield);

		JButton btnBefore = new JButton("종료");
		btnBefore.setBounds(450, 300, 100, 30);
		btnBefore.addActionListener(exitListener);
		con.add(btnBefore);

		setSize(800, 400);
		setResizable(false);
		setVisible(true);

	}

//학생 소켓 설정	
	public void setSocket() {
		try {
			listener = new ServerSocket(5000); // 소켓 생성
			socket = listener.accept();
			textarea.append("[알림] 상담이 시작되었습니다.\n");
			textarea.append(
					"-------------------------------------------------------------------\n1.아래에 상담내용을 적으세요.\n2. Enter 누르면 대화창에 입력됩니다.\n");
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
				textarea.append("서버와 채팅 중 오류가 발생했습니다.");
			}
		}
	}

//상대방이 보낸거 읽어오는 함수
	void reader() {
		try {
			while (true) {
				bfReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream())); // 소켓 입력 스트림
				String next = bfReader.readLine();
				textarea.append("[교수] " + next + "\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("TTTT");
		}
	}

//main함수	
	public static void main(String[] args) {
		CounselingStu cs = new CounselingStu();
		cs.setSocket(); // 학생 소켓 생성
		System.out.println("dfdfdf");
		cs.reader(); // 학생 수신~~
	}

//상담신청&종료 버튼 액션
	ActionListener exitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) e.getSource();
			if (btn.getText() == "종료") {
				System.exit(0);
			}
		}
	};

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
