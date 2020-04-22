package project_travel;

import java.awt.TextField;
import java.io.Serializable;

public class Travel_Info implements Serializable{ 
	// Travel_Info 클래스 직렬화
	// 아이디와 패스워드를 가지고 있는 클래스
	private String id;
	private String password;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
