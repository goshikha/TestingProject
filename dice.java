import java.util.*;
class dice{
	int faces = 0;
	

	public dice(int a){
		this.faces = a;
	}

	public void  result(){
		if(this.faces < 2){
			System.out.println("dice must have atleast two faces");
		}
		else if(this.faces == 2){
			Random rand = new Random();
			int af = rand.nextInt(1) + 1;
			if(af == 1)
				System.out.println("heads");
			else
				System.out.println("tails");
		}
		else{
			Random rand1 = new Random();
			int aff = rand1.nextInt(this.faces - 1);
			System.out.println(aff + 1);
		}

	}
}

public class dicerolling{
	public static void main(String[] args){
		Scanner gen = new Scanner(System.in);
		int x = gen.nextInt();
		dice first = new dice(x);
		first.result();
	}
}
		