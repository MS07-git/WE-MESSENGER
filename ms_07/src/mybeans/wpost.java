package mybeans;

public class wpost 
{
  public wpost(int id, String email, String msg) {
		super();
		this.id = id;
		this.email = email;
		this.msg = msg;
	}
public wpost() {
		super();
	}
int id;
  String email;
  String msg;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
}
