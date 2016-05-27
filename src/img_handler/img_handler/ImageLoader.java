package img_handler;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	static final double MAX_WIDTH = 1000;
	static final double MAX_HEIGHT = 1000;
	
	public static BufferedImage open(String fn) {
		File f = new File(fn);
		if (!f.exists()) {
			System.out.printf("File %s not exists!\n", fn);
			return null;
		}
		try {
			BufferedImage bi = ImageIO.read(f);
			double wr = MAX_WIDTH / bi.getWidth();
			double hr = MAX_HEIGHT / bi.getHeight();
			if (wr < 1.0 || hr < 1.0) {
				return ImageProc.scale(bi, Math.min(wr, hr));			
			}
			else
				return ImageProc.scale(bi, 1.0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public static void main(String args[]) {
		BufferedImage img = open("test_image/IMG_4314.JPG");

	}
}