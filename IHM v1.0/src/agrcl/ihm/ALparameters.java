package agrcl.ihm;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ALparameters {

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public static int screenHeight = screenSize.height;

	public static int screenWidth = screenSize.width;

	public static final int WINDOW_WIDTH = 1240;

	public static final int BASIC = 1;

	public static final int WINDOW_HEIGHT = BASIC*(screenWidth/2);

	public static final int SCALE = BASIC * 40;

	public static final int cropLign = 11;

	public static final int cropCol = 4;
	
	public static final int cowCol = 4;
	
	public static final int cowLign = 7;

	public static final int pigCol = 4;
	
	public static final int pigLign = 7;
	
	public static final int chickenCol = 4;
	
	public static final int chickenLign = 7;
	
	public static final int sheepCol = 4;
	
	public static final int sheepLign = 7;
}
