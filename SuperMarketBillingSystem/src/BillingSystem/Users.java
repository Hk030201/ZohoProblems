package BillingSystem;
import java.util.*;
public class Users 
{
	public ArrayList<User> users=new ArrayList<User>();
	
	Users()
	{
		
	}
	
	public void newUser(String name,String email,String pswd,String role)
	{
		users.add(new User(name,email,pswd,role));
		System.out.println("User added");
	}
	
	public int authenticate(String email,String pswd,String role)
	{
		for(int i=0;i<users.size();i++)
		{
			String mail = users.get(i).getEmail();
			String pwd = users.get(i).getPswd();
			String ro = users.get(i).getRole();
			if(mail.equals(email) && pwd.equals(pswd) && ro.equalsIgnoreCase(role))	
				return 1;
		}
		return 0;
	}
	
	public void addCredit(String name,int val)
	{
		int f=0;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(name))
			{
				users.get(i).setCredit(val);
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("User Not Found");	
	}
}
