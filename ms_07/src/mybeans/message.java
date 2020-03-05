package mybeans;
public class message 
{
 int id;
 String sender;
 String receiver;
 String msg;
 String date;
public message() 
{
	super();
}
public message(int id, String sender, String receiver, String msg, String date) {
	super();
	this.id = id;
	this.sender = sender;
	this.receiver = receiver;
	this.msg = msg;
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getReceiver() {
	return receiver;
}
public void setReceiver(String receiver) {
	this.receiver = receiver;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
}
