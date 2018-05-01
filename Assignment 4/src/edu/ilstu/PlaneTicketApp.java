/*File name: PlaneTicketApp.java
 *
 *Programmer: Derek Townsend
 *ULID: djtown1
 *
 *Date: Mar 26, 2018
 *
 *Class: IT 178
 *Lecture Section: 001
 *Lecture Instructor:Ms. Matsuda
 * 
 */
package edu.ilstu;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author derek
 *
 */
public class PlaneTicketApp extends JFrame{
	private ButtonGroup seatGroup;
	private Container contents;
	private JTextField name,date;
	private JLabel nameLabel,airportLabel,dateLabel,destinationLabel,seatLabel;
	private JComboBox<String> airport,destination,econSeat,businSeat;
	private JRadioButton economy,business;
	private JButton checkPrice,submit;	
	private String [] airportList ={ "CHI", "LAX", "YVR"},
        economySeats={"A1","A2","A3","A4","B1","B2","B3","B4"},
        businessSeats={"C1","C2","C3","C4","C5","C6","D1","D2","D3","D4","D5","D6"};
	private double price;
	AirplaneDeals tickets=new AirplaneDeals();
	FlightData flight;
	
	public PlaneTicketApp() {
		super("GoEverywhere Ticket Purchaser");
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
        RadioButtonHandler rbh=new RadioButtonHandler();
        ButtonHandler bh=new ButtonHandler();
        cs.anchor = GridBagConstraints.NORTHWEST;
        cs.insets = new Insets(5,13,13,13);
		contents = getContentPane();
		contents.setLayout(new BorderLayout());
		
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		Font font2 = new Font("SansSerif", Font.BOLD, 16);
		
		nameLabel = new JLabel(" Name");
		nameLabel.setFont(font1);
	        cs.gridx = 1;
	        cs.gridy = 1;
	        cs.gridwidth = 1;
	        panel.add(nameLabel, cs); 
	       
	    name = new JTextField(20);
	    name.setFont(font2);
	        cs.gridx = 1;
	        cs.gridy = 2;
	        cs.gridwidth = 2;
	        panel.add(name, cs);
	 
	    airportLabel = new JLabel(" Airport ");
	    airportLabel.setFont(font1);
	        cs.gridx = 1;
	        cs.gridy = 3;
	        cs.gridwidth = 1;
	        panel.add(airportLabel, cs);
	    
	    airport=new JComboBox<String>(airportList);
	    airport.setFont(font2);
	    	cs.gridx = 1;
	    	cs.gridy = 4;
	    	cs.gridwidth = 1;
	    	panel.add(airport, cs);

	    dateLabel = new JLabel(" Date");
	    dateLabel.setFont(font1);
	        cs.gridx = 1;
	        cs.gridy = 5;
	        cs.gridwidth = 1;
	        panel.add(dateLabel, cs); 
		       
	    date = new JTextField(10);
	    date.setFont(font2);
	        cs.gridx = 1;
	        cs.gridy = 6;
	        cs.gridwidth = 2;
	        panel.add(date, cs);
	    
        destinationLabel = new JLabel(" Destination ");
        destinationLabel.setFont(font1);
	        cs.gridx = 1;
	        cs.gridy = 7;
	        cs.gridwidth = 1;
	        panel.add(destinationLabel, cs);
	    
        destination=new JComboBox<String>(airportList);
        destination.setFont(font2);
	    	cs.gridx = 1;
	    	cs.gridy = 8;
	    	cs.gridwidth = 1;
	    	panel.add(destination, cs);
	    	
    	economy=new JRadioButton("Economy");
    	economy.addActionListener(rbh);
    	economy.setFont(font2);
    	cs.gridx = 1;
    	cs.gridy = 9;
    	cs.gridwidth = 1;
    	panel.add(economy, cs);
    	
    	business=new JRadioButton("Business");
    	business.addActionListener(rbh);
    	business.setFont(font2);
    	cs.gridx = 2;
    	cs.gridy = 9;
    	cs.gridwidth = 1;
    	panel.add(business, cs);	
	    
    	seatGroup= new ButtonGroup( );
    	seatGroup.add(economy);
    	seatGroup.add(business);
    	
    	seatLabel = new JLabel(" Seat ");
    	seatLabel.setFont(font1);
	        cs.gridx = 1;
	        cs.gridy = 10;
	        cs.gridwidth = 1;
	        panel.add(seatLabel, cs);
    	
	     
		econSeat=new JComboBox<String>(economySeats);
		econSeat.setFont(font2);
	    	cs.gridx = 1;
	    	cs.gridy = 11;
	    	cs.gridwidth = 1;
	    	panel.add(econSeat, cs);
	    	econSeat.setVisible(false);
 	
	   
	    businSeat=new JComboBox<String>(businessSeats);
	    businSeat.setFont(font2);
	    	cs.gridx = 1;
	    	cs.gridy = 11;
	    	cs.gridwidth = 1;
	    	panel.add(businSeat, cs);
	    	businSeat.setVisible(false);
	    
	    
	    checkPrice=new JButton("Check Price");
	    checkPrice.setFont(font2);
	    checkPrice.addActionListener(bh);
	    	cs.gridx = 1;
	    	cs.gridy = 12;
    		cs.gridwidth = 1;
    		panel.add(checkPrice, cs);
    	
    		
   		submit=new JButton("Submit");
   		submit.setFont(font2);
   		submit.addActionListener(bh);
   	    	cs.gridx = 1;
   	    	cs.gridy = 13;
       		cs.gridwidth = 1;
       		panel.add(submit,cs);
       		
//	        cs.weightx = 1;
//			cs.weighty = 1;
//			panel.add(new JLabel(" "), cs);
//	    	System.out.println(name.getText());
       	
	    contents.add(panel,BorderLayout.NORTH);
	    setResizable(false);
		setSize(400,800);
		setVisible(true);
	}

	
	
	private class RadioButtonHandler implements ActionListener
	 {
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource()==economy) {
	    		businSeat.setVisible(false);
	    		econSeat.setVisible(true);
	    	}else{
	    		econSeat.setVisible(false);
	    		businSeat.setVisible(true);
	    	}
	    }
	 }
		
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			price=tickets.getTicketPrice(airport.getSelectedItem().toString(), destination.getSelectedItem().toString()); 
	    	if(e.getSource()==checkPrice) {
	    		JOptionPane.showMessageDialog(null,"Price: "+price);
	    	}else{
	    		String seat;
	    		if(businSeat.isVisible()) {
	    			seat=businSeat.getSelectedItem().toString();
	    		}else {
	    			seat=econSeat.getSelectedItem().toString();
	    		}
	    		
	    		flight=tickets.getTicket(airport.getSelectedItem().toString(), destination.getSelectedItem().toString());
	    		
	    		JOptionPane.showMessageDialog(null,"Flight details:\n\n"+name.getText()+"\nFlight Number: "+flight.getFlightNumber()+"\nSeat:   "+seat+"\n\nAirport:  "+flight.getCityOrigin()+" to "+flight.getCityDestination()+"\nDate: "+date.getText()+"Time: "+flight.getFlightTime()+"\n\nPrice: "+price);
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
		PlaneTicketApp app=new PlaneTicketApp();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
