package crypto;

import java.util.Scanner;

public class ceasar {
	
	public static void main(String [] args) {
		
		Scanner input=new Scanner(System.in);

		System.out.print("1.Ma Hoa 2. Giai Ma");
		int in=Integer.parseInt(input.nextLine());
		switch(in) {
		  case 1:
				System.out.println("Nhap khoa K :");
				
				int k=Integer.parseInt(input.nextLine());
				
				System.out.println("Nhap chuoi ma hoa    :");
				
				String ma2= input.nextLine();
				
				String ma=ma2.toUpperCase();
				new ceasar().mahoa(k, ma);

		    break;
		  case 2:
		    String ma3="L QE GEIWE";
		    for(int i=0;i<=25;i++) {
		    int k2=i;
		    new ceasar().De(k2, ma3);
		    System.out.print("  ");

		    System.out.print(" K:= "+k2);
		    System.out.print("  ");
		    System.out.print("\n");
		    }
		    break;
		 
		}
	}
	public void mahoa(int k, String c) {
		String EncryptMessage = "";
		for(int i=0; i < c.length();i++)  

        {
            char banma = c.charAt(i);
            if(banma >= 'a' && banma <= 'z')
            {
                banma = (char) (banma + k);
            
                if(banma < 'a') {
                    banma = (char) (banma+'a'-'z'-1);
                }
                EncryptMessage = EncryptMessage + banma;
            }    
            else if(banma >= 'A' && banma <= 'Z')
            {
                banma = (char) (banma + k);
                
                if (banma < 'A') {
                    banma = (char) (banma+'A'-'Z'-1);
                }
                EncryptMessage = EncryptMessage + banma;            
            }
            else 
            {
             EncryptMessage = EncryptMessage + banma;            
            } 
        }
	 System.out.print(""+EncryptMessage);	
	}

	public void De(int k, String c) {
		String decryptMessage = "";
		for(int i=0; i < c.length();i++)  

        {
            char banma = c.charAt(i);
            if(banma >= 'a' && banma <= 'z')
            {
                banma = (char) (banma - k);
            
                if(banma < 'a') {
                    //reshift to starting position 
                    banma = (char) (banma-'a'+'z'+1);
                }
                decryptMessage = decryptMessage + banma;
            }    
            else if(banma >= 'A' && banma <= 'Z')
            {
                banma = (char) (banma - k);
                
                if (banma < 'A') {
                    banma = (char) (banma-'A'+'Z'+1);
                }
                decryptMessage = decryptMessage + banma;            
            }
            else 
            {
             decryptMessage = decryptMessage + banma;            
            } 
        }
	 System.out.print(""+decryptMessage);	
	}
}
