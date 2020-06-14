import java.awt.Color;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which handles the Select Function
 */
public class FunctionSelect extends JPanel {
	/**
	 * Sets the setEnabled and setForeground feature of all the Function buttons
	 */
	public static void setFeatures () {

		DrawObjectEditor.Select.setBackground(Color.GRAY);
		DrawObjectEditor.Select.setForeground(Color.WHITE);
		DrawObjectEditor.Select.setEnabled(false);
		
		DrawObjectEditor.Move.setEnabled(true);
		DrawObjectEditor.Move.setForeground(null);
		
		DrawObjectEditor.Delete.setEnabled(true);
		DrawObjectEditor.Delete.setForeground(null);
		
		DrawObjectEditor.Copy.setEnabled(true);
		DrawObjectEditor.Copy.setForeground(null);
		
		DrawObjectEditor.Random.setEnabled(true);
		DrawObjectEditor.Random.setForeground(null);
	}
	
}
