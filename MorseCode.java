//The "Morse Code" class
//October 1, 2018
//Programmed by Joshua Fernandes

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MorseCode extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	public static long time, time2;
	public static String[] lettersInMorse = {"01","1000","1010","100","0","0010","110","0000","00","0111","101","0100","11","10","111","0110","1101","010","000","1",
	                                        "001","0001","011","1001","1011","1100","01111","00111","00011","00001","00000","10000","11000","11100","11110","11111"};
	public static String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2",
	                                 "3","4","5","6","7","8","9","0"};
	public static String currentText, input;

	public MorseCode()
	{
		super("Morse Code");
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLocation(1200, 200);
		this.addKeyListener(this);
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 500);
		g.setColor (Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString(currentText, 40, 100);
		g.drawString(input, 40, 400);
	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyChar() == 'k')
		{
			time = System.currentTimeMillis();
		}
		else if (e.getKeyChar() == 'n')
		{
			currentText += convert (input);
			input = "";
			repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			currentText += " ";
			repaint();
		}
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyChar() == 'k')
		{
			time2 = System.currentTimeMillis();

			if (time2 - time < 200L && time2 - time > 0L)
			{
				input += "0";
			}
			else
			{
				input += "1";
			}

			time = 0L;
			time2 = 0L;
			repaint();
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public static void main(String[] args)
	{
		time = 0L;
		time2 = 0L;
		currentText = "";
		input = "";
		new MorseCode();
	}

	public static String convert (String input)
	{
		int position = -1;

		for (int i = 0; i < lettersInMorse.length; i++)
		{
			if (input.equals(lettersInMorse[i]))
			{
				position = i;
			}
		}
		if (position == -1)
		{
			return "";
		}
		else
		{
			return letters [position];
		}
	}
}
