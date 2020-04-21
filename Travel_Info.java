package project_travel;

import java.awt.TextField;
import java.io.Serializable;

public class Travel_Info implements Serializable{ 
	// Travel_Info 클래스 직렬화
	// 아이디와 패스워드를 가지고 있는 클래스
	private TextField id;
	private TextField password;
	
	
	public TextField getId() {
		return id;
	}
	public void setId(TextField id) {
		this.id = id;
	}
	public TextField getPassword() {
		return password;
	}
	public void setPassword(TextField password) {
		this.password = password;
	}
	
	
	
}
