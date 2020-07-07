package Other;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
public class TestQRcoe {
	 private static int QRCODE_IMAGE_HEIGHT = 300;
	private static int QRCODE_IMAGE_WIDTH = 300;
	static String IMAGE_PATH = "D://";
			public static void main(String[]args) throws WriterException, IOException {
				TestQRcoe X = new TestQRcoe();
				X.QRCode();
			}
		public void QRCode() throws WriterException, IOException {
			QRCodeWriter qrWriter = new QRCodeWriter();
			//Tạo HashMap
			Map hints = new HashMap();
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			//Tạo QRCode
			BitMatrix matrix = qrWriter.encode("PTIT No.1",
			                         BarcodeFormat.QR_CODE,
			                         QRCODE_IMAGE_WIDTH,
			                         QRCODE_IMAGE_HEIGHT,hints);
			 
			MatrixToImageConfig config = new MatrixToImageConfig(0xFF40BAD0, MatrixToImageConfig.WHITE);
			BufferedImage	qrImage = MatrixToImageWriter.toBufferedImage(matrix,config);
			
			BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g = (Graphics2D) combined.getGraphics();
	        testQR resize= new testQR();
	        BufferedImage overly = resize.main("MailG\\logo.png");
	        
	        int deltaHeight = qrImage.getHeight() - overly.getHeight();
	       int deltaWidth = qrImage.getWidth() - overly.getWidth();
	        int with= qrImage.getWidth();
	        // Write QR code to new image at position 0/0
	          g.drawImage(qrImage,0,0,null);
	          g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	        	// Write logo into combine image at position (deltaWidth / 2) and
	        // (deltaHeight / 2). 
	       // the same space for the logo to be centered
	        g.drawImage(overly, (int) Math.round(deltaWidth/2), (int) Math.round(deltaHeight/2), null);
	           
	        File imageFile = new File("/media/nguyenkhanhson", "Test5.png");
	        ImageIO.write(combined, "PNG", imageFile);
		
		
}
}
