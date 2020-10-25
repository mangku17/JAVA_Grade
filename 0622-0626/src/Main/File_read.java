package Main;

import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class File_read {
	
	public HashMap<String, Student_Data_Method> fil_reading(){
		// HashMap 객체, data 배열 객체 선언
				Student_Data_Method[] stu_data = new Student_Data_Method[100];
				HashMap<String, Student_Data_Method> hash_data = new HashMap<String, Student_Data_Method>();
				
				// 한 줄 씩 받을 String 데이터
				String read_temp_data = new String();
				
				// stu_data[] 인덱스 값을 나타내는 변수. 초기값=0
				int count=0;
				
				// 파일 입출력 객체 생성시 에러 발생 우려로 시스템 자체서 try-catch문 사용
				try {
					
					// .csv 파일 읽는 함수 호출.
					BufferedReader br = new BufferedReader(new FileReader("database.csv"));
					Scanner scan_data = new Scanner(br);
					
					// scanner로 한 줄씩 입력 받음. hasNextLine() -> 입력된 값이 있을 시 true
					while (scan_data.hasNextLine()) {
						
						// 각 count값에 해당하는 stu_data[] 생성
						stu_data[count] = new Student_Data_Method();
						// .csv 파일에서 입력 받은 파일을 String에 저장
						read_temp_data = scan_data.nextLine();
						// ,로 구분하여 각각 저장하기 위해 배열로 저장
						String[] array_temp_data = read_temp_data.split(",", 10);
						
						// data객체에 자료형 변환 후 저장.
						for(int i=0;i<array_temp_data.length;i++) {
							switch(i) {
							case 0:
								stu_data[count].set_name(array_temp_data[i]);
								break;
							case 1:
								stu_data[count].set_stu_num(Integer.parseInt(array_temp_data[i]));
								break;
							case 2:
								stu_data[count].set_python(Integer.parseInt(array_temp_data[i]));
								break;
							case 3:
								stu_data[count].set_java(Integer.parseInt(array_temp_data[i]));
								break;
							case 4:
								stu_data[count].set_c(Integer.parseInt(array_temp_data[i]));
								break;
							case 5:
								stu_data[count].set_total();
								break;
							case 6:
								stu_data[count].set_avg();
								break;
							case 7:
								stu_data[count].set_grades(array_temp_data[i]);
								break;
							case 8:
								stu_data[count].set_pw(Integer.parseInt(array_temp_data[i]));
								break;
							default:
								break;	
							}
						}
						// data 객체에 들어가 count 인덱스값 증가
						count++;			
					}
					
					// data 객체 배열을 HashMap에 키-자료값으로 순차적으로 저장. 
					for(int i=0; i<count; i++) {
						hash_data.put(stu_data[i].name_pk, stu_data[i]);
					}

					br.close();
				} catch (FileNotFoundException e) {
					// 예외처리
					e.printStackTrace();
				} catch (IOException e1) {
					// 예외처리
					e1.printStackTrace();
				}
				// HashMap 반환
				return hash_data;
		}
		
	
}
