package Main;
import java.util.HashMap;
import java.io.*;

public class File_writer {
	HashMap<String, Student_Data_Method> student_data;

	public File_writer(HashMap<String, Student_Data_Method> student_data) {
		this.student_data = student_data;
	}

	public void file_wirting() {
		try {
			// ���� ���� ��ü ����. ������Ʈ ���Ͽ� 'test.csv' ���� ����.
			PrintWriter writer = new PrintWriter(new File("database.csv"));

			Object[] st_temp = student_data.keySet().toArray();
			String[] st = new String[student_data.size()];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}

			// String�� �迭 �������� �����Ͽ� �ڷ��� ���� ���� �߰� ���� ����
			StringBuilder sb = new StringBuilder();

			// �Ű� ���� ������ ���� �ؽ� ���� ���� Ű-�ڷᰪ(��ü).�޼ҵ�(����)�� �˻��Ͽ� StringBuilder�� ����
			// ,�� ������ ���� ĭ���� /n�� ���� �ٷ�
			
			for (int i = 0; i < st.length; i++) {
				sb.append(student_data.get(st[i]).get_name());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_num());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_python());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_c());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_java());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_total());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_avg());
				sb.append(',');
				sb.append(student_data.get(st[i]).rank_grades());
				sb.append(',');
				sb.append(student_data.get(st[i]).get_pw());
				sb.append('\n');
			}

			// StringBuilder�� ����� ���� test.csv�� ����.
			writer.write(sb.toString());
			
			
			System.out.println("���� ����!");
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
