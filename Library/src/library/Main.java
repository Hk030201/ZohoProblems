package library;
import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
		Library l1=new Library();
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
				System.out.println("Enter name,email,pswd,role(In given order):");
				String name=ob.nextLine();
				String email=ob.nextLine();
				String pswd=ob.nextLine();
				String role=ob.nextLine();
				l1.addUser(name, email, pswd, role);
			}
			else if(op==2)
			{
				System.out.println("Enter email,pswd,role");
				String email=ob.nextLine();
				String pswd=ob.nextLine();
				String role=ob.nextLine();
				int f=l1.checkUser(email,pswd,role);
				if(f==1)
				{
					if(role.equalsIgnoreCase("Admin"))
					{
						do
						{
							System.out.println("Enter 1)Add Book 2)Edit Book 3)Delete Book 4)Add User 5)View Books 6)Search Book 7)Manage fine 8)Reports");
							ad=ob.nextInt();
							ob.nextLine();
							switch(ad)
							{
								case 1:
									System.out.println("Enter book details");
									int bid=ob.nextInt();
									int qty=ob.nextInt();
									float price=ob.nextFloat();
									ob.nextLine();
									String bname=ob.nextLine();
									String genre=ob.nextLine();
									l1.addBook(bid, bname, genre, qty, price);
									break;
								case 2:
									System.out.println("Enter book details to update");
									int bid1=ob.nextInt();
									int qty1=ob.nextInt();
									float price1=ob.nextFloat();
									ob.nextLine();
									String bname1=ob.nextLine();
									String genre1=ob.nextLine();
									l1.updateBook(bid1, bname1, genre1, qty1, price1);
									break;
								case 3:
									System.out.println("Enter BookId to delete :");
									int id=ob.nextInt();
									l1.deleteBook(id);
									break;
								case 4:
									System.out.println("Enter name,email,pswd,role(In given order):");
									String name1=ob.nextLine();
									String email1=ob.nextLine();
									String pswd1=ob.nextLine();
									String role1=ob.nextLine();
									l1.addUser(name1, email1, pswd1, role1);
									break;
								case 5:
									l1.viewBooks();
									break;
								case 6:
									System.out.println("Enter book name :");
									String name=ob.nextLine();
									l1.searchBook(name);
									break;
								case 7:
									System.out.println("Enter userName :");
									String val=ob.nextLine();
									l1.manageFine(val);
									break;
								case 8:
									System.out.println("1)Books with less qty");
									int r=ob.nextInt();
									ob.nextLine();
									switch(r)
									{
										case 1:
											l1.checkBooks();
											break;
										default:
											System.out.println("Invalid Choice");
									}
									break;
								default:
									System.out.println("Invalid choice");
							}
							System.out.println("Do you want to continue :(y/n)");
							a_ch=ob.next().charAt(0);
						}while(a_ch=='y');
					}
					else if(role.equalsIgnoreCase("Customer"))
					{
						do
						{
							System.out.println("Enter 1)View Books 2)Issue Book 3)Return Book 4)Queries ");
							us=ob.nextInt();
							ob.nextLine();
							switch(us)
							{
								case 1:
									l1.viewBooks();
									break;
								case 2:
									System.out.println("Enter BookId to Issue:");
									int id=ob.nextInt();
									ob.nextLine();
									System.out.println("Enter your name :");
									String name=ob.nextLine();
									l1.issueBook(id,name);
									break;
								case 3:
									System.out.println("Enter BookId to return :");
									id=ob.nextInt();
									ob.nextLine();
									System.out.println("Enter your name :");
									name=ob.nextLine();
									l1.returnBook(id,name);
									break;
								case 4:
									System.out.println("Enter 1)Book Loss 2)MemberCard Loss 3)View Fine 4)View IssuedBooks");
									int o=ob.nextInt();
									ob.nextLine();
									System.out.println("Enter userName :");
									String val=ob.nextLine();
									if(o==1)
									{
										System.out.println("Enter BookID :");
										int hk=ob.nextInt();
										l1.manageBookLoss(val,hk);
									}
									else if(o==2)
										l1.manageCardLoss(val);
									else if(o==3)
										l1.viewFine(val);
									else if(o==4)
										l1.viewIssuedBooks(val);	
									else
										System.out.println("Invalid choice");
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
