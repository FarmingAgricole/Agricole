package agrl.ihm;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ALparameters {
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int screenHeight = screenSize.height;
	
	public static int screenWidth = screenSize.width;
	
	public static final int WINDOW_WIDTH = screenWidth;

	public static final int BASIC = WINDOW_WIDTH / 1000;
	
	public static final int WINDOW_HEIGHT = BASIC* 650;
	
	public static final int SCALE = BASIC * 40;

}
