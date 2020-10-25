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
	static PrintWriter writer; // 메시지를 소켓 스트림에 써줄 쓰기 스트림
	static Socket socket = null;; // 소켓
	static String outputMessage;

	CounselingAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);

		JButton btnIfmInput = new JButton("만족도 조사"); // 만족도 조사 버튼 ,btnIfmInput
		btnIfmInput.setBackground(Color.cyan);
		btnIfmInput.setForeground(new Color(0, 0, 0));
		btnIfmInput.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmInput.setBounds(0, 85, 195, 34);
		btnIfmInput.setBorderPainted(false);
		con.add(btnIfmInput);

		JButton btnIfmSearch = new JButton("학생 성적 열람"); // 학생 성적 열람, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmSearch.setBackground(Color.cyan);
		btnIfmSearch.setBounds(0, 129, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		con.add(btnIfmSearch);

		JButton btnIfmDel = new JButton("교수 상담"); // 교수 상담 버튼, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIfmDel.setBackground(Color.cyan);
		btnIfmDel.setBounds(0, 173, 195, 34);
		btnIfmDel.setBorderPainted(false);
		con.add(btnIfmDel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
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

		textfield.setBounds(250, 260, 490, 30);
		textfield.setBackground(Color.LIGHT_GRAY);
//대화창 엔터 액션 + 송신
		textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMessage = textfield.getText();
				try {
					// 소켓 출력
					bfWriter.write(outputMessage + "\n");
					bfWriter.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 텍스트내용 출려
				textarea.append("[교수] " + outputMessage + "\n");
				textfield.selectAll();
			}
		});
		con.add(textfield);

		JButton btnBefore = new JButton("종료");
		btnBefore.setBounds(450, 300, 100, 30);
		btnBefore.addActionListener(exitListener);
		con.add(btnBefore);
		
//생성자안에서 소켓 설정		
		try {
			// 소켓 객체 생성
			socket = new Socket("localhost", 5000);
			OutputStream out = socket.getOutputStream();
			bfWriter = new BufferedWriter(new OutputStreamWriter(out));
			textarea.append("[알림] 학생과 연결이 되었습니다.\n");
			textarea.append("-------------------------------------------------------------------\nEnter 누르면 대화창에 입력됩니다.\n");
			textarea.append("-------------------------------------------------------------------\n");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try { // 소켓 사라져라ㅏㅏㅏㅏㅏㅏㅏ아아ㅏㅏㅏㅏㅏㅏ
				if (socket == null) {
					socket.close();
				}
			} catch (IOException e2) {
				textarea.append("서버와 채팅 중 오류가 발생했습니다.");
			}
		}
		setSize(800, 400);
		setResizable(false);
		setVisible(true);
	}
//상대방이 보내는거 읽는 함수 + 수신
	public void reader() {
		try {
			while (true) {
				bfReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream())); // 소켓 입력 스트림
				String next = bfReader.readLine();
				textarea.append("[학생] " + next + "\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("TTTT");
		} finally {

		}
	}
//main
	public static void main(String[] args) {
		CounselingAdmin ca = new CounselingAdmin(); //생성자에서 소켓 생성
		System.out.println("fsdfsf");
		ca.reader(); //교수님 수신
	}
	
// 상담신청&종료 버튼 액션
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
}
