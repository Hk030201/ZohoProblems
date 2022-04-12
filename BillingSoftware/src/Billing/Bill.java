package Billing;
import java.util.*;
public class Bill
{
	public ArrayList<Product> bill=new ArrayList<Product>();
	public HashMap<Integer,Integer> dis=new HashMap<Integer,Integer>();
	
	Product p=new Product();
	
    public void addToBill(String name,int val,int num,Inventory i)
    {
    	if(i.items.containsKey(name))
    	{
    		if(i.items.get(name)>=num)
    			bill.add(new Product(name,val,num));
    		else
    			System.out.println("ERROR: Only "+i.items.get(name)+" of "+name+" items are available.");	
    	}
    	else
    		System.out.println(name+" is not available!!");
    }
    
    public void addDis(int total,int per)
    {
    	dis.put(total,per);
    }
    
    public void printBill(ComboOffer c)
    {
    	p.displayBill(bill,dis,c,p);
    }
}