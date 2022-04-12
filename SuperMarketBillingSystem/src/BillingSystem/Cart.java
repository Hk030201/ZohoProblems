package BillingSystem;
import java.util.*;
public class Cart 
{
	ArrayList<Product> cart=new ArrayList<>();
	ArrayList<Bill> bills=new ArrayList<>();
	
	Bill b1=new Bill();
	
	public void addToCart(Products p1,int pId,int qty)
	{
		int f=0;
		for(int i=0;i<p1.items.size();i++)
		{
			if(pId==p1.items.get(i).getId() && qty<=p1.items.get(i).getQty())
			{
				cart.add(new Product(p1.items.get(i).getId(),p1.items.get(i).getName(),qty,p1.items.get(i).getPrice()));
				p1.items.get(i).setQty(p1.items.get(i).getQty()-qty);
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Product Not Found");	
	}
	
	public void deleteInCart(int pId)
	{
		int f=0;
		for(int i=0;i<cart.size();i++)
		{
			if(pId==cart.get(i).getId())
			{
				f=1;
				cart.remove(cart.get(i));
				break;
			}
		}
		if(f==0)
			System.out.println("Product not found in cart");	
	}
	public void editProductQty(int pId,int qty)
	{
		int f=0;
		for(int i=0;i<cart.size();i++)
		{
			if(pId==cart.get(i).getId())
			{
				f=1;
				cart.get(i).setQty(qty);
				break;
			}
		}
		if(f==0)
			System.out.println("Product not found in cart");
	}
	
	public void payBill(String name,Users u1)
	{
		float rs=b1.calTotal(cart);
		for(int i=0;i<u1.users.size();i++)
		{
			if(u1.users.get(i).getName().equals(name))
			{
				if(u1.users.get(i).getCredit()>=rs)
				{
					bills.add(new Bill(name,rs));
					if(rs>5000)
						u1.users.get(i).setCredit(u1.users.get(i).getCredit()+100);
					else
					{
						int val=(int)rs/100;
						val+=u1.users.get(i).getScore();
						if(val>=50)
							u1.users.get(i).setCredit(u1.users.get(i).getCredit()+100);
					}
				}
				else
				{
					System.out.println("Insufficient credit..!!Add more credit.");
				}
			}
		}
	}
	
	public void viewBills()
	{
		for(int i=0;i<bills.size();i++)
			System.out.println(bills.get(i).getName()+" "+bills.get(i).getTotal());
	}
}
