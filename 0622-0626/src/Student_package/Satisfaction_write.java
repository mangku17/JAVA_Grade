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
            // ���� ��ü ����
            File file = new File(file_src) ;
            // true ������ ������ ���� ���뿡 �̾ �ۼ�
            FileWriter file_load = new FileWriter(file, true) ;
             
            // ���Ͼȿ� ���ڿ� ����
            file_load.write(name+" "+text);
            file_load.flush();
 
            // ��ü �ݱ�
            file_load.close();
         
        	}catch(Exception e){
        		e.printStackTrace();
        }	
	}
}
