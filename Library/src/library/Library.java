package library;
import java.util.*;

class sortByBname implements Comparator<Book>
{
	public int compare(Book a,Book b)
	{
		return a.getBname().compareTo(b.getBname());
	}
}
public class Library 
{
	ArrayList<User> users=new ArrayList<>();
	ArrayList<Book> books=new ArrayList<>();
	HashMap<String,Book> issuedBook=new HashMap<>();
	
	public void addUser(String name,String email,String pswd,String role)
	{
		users.add(new User(name,email,pswd,role));
		System.out.println("User added");
	}
	public int checkUser(String email,String pswd,String role)
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
	public void addBook(int bId,String bName,String genre,int qty,float price)
	{
		books.add(new Book(bId,bName,genre,qty,price));
		System.out.println("Book added");
	}
	public void updateBook(int bId,String bName,String genre,int qty,float price)
	{
		int f=0;
		for(int i=0;i<books.size();i++)
		{
			if(bId==books.get(i).getBid())
			{
				books.get(i).setBname(bName);
				books.get(i).setGenre(genre);
				books.get(i).setQty(qty);
				books.get(i).setPrice(price);
				System.out.println("Book Updated");
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Book Not Found");	
	}
	public void deleteBook(int bId)
	{
		Book item=null;
		for(int i=0;i<books.size();i++)
			if(books.get(i).getBid()==bId)
				item=books.get(i);
		if(item!=null)
		{
			books.remove(item);
			System.out.println("Book deleted");
		}
		else
			System.out.println("Book unavailable");
	}
	public void searchBook(String bName)
	{
		int f=0;
		for(int i=0;i<books.size();i++)
		{
			if(books.get(i).getBname().equals(bName))
			{
				System.out.println(books.get(i).getBid()+" "+books.get(i).getBname()+" "+books.get(i).getGenre()+" "+books.get(i).getQty()+" "+books.get(i).getPrice());
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Book unavailable");
	}
	public void viewBooks()
	{
		Collections.sort(books,new sortByBname());
		for(int i=0;i<books.size();i++)
		{
			System.out.println(books.get(i).getBid()+" "+books.get(i).getBname()+" "+books.get(i).getGenre()+" "+books.get(i).getQty());
		}
	}
	public void manageFine(String val)
	{
		User user=null;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(val))
				user=users.get(i);
		}
		if(user!=null)
		{
			
		}
		else
			System.out.println("user Not Found");
	}
	public void issueBook(int bId,String name)
	{
		int f=0,g=0;
		User user=null;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(name))
				user=users.get(i);
		}
		if(user!=null)
		{
			for(int i=0;i<books.size();i++)
			{
				if(bId==books.get(i).getBid() && books.get(i).getQty()>0)
				{
					if(user.getCredit()>=500)
					{
						issuedBook.put(user.getName(),new Book(bId,books.get(i).getBname(),books.get(i).getGenre()));
						books.get(i).setQty(books.get(i).getQty()-1);
						f=1;
						break;
					}
					else
					{
						g=1;
						System.out.println("Insufficient Credit..!Add more credit");
					}
				}
			}
			if(f==0 && g==0)
				System.out.println("Book Not Found or Not Available");	
		}
		else
			System.out.println("UserName Not Found");
	}
	public void returnBook(int bId,String name)
	{
		if(issuedBook.containsKey(name))
		{
			issuedBook.remove(name);
			System.out.println("Book returned");
		}
		for(int i=0;i<books.size();i++)
		{
			if(books.get(i).getBid()==bId)
			{
				books.get(i).setQty(books.get(i).getQty()+1);
				break;
			}
		}
	}
	public void manageBookLoss(String val,int bId)
	{
		User user=null;
		Book book=null;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(val))
			{
				user=users.get(i);
				break;
			}
		}
		for(int i=0;i<books.size();i++)
		{
			if(books.get(i).getBid()==bId)
			{
				book=books.get(i);
				break;
			}
		}
		if(user!=null && book!=null)
		{
			float p=book.getPrice()*(0.5f);
			user.setFine(user.getFine()+p);
		}
		else
			System.out.println("User/Book Not Found");
	}
	public void manageCardLoss(String val)
	{
		User user=null;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(val))
			{
				user=users.get(i);
				break;
			}
		}
		if(user!=null)
		{
			user.setFine(user.getFine()+10);
		}
		else
			System.out.println("User Not Found");
	}
	public void viewFine(String name)
	{
		User user=null;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(name))
				user=users.get(i);
		}
		if(user!=null)
		{
			System.out.println("Fine amount to be paid :"+user.getFine());
		}
		else
			System.out.println("User Not Found");
	}
	public void checkBooks()
	{
		for(int i=0;i<books.size();i++)
			if(books.get(i).getQty()<=0)
				System.out.println(books.get(i).getBid()+" "+books.get(i).getBname()+" "+books.get(i).getGenre());
	}
	public void viewIssuedBooks(String name)
	{
		for(Map.Entry<String,Book> na:issuedBook.entrySet())
		{
			if(na.getKey().equals(name))
			{
				Book b=na.getValue();
				System.out.println(b.getBid()+" "+b.getBname()+" "+b.getGenre());
			}
		}
	}
}
