package project_travel;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.GrayFilter;
import javax.swing.JOptionPane;

public class TravelLog {

	public static void main(String[] args) {

		Travel_Info travel_info = new Travel_Info();
		Travel_Check travel_check = new Travel_Check();
		
		
		
		//-------------- 프레임 생성 --------------------------------		
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
		//-------------------------------------------------------




		//--------------------로그인 프레임---------------------------		
		// ID , PWD 표시 레이블
		Label lid = new Label("ID");
		lid.setBounds(250,345,100,40);
		lid.setFont(font);
		Label lpwd = new Label("PWD");
		lpwd.setBounds(240,395,100,40);
		lpwd.setFont(font);

		// ID, PWD 입력 TextField
		TextField tf_id = new TextField();
		tf_id.setBounds(300,350,200,25);
		TextField tf_pwd = new TextField();
		tf_pwd.setBounds(300,400,200,25);

		// 로그인버튼
		Button btnlog = new Button("로그인");
		btnlog.setBounds(530,350,80,80);

		// 회원가입 버튼
		Button btnnew = new Button("회원가입");
		btnnew.setBounds(530,450,80,30);


		// 빈아이디 레이블
		Label none_idnpass = new Label();
		none_idnpass.setBounds(290,410,220,80);
		none_idnpass.setFont(font);
		//--------------------------------------------------------



		//------------------회원가입 프레임----------------------------
		// 회원가입 - 아이디,패스워드
		TextField tf_nid = new TextField();
		tf_nid.setBounds(170,150,200,25);
		TextField tf_npwd = new TextField();
		tf_npwd.setBounds(170,250,200,25);

		// 회원가입 - ID,PWD 레이블
		Label lid2 = new Label("ID");
		lid2.setBounds(130,140,100,40);
		lid2.setFont(font);
		Label lpwd2 = new Label("PWD");
		lpwd2.setBounds(115,240,100,40);
		lpwd2.setFont(font);

		// 아이디중복 레이블
		Label lidCheck = new Label();
		lidCheck.setBounds(170,100,250,200);
		lidCheck.setFont(font);

		// 회원가입 아이디 중복확인 버튼
		Button btnidCheck = new Button("아이디 중복확인");
		btnidCheck.setBounds(450, 150, 100, 40);

		// 회원가입 - 가입하기 버튼
		Button btnMember = new Button("가입하기");
		btnMember.setBounds(450, 250, 100, 40);
		btnMember.setEnabled(false);

		//-------------------------------------------------------		

		//--------------------로그인 프레임---------------------------		
		// 로그인 - Login 버튼 클릭
		btnlog.addActionListener( new ActionListener() {
			String id = "";
			String pwd = "";
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_id.getText().trim().equals("")) {
					none_idnpass.setText("아이디를 입력해주세요.");
				}else if(tf_pwd.getText().trim().equals("")) {
					none_idnpass.setText("비밀번호를 입력해주세요.");
				}else {

					travel_info.setId( tf_id.getText() );
					travel_info.setPassword( tf_pwd.getText() );

					String path = "F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+ travel_info.getId();
					File f = new File(path);
					System.out.println(f);
					
					if(!f.exists()) {
						none_idnpass.setText("가입하지않은 아이디");
						tf_id.setText("");
						btnnew.setBackground(Color.YELLOW);

					}else {
						//로드하기 
						Travel_Loader travel_loader = new Travel_Loader(travel_info);
						id = travel_loader.getInfo().getId();
						pwd = travel_loader.getInfo().getPassword();
						
						if(tf_id.getText().equals(id) && tf_pwd.getText().equals(pwd)) {
							none_idnpass.setText(tf_id.getText() + "님 환영합니다");
						}else {
							none_idnpass.setText("비밀번호 틀림");
						}
						
					}


				}

			}
		} );


		// 로그인 - 회원가입 버튼
		btnnew.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(true);

			}
		} );

		//---------------------------------------------------------------------------------

		//--------------------------------회원가입 프레임-----------------------------------------

		// 회원가입 - ID중복확인 버튼
		btnidCheck.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				travel_info.setId( tf_nid.getText() ); //tf_nid(TextField)를 info클래스에 저장
				travel_info.setPassword( tf_npwd.getText() ); //tf_npwd(TextField)를 info클래스에 저장
				
				String path = "F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+ travel_info.getId();
				File f = new File(path);

				if(tf_nid.getText().trim().equals("")) { // tf_nid(TextField)에 값이 없으면
					lidCheck.setText("아이디를 입력해주세요!"); // 레이블 출력
				}

				if(!f.exists()) { // 해당 아이디의 파일이 존재하지 않는다면
					lidCheck.setText("가입이 가능한 아이디 입니다!"); // f경로에 폴더가 없으면 해당 레이블 출력  
					travel_check.setCheck(true); // Travel_Check 클래스에 있는 check 값을 true로 변경
					//TextField 갱신 
					tf_npwd.setText(tf_npwd.getText()+"");// 만약 중복확인버튼을 클릭하기전 비밀번호가 미리 입력되있는경우를 대비하여 갱신함

				}else if(f.exists() && !tf_nid.getText().trim().equals("")){ // 해당 아이디의 폴더이 존재 한다면
					lidCheck.setText("중복된 아이디 입니다!"); // f경로에 폴더가 있으면 해당 레이블 출력 
					tf_nid.setText("");					// ID의 TextField를 초기화 
					tf_nid.requestFocus(); 				// ID-TextField에 커서를 둠
					travel_check.setCheck(false); 		// Travel_Check 클래스에 있는 check 값을 false로 변경
					//TextField 갱신
					tf_npwd.setText(""); // 중복된 ID라면 가입하기버튼을 비활성화하기위해 PWD-TextField를 초기화

				}else if(tf_nid.getText().trim().equals("")) { // 중복하기 버튼 클릭시 값이 없다면 해당 레이블 출력
					lidCheck.setText("아이디를 입력해주세요!");
				}
			}
		});

		// tf_nid(TextField)에 값이 추가되거나 삭제가되면 가입하기 버튼 비활성화
		tf_nid.addTextListener( new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				if( tf_nid.getText() != null ) { // tf_nid에 값이 변경되면 
					btnMember.setEnabled(false); // btnMember(가입하기 버튼) 비활성화
				}

			}
		} );

		// 회원가입 - 가입하기 버튼 활성화 (조건)
		tf_npwd.addTextListener( new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				//Travel_Check 클래스에 check값이 true이면서 ID-TextField가 빈값이 아니라면
				if( travel_check.isCheck() == true && !tf_npwd.getText().trim().equals(""))  { 
					btnMember.setEnabled(true); //가입하기 버튼 활성화
					btnMember.setBackground(Color.YELLOW);
				}else {
					btnMember.setEnabled(false); // 버튼 비활성화
				}

			}
		} );

		// 회원가입 - 가입하기 버튼
		btnMember.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				travel_info.setId(tf_nid.getText());
				travel_info.setPassword(tf_npwd.getText());
				
				new Travel_Writer(travel_info); // ID와 PWD를  Travel_Writer클래스를 통해 저장 (익명 클래스)
				// 회원가입하기버튼 클릭 후 DB에 폴더(정보ID,PWD)가 만들어지면 확인해서 있으면 회원가입 성공 없으면 실패 
				String path = "F:\\C,웹개발 학원\\웹개발(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+ travel_info.getId();
				File f = new File(path);
				if( !f.exists() ) {
					JOptionPane.showMessageDialog(f2,"회원가입 실패!");
				}else {
					JOptionPane.showMessageDialog(f2,"회원가입 성공!");
					tf_nid.setText("");
					tf_npwd.setText("");
				}
				
			

				}
			} );
		//--------------------------------------------------------------------------------------------		

		f.add(tf_id); 		// 아이디창
		f.add(tf_pwd); // 비밀번호창

		f.add(lid);  //아이디레이블
		f.add(lpwd); //패스워드 레이블
		f.add(none_idnpass); // 로그인,패스워드 빈값일때 나오는 레이블

		f.add(btnlog); // 로그인버튼
		f.add(btnnew); //회원가입 버튼

		f2.add(tf_nid);     // 회원가입 - ID(TextField)
		f2.add(tf_npwd);    // 회원가입 - PWD(TextField)
		f2.add(btnidCheck); // 회원가입 - IdCheck 버튼
		f2.add(lid2); 		// 회원가입 - ID 레이블
		f2.add(lpwd2); 		// 회원가입 - PWD 레이블
		f2.add(btnMember); 	// 회원가입 - 회원가입하기 버튼
		f2.add(lidCheck); 	// 회원가입 - ID 중복인지 아닌지 레이블


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



























