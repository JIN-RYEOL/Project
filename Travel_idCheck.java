package project_travel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Travel_idCheck {
	// ���̵� �ߺ�Ȯ�� Ŭ����
	
	ObjectOutputStream oos;
	FileOutputStream fos = null;
	
	public Travel_idCheck( Travel_Info info ) {
		String path = "F:\\C,������ �п�\\������(Java)\\web_0324_kjr/TravelInfo/"+info.getId();
		File dir = new File("F:\\C,������ �п�\\������(Java)\\web_0324_kjr/TravelInfo/"+info.getId());
	
		if(dir.exists()) {
			System.out.println("�ߺ�!");
		}
	
	}
}//class
