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
			// 파일 쓰기 객체 생성. 프로젝트 파일에 'test.csv' 파일 쓰기.
			PrintWriter writer = new PrintWriter(new File("database.csv"));

			Object[] st_temp = student_data.keySet().toArray();
			String[] st = new String[student_data.size()];
			for (int i = 0; i < st_temp.length; i++) {
				st[i] = st_temp[i].toString();
			}

			// String을 배열 형식으로 저장하여 자료형 구분 없이 추가 삭제 가능
			StringBuilder sb = new StringBuilder();

			// 매개 변수 값으로 받은 해쉬 맵을 통해 키-자료값(객체).메소드(변수)를 검색하여 StringBuilder에 저장
			// ,는 엑설의 다음 칸으로 /n는 다음 줄로
			
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

			// StringBuilder에 저장된 값을 test.csv에 저장.
			writer.write(sb.toString());
			
			
			System.out.println("저장 성공!");
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
