import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class bakery extends JFrame implements ActionListener
{
	JLabel heading,l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4;
	JComboBox jcb;
	JButton b1,b2,b3,b4,b5;
	Container cnt;
	bakery()
	{	
heading = new JLabel("********* Bakery Management System *********");
		l1 = new JLabel("Order ID");
		l2 = new JLabel("Name");
		l3 = new JLabel("Quantity");
		l4 = new JLabel("Cake Size:");
                l5 = new JLabel("Order Price");
		l6 = new JLabel("");
		l7 = new JLabel("");
		l8 = new JLabel("");
		jcb = new JComboBox();
		jcb.addItem("Small");
		jcb.addItem("Medium");
		jcb.addItem("Large");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(5);
		t4=new JTextField(15);
		b1=new JButton("Insert");
		b2=new JButton("Delete");
		b3=new JButton("Update");
		b4=new JButton("Show details");
		cnt=getContentPane();
		cnt.setLayout(new FlowLayout());
		cnt.setBackground(Color.orange);
		ImageIcon ic1=new ImageIcon("cake.jpg");
       		b5=new JButton(ic1);
		b5.setPreferredSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cnt.add(heading);
		cnt.add(b5);
		cnt.add(l1); 
		cnt.add(t1);
		cnt.add(l2); 
		cnt.add(t2); 
		cnt.add(l3);
		cnt.add(t3);
		cnt.add(l4);
		cnt.add(jcb);
		cnt.add(l5);
		cnt.add(t4);
		cnt.add(b1);
		cnt.add(b2);
		cnt.add(b3);
		cnt.add(b4);
		cnt.add(l6);
		cnt.add(l7);
		cnt.add(l8);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
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
		con=DriverManager.getConnection("jdbc:odbc:Demo");
		PreparedStatement ps=con.prepareStatement("insert into Bakery values(?,?,?,?)");
		Statement st=con.createStatement();
		int OrderID=Integer.parseInt( t1.getText());
		String Name =t2.getText();
		int Quantity=Integer.parseInt(t3.getText());
		int OrderPrice=Integer.parseInt(t4.getText());
		ps.setInt(1,OrderID);
		ps.setString(2,Name);
		ps.setInt(3,Quantity);
		ps.setInt(4,OrderPrice);
		ps.executeUpdate();
		l6.setText("Record Inserted");
		System.out.println("Record Inserted");
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
        con=DriverManager.getConnection("jdbc:odbc:Demo");
        PreparedStatement ps=con.prepareStatement("delete from Bakery where OrderID=(?)");
        Statement st=con.createStatement();
        int OrderID=Integer.parseInt( t1.getText());
	ps.setInt(1,OrderID);	
        ps.executeUpdate();
        l7.setText("Record Deleted");
	System.out.println("Record Deleted");
    }
    catch(SQLException e2)
    { }
    
}





if(e.getSource()==b3)
{
	Connection con;
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}
	catch(Exception e1)
	{ 
	System.out.println("e1.getMessage()");
	}
	try
	{
	con=DriverManager.getConnection("jdbc:odbc:Demo");
	PreparedStatement ps= con.prepareStatement("update Bakery set Name=? where OrderID=?");
	Statement st=con.createStatement();
	int OrderID=Integer.parseInt( t1.getText());
	String Name =t2.getText();
	ps.setString(1,Name);
	ps.setInt(2,OrderID);
	ps.executeUpdate();
	l8.setText("Record Updated");
	System.out.println("Record Updated");
	}
	catch(SQLException e3)
	{
	System.out.println("e1.getMessage()");
        }
}






if(e.getSource()==b4)
{	
	try{
	Connection con;
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con=DriverManager.getConnection("jdbc:odbc:Demo");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("Select * from Bakery");
	while(rs.next())
	{
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
	}
	con.close();
	}
	catch(Exception e3)
	{
 	System.out.println(e3.getMessage());
 	}
}

}
public static void main(String args[])
{
	bakery b=new bakery();
	b.setSize(300,570);
	b.setVisible(true);
}	
} 

