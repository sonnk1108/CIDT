package Other;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class testQR {
	public BufferedImage main(String pathFile) throws IOException {
		  int scaledWidth = 70;
		BufferedImage inputImage = ImageIO.read(new File(pathFile));
		int scaledHeight = 70;
		BufferedImage outputImage = new BufferedImage(scaledWidth,
		            scaledHeight, inputImage.getType());

		    // scales the input image to the output image
		    Graphics2D g2d = outputImage.createGraphics();
		    g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		    g2d.dispose();

		    String outputImagePath ="D:\\resize.jpg";
			// extracts extension of output file
		    String formatName = outputImagePath.substring(outputImagePath
		            .lastIndexOf(".") + 1);

		    // writes to output file
		    ImageIO.write(outputImage, formatName, new File(outputImagePath));
			return outputImage;
		}
	
}
