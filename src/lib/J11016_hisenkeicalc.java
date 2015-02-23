package lib;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class J11016_hisenkeicalc extends Applet{
	TextField tf1,tf2;
	boolean start;
	int x1,x2,y1,y2,istep,speed;
	double x, y, z, x0, a;
	AnimeRun ar;

		public void init() {
			setLayout(null);

			Label lb1 = new Label("a=");
			lb1.setBounds(10,10,30,20);

			Label lb2 = new Label("speed=");
			lb2.setBounds(130,10,50,20);

			tf1 = new TextField(3);
			tf1.setBounds(40,10,70,20);
			tf1.addTextListener(new TextInput());

			tf2 = new TextField(3);
			tf2.setBounds(180,10,70,20);
			tf2.addTextListener(new TextInput());

			Button bt=new Button("Start");
			bt.setBounds(100,220,120,20);
			bt.addActionListener(new ButtonClick());
			add(lb1);add(lb2); add(tf1); add(tf2); add(bt);

			start = false;
			ar = new AnimeRun();
			a=3.7; x0=0.1;
			istep=1; y=x0; speed=200;
			x1=10;
			y1=230-(int)(x0*200/1.);
		}
			public void paint(Graphics g) {
				g.setColor(Color.yellow);g.fillRect(10,30,300,200);
				g.setColor(Color.black);g.drawRect(10,30,300,200);
				g.setColor(Color.black);g.drawString(" Xn+1=a*Xn*(1-Xn)",20,50);

				for (int i=1; i<=40; i++){
					x=i*1.;
					z=a*y*(1.-y);
					x2=10+(int)(x*300/40.);
					y2=230-(int)(z*200/1.);
					g.drawLine(x1,y1,x2,y2);
					x1=x2; y1=y2;

					if(i == 40) x1=10;
					y=z;
				}
			}
				class TextInput implements TextListener {
					public void textValueChanged(TextEvent e) {
						a = Double.valueOf(tf1.getText()).doubleValue();
						speed = Integer.parseInt(tf2.getText());
						repaint();
					}
				}
				class ButtonClick implements ActionListener{
					public void actionPerformed(ActionEvent e){
						if(start == false){
							start = true;
							Thread th = new Thread(ar);
							th.start();
						}
					}
				}
				class AnimeRun implements Runnable{
					public void run(){
						while(start){
							istep += 1;
							repaint();
							try{
								Thread.sleep(speed);
							}
							catch(Exception e){
							}
						}
					}
			}
		}