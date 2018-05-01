/*File name: LanguagesApp.java
 *
 *Programmer: Derek Townsend
 *ULID: djtown1
 *
 *Date: Apr 11, 2018
 *
 *Class: IT 178
 *Lecture Section: 001
 *Lecture Instructor:Ms. Matsuda
 * 
 */
package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;



/**
 * @author derek
 *
 */
public class LanguagesApp extends JFrame{
	private Container contents;
	private ButtonGroup words;
	private JLabel latin1,english1,language,englishWord;
	private JButton startTest,nextWord,backWord,submit,nextQuesMain,backQuesMain,score;
	private JRadioButton latinWord1,latinWord2,latinWord3,latinWord4;
	private String[][] wordList= {{"Si","If"}, {"Pacem","Peace"}, {"Ad","To"}, {"Nunc","Now"}, {"Hoc","This"}, {"Ira","Anger"}, {"Spontanea","Spontaneous"}, {"Humanus","Human"}, {"Amor","Love"}, {"Incendo","Light"}, {"Lux","Day"}, {"Ferveo","Burn"}, {"Video","See"}, {"Mors","Death"}, {"Aevitas","Lifetime"}, {"Insanus","Insane"}, {"Desidiosus","Lazy"}, {"Carnifex","Deadily"}, {"Dubius","Dangerous"}, { "Bellum","War"}, {"Solus","Alone"}, {"Cinis","Destruction"}};
	private String correctLatin1,correctLatin2,correctEnglish1,correctEnglish2;
	private Random gen=new Random();
	private int row1=gen.nextInt(20),row2=gen.nextInt(19),points;
	private boolean wordIsCorrect=false,firstTime=true;;
	ButtonHandler bh=new ButtonHandler();
	RadioButtonHandler rbh=new RadioButtonHandler();
	JFrame question1Window,question2Window;
	
	public LanguagesApp() {
		super("Latin to English");
		JPanel panel1 = new JPanel(new GridLayout(1,2));
		JPanel panel2 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		
		contents = getContentPane();
		contents.setLayout(new BorderLayout());
		
		language=new JLabel("   Latin                            English");
		panel2.add(language);
		
		correctLatin1=wordList[row1][0];
		correctEnglish1=wordList[row1][1];
		latin1=new JLabel(correctLatin1);
	
		panel1.add(latin1);
			
		english1=new JLabel(correctEnglish1);
		
		panel1.add(english1);

		while(row2==row1) {
			row2=gen.nextInt(19);
		}
		correctLatin2=wordList[row2][0];
		correctEnglish2=wordList[row2][1];
		
		nextWord=new JButton("Next");
		startTest=new JButton("Take Test");
		backWord=new JButton("Back");
		
		nextWord.addActionListener(bh);
		backWord.addActionListener(bh);
		startTest.addActionListener(bh);
		backWord.setEnabled(false);
		
		panel3.add(backWord);
		panel3.add(startTest);
		panel3.add(nextWord);


		contents.add(panel1,BorderLayout.CENTER);
		contents.add(panel2,BorderLayout.NORTH);
		contents.add(panel3,BorderLayout.SOUTH);
		setUp1();
		setSize(400,210);
		setVisible(true);
		
//		gen.nextInt(19);
//		JFrame wordList =window1();
//		.dispose();
	}
	
	private void question1() {
		question1Window =new JFrame("Question 1");
		question1Window.getContentPane();
		
		JPanel panel1 = new JPanel(new GridLayout(2,2));
		JPanel panel2 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		question1Window.setLayout(new BorderLayout());
		
		
		englishWord=new JLabel(correctEnglish1);
		panel2.add(englishWord);
		
		
		
		int num1=gen.nextInt(19),num2=gen.nextInt(19),num3=gen.nextInt(19);
		while(row1==num1||row1==num2||row1==num3||num1==num2||num2==num3||num3==num1) {
			num1=gen.nextInt(19);
			num2=gen.nextInt(19);
			num3=gen.nextInt(19);
		}
		
		latinWord1=new JRadioButton();
		panel1.add(latinWord1);
		latinWord1.addActionListener(rbh);
		
		
		latinWord2=new JRadioButton();
		panel1.add(latinWord2);
		latinWord2.addActionListener(rbh);
		
		latinWord3=new JRadioButton();
		panel1.add(latinWord3);
		latinWord3.addActionListener(rbh);
		
		latinWord4=new JRadioButton();
		panel1.add(latinWord4);
		latinWord4.addActionListener(rbh);
		
		
		words= new ButtonGroup();
		words.add(latinWord1);
		words.add(latinWord2);
		words.add(latinWord3);
		words.add(latinWord4);
		
//		submit,nextQuesMain,backQuesMain
		nextQuesMain=new JButton("Next");
		submit=new JButton("Submit");
		backQuesMain=new JButton("Back");
		backQuesMain.setEnabled(false);
		
		nextQuesMain.addActionListener(bh);
		submit.addActionListener(bh);
		backQuesMain.addActionListener(bh);
		
		panel3.add(backQuesMain);
		panel3.add(submit);
		panel3.add(nextQuesMain);
		
		question1Window.add(panel1,BorderLayout.CENTER);
		question1Window.add(panel2,BorderLayout.NORTH);
		question1Window.add(panel3,BorderLayout.SOUTH);
		
		randomOrder(num1, num2, num3);
		setUp2();
		question1Window.setSize(400,210);
		question1Window.setVisible(true);
		
	}
	private void question2() {
		question2Window =new JFrame("Question 2");
		question2Window.getContentPane();
		
		JPanel panel1 = new JPanel(new GridLayout(2,2));
		JPanel panel2 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		question2Window.setLayout(new BorderLayout());
		
		
		englishWord=new JLabel(correctEnglish2);
		panel2.add(englishWord);
		
		
		
		int num1=gen.nextInt(19),num2=gen.nextInt(19),num3=gen.nextInt(19);
		while(row1==num1||row1==num2||row1==num3||num1==num2||num2==num3||num3==num1) {
			num1=gen.nextInt(19);
			num2=gen.nextInt(19);
			num3=gen.nextInt(19);
		}
		
		latinWord1=new JRadioButton();
		panel1.add(latinWord1);
		latinWord1.addActionListener(rbh);
		
		
		latinWord2=new JRadioButton();
		panel1.add(latinWord2);
		latinWord2.addActionListener(rbh);
		
		latinWord3=new JRadioButton();
		panel1.add(latinWord3);
		latinWord3.addActionListener(rbh);
		
		latinWord4=new JRadioButton();
		panel1.add(latinWord4);
		latinWord4.addActionListener(rbh);
		
		words= new ButtonGroup();
		words.add(latinWord1);
		words.add(latinWord2);
		words.add(latinWord3);
		words.add(latinWord4);
		
//		submit,nextQuesMain,backQuesMain
		score=new JButton("Score");
		nextQuesMain=new JButton("Next");
		submit=new JButton("Submit");
		backQuesMain=new JButton("Back");
		
		score.addActionListener(bh);
		nextQuesMain.addActionListener(bh);
		submit.addActionListener(bh);
		backQuesMain.addActionListener(bh);
		
		panel3.add(backQuesMain);
		panel3.add(submit);
		panel3.add(nextQuesMain);
		panel3.add(score);
		score.setEnabled(false);
		
		question2Window.add(panel1,BorderLayout.CENTER);
		question2Window.add(panel2,BorderLayout.NORTH);
		question2Window.add(panel3,BorderLayout.SOUTH);
		
		randomOrder(num1, num2, num3);
		setUp2();
		question2Window.setSize(400,210);
		question2Window.setVisible(true);
		
	}
	public void randomOrder(int num1,int num2,int num3) {
		int order=gen.nextInt(4);
		if(englishWord.getText()==correctEnglish1) {
			if(order==0) {
				latinWord1.setText(correctLatin1);
				latinWord2.setText(wordList[num1][0]);
				latinWord3.setText(wordList[num2][0]);
				latinWord4.setText(wordList[num3][0]);
			}else if(order==1) {
				latinWord1.setText(wordList[num1][0]);
				latinWord2.setText(correctLatin1);
				latinWord3.setText(wordList[num2][0]);
				latinWord4.setText(wordList[num3][0]);
			}else if(order==2) {
				latinWord1.setText(wordList[num2][0]);
				latinWord2.setText(wordList[num1][0]);
				latinWord3.setText(correctLatin1);
				latinWord4.setText(wordList[num3][0]);
			}else if(order==3) {
				latinWord1.setText(wordList[num3][0]);
				latinWord2.setText(wordList[num1][0]);
				latinWord3.setText(wordList[num2][0]);
				latinWord4.setText(correctLatin1);
			}
		}else {
			if(order==0) {
				latinWord1.setText(correctLatin2);
				latinWord2.setText(wordList[num1][0]);
				latinWord3.setText(wordList[num2][0]);
				latinWord4.setText(wordList[num3][0]);
			}else if(order==1) {
				latinWord1.setText(wordList[num1][0]);
				latinWord2.setText(correctLatin2);
				latinWord3.setText(wordList[num2][0]);
				latinWord4.setText(wordList[num3][0]);
			}else if(order==2) {
				latinWord1.setText(wordList[num2][0]);
				latinWord2.setText(wordList[num1][0]);
				latinWord3.setText(correctLatin2);
				latinWord4.setText(wordList[num3][0]);
			}else if(order==3) {
				latinWord1.setText(wordList[num3][0]);
				latinWord2.setText(wordList[num1][0]);
				latinWord3.setText(wordList[num2][0]);
				latinWord4.setText(correctLatin2);
			}
		}
	}
	private void setUp1() {
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		Font font2 = new Font("SansSerif", Font.BOLD, 16);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		language.setFont(font1);
		
		latin1.setHorizontalAlignment(JLabel.CENTER);
		latin1.setBorder(border);
		latin1.setFont(font2);
		
		english1.setBorder(border);
		english1.setHorizontalAlignment(JLabel.CENTER);
		english1.setFont(font2);
	}
	
	private void setUp2() {
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		Font font2 = new Font("SansSerif", Font.BOLD, 16);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		englishWord.setFont(font1);
		
		latinWord1.setBorder(border);
		latinWord1.setBorderPainted(true);
		latinWord1.setHorizontalAlignment(JRadioButton.CENTER);
		latinWord1.setFont(font2);
		
		latinWord2.setBorder(border);
		latinWord2.setBorderPainted(true);
		latinWord2.setHorizontalAlignment(JRadioButton.CENTER);
		latinWord2.setFont(font2);

		latinWord3.setBorder(border);
		latinWord3.setBorderPainted(true);
		latinWord3.setHorizontalAlignment(JRadioButton.CENTER);
		latinWord3.setFont(font2);
		
		latinWord4.setBorder(border);
		latinWord4.setBorderPainted(true);
		latinWord4.setHorizontalAlignment(JRadioButton.CENTER);
		latinWord4.setFont(font2);
	}
	private class RadioButtonHandler implements ActionListener
	 {
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource()==latinWord1&&latinWord1.getText()==correctLatin1) {
	    		wordIsCorrect=true;
	    	}
	    	if(e.getSource()==latinWord2&&latinWord2.getText()==correctLatin1) {
	    		wordIsCorrect=true;
	    	}
	    	if(e.getSource()==latinWord3&&latinWord3.getText()==correctLatin1) {
	    		wordIsCorrect=true;
	    	}
			if(e.getSource()==latinWord4&&latinWord4.getText()==correctLatin1) {
	    		wordIsCorrect=true;
			}

			if(e.getSource()==latinWord1&&latinWord1.getText()==correctLatin2) {
	    		wordIsCorrect=true;
	    	}
	    	if(e.getSource()==latinWord2&&latinWord2.getText()==correctLatin2) {
	    		wordIsCorrect=true;
	    	}
	    	if(e.getSource()==latinWord3&&latinWord3.getText()==correctLatin2) {
	    		wordIsCorrect=true;
	    	}
			if(e.getSource()==latinWord4&&latinWord4.getText()==correctLatin2) {
	    		wordIsCorrect=true;
			}
	 }
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==startTest) {
			dispose();
			question1();
			}
			if(e.getSource()==backWord) {
				latin1.setText(correctLatin1);					
				english1.setText(correctEnglish1);
				backWord.setEnabled(false);
				nextWord.setEnabled(true);
			}
			if(e.getSource()==nextWord) {
				latin1.setText(correctLatin2);
				english1.setText(correctEnglish2);
				nextWord.setEnabled(false);
				backWord.setEnabled(true);
			}
			if(e.getSource()==submit) {
				if(!firstTime) {
					score.setEnabled(true);
				}
				if(wordIsCorrect) {
					JOptionPane.showMessageDialog(null,"Correct");
					points++;
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect");
				}
				wordIsCorrect=false;
				submit.setEnabled(false);
				firstTime=false;
				
				
			}
			if(e.getSource()==nextQuesMain) {
				question1Window.dispose();
				question2();
				nextQuesMain.setEnabled(false);
			}
			if(e.getSource()==backQuesMain) {
				question2Window.dispose();
				question1();
				
			}
			if(e.getSource()==score) {
				JOptionPane.showMessageDialog(null,"You got "+points+" correct out of 2 questions");
				points=0;
			}
			
	    }
	}
	
	
	
	/**
	* Write a brief description of what the method is doing.
	*
	* @param name description 
	* @return description 
	* @throws classname description
	* 
	*/
	public static void main(String[] args) {
		LanguagesApp app= new LanguagesApp();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
