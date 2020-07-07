package crypto;

public class player {
	int num=0;
	public void guess() {
		 num = (int)(Math.random()*10);
		 System.out.print("Toi du doan so : "+num);
	}
}
