package mybeans;

public class friends 
{
	int id;
	String sender;
	String receiver;
	int status;
	String dor;
	public friends() {
		super();
	}
	public friends(int id, String sender, String receiver, int status, String dor) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
		this.dor = dor;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	
	}
