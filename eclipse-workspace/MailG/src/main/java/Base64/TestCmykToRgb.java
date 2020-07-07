package Base64;

import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;

import javax.imageio.ImageIO;

public class TestCmykToRgb {

    public static void main(String[] args) throws Exception {
        BufferedImage cmykImage = ImageIO.read(new File(
                "D:\\testkaka.jpg"));


        BufferedImage rgbImage = new BufferedImage(cmykImage.getWidth(),
                cmykImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        ColorConvertOp op = new ColorConvertOp(null);
        op.filter(cmykImage, rgbImage);

        ImageIO.write(rgbImage, "JPEG", new File("D:\\example-rgb.jpg"));

    }
}