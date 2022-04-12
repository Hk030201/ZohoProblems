package BillingSystem;
import java.util.*;
public class Bill
{
	private float total;
	private String name;
	
	Bill()
	{
		
	}
	Bill(String name,float total)
	{
		this.name=name;
		this.total=total;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public float getTotal()
	{
		return this.total;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public float calTotal(ArrayList<Product> cartItems)
	{
		float total=0;
		for(int i=0;i<cartItems.size();i++)
			total+=cartItems.get(i).getPrice();
		return total;
	}
}
