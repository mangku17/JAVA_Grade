package Main;

import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class File_read {
	
	public HashMap<String, Student_Data_Method> fil_reading(){
		// HashMap ��ü, data �迭 ��ü ����
				Student_Data_Method[] stu_data = new Student_Data_Method[100];
				HashMap<String, Student_Data_Method> hash_data = new HashMap<String, Student_Data_Method>();
				
				// �� �� �� ���� String ������
				String read_temp_data = new String();
				
				// stu_data[] �ε��� ���� ��Ÿ���� ����. �ʱⰪ=0
				int count=0;
				
				// ���� ����� ��ü ������ ���� �߻� ����� �ý��� ��ü�� try-catch�� ���
				try {
					
					// .csv ���� �д� �Լ� ȣ��.
					BufferedReader br = new BufferedReader(new FileReader("database.csv"));
					Scanner scan_data = new Scanner(br);
					
					// scanner�� �� �پ� �Է� ����. hasNextLine() -> �Էµ� ���� ���� �� true
					while (scan_data.hasNextLine()) {
						
						// �� count���� �ش��ϴ� stu_data[] ����
						stu_data[count] = new Student_Data_Method();
						// .csv ���Ͽ��� �Է� ���� ������ String�� ����
						read_temp_data = scan_data.nextLine();
						// ,�� �����Ͽ� ���� �����ϱ� ���� �迭�� ����
						String[] array_temp_data = read_temp_data.split(",", 10);
						
						// data��ü�� �ڷ��� ��ȯ �� ����.
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
						// data ��ü�� �� count �ε����� ����
						count++;			
					}
					
					// data ��ü �迭�� HashMap�� Ű-�ڷᰪ���� ���������� ����. 
					for(int i=0; i<count; i++) {
						hash_data.put(stu_data[i].name_pk, stu_data[i]);
					}

					br.close();
				} catch (FileNotFoundException e) {
					// ����ó��
					e.printStackTrace();
				} catch (IOException e1) {
					// ����ó��
					e1.printStackTrace();
				}
				// HashMap ��ȯ
				return hash_data;
		}
		
	
}
