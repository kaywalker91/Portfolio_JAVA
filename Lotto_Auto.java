package Portfolio;

import java.awt.*;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;

public class Lotto_Auto 
{
	public static void main(String[] args) 
	{
		Game g = new Game();
	}
}

class Game extends Frame implements ActionListener 
{
	int i = 0;
	int j = 0;
	
	int rank = 7; //�ζǵ���� ��Ÿ���� ����
	int rank1,rank2,rank3,rank4,rank5,rank6,rank7;
	int pansu=0;
	String lottoNum[] = new String[6]; //�ζǹ�ȣ�� TextField���� �Է¹޴� �迭
	int lotto[] = new int[6];// lottoNum�� int������ ��ȯ�Ͽ� �����ϴ� �迭
	
	int n1,n2; //���������� �����ϴ� ����
	int cnt1 = 0;//�ζǹ�ȣ ������ŭ ���������� �����ϵ��� ����� ����
	int cnt2 = 0;//�ζǹ�ȣ ������ŭ ���������� �����ϵ��� ����� ����
	int[] lottoWin = new int[6];//�ζǴ�÷��ȣ�� �����ϴ� �迭
	int[] lottoA = new int[6];//�ڵ��ζǹ�ȣ�� �����ϴ� �迭
	
	Random rd = new Random();
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Label lbTitle = new Label("�ζ� ���߱� ����");	
	Label lbMy = new Label("��ȣ�Է�");
	TextField tf1  = new TextField(2);
	TextField tf2  = new TextField(2);
	TextField tf3  = new TextField(2);
	TextField tf4  = new TextField(2);
	TextField tf5  = new TextField(2);
	TextField tf6  = new TextField(2);
	
	Label sixc = new Label("6�����߸� 1��: 10��");
	Label fivec = new Label("5�����߸� 2��: 1��");
	Label fourc = new Label("4�����߸� 3��: 1õ����");
	Label threec = new Label("3�����߸� 4��: 10����");
	Label twoc = new Label("2�����߸� 5��: 5õ��");
	Label onec = new Label("1�����߸� 6��: ��");
	Label zeroc = new Label("0�����߸� 7��: ��");
		
	Button btnStart = new Button("��÷ ����");
	Button btnauto = new Button("�ڵ� �Է�");
	Button btnRenew = new Button("�ʱ�ȭ");
	
	public Game() 
	{
		super("Lotto");
		
		this.init();
		
		this.start();
		
		this.setSize(400, 550);	
		
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		
		this.setVisible(true);
	}

	public void init() 
	{
		// �ۼַ�Ʈ���  : ���� ��ǥ �Է¹��.
		this.setLayout(null);
		
		Font font25 = new Font("SansSerif", Font.BOLD, 25);
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		//Ÿ��Ʋ
		this.add(lbTitle);
		lbTitle.setBounds(100, 50, 300, 30);		
		lbTitle.setFont(font25);
		
		this.add(lbMy);
		lbMy.setBounds(50, 100, 70, 30);
		lbMy.setFont(font15);
		
		this.add(btnStart);
		btnStart.setBounds(50, 200, 80, 30);
		btnStart.setFont(font15);
		this.add(btnauto);
		btnauto.setBounds(150, 200, 80, 30);
		btnauto.setFont(font15);
		this.add(btnRenew);
		btnRenew.setBounds(250, 200, 80, 30);
		btnRenew.setFont(font15);
		
		this.add(tf1);
		tf1.setBounds(50, 140, 40, 40);
		tf1.setFont(font20);
		this.add(tf2);
		tf2.setBounds(100, 140, 40, 40);
		tf2.setFont(font20);
		this.add(tf3);
		tf3.setBounds(150, 140, 40, 40);
		tf3.setFont(font20);
		this.add(tf4);
		tf4.setBounds(200, 140, 40, 40);
		tf4.setFont(font20);
		this.add(tf5);
		tf5.setBounds(250, 140, 40, 40);
		tf5.setFont(font20);
		this.add(tf6);
		tf6.setBounds(300, 140, 40, 40);
		tf6.setFont(font20);
		
		this.add(sixc);
		sixc.setBounds(50, 260, 250, 30);
		sixc.setFont(font20);
		this.add(fivec);
		fivec.setBounds(50, 290, 250, 30);
		fivec.setFont(font20);
		this.add(fourc);
		fourc.setBounds(50, 320, 250, 30);
		fourc.setFont(font20);
		this.add(threec);
		threec.setBounds(50, 350, 250, 30);
		threec.setFont(font20);
		this.add(twoc);
		twoc.setBounds(50, 380, 250, 30);
		twoc.setFont(font20);
		this.add(onec);
		onec.setBounds(50, 410, 250, 30);
		onec.setFont(font20);
		this.add(zeroc);
		zeroc.setBounds(50, 440, 250, 30);
		zeroc.setFont(font20);
		
	}

	public void start() 
	{
		
		btnStart.addActionListener(this);
		btnauto.addActionListener(this);
		btnRenew.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) {
				setVisible(false);
		   		dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnStart) 
		{
			ran();
			
			lottoNum[i] = tf1.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf2.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf3.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf4.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf5.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf6.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			final Dialog dlg = new Dialog(this, "��÷Ȯ��", true);
			dlg.setLayout(null);	
			
			Font font30 = new Font("���", Font.BOLD, 30);
			Font font25 = new Font("���", Font.BOLD, 25);
			Font font20 = new Font("���", Font.BOLD, 20);
			Font font15 = new Font("SansSerif", Font.BOLD, 15);
			Font font10 = new Font("SansSerif", Font.BOLD, 10);
			
			sorting();
			
			for(i=0;i<6;i++)
			{
				System.out.println("��÷��ȣ"+(i+1)+"��");
				System.out.println(lottoWin[i]);
				
				if(lotto[i] == lottoWin[i])
				{
					rank--;
				}
				
			}
			
			if(rank == 1) {
				rank1 += 1;
			}else if(rank == 2) {
				rank2 += 1;
			}else if(rank == 3) {
				rank3 += 1;
			}else if(rank == 4) {
				rank4 += 1;
			}else if(rank == 5) {
				rank5 += 1;
			}else if(rank == 6) {
				rank6 += 1;
			}else if(rank == 7) {
				rank7 += 1;
			}
			
			pansu++;
			
			Label lbTitle0 = new Label("���� "+pansu+"��° ������!");
			Label lbTitle = new Label(rank+"���÷!");
			Label lbTitle1 = new Label("1�� "+(rank1)+"�� ��÷!");
			Label lbTitle2 = new Label("2�� "+(rank2)+"�� ��÷!");
			Label lbTitle3 = new Label("3�� "+(rank3)+"�� ��÷!");
			Label lbTitle4 = new Label("4�� "+(rank4)+"�� ��÷!");
			Label lbTitle5 = new Label("5�� "+(rank5)+"�� ��÷!");
			Label lbTitle6 = new Label("6�� "+(rank6)+"�� ��÷!");
			Label lbTitle7 = new Label("7�� "+(rank7)+"�� ��÷!");
			
			Button bt = new Button("Ȯ ��");
			
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
			
			dlg.add(lbTitle0);
			lbTitle0.setBounds(50, 50, 300, 30);		
			lbTitle0.setFont(font30);
			
			dlg.add(lbTitle);
			lbTitle.setBounds(120, 100, 150, 30);		
			lbTitle.setFont(font25);
			
			dlg.add(lbTitle1);
			lbTitle1.setBounds(100, 150, 150, 30);		
			lbTitle1.setFont(font20);
			dlg.add(lbTitle2);
			lbTitle2.setBounds(100, 200, 150, 30);		
			lbTitle2.setFont(font20);
			dlg.add(lbTitle3);
			lbTitle3.setBounds(100, 250, 150, 30);		
			lbTitle3.setFont(font20);
			dlg.add(lbTitle4);
			lbTitle4.setBounds(100, 300, 150, 30);		
			lbTitle4.setFont(font20);
			dlg.add(lbTitle5);
			lbTitle5.setBounds(100, 350, 150, 30);		
			lbTitle5.setFont(font20);
			dlg.add(lbTitle6);
			lbTitle6.setBounds(100, 400, 150, 30);		
			lbTitle6.setFont(font20);
			dlg.add(lbTitle7);
			lbTitle7.setBounds(100, 450, 150, 30);		
			lbTitle7.setFont(font20);
			
			dlg.add(bt);
			bt.setBounds(120, 500, 100, 50);		
			bt.setFont(font20);
			
			dlg.setLocation(xpos, 400);
			dlg.setSize(350, 600);
			dlg.setVisible(true);
		}
		
		if(e.getSource() == btnauto) 
		{
			ran2();
			
			tf1.setText(lottoA[0]+"");
			tf2.setText(lottoA[1]+"");
			tf3.setText(lottoA[2]+"");
			tf4.setText(lottoA[3]+"");
			tf5.setText(lottoA[4]+"");
			tf6.setText(lottoA[5]+"");
			
			sorting2();
			
		}
		
		if(e.getSource() == btnRenew) 
		{
			n1 = 0;
			n2 = 0;
			cnt1 = 0;
			cnt2 = 0;
			i=0;
			rank = 7;
			
			for(int i=0; i<6 ;i++) {
				
				lottoA[i] = 0;
				
			}
			
			tf1.setText(lottoA[0]+"");
			tf2.setText(lottoA[1]+"");
			tf3.setText(lottoA[2]+"");
			tf4.setText(lottoA[3]+"");
			tf5.setText(lottoA[4]+"");
			tf6.setText(lottoA[5]+"");
			
			for(int i=0; i<6 ;i++) {
				
				lottoWin[i] = 0;
				
			}
					
		}
		
	}
	
	void ran()
	{
		jump:
			
		while(cnt1<6)
		{
			n1 = rd.nextInt(45)+1;
					
			for(int j=0; j<cnt1; j++)
			{
				if(lottoWin[j] == n1)
				{
					continue jump;
				}
			}
					
			lottoWin[cnt1] = n1;
					
			cnt1++;
		}
		
	}
	
	void ran2()
	{
		jump:
			
		while(cnt2<6)
		{
			n2 = rd.nextInt(45)+1;
					
			for(int k=0; k<cnt2; k++)
			{
				if(lottoA[j] == n2)
				{
					continue jump;
				}
			}
					
			lottoA[cnt2] = n2;
					
			cnt2++;
		}
		
	}
	
	void sorting()
	{
		Arrays.sort(lottoWin);
		Arrays.sort(lotto);
	}
	
	void sorting2()
	{
		Arrays.sort(lottoA);
	}
	
}

