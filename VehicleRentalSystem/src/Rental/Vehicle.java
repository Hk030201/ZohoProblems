package Rental;
public class Vehicle 
{
	private String vNo;
	private String name;
	private String type;
	private float rentAmt;
	private boolean status;
	
	Vehicle()
	{
		this.status=true;
	}
	Vehicle(String vNo,String name,String type,float rentAmt)
	{
		this();
		this.vNo=vNo;
		this.name=name;
		this.type=type;
		this.rentAmt=rentAmt;
	}
	
	public String getVno()
	{
		return this.vNo;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getType()
	{
		return this.type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	public float getRent()
	{
		return this.rentAmt;
	}
	public void setRent(float rentAmt)
	{
		this.rentAmt=rentAmt;
	}
	public boolean getStatus()
	{
		return this.status;
	}
	public void setStatus()
	{
		if(this.status==true)
			this.status=false;
		else
			this.status=true;
	}
}
