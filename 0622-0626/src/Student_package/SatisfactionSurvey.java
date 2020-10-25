package Student_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SatisfactionSurvey extends JFrame{
	int point = 0; //����������
	   String subject; //�򰡰���
	   String text; //
	   JTextArea textarea = new JTextArea(); //�������� ����ϰ� �Ʒ������� ����ϱ� ����
	   JButton btnMoney;
	   JTextField jt_name;
	   
	   SatisfactionSurvey() {
	      String subject[] = { "Java", "Python", "C programing" };

//	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setTitle("������ ����");
	      Container con = getContentPane();
	      con.setLayout(null);
	      con.setBackground(Color.WHITE);
	      
	      JLabel jb_view = new JLabel("�̸� :");
	      jb_view.setBounds(20,20,40,20);
	      con.add(jb_view);
	      
	      jt_name = new JTextField(10);
	      jt_name.setBounds(55,20,100,20);
	      con.add(jt_name);
	      

	      JComboBox<String> cbSubject = new JComboBox<String>(subject);
	      cbSubject.addActionListener(subListener);
	      cbSubject.setSelectedIndex(0);
	      con.add(cbSubject);
	      cbSubject.setBounds(680, 20, 100, 30);

	      // ���� + �亯 (3�� �ݺ�)-----------------------------------------------------
	      JPanel panQ1 = new JPanel();
	      panQ1.setBorder(new LineBorder(Color.black));
	      panQ1.setBackground(Color.white);
	      panQ1.setBounds(20, 60, 760, 35);
	      con.add(panQ1);

	      JLabel laQ1 = new JLabel("������ ������ �����?");
	      panQ1.add(laQ1);

	      ButtonGroup Q1 = new ButtonGroup();

	      JRadioButton rdVerygood = new JRadioButton("�ſ� ����");
	      rdVerygood.setBackground(Color.white);
	      panQ1.add(rdVerygood);
	      rdVerygood.addItemListener(listener);
	      Q1.add(rdVerygood);

	      JRadioButton rdGood = new JRadioButton("����");
	      rdGood.setBackground(Color.white);
	      rdGood.addItemListener(listener);
	      panQ1.add(rdGood);
	      Q1.add(rdGood);

	      JRadioButton rdSoso = new JRadioButton("����");
	      rdSoso.setBackground(Color.white);
	      rdSoso.addItemListener(listener);
	      panQ1.add(rdSoso);
	      Q1.add(rdSoso);

	      JRadioButton rdBad = new JRadioButton("�Ҹ���");
	      rdBad.setBackground(Color.white);
	      rdBad.addItemListener(listener);
	      panQ1.add(rdBad);
	      Q1.add(rdBad);

	      JRadioButton rdDislike = new JRadioButton("�ſ� �Ҹ���");
	      rdDislike.setBackground(Color.white);
	      rdDislike.addItemListener(listener);
	      panQ1.add(rdDislike);
	      Q1.add(rdDislike);
	      // ������----------------------------------------------------------------
	      //Q2--------------------------------------------------------------------
	      JPanel panQ2 = new JPanel();
	      panQ2.setBorder(new LineBorder(Color.black));
	      panQ2.setBackground(Color.white);
	      panQ2.setBounds(20, 110, 760, 35);
	      con.add(panQ2);

	      JLabel laQ2 = new JLabel("������ �ʿ��� �ǽ��� �����ϰ� �̷��������?");
	      panQ2.add(laQ2);

	      ButtonGroup Q2 = new ButtonGroup();

	      JRadioButton rdVerygood2 = new JRadioButton("�ſ� ����");
	      rdVerygood2.setBackground(Color.white);
	      panQ2.add(rdVerygood2);
	      rdVerygood2.addItemListener(listener);
	      Q2.add(rdVerygood2);

	      JRadioButton rdGood2 = new JRadioButton("����");
	      rdGood2.setBackground(Color.white);
	      rdGood2.addItemListener(listener);
	      panQ2.add(rdGood2);
	      Q2.add(rdGood2);

	      JRadioButton rdSoso2 = new JRadioButton("����");
	      rdSoso2.setBackground(Color.white);
	      rdSoso2.addItemListener(listener);
	      panQ2.add(rdSoso2);
	      Q2.add(rdSoso2);

	      JRadioButton rdBad2 = new JRadioButton("�Ҹ���");
	      rdBad2.setBackground(Color.white);
	      rdBad2.addItemListener(listener);
	      panQ2.add(rdBad2);
	      Q2.add(rdBad2);

	      JRadioButton rdDislike2 = new JRadioButton("�ſ� �Ҹ���");
	      rdDislike2.setBackground(Color.white);
	      rdDislike2.addItemListener(listener);
	      panQ2.add(rdDislike2);
	      Q2.add(rdDislike2);
	     // ---------------------------------------------------------------------
	     //Q3--------------------------------------------------------------------
	      JPanel panQ3 = new JPanel();
	      panQ3.setBorder(new LineBorder(Color.black));
	      panQ3.setBackground(Color.white);
	      panQ3.setBounds(20, 160, 760, 35);
	      con.add(panQ3);

	      JLabel laQ3 = new JLabel("������ ������ �����߳���?");
	      panQ3.add(laQ3);

	      ButtonGroup Q3 = new ButtonGroup();

	      JRadioButton rdVerygood3 = new JRadioButton("�ſ� ����");
	      rdVerygood3.setBackground(Color.white);
	      panQ3.add(rdVerygood3);
	      rdVerygood3.addItemListener(listener);
	      Q3.add(rdVerygood3);

	      JRadioButton rdGood3 = new JRadioButton("����");
	      rdGood3.setBackground(Color.white);
	      rdGood3.addItemListener(listener);
	      panQ3.add(rdGood3);
	      Q3.add(rdGood3);

	      JRadioButton rdSoso3 = new JRadioButton("����");
	      rdSoso3.setBackground(Color.white);
	      rdSoso3.addItemListener(listener);
	      panQ3.add(rdSoso3);
	      Q3.add(rdSoso3);

	      JRadioButton rdBad3 = new JRadioButton("�Ҹ���");
	      rdBad3.setBackground(Color.white);
	      rdBad3.addItemListener(listener);
	      panQ3.add(rdBad3);
	      Q3.add(rdBad3);

	      JRadioButton rdDislike3 = new JRadioButton("�ſ� �Ҹ���");
	      rdDislike3.setBackground(Color.white);
	      rdDislike3.addItemListener(listener);
	      panQ3.add(rdDislike3);
	      Q3.add(rdDislike3);
	     // --------------------------------------------------------
	      textarea.setBackground(Color.LIGHT_GRAY);
	      JScrollPane scroll = new JScrollPane(textarea);
	      scroll.setBounds(20, 210, 760, 80);
	      textarea.setFont(new Font("���� ���", Font.BOLD, 18));
	      con.add(scroll);

	      JButton btnBefore = new JButton("����");
	      btnBefore.setBackground(Color.LIGHT_GRAY);
	      btnBefore.setBounds(322, 300, 100, 20);
	      btnBefore.addActionListener(SsListener);
	      con.add(btnBefore);
	      
	      JButton btnSend = new JButton("����");
	      btnSend.setBackground(Color.LIGHT_GRAY);
	      btnSend.setBounds(562, 300, 100, 20);
	      btnSend.addActionListener(SsListener);
	      con.add(btnSend);
	      
	      btnMoney = new JButton("���л� ��ȸ");
	      btnMoney.setBackground(Color.LIGHT_GRAY);
	      btnMoney.setBounds(113, 299, 100, 23);
	      btnMoney.addActionListener(coinListener);
	      con.add(btnMoney);
	      setSize(800, 400);
	      setResizable(false);
	      setVisible(true);
	   }
	   
	   public static void main(String[] args) {
	      new SatisfactionSurvey();
	   }
	   
	   //������ư
	   ItemListener listener = new ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
	         JRadioButton cb = (JRadioButton) e.getSource();
	         if (e.getStateChange() == ItemEvent.SELECTED) {
	            if (cb.getText() == "�ſ� ����") {
	               point += 5;
	            } else if (cb.getText() == "����") {
	               point += 4;
	            } else if (cb.getText() == "����") {
	               point += 3;
	            } else if (cb.getText() == "�Ҹ���") {
	               point += 2;
	            } else {
	               point = 1;
	            }
	         } else {
	            point -= point;
	         }
	      }
	   }; 
	   
	  
	   
	   //����, ���� ��ư
	   ActionListener SsListener = new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	         // TODO Auto-generated method stub
	         JButton btn = (JButton) e.getSource();
	         if (btn.getText() == "����") {
	        	 text = "[����] "+ subject +"\n[������ �� ����] " + point +"\n";
	        	 textarea.append(text); //�����˴ϴ�... 
	        	 Satisfaction_write satis_write = new Satisfaction_write(text,jt_name.getText());
	        	 satis_write.write();
	         }

	      }
	   };
	   
	   //�޺��ڽ� 
	   ActionListener subListener = new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	         // TODO Auto-generated method stub
	         JComboBox cb = (JComboBox) e.getSource();
	         if(cb.getSelectedIndex()==0) { subject = "�ڹ�";}
	         else if(cb.getSelectedIndex()==1) {subject = "���̽�";}
	         else {subject = "C";}
	         
	      }
	   };
	   ActionListener coinListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String selbt= btnMoney.getText();
			if(selbt.equals("���л� ��ȸ")) {
				new Scholarship_Student();
			}
			
		}
	};

	   

}

