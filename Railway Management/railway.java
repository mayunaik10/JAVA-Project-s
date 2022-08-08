import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class railway extends JFrame implements ActionListener
{
	JLabel heading ,l1,l2,l3,l4,l5,l6,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t9;
	JComboBox jcb;
	JButton b1,b2,b3;
	Container cnt;
	railway()
	{
		heading = new JLabel("**********Railway Reservation Counter**********");
		l1 = new JLabel("Train No");
		l2 = new JLabel("From");
		l3 = new JLabel("To");
		l4 = new JLabel("Total Member");
		l5 = new JLabel("First Member Name");
		l6 = new JLabel("Second Member Name");
		l9 = new JLabel("Rent");
		l10=new JLabel("Reservation Quota");
		l11=new JLabel("");
		l12=new JLabel("");
		jcb = new JComboBox();
		jcb.addItem("General");
		jcb.addItem("Tatkal");
		jcb.addItem("Premium Tatkal");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t6 = new JTextField(20);
		t9 = new JTextField(20);
		b1 = new JButton("Submit");
		b2 = new JButton("Show details");
		b3 = new JButton("Delete Record");
		cnt=getContentPane();
		cnt.setLayout(new FlowLayout());
		cnt.setBackground(Color.orange);
		cnt.add(heading);
		cnt.add(l1);
		cnt.add(t1);
		cnt.add(l2);
		cnt.add(t2);
		cnt.add(l3);
		cnt.add(t3);
		cnt.add(l10);
		cnt.add(jcb);
		cnt.add(l4);
		cnt.add(t4);
		cnt.add(l5);
		cnt.add(t5);
		cnt.add(l6);
		cnt.add(t6);
		cnt.add(l9);
		cnt.add(t9);
		cnt.add(b1);
		cnt.add(b2);
		cnt.add(b3);
		cnt.add(l11);
		cnt.add(l12);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
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
		con=DriverManager.getConnection("jdbc:odbc:TestDsn");
		PreparedStatement ps=con.prepareStatement("insert into railway values(?,?,?,?,?,?,?)");
				Statement st=con.createStatement();
				int TrainNo=Integer.parseInt(t1.getText());
				String From=t2.getText();
				String To=t3.getText();
				int TotalMember=Integer.parseInt(t4.getText());
				String FirstMemberName=t5.getText();
				String SecondMemberName=t6.getText();
				int Rent=Integer.parseInt(t9.getText());
				ps.setInt(1,TrainNo);
				ps.setString(2,From);
				ps.setString(3,To);
				ps.setInt(4,TotalMember);
				ps.setString(5,FirstMemberName);
				ps.setString(6,SecondMemberName);
				ps.setInt(7,Rent);
				ps.executeUpdate();
				l11.setText("Record inserted successfully");
				System.out.println("Record inserted successfully");
		}	
		catch(SQLException e2)
		{ }
}
if(e.getSource()==b2)
{	
	try{
	Connection con;
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con=DriverManager.getConnection("jdbc:odbc:TestDsn");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("Select * from railway");
	while(rs.next())
	{
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getInt(7));
	}
	con.close();
	}
	catch(Exception e3)
	{
 	System.out.println(e3.getMessage());
 	}
}

if(e.getSource()==b3)
{
    Connection con;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    }
    catch(Exception e4)
    { }
    try
    {
        con=DriverManager.getConnection("jdbc:odbc:TestDsn");
        PreparedStatement ps=con.prepareStatement("delete from railway where TrainNo=(?)");
        Statement st=con.createStatement();
        int TrainNo=Integer.parseInt( t1.getText());
	ps.setInt(1,TrainNo);
        ps.executeUpdate();
	l12.setText("Record Deleted");
        System.out.println("Record Deleted");
    }
    catch(SQLException e4)
    {System.out.println(e4.getMessage()); 
    }
    
}
}		
	public static void main(String args[])
	{
		railway r=new railway();
		r.setSize(250,550);
		r.setVisible(true);
	}
}

		
