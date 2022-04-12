package BillingSystem;
import java.util.*;

public class Products 
{
	public ArrayList<Product> items=new ArrayList<Product>();
	
	public void addProduct(int pId,String pName,int qty,float price)
	{
		items.add(new Product(pId,pName,qty,price));
		System.out.println("Product added");
	}
	
	public void viewProducts()
	{
		for(int i=0;i<items.size();i++)
		{
			System.out.println(items.get(i).getId()+" "+items.get(i).getName()+" "+items.get(i).getQty()+" "+items.get(i).getPrice());
		}
	}
	
	public void deleteProduct(int pId)
	{
		Product item=null;
		for(int i=0;i<items.size();i++)
			if(items.get(i).getId()==pId)
				item=items.get(i);
		if(item!=null)
		{
			items.remove(item);
			System.out.println("Product deleted");
		}
		else
			System.out.println("Product unavailable");
	}
	
	public void searchProduct(String pName)
	{
		int f=0;
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i).getName().equals(pName))
			{
				System.out.println(items.get(i).getId()+" "+items.get(i).getName()+" "+items.get(i).getQty()+" "+items.get(i).getPrice());
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Product unavailable");
	}
	
	public void updateProduct(int pId,String pName,int qty,float price)
	{
		int f=0;
		for(int i=0;i<items.size();i++)
		{
			if(pId==items.get(i).getId())
			{
				items.get(i).setName(pName);
				items.get(i).setQty(qty);
				items.get(i).setPrice(price);
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Product Not Found");	
	}
}
