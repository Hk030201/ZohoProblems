package Billing;

import java.util.ArrayList;

public class ComboOffer
{
	private String cName;
	private int cVal;
	private String p1,p2;
	private int q1,q2;
	
	public ArrayList<ComboOffer> com=new ArrayList<ComboOffer>();

	ComboOffer()
	{
		
	}
	
	ComboOffer(String cName,int cVal,String p1,int q1,String p2,int q2)
	{
		this.cName=cName;
		this.cVal=cVal;
		this.p1=p1;
		this.p2=p2;
		this.q1=q1;
		this.q2=q2;
	}

	public void addCombo(String cName,int cVal,String p1,int q1,String p2,int q2)
	{
	  	com.add(new ComboOffer(cName,cVal,p1,q1,p2,q2));
	}
	
	public int getCombo(ArrayList<Product> items,ComboOffer c,int total,Product p)
	{
		for(int i=c.com.size()-1;i>=0;i--)
		{
			if(c.com.get(i).q1<= p.getProd(items,c.com.get(i).p1)&& c.com.get(i).q2<= p.getProd(items,c.com.get(i).p2))
			{
				System.out.println("Discount "+c.com.get(i).cName+":"+c.com.get(i).cVal);
				System.out.println("Total bill amount: "+(total-c.com.get(i).cVal));
				return 1;
			}
		}
		return 0;
	}
	public void printCombo()
	{
	  	for(ComboOffer s:com)
	   		System.out.println(s.cName);
	}
}
