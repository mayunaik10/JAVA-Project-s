import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class cruise extends JFrame implements ActionListener
{
	JLabel user,pass,shipno,shipname,ticketp,select;
	JTextField t1,t2,t3,t4,t5;
	JComboBox jcb;
	JButton b1,b2;
	Container cnt;
	cruise()
	{
		user= new JLabel("Username");
		pass = new JLabel("Password");
		shipno= new JLabel("Ship No");
		shipname = new JLabel("Ship Name:");
                ticketp= new JLabel("Ticket Price");
		select= new JLabel("Select Destination:");
		jcb = new JComboBox();
		jcb.addItem("Maldives");
		jcb.addItem("Bali");
		jcb.addItem("Goa");
		jcb.addItem("Andman");
		jcb.addItem("Kerala");
		t1=new JTextField(10);
		t2=new JPasswordField(10);
		t3=new JTextField(5);
		t4=new JTextField(10);
		t5=new JTextField(6);
		b1=new JButton("Insert");
		b2=new JButton("Delete");
		cnt=getContentPane();
		cnt.setLayout(new FlowLayout());
		cnt.setBackground(Color.yellow);
		cnt.add(user); 
		cnt.add(t1);
		cnt.add(pass); 
		cnt.add(t2); 
		cnt.add(shipno);
		cnt.add(t3);
		cnt.add(shipname);
		cnt.add(t4);
		cnt.add(select);
		cnt.add(jcb);
		cnt.add(ticketp);
		cnt.add(t5);
		cnt.add(b1);
		cnt.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
	Connection con;
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}
	catch(Exception e1)
	{ }
	try
	{
		con=DriverManager.getConnection("jdbc:odbc:TestDSN");
		PreparedStatement ps=con.prepareStatement("insert into cruise values(?,?,?,?,?)");
		Statement st=con.createStatement();
		String Username=t1.getText();
		String Password=t2.getText();
		int ShipNo=Integer.parseInt(t3.getText());
		String ShipName=t4.getText();
		int TicketPrice=Integer.parseInt(t5.getText());
		ps.setString(1,Username);
		ps.setString(2,Password);
		ps.setInt(3,ShipNo);
		ps.setString(4,ShipName);
		ps.setInt(5,TicketPrice);
		ps.executeUpdate();
		System.out.println("Booking Is successfull");
	}
	catch(SQLException e2)
	{ }
	}
if(e.getSource()==b2)
{
	Connection con;
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}
	catch(Exception e1)
	{ }
	try
	{
		con=DriverManager.getConnection("jdbc:odbc:TestDSN");
		PreparedStatement ps=con.prepareStatement("Delete from cruise where Username=(?)");
		Statement st=con.createStatement();
		String Username=t1.getText();
		ps.setString(1,Username);
		ps.executeUpdate();
		System.out.println("Record Deleted");
	}
	catch(SQLException e2)
	{ }
	}
}
public static void main(String args[])
{
	cruise c=new cruise();
	c.setSize(500,500);
	c.setVisible(true);
}
}     

 

