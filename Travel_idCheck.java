package project_travel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Travel_idCheck {
	// 아이디 중복확인 클래스
	
	ObjectOutputStream oos;
	FileOutputStream fos = null;
	
	public Travel_idCheck( Travel_Info info ) {
		String path = "F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr/TravelInfo/"+info.getId();
		File dir = new File("F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr/TravelInfo/"+info.getId());
	
		if(dir.exists()) {
			System.out.println("중복!");
		}
	
	}
}//class
