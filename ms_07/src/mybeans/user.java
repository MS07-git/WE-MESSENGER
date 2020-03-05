package mybeans;

public class user 
{
	String email;
	String pass;
	String user;
	String gender;
	String pp;
	
	public user() {
		super();
	}
	public user(String email, String pass, String user, String gender, String pp) {
		super();
		this.email = email;
		this.pass = pass;
		this.user = user;
		this.gender = gender;
		this.pp = pp;
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
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
}
