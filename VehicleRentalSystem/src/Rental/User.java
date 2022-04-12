package Rental;
public class User 
{
	private String name;
	private String email;
	private String pswd;
	private String role;
	private int credit;
	
	User()
	{
		this.credit=30000;
		this.role="User";
	}
	
	User(String name,String email,String pswd,String role)
	{
		this();
		this.name=name;
		this.email=email;
		this.pswd=pswd;
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
	
	public int getCredit()
	{
		return this.credit;
	}
	
	public void setCredit(int val)
	{
		this.credit+=val;
	}
}

