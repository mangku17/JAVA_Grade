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
	static PrintWriter writer; // 五獣走研 社掴 什闘顕拭 潤匝 床奄 什闘顕
	static Socket socket = null;; // 社掴
	static String outputMessage;

	CounselingAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(null);
		con.setBackground(Color.WHITE);

		JButton btnIfmInput = new JButton("幻膳亀 繕紫"); // 幻膳亀 繕紫 獄動 ,btnIfmInput
		btnIfmInput.setBackground(Color.cyan);
		btnIfmInput.setForeground(new Color(0, 0, 0));
		btnIfmInput.setFont(new Font("閏顕", Font.PLAIN, 14));
		btnIfmInput.setBounds(0, 85, 195, 34);
		btnIfmInput.setBorderPainted(false);
		con.add(btnIfmInput);

		JButton btnIfmSearch = new JButton("俳持 失旋 伸寓"); // 俳持 失旋 伸寓, btnIfmSearch
		btnIfmSearch.setForeground(new Color(0, 0, 0));
		btnIfmSearch.setFont(new Font("閏顕", Font.PLAIN, 14));
		btnIfmSearch.setBackground(Color.cyan);
		btnIfmSearch.setBounds(0, 129, 195, 34);
		btnIfmSearch.setBorderPainted(false);
		con.add(btnIfmSearch);

		JButton btnIfmDel = new JButton("嘘呪 雌眼"); // 嘘呪 雌眼 獄動, btnIfmDel
		btnIfmDel.setForeground(new Color(0, 0, 0));
		btnIfmDel.setFont(new Font("閏顕", Font.PLAIN, 14));
		btnIfmDel.setBackground(Color.cyan);
		btnIfmDel.setBounds(0, 173, 195, 34);
		btnIfmDel.setBorderPainted(false);
		con.add(btnIfmDel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
		panel.setBounds(0, 0, 195, 371);
		con.add(panel);

		JLabel lblNewLabel = new JLabel("MAIN MENU"); // 五昔五敢 展戚堂 鳶確脊艦陥, 疑拙 x
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
//企鉢但 殖斗 衝芝 + 勺重
		textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMessage = textfield.getText();
				try {
					// 社掴 窒径
					bfWriter.write(outputMessage + "\n");
					bfWriter.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 努什闘鎧遂 窒形
				textarea.append("[嘘呪] " + outputMessage + "\n");
				textfield.selectAll();
			}
		});
		con.add(textfield);

		JButton btnBefore = new JButton("曽戟");
		btnBefore.setBounds(450, 300, 100, 30);
		btnBefore.addActionListener(exitListener);
		con.add(btnBefore);
		
//持失切照拭辞 社掴 竺舛		
		try {
			// 社掴 梓端 持失
			socket = new Socket("localhost", 5000);
			OutputStream out = socket.getOutputStream();
			bfWriter = new BufferedWriter(new OutputStreamWriter(out));
			textarea.append("[硝顕] 俳持引 尻衣戚 鞠醸柔艦陥.\n");
			textarea.append("-------------------------------------------------------------------\nEnter 刊牽檎 企鉢但拭 脊径桔艦陥.\n");
			textarea.append("-------------------------------------------------------------------\n");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try { // 社掴 紫虞閃虞たたたたたたた焼焼たたたたたた
				if (socket == null) {
					socket.close();
				}
			} catch (IOException e2) {
				textarea.append("辞獄人 辰特 掻 神嫌亜 降持梅柔艦陥.");
			}
		}
		setSize(800, 400);
		setResizable(false);
		setVisible(true);
	}
//雌企号戚 左鎧澗暗 石澗 敗呪 + 呪重
	public void reader() {
		try {
			while (true) {
				bfReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream())); // 社掴 脊径 什闘顕
				String next = bfReader.readLine();
				textarea.append("[俳持] " + next + "\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("TTTT");
		} finally {

		}
	}
//main
	public static void main(String[] args) {
		CounselingAdmin ca = new CounselingAdmin(); //持失切拭辞 社掴 持失
		System.out.println("fsdfsf");
		ca.reader(); //嘘呪還 呪重
	}
	
// 雌眼重短&曽戟 獄動 衝芝
	ActionListener exitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) e.getSource();
			if (btn.getText() == "曽戟") {
				System.exit(0);
			}
		}
	};
}
