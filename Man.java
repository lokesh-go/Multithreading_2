import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;

public class Man extends JFrame implements Runnable, ActionListener 
{
	BufferedImage img[];
	Image img1;
	MediaTracker med;
	Toolkit tk;
	Thread t;
	int j,x=40,y=450;
	MenuBar mbar;
	Menu mn;
	MenuItem m1,m2,m3;
	
	Man()
	{
		
		mbar=new MenuBar();
		setMenuBar(mbar);

		mn=new Menu("Action");
		mbar.add(mn);

		m1=new MenuItem("Walk");
		mn.add(m1);

		m1.addActionListener(this);

		med=new MediaTracker(this);
		tk=tk.getDefaultToolkit();
		img=new BufferedImage[5];
		img1=tk.getImage("g.jpg");
		t=new Thread(this);
		try
		{
			img[0]=ImageIO.read(new File("man1.gif"));
			img[1]=ImageIO.read(new File("man2.gif"));
			img[2]=ImageIO.read(new File("man3.gif"));
			img[3]=ImageIO.read(new File("man4.gif"));
			img[4]=ImageIO.read(new File("man5.gif"));
	//		img[5]=ImageIO.read(new File("man5.gif"));
		}
		catch (Exception e)
		{
		}
		setSize(1368,720);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e3)
	{
			t.start();
	}
	public void run()
	{
		for (; ; )
		{
		
		for(j=0;j<5;j++)
		{

			x+=8;
			try
			{
				t.sleep(320);
			}
			catch (Exception e)
			{
			}
			repaint();
		}
//		if(x==1202)
//			break;
		}
	}

	public void paint(Graphics g)
	{
		System.out.println(x);
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(img1,30,180,this);
		g2.drawImage(img[j],x,y,this);
		
	}
	public static void main(String[] args) 
	{
		new Man();
	}
}
