package project_travel;

import java.awt.TextField;
import java.io.Serializable;

public class Travel_Info implements Serializable{ 
	// Travel_Info Ŭ���� ����ȭ
	// ���̵�� �н����带 ������ �ִ� Ŭ����
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
