package Portfolio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Portfolio.BingoGame.MyFrame;

public class Membership_Management 
{

	public static void main(String[] args) 
	{
		Membership membership = new Membership();
	}
}

class Membership extends Frame implements ActionListener
{
	//화면중앙배치용 변수 
	Dimension dimen, dimen1;  int xpos, ypos;
	
	//init용 화면 구현 레이아웃 변수들...
	Label lbTitle = new Label("미니게임천국 관리자모드");
	Label lbId = new Label("ID");	
	Label lbPw = new Label("PW");
	Label lbIdRecheck = new Label("");
	
	TextField tfId = new TextField(15);
	TextField tfPw = new TextField(15);
	
	Button btnlogin = new Button("로그인");
	Button btnregi = new Button("회원가입");
	
	Connection conn = null;
	String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=utf8";
	String id = "root";// ID
	String pass = "qwer";// 비밀번호	
	
	//디비 데이타 삽입용
	PreparedStatement pstmt = null;	
		
	//디비 조회용
	Statement stmt = null;
	ResultSet rs = null;
	
	String result="";//텍스트에이리어에 누적해서 한번에 출력하기위해서 
	
	Membership()
	{
		init();//화면구성		
		center();//중앙배치
		start();//이벤트
	}
	
	void center()
	{
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	
	void init()
	{
		this.setSize(500, 500);	
		this.setVisible(true);
		
		this.setLayout(null);
		
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font25 = new Font("SansSerif", Font.BOLD, 25);
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		//타이틀
		this.add(lbTitle);
		lbTitle.setBounds(70, 80, 350, 30);		
		lbTitle.setFont(font30);
		
		this.add(lbId);
		lbId.setBounds(100, 180, 50, 40);		
		lbId.setFont(font20);
		
		this.add(lbPw);
		lbPw.setBounds(100, 250, 50, 40);		
		lbPw.setFont(font20);
		
		this.add(tfId);
		tfId.setBounds(170, 180, 180, 40);		
		tfId.setFont(font15);
		
		this.add(tfPw);
		tfPw.setBounds(170, 250, 180, 40);		
		tfPw.setFont(font15);
		tfPw.setEchoChar('*');
		
		this.add(lbIdRecheck);
		lbIdRecheck.setBounds(140, 300, 350, 30);		
		lbIdRecheck.setFont(font15);
		
		this.add(btnregi);
		btnregi.setBounds(100, 350, 120, 50);		
		btnregi.setFont(font15);
		this.add(btnlogin);
		btnlogin.setBounds(260, 350, 120, 50);		
		btnlogin.setFont(font15);
		
	}
	
	void start()
	{
		btnlogin.addActionListener(this);
		btnregi.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==btnregi)
		{
			regi();
		}
		
		if(e.getSource()==btnlogin)
		{
			String emtyCheck1 = tfId.getText();
			String emtyCheck2 = tfPw.getText();
			
			if(emtyCheck1.equals("") && emtyCheck2.equals(""))
			{
				System.out.println("아이디,패스워드를 입력하세요!");
			}
			else if(emtyCheck2.equals(""))
			{
				System.out.println("패스워드를 입력하세요!");
			}
			else if(emtyCheck1.equals(""))
			{
				System.out.println("아이디를 입력하세요!");
			}
			else
			{
				Login();
			}
			
		}
		
	}
	
	void regi()
	{
		Frame f = new Frame();
		f.setSize(500, 700);
		//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
	
		f.setLayout(null);
		
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = f.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		f.setLocation(xpos, ypos);
	
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
	
		Label lbTitle1 = new Label("회원가입화면");
		Label lbId1 = new Label("아이디");
		Label lbPw1 = new Label("패스워드");
		Label lbPwc1 = new Label("패스워드확인");
		Label lbIdlap = new Label("");
		Label lbName = new Label("이름");
		Label lbPhone = new Label("휴대전화");
		Label lbAddr = new Label("주소");
		TextField tfId1 = new TextField(15);
		TextField tfPw1 = new TextField(15);
		TextField tfPwc1 = new TextField(15);
		TextField tfName = new TextField(15);
		TextField tfPhone = new TextField(15);
		TextField tfAddr = new TextField(15);
		Button bt = new Button("가입하기");
		Button btCheck = new Button("중복체크");
		tfPw1.setEchoChar('*');
		tfPwc1.setEchoChar('*');
	
		f.add(lbTitle1);
		lbTitle1.setBounds(150, 60, 300, 30);		
		lbTitle1.setFont(font30);
	
		f.add(lbId1);
		lbId1.setBounds(100, 120, 50, 30);		
		lbId1.setFont(font15);
		f.add(lbIdlap);
		lbIdlap.setBounds(170, 120, 200, 30);		
		lbIdlap.setFont(font15);
		f.add(tfId1);
		tfId1.setBounds(100, 160, 200, 30);		
		tfId1.setFont(font15);
		f.add(btCheck);
		btCheck.setBounds(320, 160, 120, 30);		
		btCheck.setFont(font15);
	
		f.add(lbPw1);
		lbPw1.setBounds(100, 200, 100, 30);		
		lbPw1.setFont(font15);
	
		f.add(tfPw1);
		tfPw1.setBounds(100, 240, 200, 30);		
		tfPw1.setFont(font15);
	
		f.add(lbPwc1);
		lbPwc1.setBounds(100, 280, 100, 30);		
		lbPwc1.setFont(font15);
	
		f.add(tfPwc1);
		tfPwc1.setBounds(100, 320, 200, 30);		
		tfPwc1.setFont(font15);
	
		f.add(lbName);
		lbName.setBounds(100, 360, 100, 30);		
		lbName.setFont(font15);
	
		f.add(tfName);
		tfName.setBounds(100, 400, 200, 30);		
		tfName.setFont(font15);
	
		f.add(lbPhone);
		lbPhone.setBounds(100, 440, 100, 30);		
		lbPhone.setFont(font15);
	
		f.add(tfPhone);
		tfPhone.setBounds(100, 480, 200, 30);		
		tfPhone.setFont(font15);
	
		f.add(lbAddr);
		lbAddr.setBounds(100, 520, 100, 30);		
		lbAddr.setFont(font15);
	
		f.add(tfAddr);
		tfAddr.setBounds(100, 560, 200, 30);		
		tfAddr.setFont(font15);
	
		f.add(bt);
		bt.setBounds(170, 600, 150, 50);		
		bt.setFont(font15);
		
		String pw1 = tfPw1.getText();
		String pwc1 = tfPwc1.getText();
		
		bt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					String id1 = tfId1.getText();
					String pw = tfPw1.getText();
					String pwc = tfPwc1.getText();
					String name = tfName.getText();
					String phone = tfPhone.getText();
					String addr = tfAddr.getText();
			
					//디비 연결
					conn = DriverManager.getConnection(url, id, pass);
					//삽입될때 쿼리문
					String query = "insert into members values (null, ?, ?, ?, ?, ?)";

					//쿼리문 수행
					pstmt = conn.prepareStatement(query);	
				
					//pstmt에 삽입될 변수값을 탑재
					pstmt.setString(1, id1);
					pstmt.setString(2, pw);
					pstmt.setString(3, name);
					pstmt.setString(4, phone);
					pstmt.setString(5, addr);
					pstmt.executeUpdate();
					
					if(pw.equals(pwc) && !(pw.equals("") && pwc.equals("")))
					{
						Frame f = new Frame();
						f.setSize(500, 200);
				
						f.setLayout(null);
					
						Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
						Dimension dimen1 = f.getSize();
						int xpos = (int)(dimen.getWidth() / 2 - dimen1.getWidth() / 2);
						int ypos = (int)(dimen.getHeight() / 2 - dimen1.getHeight() / 2);
						f.setLocation(xpos, ypos);//윈도우창의 위치를 가운데로 지정해주는 코드
				
						Font font30 = new Font("SansSerif", Font.BOLD, 30);
						Font font25 = new Font("SansSerif", Font.BOLD, 25);
						Font font20 = new Font("SansSerif", Font.BOLD, 20);
						Font font15 = new Font("SansSerif", Font.BOLD, 15);
						Font font10 = new Font("SansSerif", Font.BOLD, 10);
				
						Label lbTitle3 = new Label("회원가입이 완료되었습니다");
				
						f.add(lbTitle3);
						lbTitle3.setBounds(80, 100, 500, 30);		
						lbTitle3.setFont(font25);
				
						f.setVisible(true);//화면에 윈도우창을 보여주는 코드
				
						f.addWindowListener(new WindowAdapter() 
						{
							public void windowClosing(WindowEvent e) 
							{
								f.setVisible(false);
							}
						});		
						
					}
					else if(!(pw.equals(pwc)))
					{
						System.out.println("비밀번호를 확인하세요!");	
					}
					else if(id1.equals("") || pw.equals("") || pwc.equals("") || name.equals("") || phone.equals("") || addr.equals(""))
					{
						System.out.println("공백란을 확인하세요!");	
					}
					
				} 
				catch (SQLException e1) {}	
			}
		});
	
		btCheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//검색대상이되는 이름 가져오기
				String idCheck = tfId1.getText();
			
				//디비에서 정보를 가져와서 텍스트에이리어에 뿌려주기				
				try 
				{
					//디비 접속을 위한 conn변수 생성
					conn = DriverManager.getConnection(url, id, pass);
					//디비에연결
					stmt = conn.createStatement();
					String query= "select * from members";
					rs = stmt.executeQuery(query);
					//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
					
					while (rs.next()) 
					{
						if(idCheck.equals(rs.getString("id")))
						{
							lbIdlap.setText("중복된아이디가 있습니다!");
						}
					}	
					rs.close();
				} 
				catch (SQLException error)
				{
					System.err.println("error = " + error.toString());			
				}	
			}
		});
	
	
		f.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				f.setVisible(false);
			}
		});
	
		f.setVisible(true);//화면에 윈도우창을 보여주는 코드
	
	}
	
	void dlgMsg(String msg)
	{
		final Dialog dlg = new Dialog(this, "알림", true);
		dlg.setLayout(null);	
		
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		Label lbTitle = new Label(msg);
		
		Button bt = new Button("확인");
		
		Panel pp = new Panel(new FlowLayout());
		
		pp.add(bt);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		
		dlg.add(lbTitle);
		lbTitle.setBounds(40, 90, 300, 30);		
		lbTitle.setFont(font20);
		
		dlg.add(bt);
		bt.setBounds(130, 140, 80, 50);		
		bt.setFont(font15);
		
		dlg.setLocation(xpos, 400);
		dlg.add("South", pp);
		dlg.setSize(350, 250);
		dlg.setVisible(true);
	}
	
	void Login()
	{
		String idin = tfId.getText();
		String pwin = tfPw.getText();
	
		//디비에서 정보를 가져와서 텍스트에이리어에 뿌려주기				
		try 
		{
			//디비 접속을 위한 conn변수 생성
			conn = DriverManager.getConnection(url, id, pass);
			//디비에연결
			stmt = conn.createStatement();
			//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
			rs = stmt.executeQuery("select * from members");
			//디비에서 조회한 모든데이타가 저장된 r의 값을 한줄씩 체크해서 없을때까지 반복
			while (rs.next()) 
			{
				//한줄씩 반복하면서 result.에 누적해서 저장
				//getString은 테이블의 컬럼명 기준으로 데이타를 가져올수 있음.
				if(idin.equals(rs.getString("id")) && pwin.equals(rs.getString("pw")))
				{
					Frame f = new Frame();
					f.setSize(500, 750);
				
					f.setLayout(null);
				
					dimen = Toolkit.getDefaultToolkit().getScreenSize();
					dimen1 = f.getSize();
					xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
					ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
					f.setLocation(xpos, ypos);
				
					Font font40 = new Font("SansSerif", Font.BOLD, 40);
					Font font30 = new Font("SansSerif", Font.BOLD, 30);
					Font font20 = new Font("SansSerif", Font.BOLD, 20);
					Font font15 = new Font("SansSerif", Font.BOLD, 15);
					Font font10 = new Font("SansSerif", Font.BOLD, 10);
				
					Label lbTitle1 = new Label("관리자 화면");
				
					Button btAllview = new Button("회원현황보기");
					Button btEdit = new Button("회원수정하기");
					Button btDel = new Button("회원삭제하기");
					Button btLotto = new Button("로또게임하기");
					Button btRPC = new Button("가위바위보게임하기");
					Button btBingo = new Button("빙고게임하기");
				
					f.add(lbTitle1);
					lbTitle1.setBounds(140, 70, 350, 50);		
					lbTitle1.setFont(font40);
				
					f.add(btAllview);
					btAllview.setBounds(120, 160, 250, 50);		
					btAllview.setFont(font20);
					f.add(btEdit);
					btEdit.setBounds(120, 250, 250, 50);		
					btEdit.setFont(font20);
					f.add(btDel);
					btDel.setBounds(120, 350, 250, 50);		
					btDel.setFont(font20);
					f.add(btLotto);
					btLotto.setBounds(120, 440, 250, 50);		
					btLotto.setFont(font20);
					f.add(btRPC);
					btRPC.setBounds(120, 540, 250, 50);		
					btRPC.setFont(font20);
					f.add(btBingo);
					btBingo.setBounds(120, 640, 250, 50);		
					btBingo.setFont(font20);
				
					lbIdRecheck.setText("");
				
					btAllview.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							Frame f = new Frame();
							f.setSize(700, 700);
							//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
						
							f.setLayout(null);
						
							dimen = Toolkit.getDefaultToolkit().getScreenSize();
							dimen1 = f.getSize();
							xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
							ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
							f.setLocation(xpos, ypos);
							
							Font font40 = new Font("SansSerif", Font.BOLD, 40);
							Font font30 = new Font("SansSerif", Font.BOLD, 30);
							Font font20 = new Font("SansSerif", Font.BOLD, 20);
							Font font15 = new Font("SansSerif", Font.BOLD, 15);
							Font font10 = new Font("SansSerif", Font.BOLD, 10);
						
							Label lbTitle2 = new Label("회원 현황");
						
							TextArea taList = new TextArea();

							f.add(lbTitle2);
							lbTitle2.setBounds(240, 60, 300, 50);		
							lbTitle2.setFont(font40);
						
							f.add(taList);
							taList.setBounds(80, 150, 550, 500);
							taList.setFont(font20);
						
							result="";//수정시 새로고침 효과
							//디비에서 정보를 가져와서 텍스트에이리어에 뿌려주기				
							try 
							{
								//디비 접속을 위한 conn변수 생성
								conn = DriverManager.getConnection(url, id, pass);
								//디비에연결
								stmt = conn.createStatement();
								//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
								rs = stmt.executeQuery("select * from members");
								//디비에서 조회한 모든데이타가 저장된 r의 값을 한줄씩 체크해서 없을때까지 반복
								while (rs.next()) 
								{
									//한줄씩 반복하면서 result.에 누적해서 저장
									//getString은 테이블의 컬럼명 기준으로 데이타를 가져올수 있음.
									result += rs.getString("id") +"/"+ rs.getString("pw") + "/"+rs.getString("name")+"/"+ rs.getString("phone") +"/"+ rs.getString("addr") +"\n";	
								}
								//한번에 화면에 뿌리기
								taList.setText(result);
								rs.close();
							} 
							catch (SQLException error) 
							{
								System.err.println("error = " + error.toString());			
							}	
						
						
							f.addWindowListener(new WindowAdapter() 
							{
								public void windowClosing(WindowEvent e) 
								{
									f.setVisible(false);
								}
							});
						
							f.setVisible(true);//화면에 윈도우창을 보여주는 코드
						
						}
					});
				
					btEdit.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							Frame f = new Frame();
							f.setSize(500, 550);
						
							f.setLayout(null);
						
							dimen = Toolkit.getDefaultToolkit().getScreenSize();
							dimen1 = f.getSize();
							xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
							ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
							f.setLocation(xpos, ypos);
							
							Font font40 = new Font("SansSerif", Font.BOLD, 40);
							Font font30 = new Font("SansSerif", Font.BOLD, 30);
							Font font20 = new Font("SansSerif", Font.BOLD, 20);
							Font font15 = new Font("SansSerif", Font.BOLD, 15);
							Font font10 = new Font("SansSerif", Font.BOLD, 10);
						
							Label lbTitle3 = new Label("회원수정하기");
							Label lbIdmodi = new Label("I D");
							Label lbNamemodi = new Label("Name");
							Label lbPhonemodi = new Label("H P");
							Label lbAddrmodi = new Label("Address");
							TextField tfIdmodi = new TextField(20);
							TextField tfNamemodi = new TextField(20);
							TextField tfPhonemodi = new TextField(20);
							TextField tfAddrmodi = new TextField(20);
							Button btmodi = new Button("수정완료");
							Button btSearch = new Button("찾 기");
						
							f.add(lbTitle3);
							lbTitle3.setBounds(130, 60, 300, 50);		
							lbTitle3.setFont(font40);
						
							f.add(lbIdmodi);
							lbIdmodi.setBounds(100, 140, 80, 30);		
							lbIdmodi.setFont(font20);
							f.add(tfIdmodi);
							tfIdmodi.setBounds(190, 140, 180, 30);		
							tfIdmodi.setFont(font20);
							
							f.add(lbNamemodi);
							lbNamemodi.setBounds(100, 200, 80, 30);		
							lbNamemodi.setFont(font20);
							f.add(tfNamemodi);
							tfNamemodi.setBounds(190, 200, 180, 30);		
							tfNamemodi.setFont(font20);
						
							f.add(lbPhonemodi);
							lbPhonemodi.setBounds(100, 260, 80, 30);		
							lbPhonemodi.setFont(font20);
							f.add(tfPhonemodi);
							tfPhonemodi.setBounds(190, 260, 180, 30);		
							tfPhonemodi.setFont(font20);
						
							f.add(lbAddrmodi);
							lbAddrmodi.setBounds(100, 320, 80, 30);		
							lbAddrmodi.setFont(font20);
							f.add(tfAddrmodi);
							tfAddrmodi.setBounds(190, 320, 180, 30);		
							tfAddrmodi.setFont(font20);
						
							f.add(btmodi);
							btmodi.setBounds(100, 400, 150, 50);		
							btmodi.setFont(font20);
							f.add(btSearch);
							btSearch.setBounds(270, 400, 150, 50);		
							btSearch.setFont(font20);
						
						
							btmodi.addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
								{
									result="";//수정시 새로고침 효과
								
									String idModi = tfIdmodi.getText();
									String nameModi = tfNamemodi.getText();
									String phoneModi = tfPhonemodi.getText();
									String addrModi = tfAddrmodi.getText();
								
									String query = "update members set name = ?, phone = ?, addr = ? where id = ?";
								
									try 
									{
										PreparedStatement pstmt = conn.prepareStatement(query);	
										pstmt.setString(1,nameModi);
										pstmt.setString(2,phoneModi);
										pstmt.setString(3,addrModi);
										pstmt.setString(4,idModi);
										pstmt.executeUpdate();
										pstmt.close();
										System.err.println("회원 정보수정 완료!!");
									} 
									catch (SQLException ee) 
									{
										System.err.println("회원 정보수정 실패!!");
									
									}
								}
						
							});
						
							btSearch.addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
								{
									String searchID = tfIdmodi.getText();
								
									//디비에서 정보를 가져와서 텍스트에이리어에 뿌려주기				
									try 
									{
										//디비 접속을 위한 conn변수 생성
										conn = DriverManager.getConnection(url, id, pass);
										//디비에연결
										stmt = conn.createStatement();
										//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
										rs = stmt.executeQuery("select * from members");
										//디비에서 조회한 모든데이타가 저장된 r의 값을 한줄씩 체크해서 없을때까지 반복
										while (rs.next()) 
										{
											//한줄씩 반복하면서 result.에 누적해서 저장
											//getString은 테이블의 컬럼명 기준으로 데이타를 가져올수 있음.
											if(searchID.equals(rs.getString("id")))
											{
												tfIdmodi.setText(rs.getString("id"));
												tfIdmodi.setEnabled(false);
												tfNamemodi.setText(rs.getString("name"));
												tfPhonemodi.setText(rs.getString("phone"));
												tfAddrmodi.setText(rs.getString("addr"));
											}
												
										}				
											
										rs.close();
									} 
									catch (SQLException error) 
									{
										System.err.println("error = " + error.toString());			
									}	
								}
							
							});
						
							f.addWindowListener(new WindowAdapter() 
							{
								public void windowClosing(WindowEvent e) 
								{
									f.setVisible(false);
								}
							});
						
							f.setVisible(true);//화면에 윈도우창을 보여주는 코드
						
						}
					});
				
					btDel.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							Frame f = new Frame();
							f.setSize(500, 500);
							//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
						
							f.setLayout(null);
						
							dimen = Toolkit.getDefaultToolkit().getScreenSize();
							dimen1 = f.getSize();
							xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
							ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
							f.setLocation(xpos, ypos);
						
							Font font30 = new Font("SansSerif", Font.BOLD, 30);
							Font font20 = new Font("SansSerif", Font.BOLD, 20);
							Font font15 = new Font("SansSerif", Font.BOLD, 15);
							Font font10 = new Font("SansSerif", Font.BOLD, 10);
						
							Label lbTitle4 = new Label("회원삭제하기");
							Label delId = new Label("I D");
							Label delName = new Label("Name");
							Label delPhone = new Label("H P");
							Label delAddr = new Label("Address");
							Label delNameView = new Label("");
							Label delPhoneView = new Label("");
							Label delAddrView = new Label("");
						
							f.add(lbTitle4);
							lbTitle4.setBounds(150, 60, 300, 30);		
							lbTitle4.setFont(font30);
						
							TextField tfIddel1 = new TextField(15);
						
							f.add(delId);
							delId.setBounds(60, 130, 80, 30);		
							delId.setFont(font20);
							f.add(tfIddel1);
							tfIddel1.setBounds(180, 130, 150, 30);		
							tfIddel1.setFont(font20);
						
							f.add(delName);
							delName.setBounds(60, 180, 80, 30);		
							delName.setFont(font20);
							f.add(delNameView);
							delNameView.setBounds(180, 180, 150, 30);		
							delNameView.setFont(font20);
						
							f.add(delPhone);
							delPhone.setBounds(60, 230, 100, 30);		
							delPhone.setFont(font20);
							f.add(delPhoneView);
							delPhoneView.setBounds(180, 230, 150, 30);		
							delPhoneView.setFont(font20);
						
							f.add(delAddr);
							delAddr.setBounds(60, 280, 80, 30);		
							delAddr.setFont(font20);
							f.add(delAddrView);
							delAddrView.setBounds(180, 280, 250, 30);		
							delAddrView.setFont(font20);
						
							Button btnDel = new Button("삭제하기");
							Button btnDelsear = new Button("조회하기");
						
							f.add(btnDel);
							btnDel.setBounds(100, 350, 120, 70);		
							btnDel.setFont(font20);
							f.add(btnDelsear);
							btnDelsear.setBounds(270, 350, 120, 70);		
							btnDelsear.setFont(font20);
						
							btnDelsear.addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
								{
									String delId1 = tfIddel1.getText();
									//디비에서 정보를 가져와서 텍스트에이리어에 뿌려주기				
									try 
									{
										//디비 접속을 위한 conn변수 생성
										conn = DriverManager.getConnection(url, id, pass);
										//디비에연결
										stmt = conn.createStatement();
										//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
										rs = stmt.executeQuery("select * from members");
										//디비에서 조회한 모든데이타가 저장된 r의 값을 한줄씩 체크해서 없을때까지 반복
										while (rs.next()) 
										{
											//한줄씩 반복하면서 result.에 누적해서 저장
											//getString은 테이블의 컬럼명 기준으로 데이타를 가져올수 있음.
											if(delId1.equals(rs.getString("id")))
											{
												delNameView.setText(rs.getString("name"));
												delPhoneView.setText(rs.getString("phone"));
												delAddrView.setText(rs.getString("addr"));
											}			
										}				
											
										rs.close();
										
									} 
									catch (SQLException error) 
									{
										System.err.println("error = " + error.toString());			
									}	
								}
							});
						
							btnDel.addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
								{
									dlgMsg("DB에서 데이타가 삭제됩니다.");
									
									String iddel= tfIddel1.getText();
								
									String query = "delete from members where id = ? ";
								
									try 
									{
										PreparedStatement pstmt = conn.prepareStatement(query);
										pstmt.setString(1, iddel);
										pstmt.executeUpdate();
										pstmt.close();
										System.err.println("회원 삭제 완료!!");
										
										delNameView.setText("삭제완료!");
										delPhoneView.setText("삭제완료!");
										delAddrView.setText("삭제완료!");
									} 
									catch (SQLException ee) 
									{
										System.err.println("회원 삭제 실패!!");
									
									}
								
								}
							});
					
							f.addWindowListener(new WindowAdapter() 
							{
								public void windowClosing(WindowEvent e) 
								{
									f.setVisible(false);
								}
							});
						
							f.setVisible(true);//화면에 윈도우창을 보여주는 코드
						
						}
					});
				
					f.addWindowListener(new WindowAdapter() 
					{
						public void windowClosing(WindowEvent e) 
						{
							f.setVisible(false);
						}
					});
					
					btLotto.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							Game g = new Game();
						}
					});
					
					btRPC.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							RockPaperScissors rpc = new RockPaperScissors();
						}
					});
					
					btBingo.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							new MyFrame("빙고게임");
						}
					});
				
					f.setVisible(true);//화면에 윈도우창을 보여주는 코드
			}
			else if((idin.equals(rs.getString("id"))))
			{
				if(!(pwin.equals(rs.getString("pw"))))
				{
					String lbPwconfirm = "패스워드가 일치하지 않습니다!";
					lbIdRecheck.setText(lbPwconfirm+"");
				}
			}		
		}
		
			rs.close();
		
		} 
		catch (SQLException error) 
		{
			System.err.println("error = " + error.toString());			
		}			
	}

}
		
	


