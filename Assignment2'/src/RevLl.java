

public class RevLl {
	static Linked head;
class Linked
{
	int data;
	Linked next;
	
	public Linked(int d)
	{
		next=null;
		data=d;
	}
}
	public void insert(int d)
	{
		Linked nn = new Linked(d);
		
		if(head==null)
		{
		head=nn;
		return;
		}

		Linked last=head;
		while(last.next!=null)
		{
		last=last.next;
		}
		last.next=nn;
		
	}
	
	public static void rev(Linked l)
	{
		if(l.next!=null)
		{
			rev(l.next);
			
		}	
		
		System.out.println(l.data);
	}



	public static void main(String[] args) {
		
		RevLl n1= new RevLl();
		n1.insert(3);
		n1.insert(4);
		n1.insert(5);
		n1.insert(6);
		
		System.out.println("REVERSE:");
		rev(head);
		

	}

}
