package Rental;

import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
		RentHouse r1=new RentHouse();
		Scanner ob=new Scanner(System.in);
		char ch='y',a_ch='y',u_ch='y';
		int ad=0,us=0;
		do 
		{
			System.out.println("Enter 1)SignUp 2)LogIn");
			int op=ob.nextInt();
			ob.nextLine();
			if(op==1)
			{
				System.out.println("Enter name,email,pswd,role(In given order - Give role as User):");
				String name=ob.nextLine();
				String email=ob.nextLine();
				String pswd=ob.nextLine();
				String role=ob.nextLine();
				if(!role.equals("User"))
					System.out.println("Incorrect Role");
				else
					r1.addUser(name,email,pswd,role);
			}
			else if(op==2)
			{
				System.out.println("Enter email,pswd,role");
				String email=ob.nextLine();
				String pswd=ob.nextLine();
				String role=ob.nextLine();
				r1.authenticate(email,pswd,role);
				int f=0;
				if(f==1)
				{
					if(role.equalsIgnoreCase("Admin"))
					{
						do
						{
							System.out.println("Enter 1)Add vehicle 2)Update Vehicle 3)Remove vehicle");
							ad=ob.nextInt();
							ob.nextLine();
							switch(ad)
							{
								case 1:
									System.out.println("Enter vehicle number,name,type,rent amount");
									String no=ob.nextLine();
									String name=ob.nextLine();
									String type=ob.nextLine();
									float rent=ob.nextFloat();
									r1.addVehicle(no,name,type,rent);
									break;
								case 2:
									System.out.println("Enter vehicle number,name,type,rent amount");
									String no1=ob.nextLine();
									String name1=ob.nextLine();
									String type1=ob.nextLine();
									float rent1=ob.nextFloat();
									r1.updateVehicle(no1,name1,type1,rent1);
									break;
								case 3:
									System.out.println("Enter vehicle number to delete :");
									String num=ob.nextLine();
									r1.removeVehicle(num);
									break;
								case 4:
									break;
								case 5:
									break;
								case 6:
									break;
								case 7:
									break;
								case 8:
									break;
								default:
									System.out.println("Invalid choice");
							}
							System.out.println("Do you want to continue :(y/n)");
							a_ch=ob.next().charAt(0);
						}while(a_ch=='y');
					}
					else if(role.equalsIgnoreCase("User"))
					{
						do
						{
							System.out.println("Enter ");
							us=ob.nextInt();
							ob.nextLine();
							switch(us)
							{
								case 1:
									break;
								case 2:
									break;
								case 3:
									break;
								case 4:
									break;	
								default:
									System.out.println("Invalid choice");
							}
							System.out.println("Do you want to continue :(y/n)");
							u_ch=ob.next().charAt(0);
						}while(u_ch=='y');
					}
					else
						System.out.println("Invalid choice");
				}
				else
					System.out.println("User Not Available");	
			}
			else
				System.out.println("Invalid choice");
			System.out.println("Do you want to continue:(y/n)");
			ch=ob.next().charAt(0);
			
		}while(ch=='y');
		ob.close();
	}
}
