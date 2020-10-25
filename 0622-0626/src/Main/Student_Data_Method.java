package Main;

import java.util.HashMap;
import java.util.Map;

class Studnet_Data {
	String name_pk;
	int stu_num;
	int python;
	int java;
	int c;
	int total;
	float avg;
	String grades;
	int pw;

	public Studnet_Data() {

	}

	public Studnet_Data(String name_pk, int stu_num, int pw) {
		this.name_pk = name_pk;
		this.stu_num = stu_num;
		this.pw = pw;
	}
}

class manager {
	final String id = "Adminstor";
	final String pw = "0000";
}

public class Student_Data_Method extends Studnet_Data {

	public Student_Data_Method() {
		super();
	}

	public Student_Data_Method(String name_pk, int stu_num, int pw) {
		super(name_pk, stu_num, pw);
	}

	public void set_name(String name_pk) {
		this.name_pk = name_pk;
	}

	public void set_stu_num(int stu_num) {
		this.stu_num = stu_num;
	}

	public void set_python(int python) {
		this.python = python;
	}

	public void set_java(int java) {
		this.java = java;
	}

	public void set_c(int c) {
		this.c = c;
	}

	public void set_total() {
		total = python + java + c;
	}

	public void set_avg() {
		avg = (float) total / 3;
	}

	public void set_grades(String grades) {
		this.grades = grades;
	}

	public void set_pw(int pw) {
		this.pw = pw;
	}

	public String get_name() {
		return name_pk;
	}

	public int get_num() {
		return stu_num;
	}

	public int get_python() {
		return python;
	}

	public int get_java() {
		return java;
	}

	public int get_c() {
		return c;
	}

	public int get_total() {
		return total;
	}

	public float get_avg() {
		return avg;
	}

	public String get_grades() {
		return grades;
	}

	public int get_pw() {
		return pw;
	}

	public String rank_grades() {
		int jum = (int) get_avg();
		if (jum >= 90 && jum <= 100) {
			this.grades = "A";
		} else if (jum >= 80 && jum <= 89) {
			this.grades = "B";
		} else if (jum >= 70 && jum <= 79) {
			this.grades = "C";
		} else if (jum >= 60 && jum <= 69) {
			this.grades = "D";
		} else {
			this.grades = "F";
		}
		return grades;
	}

}