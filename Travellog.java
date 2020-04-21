package project_travel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.GrayFilter;

public class Travellog {

	public static void main(String[] args) {
		
		Travel_Info travel_info = new Travel_Info();
		
		// ù �α��� ������
		Frame f = new Frame("�α���");
		f.setBounds(200, 200, 800, 500);
		f.setBackground(Color.DARK_GRAY);
		f.setLayout(null);
		
		// ȸ������ ������
		Frame f2 = new Frame("ȸ������");
		f2.setBounds(300, 200, 600, 400);
		f2.setBackground(Color.DARK_GRAY);
		f2.setLayout(null);
		
		Font font = new Font("����",Font.BOLD,17);
		
		// id , password ���̺�
		Label l_id = new Label("id");
		l_id.setBounds(220,340,100,40);
		l_id.setFont(font);
		Label l_password = new Label("password");
		l_password.setBounds(190,390,100,40);
		l_password.setFont(font);
		
		// �α���â(���̵�,��й�ȣ)
		TextField tf_id = new TextField();
		tf_id.setBounds(300,350,200,25);
		TextField tf_password = new TextField();
		tf_password.setBounds(300,400,200,25);
		
		// �α��ι�ư
		Button btnlog = new Button("�α���");
		btnlog.setBounds(530,350,80,80);
		
		// ȸ������ ��ư
		Button btnnew = new Button("ȸ������");
		btnnew.setBounds(530,450,80,30);
		
		
		// ����̵� ���̺�
		Label none_idnpass = new Label();
		none_idnpass.setBounds(300,400,210,80);
		none_idnpass.setFont(font);
		
		// ȸ������ ���̵�,�н�����
		TextField tf_nid = new TextField();
		tf_nid.setBounds(170,150,200,25);
		TextField tf_npassword = new TextField();
		tf_npassword.setBounds(170,250,200,25);
		
		// ȸ������ id,pass ���̺�
		Label l_nid = new Label("id");
		l_nid.setBounds(100,140,100,40);
		l_nid.setFont(font);
		Label l_npassword = new Label("password");
		l_npassword.setBounds(60,240,100,40);
		l_npassword.setFont(font);
		
		// ���̵��ߺ� ���̺�
		Label l_nidCheck = new Label();
		l_nidCheck.setBounds(200,180,300,40);
		l_nidCheck.setFont(font);
		
		// ȸ������ ���̵� �ߺ�Ȯ�� ��ư
		Button btnidCheck = new Button("���̵� �ߺ�Ȯ��");
		btnidCheck.setBounds(450, 150, 100, 40);
		
		// ȸ�������ϱ� ��ư
		Button btnMember = new Button("ȸ������");
		btnMember.setBounds(450, 250, 100, 40);
		
//-------------------------------------------------------		
		
		// ���̵�� �н����尡 ������ �α��ι�ư Ŭ��
		btnlog.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_id.getText().trim().equals("")) {
					none_idnpass.setText("���̵� �Է����ּ���.");
				}else if(tf_password.getText().trim().equals("")) {
					none_idnpass.setText("��й�ȣ�� �Է����ּ���.");
				}else {
						
						travel_info.setId(tf_id);
					
					if(!tf_id.getText().equals(f)) {
						none_idnpass.setText("���Ե����ʴ� ���̵�.");
						btnnew.setBackground(Color.YELLOW);
						
					}else {
						none_idnpass.setText(tf_id.getText() + "�� ȯ���մϴ�");
					}
					
					
				}
				
			}
		} );
		
		// ȸ������ ��ư
		btnnew.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(true);
				
			}
		} );
		
		// ȸ�������� - ���̵� �ߺ�Ȯ�� ��ư
		btnidCheck.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//travel_info.setId( tf_nid.getText() );
					
				
			}
		});
		
		f.add(tf_id); // ���̵�â
		f.add(tf_password); // ��й�ȣâ
		
		f.add(l_id); //���̵��̺�
		f.add(l_password); //�н����� ���̺�
		f.add(none_idnpass); // �α���,�н����� ���϶� ������ ���̺�
		
		f.add(btnlog); // �α��ι�ư
		f.add(btnnew); //ȸ������ ��ư
		
		f2.add(tf_nid); // ȸ������ ���̵�â
		f2.add(tf_npassword); // ȸ������ ��й�ȣâ
		f2.add(btnidCheck); // ���̵� �ߺ�Ȯ�� ��ư
		f2.add(l_nid); // id �Է�â
		f2.add(l_npassword); // password �Է�â
		f2.add(btnMember); // ȸ�������ϱ� ��ư
		f2.add(l_nidCheck); // ���̵� �ߺ� ���̺�
		
		
		f.setVisible(true);
		f.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			};
			
		} );
		
		f2.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f2.dispose();
				
			};
			
		} );
		
		
		
	}//main

}



























