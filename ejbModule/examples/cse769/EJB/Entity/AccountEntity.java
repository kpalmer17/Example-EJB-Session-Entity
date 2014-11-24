package examples.cse769.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "MessageTable")
public class AccountEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USERID")
	private int userid;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Column(name="USERNAME")
	private String userName;
	public String getUserName() {return userName;}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	@Column(name="PASSWORD")
	private String password;
	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password;}

	
}
