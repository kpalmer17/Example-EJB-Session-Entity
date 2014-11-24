package examples.cse769.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "MessageTable")
public class BarEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BARID")
	private int barid;

	public int getBarid() {
		return barid;
	}
	public void setBarid(int barid) {
		this.barid = barid;
	}

	@Column(name="NAME")
	private String name;
	public String getUserName() {return name;}

	public void setName(String Names) 
	{
		this.name = Names;
	}
	
	@Column(name="TYPE")
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="PRICE")
	private int price;

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Column(name="ADDRESS")
	private String address;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Column(name="OPEN")
	private String open;

	public String getOpen() {
		return open;
	}
	public void setOpen (String open) {
		this.open = open;
	}
	
	@Column(name="CLOSE")
	private String close;

	public String getClose() {
		return close;
	}
	public void setClose (String close) {
		this.close = close;
	}
	
}
