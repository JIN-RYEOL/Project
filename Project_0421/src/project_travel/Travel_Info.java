package project_travel;

import java.awt.TextField;
import java.io.Serializable;

public class Travel_Info implements Serializable{ 
	// Travel_Info Ŭ���� ����ȭ
	// ���̵�� �н����带 ������ �ִ� Ŭ����
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
