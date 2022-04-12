package library;
public class User 
{
	private String name;
	private String email;
	private String pswd;
	private String role;
	private float fine;
	private int credit;
	
	User()
	{
		this.credit=1500;
	}
	
	User(String name,String email,String pswd,String role)
	{
		this();
		this.name=name;
		this.email=email;
		this.pswd=pswd;
		this.role=role;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPswd()
	{
		return this.pswd;
	}
	
	public String getRole()
	{
		return this.role;
	}
	public Float getFine()
	{
		return this.fine;
	}
	
	public int getCredit()
	{
		return this.credit;
	}
	
	public void setCredit(int val)
	{
		this.credit+=val;
	}
	public void setFine(float val)
	{
		this.fine+=val;
	}
}

