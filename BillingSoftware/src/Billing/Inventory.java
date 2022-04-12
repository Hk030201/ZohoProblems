package Billing;

import java.util.*;

public class Inventory 
{
	public HashMap<String,Integer> items=new HashMap<String,Integer>();	
	Inventory()
	{
		
	}
	public void addToInv(String name,int num)
	{
	   	items.put(name,num);
	}
	public void viewInventory()
	{
		System.out.println(items);
	}
}
