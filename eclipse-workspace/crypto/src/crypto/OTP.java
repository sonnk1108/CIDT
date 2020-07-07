package crypto;

public class OTP {
		public static void main(String []args) {
    String bangchu = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String diem1="IEY";
    String diem4="HREUAG";
    String diem3="EYUTIOAN";
    for(int i=0;i<diem1.length();i++) {
    	for(int j=0 ;j <diem3.length();j++) {
    		for(int k=0;k < diem4.length();k++) {
    			System.out.print("K "+diem1.charAt(i)+"");
    			System.out.print(" "+diem3.charAt(j)+"");
    			System.out.print(" "+diem4.charAt(k)+"  U");
    			System.out.print("\n");
    		}
    	}
    	
    
    }
		}	
	
	
}
