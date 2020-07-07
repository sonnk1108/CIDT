package thongsothietbi;

import java.util.Timer;


public class Main {
	public static void main(String [] args) {
		thongsothietbi2 perfomentLoad = new thongsothietbi2();
	    Timer timer = new Timer();
	    
	    timer.schedule(perfomentLoad,0,1000);
	}
}
