package Portfolio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.border.*;
import javax.swing.text.Caret;


public class RockPaperScissors extends JFrame
{
	
	JLabel lbl,com,result,com1,result1,win1,lose1,draw1,cnt1,tot;
    JPanel Panel1,Panel2;
    JButton b1,b2,rock,paper,scissors;
    int playerinput;
    int win,draw,lose,cnt;
    
    ImageIcon img = new ImageIcon("./Img/Rock.jpg");
    ImageIcon img2 = new ImageIcon("./Img/Sissor.jpg ");
    ImageIcon img3 = new ImageIcon("./Img/Paper.png");
    
    public RockPaperScissors()
    {
          super( "��������������" );
          
          setLayout(null);
   
          EtchedBorder eborder =  new EtchedBorder();
          
          Font font30 = new Font("SansSerif", Font.BOLD, 30);
          Font font25 = new Font("SansSerif", Font.BOLD, 25);
          Font font20 = new Font("SansSerif", Font.BOLD, 20);
  		  Font font15 = new Font("SansSerif", Font.BOLD, 15);
  		  Font font10 = new Font("SansSerif", Font.BOLD, 10);
  		
          lbl = new JLabel( "����/����/�� ����",JLabel.CENTER);
          lbl.setBounds(80, 50, 350, 30);		
          lbl.setFont(font30);
          
          lbl.setBorder(eborder);
          
          add( lbl );
          
          Panel2 = new JPanel();
          Panel2.setBounds(40, 130, 400, 150);
          
          rock = new JButton(img);
          rock.setPreferredSize(new Dimension(120, 120)); // ��ư ũ�� ����

          scissors = new JButton(img2);
          scissors.setPreferredSize(new Dimension(120, 120)); // ��ư ũ�� ����
          
          paper = new JButton(img3);
          paper.setPreferredSize(new Dimension(120, 120)); // ��ư ũ�� ����
          
          Panel2.add(rock);
          Panel2.add(paper);
          Panel2.add(scissors);
          
          Panel1 = new JPanel();
          Panel1.setBounds(200, 270, 100, 50);		
          b1 = new JButton("���ӽ���");
          b1.setFont(font15);
          b2 = new JButton("�� ��");
          b2.setFont(font20);
         
          Panel1.add( b2 );
          
          com = new JLabel("��ǻ��:");
          com.setBounds(160, 350, 100, 30);
          com.setFont(font25);
          com1 = new JLabel("");
          com1.setBounds(250, 350, 70, 30);
          com1.setFont(font25);
         
          result = new JLabel("�� ��:");
          result.setBounds(160, 420, 100, 30);
          result.setFont(font25);
          result1 = new JLabel("");
          result1.setBounds(230, 420, 100, 30);
          result1.setFont(font25);
        
          add(Panel1);
          add(Panel2);
          add(com);
          add(com1);
          add(result);
          add(result1);
          
          setSize(500,550);
          setVisible(true);
          
          addWindowListener(new WindowAdapter() 
          {
        	  public void windowClosing(WindowEvent e) 
        	  {
		   		setVisible(false);
		   		dispose();
		   	  }
		  });
          
//          setDefaultCloseOperation(EXIT_ON_CLOSE);
        
          rock.addActionListener(new ActionListener() 
  		  {
        	  public void actionPerformed(ActionEvent e) 
        	  {
        		  if(e.getSource() == rock)
        		  {
        			System.out.println("����[1]");
        			playerinput = 1;
        			
        			int computer =(int)(Math.random()*3)+1;
        			
        			if(computer == 3)
        			{
        				System.out.println("�÷��̾�¸�!");
        				System.out.println("��ǻ��:����");
        				com1.setText("����");
        				result1.setText("�¸�");
        				win++;
        				cnt++;
        			}
        			else if(computer == 2)
        			{
        				System.out.println("��ǻ�ͽ¸�!");
        				System.out.println("��ǻ��:��");
        				com1.setText("��");
        				result1.setText("�й�");
        				lose++;
        				cnt++;
        			}
        			else
        			{
        				System.out.println("���º�!");
        				System.out.println("��ǻ��:�ָ�");
        				com1.setText("�ָ�");
        				result1.setText("���º�");
        				draw++;
        				cnt++;
        			}
    			}				
    		}
      	 });
        
        paper.addActionListener(new ActionListener() 
  		{
        	public void actionPerformed(ActionEvent e) 
    		{
    				if(e.getSource() == paper)
        			{
    					System.out.println("��[2]");
        				playerinput = 2;
            			
            			int computer =(int)(Math.random()*3)+1;
            			
            			if(computer == 1)
            			{
            				System.out.println("�÷��̾�¸�!");
            				System.out.println("��ǻ��:�ָ�");
            				com1.setText("�ָ�");
            				result1.setText("�¸�");
            				win++;
            				cnt++;
            			}
            			else if(computer == 3)
            			{
            				System.out.println("��ǻ�ͽ¸�!");
            				System.out.println("��ǻ��:����");
            				com1.setText("����");
            				result1.setText("�й�");
            				lose++;
            				cnt++;
            			}
            			else
            			{
            				System.out.println("���º�!");
            				System.out.println("��ǻ��:��");
            				com1.setText("��");
            				result1.setText("���º�");
            				draw++;
            				cnt++;
            			}
        			}								
    		}
      	});
        
        scissors.addActionListener(new ActionListener() 
  		{
        	public void actionPerformed(ActionEvent e) 
    		{
    			if(e.getSource() == scissors)
    	    	{
    				System.out.println("����[3]");
    				playerinput = 3;
    				
    				int computer =(int)(Math.random()*3)+1;
        			
        			if(computer == 2)
        			{
        				System.out.println("�÷��̾�¸�!");
        				System.out.println("��ǻ��:��");
        				com1.setText("��");
        				result1.setText("�¸�");
        				win++;
        				cnt++;
        			}
        			else if(computer == 1)
        			{
        				System.out.println("��ǻ�ͽ¸�!");
        				System.out.println("��ǻ��:�ָ�");
        				com1.setText("�ָ�");
        				result1.setText("�й�");
        				lose++;
        				cnt++;
        			}
        			else
        			{
        				System.out.println("���º�!");
        				System.out.println("��ǻ��:����");
        				com1.setText("����");
        				result1.setText("���º�");
        				draw++;
        				cnt++;
        			}
    	    	}				
    		}
      	});
        
        b2.addActionListener(new ActionListener() 
  		{
        	public void actionPerformed(ActionEvent e) 
    		{
    			if(e.getSource() == b2)
    	    	{
    				final Frame f = new Frame();
    				
    			   	f.setTitle("������");
    			   	
    			   	tot = new JLabel("�� ��",JLabel.CENTER);
    			   	tot.setBounds(180, 100, 150, 50);
    			   	tot.setFont(font25);
    			   	cnt1 = new JLabel("������: "+cnt+"��",JLabel.CENTER);
    			   	cnt1.setBounds(180, 150, 150, 50);
    			   	cnt1.setFont(font20);
    			   	win1 = new JLabel("���ǽ¸�: "+win+"��",JLabel.CENTER);
    			   	win1.setBounds(180, 210, 150, 50);
    			   	win1.setFont(font20);
    			   	lose1 = new JLabel("�����й�: "+lose+"��",JLabel.CENTER);
    			   	lose1.setBounds(180, 270, 150, 50);
    			   	lose1.setFont(font20);
    			   	draw1 = new JLabel("���º�: "+draw+"��",JLabel.CENTER);
    			   	draw1.setBounds(180, 330, 150, 50);
    			   	draw1.setFont(font20);
    			   	
    			   	f.add(tot);
    			   	f.add(cnt1);
    			   	f.add(win1);
    				f.add(lose1);
    				f.add(draw1);
    			   	
    			    f.setLayout(null);
    				
    			   	f.setVisible(true);
    			   	
    			   	f.addWindowListener(new WindowAdapter() {
    			   		public void windowClosing(WindowEvent e) {
    			   			f.setVisible(false);
    			   			f.dispose();
    			   		}
    			   	});
    			   	
    			   	f.setSize(500,500);
    			     	   
    			}
    				System.out.println("������");
    				System.out.println("�� ��: "+win);
    				System.out.println("�� ��: "+lose);
    				System.out.println("���º�: "+draw);
    				
    	    	}
        		
      });
    }
    
           
public static void main( String args[] )
	{   		
    	new RockPaperScissors();
 	}
}



