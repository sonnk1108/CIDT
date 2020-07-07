package crypto;

public class randomgame {
 player p1;
 player p2;
 player p3;
 	public void startgame() {
 		p1=new player();
 		p2=new player();
 		p3=new player();
 		int guess1=0;
 		int guess2=0;
 		int guess3=0;
 		boolean p1isright=false;
 		boolean p2isright=false;
 		boolean p3isright=false;
 		int tagernumber=(int)(Math.random()*10);
 		while(true) {
 			System.out.println("Target number is : "+tagernumber);
 			p1.guess();
 			p2.guess();
 			p3.guess();
 			guess1=p1.num;
 			System.out.println("number 1: "+guess1);
 			guess2=p2.num;
 			System.out.println("number 2: "+guess2);
 			guess3=p3.num;
 			System.out.println("number 3: "+guess3);
 			if(guess1==tagernumber) {
 				p1isright=true;
 			}
 			if(guess2==tagernumber) {
 				p2isright=true;
 			}
 			if(guess3==tagernumber) {
 				p3isright=true;
 			}
 			if(p1isright || p2isright|| p3isright) {
 				System.out.println("we have a winner");
 				System.out.println("player 1 : "+p1isright);
 				System.out.println("player 2 : "+p2isright);
 				System.out.println("player 3 : "+p3isright);
 				break;
 			} else {
 				System.out.println("try again");
 			}
 			
 		}
 	}


}
