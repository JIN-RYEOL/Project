package project_travel;

import java.awt.TextField;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Travel_Writer {
	// 가입하기 버튼을 누르면 path경로에 유저의 ID와 PWD가 저장됨
	TravelLog tralog = new TravelLog();
	
	ObjectOutputStream oos;
	FileOutputStream fos = null;
	
	// id가 있는지 없는지 확인하는 클래스
	public Travel_Writer( Travel_Info info ) { 
		String path = "F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+info.getId()+"\\UserInfo.sav";
		File dir = new File("F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+info.getId());
		
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		//Object객체를 통해 ID와 PWD를 저장
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(info);
	
			//JOptionPane.showMessageDialog(,"회원가입 성공!"); f2(프레임)이 없어서 나중에 확인!!!!!!!!!!!!!!!!!!!!!!!!
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// try-catch
		
	}
	
}
