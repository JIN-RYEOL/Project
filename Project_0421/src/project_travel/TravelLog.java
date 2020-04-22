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
		
		
		
		//-------------- ������ ���� --------------------------------		
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
		//-------------------------------------------------------




		//--------------------�α��� ������---------------------------		
		// ID , PWD ǥ�� ���̺�
		Label lid = new Label("ID");
		lid.setBounds(250,345,100,40);
		lid.setFont(font);
		Label lpwd = new Label("PWD");
		lpwd.setBounds(240,395,100,40);
		lpwd.setFont(font);

		// ID, PWD �Է� TextField
		TextField tf_id = new TextField();
		tf_id.setBounds(300,350,200,25);
		TextField tf_pwd = new TextField();
		tf_pwd.setBounds(300,400,200,25);

		// �α��ι�ư
		Button btnlog = new Button("�α���");
		btnlog.setBounds(530,350,80,80);

		// ȸ������ ��ư
		Button btnnew = new Button("ȸ������");
		btnnew.setBounds(530,450,80,30);


		// ����̵� ���̺�
		Label none_idnpass = new Label();
		none_idnpass.setBounds(290,410,220,80);
		none_idnpass.setFont(font);
		//--------------------------------------------------------



		//------------------ȸ������ ������----------------------------
		// ȸ������ - ���̵�,�н�����
		TextField tf_nid = new TextField();
		tf_nid.setBounds(170,150,200,25);
		TextField tf_npwd = new TextField();
		tf_npwd.setBounds(170,250,200,25);

		// ȸ������ - ID,PWD ���̺�
		Label lid2 = new Label("ID");
		lid2.setBounds(130,140,100,40);
		lid2.setFont(font);
		Label lpwd2 = new Label("PWD");
		lpwd2.setBounds(115,240,100,40);
		lpwd2.setFont(font);

		// ���̵��ߺ� ���̺�
		Label lidCheck = new Label();
		lidCheck.setBounds(170,100,250,200);
		lidCheck.setFont(font);

		// ȸ������ ���̵� �ߺ�Ȯ�� ��ư
		Button btnidCheck = new Button("���̵� �ߺ�Ȯ��");
		btnidCheck.setBounds(450, 150, 100, 40);

		// ȸ������ - �����ϱ� ��ư
		Button btnMember = new Button("�����ϱ�");
		btnMember.setBounds(450, 250, 100, 40);
		btnMember.setEnabled(false);

		//-------------------------------------------------------		

		//--------------------�α��� ������---------------------------		
		// �α��� - Login ��ư Ŭ��
		btnlog.addActionListener( new ActionListener() {
			String id = "";
			String pwd = "";
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_id.getText().trim().equals("")) {
					none_idnpass.setText("���̵� �Է����ּ���.");
				}else if(tf_pwd.getText().trim().equals("")) {
					none_idnpass.setText("��й�ȣ�� �Է����ּ���.");
				}else {

					travel_info.setId( tf_id.getText() );
					travel_info.setPassword( tf_pwd.getText() );

					String path = "F:\\C,������ �п�\\������(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+ travel_info.getId();
					File f = new File(path);
					System.out.println(f);
					
					if(!f.exists()) {
						none_idnpass.setText("������������ ���̵�");
						tf_id.setText("");
						btnnew.setBackground(Color.YELLOW);

					}else {
						//�ε��ϱ� 
						Travel_Loader travel_loader = new Travel_Loader(travel_info);
						id = travel_loader.getInfo().getId();
						pwd = travel_loader.getInfo().getPassword();
						
						if(tf_id.getText().equals(id) && tf_pwd.getText().equals(pwd)) {
							none_idnpass.setText(tf_id.getText() + "�� ȯ���մϴ�");
						}else {
							none_idnpass.setText("��й�ȣ Ʋ��");
						}
						
					}


				}

			}
		} );


		// �α��� - ȸ������ ��ư
		btnnew.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(true);

			}
		} );

		//---------------------------------------------------------------------------------

		//--------------------------------ȸ������ ������-----------------------------------------

		// ȸ������ - ID�ߺ�Ȯ�� ��ư
		btnidCheck.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				travel_info.setId( tf_nid.getText() ); //tf_nid(TextField)�� infoŬ������ ����
				travel_info.setPassword( tf_npwd.getText() ); //tf_npwd(TextField)�� infoŬ������ ����
				
				String path = "F:\\C,������ �п�\\������(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+ travel_info.getId();
				File f = new File(path);

				if(tf_nid.getText().trim().equals("")) { // tf_nid(TextField)�� ���� ������
					lidCheck.setText("���̵� �Է����ּ���!"); // ���̺� ���
				}

				if(!f.exists()) { // �ش� ���̵��� ������ �������� �ʴ´ٸ�
					lidCheck.setText("������ ������ ���̵� �Դϴ�!"); // f��ο� ������ ������ �ش� ���̺� ���  
					travel_check.setCheck(true); // Travel_Check Ŭ������ �ִ� check ���� true�� ����
					//TextField ���� 
					tf_npwd.setText(tf_npwd.getText()+"");// ���� �ߺ�Ȯ�ι�ư�� Ŭ���ϱ��� ��й�ȣ�� �̸� �Էµ��ִ°�츦 ����Ͽ� ������

				}else if(f.exists() && !tf_nid.getText().trim().equals("")){ // �ش� ���̵��� ������ ���� �Ѵٸ�
					lidCheck.setText("�ߺ��� ���̵� �Դϴ�!"); // f��ο� ������ ������ �ش� ���̺� ��� 
					tf_nid.setText("");					// ID�� TextField�� �ʱ�ȭ 
					tf_nid.requestFocus(); 				// ID-TextField�� Ŀ���� ��
					travel_check.setCheck(false); 		// Travel_Check Ŭ������ �ִ� check ���� false�� ����
					//TextField ����
					tf_npwd.setText(""); // �ߺ��� ID��� �����ϱ��ư�� ��Ȱ��ȭ�ϱ����� PWD-TextField�� �ʱ�ȭ

				}else if(tf_nid.getText().trim().equals("")) { // �ߺ��ϱ� ��ư Ŭ���� ���� ���ٸ� �ش� ���̺� ���
					lidCheck.setText("���̵� �Է����ּ���!");
				}
			}
		});

		// tf_nid(TextField)�� ���� �߰��ǰų� �������Ǹ� �����ϱ� ��ư ��Ȱ��ȭ
		tf_nid.addTextListener( new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				if( tf_nid.getText() != null ) { // tf_nid�� ���� ����Ǹ� 
					btnMember.setEnabled(false); // btnMember(�����ϱ� ��ư) ��Ȱ��ȭ
				}

			}
		} );

		// ȸ������ - �����ϱ� ��ư Ȱ��ȭ (����)
		tf_npwd.addTextListener( new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				//Travel_Check Ŭ������ check���� true�̸鼭 ID-TextField�� ���� �ƴ϶��
				if( travel_check.isCheck() == true && !tf_npwd.getText().trim().equals(""))  { 
					btnMember.setEnabled(true); //�����ϱ� ��ư Ȱ��ȭ
					btnMember.setBackground(Color.YELLOW);
				}else {
					btnMember.setEnabled(false); // ��ư ��Ȱ��ȭ
				}

			}
		} );

		// ȸ������ - �����ϱ� ��ư
		btnMember.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				travel_info.setId(tf_nid.getText());
				travel_info.setPassword(tf_npwd.getText());
				
				new Travel_Writer(travel_info); // ID�� PWD��  Travel_WriterŬ������ ���� ���� (�͸� Ŭ����)
				// ȸ�������ϱ��ư Ŭ�� �� DB�� ����(����ID,PWD)�� ��������� Ȯ���ؼ� ������ ȸ������ ���� ������ ���� 
				String path = "F:\\C,������ �п�\\������(Java)\\web_0324_kjr\\work\\Project_0421\\TravelInfo\\"+ travel_info.getId();
				File f = new File(path);
				if( !f.exists() ) {
					JOptionPane.showMessageDialog(f2,"ȸ������ ����!");
				}else {
					JOptionPane.showMessageDialog(f2,"ȸ������ ����!");
					tf_nid.setText("");
					tf_npwd.setText("");
				}
				
			

				}
			} );
		//--------------------------------------------------------------------------------------------		

		f.add(tf_id); 		// ���̵�â
		f.add(tf_pwd); // ��й�ȣâ

		f.add(lid);  //���̵��̺�
		f.add(lpwd); //�н����� ���̺�
		f.add(none_idnpass); // �α���,�н����� ���϶� ������ ���̺�

		f.add(btnlog); // �α��ι�ư
		f.add(btnnew); //ȸ������ ��ư

		f2.add(tf_nid);     // ȸ������ - ID(TextField)
		f2.add(tf_npwd);    // ȸ������ - PWD(TextField)
		f2.add(btnidCheck); // ȸ������ - IdCheck ��ư
		f2.add(lid2); 		// ȸ������ - ID ���̺�
		f2.add(lpwd2); 		// ȸ������ - PWD ���̺�
		f2.add(btnMember); 	// ȸ������ - ȸ�������ϱ� ��ư
		f2.add(lidCheck); 	// ȸ������ - ID �ߺ����� �ƴ��� ���̺�


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



























