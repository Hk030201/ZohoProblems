package BillingSystem;
import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
		Users u1=new Users();
		Products p1=new Products();
		Cart c1=new Cart();
		Scanner ob=new Scanner(System.in);
		char ch='y',a_ch='y',c_ch='y';
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
				u1.newUser(name, email, pswd, role);
			}
			if(op==2)
			{
				System.out.println("Enter email,pswd,role :");
				String email=ob.nextLine();
				String pswd=ob.nextLine();
				String role=ob.nextLine();
				int found=u1.authenticate(email,pswd,role);
				if(role.equalsIgnoreCase("admin") && found==1)
				{
					do 
					{
						System.out.println("Welcome admin..!\nEnter 1)Add User 2)Add Product 3)Delete Product 4)View Products 5)Search Product 6)Edit Product 7)Add credit");
						int adm=ob.nextInt();
						ob.nextLine();
						switch(adm)
						{
							case 1:
								System.out.println("Enter name,email,pswd,role(In given order):");
								String name1=ob.nextLine();
								String email1=ob.nextLine();
								String pswd1=ob.nextLine();
								String role1=ob.nextLine();
								u1.newUser(name1, email1, pswd1, role1);
								break;
							case 2:
								System.out.println("Enter pId,pName,qty,price(In given order):");
								int pId=ob.nextInt();
								ob.nextLine();
								String pName =ob.nextLine();
								int qty=ob.nextInt();
								float price=ob.nextFloat();
								p1.addProduct(pId, pName, qty, price);
								break;
							case 3:
								System.out.println("Enter Product Id to delete:");
								int id=ob.nextInt();
								ob.nextLine();
								p1.deleteProduct(id);
								break;
							case 4:
								p1.viewProducts();
								break;
							case 5:
								System.out.println("Enter pName to search :");
								String i=ob.nextLine();
								p1.searchProduct(i);
								break;
							case 6:
								System.out.println("Enter pId,pName,qty,price(In given order):");
								int pId1=ob.nextInt();
								ob.nextLine();
								String pName1 =ob.nextLine();
								int qty1=ob.nextInt();
								float price1=ob.nextFloat();
								p1.updateProduct(pId1,pName1,qty1,price1);
								break;
							case 7:
								System.out.println("Enter name of the user :");
								String hk=ob.nextLine();
								System.out.println("Enter credit value :");
								int val=ob.nextInt();
								u1.addCredit(hk,val);
								ob.nextLine();
								break;
							default:
								System.out.println("Invalid Choice");
						}
						System.out.println("Continue with admin?(y/n)");
						a_ch=ob.next().charAt(0);
					}while(a_ch=='y');
				}
				else if(role.equalsIgnoreCase("customer") && found==1)
				{
					do 
					{
						System.out.println("Welcome user..!\nEnter 1)View Product 2)Add Product to Cart 3)Edit quantity in Cart 4)Delete product in cart 5)Proceed to payment");
						int cus=ob.nextInt();
						ob.nextLine();
						switch(cus)
						{
							case 1:
								p1.viewProducts();
								break;
							case 2:
								System.out.println("Enter product details to add :");
								int chId=ob.nextInt();
								int q=ob.nextInt();
								c1.addToCart(p1,chId,q);
								break;
							case 3:
								System.out.println("Enter product details to add :");
								int eId=ob.nextInt();
								int eq=ob.nextInt();
								c1.editProductQty(eId,eq);
								break;
							case 4:
								System.out.println("Enter product to delete from cart :");
								int dId=ob.nextInt();
								c1.deleteInCart(dId);
								break;
							case 5:
								System.out.println("Enter name :");
								String n=ob.nextLine();
								c1.payBill(n,u1);
								break;
							default:
								System.out.println("Invalid Choice");
						}
						System.out.println("Continue with same user?(y/n)");
						c_ch=ob.next().charAt(0);
					}while(c_ch=='y');
				}
				else
					System.out.println("User Not Found...!Please register");
			}
			System.out.println("Do you want to continue:(y/n)");
			ch=ob.next().charAt(0);
			ob.nextLine();
		}while(ch=='y');
		ob.close();
	}
}
