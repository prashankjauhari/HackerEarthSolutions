
public class parent extends grandParnet{

	static{
		System.out.println(" parent");
	}
	public static void main(String args[]){
		parent p=new parent();
	}
	
}

class grandParnet{
	static{
		System.out.println("grand parent");
	}
}
