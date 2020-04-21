package project_travel;

import java.awt.TextField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Travel_Writer {

	ObjectOutputStream oos;
	FileOutputStream fos = null;
	
	// id가 있는지 없는지 확인하는 클래스
	public Travel_Writer( TextField tf ) { 
		String path = "F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr/TravelInfo/"+tf+"/UserInfo.sav";
		File dir = new File("F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr/TravelInfo/"+info.getId());
		
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		//Object객체를 통해 아이디와 패스워드를 저장
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
