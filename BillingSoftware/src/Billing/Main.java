package Billing;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Bill b=new Bill();
        Inventory i=new Inventory();
    	ComboOffer c=new ComboOffer();
        Scanner ob=new Scanner(System.in);
        char ch='y';
        int op=0;
        do
        {
            System.out.println("Give command");
            String str=ob.nextLine();
            String prod[]=new String[20];
            String inv[]=new String[20];
            String dis[]=new String[20];
            String com[]=new String[30];
            if(str.matches("ADD [a-zA-Z0-9]+ [0-9]+ [0-9]+"))
            {
                op=1;
                prod=str.split(" ");
            }
            else if(str.matches("ADD_INV [a-zA-Z0-9]+ [0-9]+"))
            {
            	op=2;
            	inv=str.split(" ");
            }
            else if(str.matches("DISCOUNT_VAL [0-9]+ [0-9]+"))
            {
            	op=9;
            	dis=str.split(" ");
            }
            else if(str.matches("DISCOUNT_COMBO [A-Z0-9]+ [0-9]+ [A-Z0-9]+ [0-9]+ [A-Z0-9]+ [0-9]+"))
            {
            	op=8;
            	com=str.split(" ");
            }
            else if(str.matches("PRINT"))
                op=3;
            else if(str.matches("INV"))
            	op=4;
            else    
                op=0;
            switch(op)
            {
                case 1:
                    b.addToBill(prod[1],Integer.parseInt(prod[2]),Integer.parseInt(prod[3]),i);
                    break;
                case 2:
                	i.addToInv(inv[1],Integer.parseInt(inv[2]));
                	break;
                case 3:
                    b.printBill(c);
                    break;
                case 4:
                	i.viewInventory();
                	c.printCombo();
                	break;
                case 9:
                	b.addDis(Integer.parseInt(dis[1]),Integer.parseInt(dis[2]));
                	break;
                case 8:
                	c.addCombo(com[1],Integer.parseInt(com[2]),com[3],Integer.parseInt(com[4]),com[5],Integer.parseInt(com[6]));
                	break;
                	
                default:
                    System.out.println("Invalid Choice");        
            }
            System.out.println("Do you want to continue(y/n)");
            ch=ob.next().charAt(0);
            ob.nextLine();
        }while(ch=='y');
        ob.close();
    }
}