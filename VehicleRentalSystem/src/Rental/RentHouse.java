package Rental;
import java.util.ArrayList;

public class RentHouse 
{
	ArrayList<User> users=new ArrayList<>();
	ArrayList<Vehicle> lists=new ArrayList<>();
	
	RentHouse()
	{
		users.add(new User("Hiruthik","a.hiruthik01@gmail.com","Hiru@030201","ADMIN"));
	}
	
	public void addUser(String name,String email,String pswd,String role)
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
	
	public void addVehicle(String vNo,String vName,String type,float rentAmt)
	{
		lists.add(new Vehicle(vNo,vName,type,rentAmt));
		System.out.println("Vehicle added");
	}
	
	public void updateVehicle(String vNo,String vName,String type,float rentAmt)
	{
		int f=0;
		for(int i=0;i<lists.size();i++)
		{
			if(vNo==lists.get(i).getVno())
			{
				lists.get(i).setName(vName);
				lists.get(i).setType(type);
				lists.get(i).setRent(rentAmt);
				System.out.println("Vehicle updated");
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Vehicle not updated");	
	}
	
	public void removeVehicle(String vNo)
	{
		Vehicle v =null;
		for(int i=0;i<lists.size();i++)
			if(lists.get(i).getVno().equals(vNo))
				v=lists.get(i);
		if(v!=null)
		{
			lists.remove(v);
			System.out.println("Vehicle removed");
		}
		else
			System.out.println("Vehicle unavailable");
	}
}
