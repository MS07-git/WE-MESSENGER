package mybeans;

public class users 
{
  String email;
  String pass;
  String user;
  String gender;
  public String getPp() {
	return Pp;
}
public void setPp(String pp) {
	Pp = pp;
}
String Pp;

public users() {
	super();
}
public users(String email, String pass, String user, String gender,String Pp) {
	super();
	this.email = email;
	this.pass = pass;
	this.user = user;
	this.gender = gender;
	this.Pp=Pp;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
}
