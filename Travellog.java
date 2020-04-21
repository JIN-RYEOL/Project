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
		
		// 첫 로그인 프레임
		Frame f = new Frame("로그인");
		f.setBounds(200, 200, 800, 500);
		f.setBackground(Color.DARK_GRAY);
		f.setLayout(null);
		
		// 회원가입 프레임
		Frame f2 = new Frame("회원가입");
		f2.setBounds(300, 200, 600, 400);
		f2.setBackground(Color.DARK_GRAY);
		f2.setLayout(null);
		
		Font font = new Font("굴림",Font.BOLD,17);
		
		// id , password 레이블
		Label l_id = new Label("id");
		l_id.setBounds(220,340,100,40);
		l_id.setFont(font);
		Label l_password = new Label("password");
		l_password.setBounds(190,390,100,40);
		l_password.setFont(font);
		
		// 로그인창(아이디,비밀번호)
		TextField tf_id = new TextField();
		tf_id.setBounds(300,350,200,25);
		TextField tf_password = new TextField();
		tf_password.setBounds(300,400,200,25);
		
		// 로그인버튼
		Button btnlog = new Button("로그인");
		btnlog.setBounds(530,350,80,80);
		
		// 회원가입 버튼
		Button btnnew = new Button("회원가입");
		btnnew.setBounds(530,450,80,30);
		
		
		// 빈아이디 레이블
		Label none_idnpass = new Label();
		none_idnpass.setBounds(300,400,210,80);
		none_idnpass.setFont(font);
		
		// 회원가입 아이디,패스워드
		TextField tf_nid = new TextField();
		tf_nid.setBounds(170,150,200,25);
		TextField tf_npassword = new TextField();
		tf_npassword.setBounds(170,250,200,25);
		
		// 회원가입 id,pass 레이블
		Label l_nid = new Label("id");
		l_nid.setBounds(100,140,100,40);
		l_nid.setFont(font);
		Label l_npassword = new Label("password");
		l_npassword.setBounds(60,240,100,40);
		l_npassword.setFont(font);
		
		// 아이디중복 레이블
		Label l_nidCheck = new Label();
		l_nidCheck.setBounds(200,180,300,40);
		l_nidCheck.setFont(font);
		
		// 회원가입 아이디 중복확인 버튼
		Button btnidCheck = new Button("아이디 중복확인");
		btnidCheck.setBounds(450, 150, 100, 40);
		
		// 회원가입하기 버튼
		Button btnMember = new Button("회원가입");
		btnMember.setBounds(450, 250, 100, 40);
		
//-------------------------------------------------------		
		
		// 아이디와 패스워드가 없을때 로그인버튼 클릭
		btnlog.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_id.getText().trim().equals("")) {
					none_idnpass.setText("아이디를 입력해주세요.");
				}else if(tf_password.getText().trim().equals("")) {
					none_idnpass.setText("비밀번호를 입력해주세요.");
				}else {
						
						travel_info.setId(tf_id);
					
					if(!tf_id.getText().equals(f)) {
						none_idnpass.setText("가입되지않는 아이디.");
						btnnew.setBackground(Color.YELLOW);
						
					}else {
						none_idnpass.setText(tf_id.getText() + "님 환영합니다");
					}
					
					
				}
				
			}
		} );
		
		// 회원가입 버튼
		btnnew.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(true);
				
			}
		} );
		
		// 회원가입탭 - 아이디 중복확인 버튼
		btnidCheck.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//travel_info.setId( tf_nid.getText() );
					
				
			}
		});
		
		f.add(tf_id); // 아이디창
		f.add(tf_password); // 비밀번호창
		
		f.add(l_id); //아이디레이블
		f.add(l_password); //패스워드 레이블
		f.add(none_idnpass); // 로그인,패스워드 빈값일때 나오는 레이블
		
		f.add(btnlog); // 로그인버튼
		f.add(btnnew); //회원가입 버튼
		
		f2.add(tf_nid); // 회원가입 아이디창
		f2.add(tf_npassword); // 회원가입 비밀번호창
		f2.add(btnidCheck); // 아이디 중복확인 버튼
		f2.add(l_nid); // id 입력창
		f2.add(l_npassword); // password 입력창
		f2.add(btnMember); // 회원가입하기 버튼
		f2.add(l_nidCheck); // 아이디 중복 레이블
		
		
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



























