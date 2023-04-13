package Newproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MetrotrainTB {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetrotrainTB window = new MetrotrainTB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MetrotrainTB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro Train Ticket Booking");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 11, 275, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(34, 59, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("From Station");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(34, 96, 125, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" To Station");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(34, 134, 101, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No of Tickets");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(34, 175, 125, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		t1 = new JTextField();
		t1.setBounds(187, 58, 139, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JComboBox c1 = 
				new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Delhi", "Kerala", "Karnataka", "vizag"}));
		c1.setBounds(187, 95, 138, 22);
		frame.getContentPane().add(c1);
		
		JComboBox c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"Select", "ooty", "Goa", "mumbai"}));
		c2.setBounds(187, 133, 139, 22);
		frame.getContentPane().add(c2);
		
		JComboBox c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		c3.setBounds(187, 174, 139, 22);
		frame.getContentPane().add(c3);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
                String from= (String) c1.getSelectedItem();
                String to=(String) c2.getSelectedItem();
                String t=(String) c3.getSelectedItem();
                int tickets=Integer.parseInt(t);
               int bill=0;
               if(from.equals("Delhi") && to.equals("ooty")) {
            	   bill=tickets*1500;
            	   
               }
               else if(from.equals("Kerala") && to.equals("ooty")) {
            	   bill=tickets*1200;
               }
               else if(from.equals("Karnataka") && to.equals("mumbai")) {
            	   bill=tickets*1300;
            	   
               }
               else
               {
            	   JOptionPane.showMessageDialog(btnNewButton,"Please select proper stations");
               }
               try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/metro","root","mrec");
				String q="insert into ticketbill values" + "('"+name+"','"+from+"','"+to+"','"+tickets+"','"+bill+"')";
				Statement sta=con.createStatement();
				sta.execute(q);
				con.close();
				JOptionPane.showMessageDialog(btnNewButton,"Hello "+name+" \n from:"+from+"\nTo:"+to+" \nTicktets:"+tickets+" \nBill:+bill+");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               
         
			}
		});
		btnNewButton.setBounds(111, 215, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
