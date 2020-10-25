package Student_package;

import java.io.File;
import java.io.FileWriter;

public class Satisfaction_write {
	String text ;
	String name ;
	public Satisfaction_write(String text,String name){
		this.text = text;
		this.name = name;
	}
	public void write() {
	
   	 String file_src = "Satisfaction.txt" ;
        try{
            // 파일 객체 생성
            File file = new File(file_src) ;
            // true 지정시 파일의 기존 내용에 이어서 작성
            FileWriter file_load = new FileWriter(file, true) ;
             
            // 파일안에 문자열 쓰기
            file_load.write(name+" "+text);
            file_load.flush();
 
            // 객체 닫기
            file_load.close();
         
        	}catch(Exception e){
        		e.printStackTrace();
        }	
	}
}
