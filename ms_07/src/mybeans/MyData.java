package mybeans;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.io.*;

public class MyData 
{
 String msg;
 public String getMessage()
 {
	 return msg="hi";
 }
 public Connection getConnection()
 {
	 Connection cn=null;
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 cn=DriverManager.getConnection("jdbc:mysql://localhost/FB1?user=root&password=");
		 msg="success";
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 return cn;
 }
 
 public void SaveUser(users u)
 {
	 Connection cn=null;
	 try
	 {
		 cn=getConnection();
		 String query="insert into users(email,pass,user,gender,pp) values(?,?,?,?,?)";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,u.getEmail());
		 st.setString(2,u.getPass());
		 st.setString(3,u.getUser());
		 st.setString(4,u.getGender());
		 st.setString(5,u.getPp());
		 st.executeUpdate();
		 msg="success";
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	finally
	{
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }
 
 public String check(String email,String uname)
 {
	 Connection cn=null;
	 String msg1="";
	
	 try
	 {
		 cn=getConnection();
		 String query="select * from users where email=?";
		 String query1="select * from users where user=?";
		 PreparedStatement st=cn.prepareStatement(query);
		 PreparedStatement st1=cn.prepareStatement(query1);
		 st.setString(1,email);
		 st1.setString(1,uname);
		 ResultSet rs=st.executeQuery();
		 ResultSet rs1=st1.executeQuery();
		 if(rs.next())
		 msg1="Email already exists.  ";
		 if(rs1.next())
		 msg1=msg1+"Username already exists.";
		
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	finally
	{
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 return msg1;
 }

 
 public String checkf(String sender,String receiver)
 {
	 Connection cn=null;
	 String msg1="";
	
	 try
	 {
		 cn=getConnection();
		 String query="select * from friends where ((sender=? and receiver=?) or (sender=? and receiver=?)) and status='1'";
		 String query1="select * from friends where ((sender=? and receiver=?) or (sender=? and receiver=?)) and status='0'";
		 String query2="select * from users where email=?";
		 PreparedStatement st=cn.prepareStatement(query);
		 PreparedStatement st1=cn.prepareStatement(query1);
		 PreparedStatement st2=cn.prepareStatement(query2);
		 st.setString(1,sender);
		 st.setString(2,receiver);
		 st.setString(4,sender);
		 st.setString(3,receiver);
		 st1.setString(1,sender);
		 st1.setString(2,receiver);
		 st1.setString(3,receiver);
		 st1.setString(4,sender);
		 st2.setString(1,receiver);
		 ResultSet rs=st.executeQuery();
		 ResultSet rs1=st1.executeQuery();
		 ResultSet rs2=st2.executeQuery();
		 if(rs.next())
		 msg1="Already Friends.";
		 if(rs1.next())
		 msg1=msg1+"Already Sent";
		 if(!rs2.next())
		 msg1=msg1+"Not a valid user";
		
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	finally
	{
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 return msg1;
 }
 
 
 
 
 
 public void SaveUser1(user u)
 {
	 Connection cn=null;
	 try
	 {
		 cn=getConnection();
		 String query="insert into User(email,pass,user,gender,pp) values(?,?,?,?,?)";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,u.getEmail());
		 st.setString(2,u.getPass());
		 st.setString(3,u.getUser());
		 st.setString(4,u.getGender());
		 st.setString(5,u.getPp());
		 st.executeUpdate();
		 msg="success";
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	finally
	{
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }
 
 public void updatePp(String pp,String email)
 {
	 Connection cn=null;
	 try
	 {
			cn=getConnection();
			String query="update users set pp=? where email=?";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1,pp);
			st.setString(2,email);
			st.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 msg="Error:-"+e.getMessage();
		 }
		 finally
		 {
			 try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
 }
 
  public boolean isVaild(users u)
 {
	 Connection cn=null;
	 try
	 {
		 cn=getConnection();
		 String query="select * from users where email=? and pass=?";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,u.getEmail());
		 st.setString(2,u.getPass());
		 ResultSet rs=st.executeQuery();
		 if(rs.next())
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return false;
 }
 
 
 public void sendRequest(friends f)
 {
	 Connection cn=null;
	 try
	 {
		cn=getConnection();
		String query="insert into friends (sender,receiver,status,dor) values(?,?,?,?)";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,f.getSender());
		st.setString(2,f.getReceiver());
		st.setInt(3,f.getStatus());
		st.setString(4,f.getDor());
		st.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
 }
 
 
 public ArrayList<friends> getPending(String email)
 {
	 Connection cn=null;
	 ArrayList<friends> al=new ArrayList<>();
	 try
	 {
		 cn=getConnection();
		 String query="select * from friends where receiver=? and status='0'";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,email);
		 ResultSet rs=st.executeQuery();
		 while(rs.next())
		 {
			 friends f=new friends(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			 al.add(f);
		 }
		
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return al;
 }
 
 
 public void Accept(int id)
 {
	 Connection cn=null;
	 try
	 {
		cn=getConnection();
		String query="update friends set status='1' where id=?";
		PreparedStatement st=cn.prepareStatement(query);
		st.setInt(1,id);
		st.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
 }
 
 public void Unfriend(String id,String id1)
 {
	 Connection cn=null;
	 try
	 {
		cn=getConnection();
		String query="delete from friends  where (sender=? and receiver=?) or (sender=? and receiver=?) ";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,id);
		st.setString(2,id1);
		st.setString(3,id1);
		st.setString(4,id);
		st.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
 }
 
 
 public void Reject(int id)
 {
	 Connection cn=null;
	 try
	 {
		cn=getConnection();
		String query="delete from friends  where receiver=? or sender=?";
		PreparedStatement st=cn.prepareStatement(query);
		st.setInt(1,id);
		st.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
 }

 public ArrayList<friends> getFriends(String email)
 {
	 Connection cn=null;
	 ArrayList<friends> al=new ArrayList<>();
	 try
	 {
		 cn=getConnection();
		 String query="select * from friends where (receiver=? or sender=?) and status='1'";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,email);
		 st.setString(2,email);
		 ResultSet rs=st.executeQuery();
		 while(rs.next())
		 {
			 friends f=new friends(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			 al.add(f);
		 }
		
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return al;
 }
 
 
 public ArrayList<String> getFemails(String email)
 {
	 Connection cn=null;
	 ArrayList<String> al=new ArrayList<>();
	 try
	 {
		 cn=getConnection();
		 String query="select sender from friends where receiver=?  and status='1' union select receiver from friends where sender=?  and status='1'";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,email);
		 st.setString(2,email);
		 ResultSet rs=st.executeQuery();
		 while(rs.next())
		 {
			 al.add(rs.getString(1));
		 }
		
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return al;
 }
 
 
 public int Followers(String email)
 {
	 Connection cn=null;
	 int a=0;
	 try
	 {
		 cn=getConnection();
		 String query="select * from friends where (sender=? or receiver=? ) and status='1'";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,email);
		 st.setString(2,email);
		 ResultSet rs=st.executeQuery();
		 while(rs.next())
		 {
			 a++;
		 }
		
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return a;
 }
 public users getUser(String email)
 {
	 Connection cn=null;
	 users x=null;
	 try
	 {
		 
		 cn=getConnection();
		 String query="select * from users where email=?";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,email);
		 ResultSet rs=st.executeQuery();
		 if(rs.next())
		 {
			 x=new users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		 }
		
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return x;
 }
 
  public void saveWpost(wpost w)
 {
	 Connection cn=null;
	 try
	 {
		cn=getConnection();
		String query="insert into wallpost(email,msg) values(?,?)";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,w.getEmail());
		st.setString(2,w.getMsg());
		st.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 
 
 public ArrayList<wpost> getPosts(String email)
 {
	 Connection cn=null;
	 ArrayList<String> al=new ArrayList<>();
	 al=getFemails(email);
	 al.add(email);
	 ArrayList<wpost> ans=new ArrayList<>();
	 
	 try
	 {
		cn=getConnection();
		String query="select * from wallpost order by id desc";
		PreparedStatement st=cn.prepareStatement(query);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			wpost w=new wpost(rs.getInt(1),rs.getString(2),rs.getString(3));
			if(al.contains(w.getEmail()))
			{
				ans.add(w);
			}
		}
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	return ans; 
 }
 
 
 
 public void sendMessage(message m)
 {
	 Connection cn=null;
	 try
	 {
		cn=getConnection();
		String query="insert into message(sender,receiver,msg,date) values(?,?,?,?)";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,m.getSender());
		st.setString(2,m.getReceiver());		
		st.setString(3,m.getMsg());
		st.setString(4,m.getDate());
		st.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 
 public ArrayList<message> getText(String s,String r)
 {
	 Connection cn=null;
	 ArrayList<message> ml=new ArrayList<>();
	 try
	 {
		 cn=getConnection();
		 String query="select * from message where (receiver=? and sender=?)or(receiver=? and sender=?) order by id asc";
		 PreparedStatement st=cn.prepareStatement(query);
		 st.setString(1,s);
		 st.setString(2,r);
		 st.setString(3,r);
		 st.setString(4,s);
		 ResultSet rs=st.executeQuery();
		 while(rs.next())
		 {
			 message f=new message(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			 ml.add(f);
		 }
		
		 
	 }
	 catch(Exception e)
	 {
		 msg="Error:-"+e.getMessage();
	 }
	 finally
	 {
		 try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return ml;
 }
 
 
 
public MyData() {
	super();
}
 
 
}
