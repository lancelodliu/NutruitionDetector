package img_handler;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.*;
import org.opencv.core.CvType;

/**
 * @author Lancelod Liu
 *
 */
public class ImageProc {
	
	/**
	 * @param src original {@link BufferedImage} object
	 * @param ratio the ratio output image will be scaled to
	 * @return scaled {@link BufferedImage} object
	 */
	public static Mat scale(Mat src, double ratio) {
		if (Math.abs(ratio-1.0) < 0.01)
			return src;
		
		int width = (int) (src.width() * ratio);
		int height = (int) (src.height() * ratio);
		Mat dst = new Mat(new Size(width, height), src.type());
		Imgproc.resize(src, dst, new Size(width, height));
		
		return dst;
	}
	
	public static Mat grayscale(Mat src) {
		Mat dst = Mat.zeros(src.size(), CvType.CV_8U);
		
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		
		return dst;
	}
	
	public static Mat binarize(Mat src) {
		Mat dst = Mat.zeros(src.size(), CvType.CV_8U);
		
		Imgproc.threshold(src, dst, 0, 255, Imgproc.THRESH_OTSU);
		
		return dst;
	}
	
//	public static BufferedImage balance(BufferedImage src) {
//		
//		return out;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat img = ImageLoader.open("test_image/IMG_4315.JPG");
		// scale test
		Mat simg = scale(img, 0.5);
		Highgui.imwrite("1scaled.jpg", simg);
		// grayscale test
		Mat gimg = grayscale(simg);
		Highgui.imwrite("2grayscaled.jpg", gimg);	
		// binary test
		Mat bimg = binarize(gimg);
		Highgui.imwrite("3binarized.jpg", bimg);	
	}

}
