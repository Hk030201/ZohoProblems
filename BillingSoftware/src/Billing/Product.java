package Billing;
import java.util.*;
public class Product 
{
	 private String pName;
	 private int price;
	 private int quantity;
	 
	 ComboOffer n=new ComboOffer();
	 Product()
	 {
		 
	 }
	 Product(String pName,int price,int quantity)
	 {
		 this.pName=pName;
		 this.price=price;
		 this.quantity=quantity;
	 }
	 public int getProd(ArrayList<Product> items,String product)
	 {
		 for(int i=0;i<items.size();i++)
			 if(items.get(i).pName.equals(product))
				 return items.get(i).quantity;
		 return 0;
	 }
	 
	 public void displayBill(ArrayList<Product> items,HashMap<Integer,Integer> dis,ComboOffer c,Product p)
	 {
		int total=0,s=0,count=0; 
		for(int i=0;i<items.size();i++)
		{
			total+=items.get(i).price*items.get(i).quantity;
			System.out.println("Item "+(i+1)+": "+items.get(i).pName+" Price :"+items.get(i).price+" Quantity :"+items.get(i).quantity);
		}
		int f=n.getCombo(items,c,total,p);
		if(f!=0)
		{
			return;
		}
		else
		{
			for(Map.Entry<Integer,Integer> entry:dis.entrySet())
			{
				if(total>entry.getKey())
				{
					count++;
					s=entry.getValue();
				}
			}
			int pretotal=total;
			total-=(int)(total*(s/100.0));
	    	System.out.println("DISCOUNT D"+(count)+": "+(pretotal-total));
	    		
		}
	    System.out.println("Total bill amount: "+total);
	 }
}
