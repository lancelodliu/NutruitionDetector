package img_handler;
import java.io.File;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.*;

public class ImageLoader {
	static final double MAX_WIDTH = 1000;
	static final double MAX_HEIGHT = 1000;
	static {
		System.loadLibrary("opencv_java249"); 
	}
	/**
	 * @param fn
	 * @return B G R sequence of image
	 */
	public static Mat open(String fn) {
		if (new File(fn).exists() == false) {
			System.out.printf("File %s not exists!\n", fn);
			return null;
		}
		Mat src = Highgui.imread(fn);
		
		if (src.empty()) {
			System.out.printf("File %s is broken!\n", fn);
			return null;
		}
		
		
		return src;
	}
		
	public static void main(String args[]) {
		Mat img = open("test_image/IMG_4314.JPG");

	}
}