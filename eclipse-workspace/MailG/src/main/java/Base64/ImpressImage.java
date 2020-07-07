package Base64;

import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

class ImpressImage {

   public static void main(String[] args) throws IOException {
      File input = new File("example-rgb.jpg");
      BufferedImage image = ImageIO.read(input);
      File compressedImageFile = new File("D:\\compress2.jpg");
      OutputStream os =new FileOutputStream(compressedImageFile);
      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
      ImageWriter writer = (ImageWriter) writers.next();
      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
      writer.setOutput(ios);
      ImageWriteParam param = writer.getDefaultWriteParam();
      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      param.setCompressionQuality(0.5f);
      writer.write(null, new IIOImage(image, null, null), param);
      
      os.close();
      ios.close();
      writer.dispose();
   }
}