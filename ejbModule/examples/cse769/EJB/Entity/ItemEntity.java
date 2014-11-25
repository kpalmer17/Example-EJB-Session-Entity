package examples.cse769.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class ItemEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ITEMID")
	private int itemid;

	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	@Column(name="NAME")
	private String name;
	public String getName() {return name;}

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
	private double price;

	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Column(name="MENUID")
	private int menuid;

	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	
	@Column(name="SPECIALID")
	private int specialid;

	public int getSpecialid() {
		return specialid;
	}
	public void setSpecialid(int specialid) {
		this.specialid = specialid;
	}
	
}
