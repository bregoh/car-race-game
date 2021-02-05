package Menu_System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;

public class ReportView extends JFrame
{

public ReportView(String fileName)
{
this(fileName,null);
}

public ReportView(String fileName,HashMap parameter)
{
super("TURBO RACING");

try
{   
   Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
JasperPrint print = JasperFillManager.fillReport(fileName, parameter, con);
JRViewer viewer=new JRViewer(print);

Container c=getContentPane();
c.add(viewer);
}
catch(ClassNotFoundException cnfe)
{
cnfe.printStackTrace();
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
catch(JRException jre)
{
jre.printStackTrace();
}

setBounds(10,10,600,500);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);


}
public static void main(String args[])
{

HashMap param=new HashMap();

ReportView viewer=new ReportView("./reports/report2.jasper",param);
viewer.setVisible(true);
}
}
