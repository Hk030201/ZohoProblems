package library;

public class Book 
{
	private int bId;
	private String bName;
	private String genre;
	private int qty;
	private float price;
	
	Book(int bId,String bName,String genre,int qty,float price)
	{
		this.bId=bId;
		this.bName=bName;
		this.genre=genre;
		this.qty=qty;
		this.price=price;
	}
	Book(int bId,String bName,String genre)
	{
		this.bId=bId;
		this.bName=bName;
		this.genre=genre;
	}
	public int getBid()
	{
		return this.bId;
	}
	
	public void setBname(String bName)
	{
		this.bName=bName;
	}
	
	public String getBname()
	{
		return this.bName;
	}
	
	public void setGenre(String genre)
	{
		this.genre=genre;
	}
	public String getGenre()
	{
		return this.genre;
	}
	
	public void setQty(int qty)
	{
		this.qty=qty;
	}
	public int getQty()
	{
		return this.qty;
	}
	
	public void setPrice(float price)
	{
		this.price=price;
	}
	public float getPrice()
	{
		return this.price;
	}
}
