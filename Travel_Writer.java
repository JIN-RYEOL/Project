package project_travel;

import java.awt.TextField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Travel_Writer {

	ObjectOutputStream oos;
	FileOutputStream fos = null;
	
	// id�� �ִ��� ������ Ȯ���ϴ� Ŭ����
	public Travel_Writer( TextField tf ) { 
		String path = "F:\\C,������ �п�\\������(Java)\\web_0324_kjr/TravelInfo/"+tf+"/UserInfo.sav";
		File dir = new File("F:\\C,������ �п�\\������(Java)\\web_0324_kjr/TravelInfo/"+info.getId());
		
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		//Object��ü�� ���� ���̵�� �н����带 ����
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			
			if(dir.exists()) {
				System.out.println();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
