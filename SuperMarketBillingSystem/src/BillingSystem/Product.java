package BillingSystem;

public class Product
{
	private int pId;
	private String pName;
	private int qty;
	private float price;
	
	Product()
	{
		
	}
	
	Product(int pId,String pName,int qty,float price)
	{
		this.pId=pId;
		this.pName=pName;
		this.qty=qty;
		this.price=price;
	}
	
	public int getId()
	{
		return this.pId;
	}
	
	public String getName()
	{
		return this.pName;
	}
	
	public int getQty()
	{
		return this.qty;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	
	public void setName(String pName)
	{
		this.pName=pName;
	}
	
	public void setQty(int qty)
	{
		this.qty=qty;
	}
	
	public void setPrice(float price)
	{
		this.price=price;
	}
}
