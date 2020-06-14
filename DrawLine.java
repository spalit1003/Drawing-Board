import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which draws the Line shape
 */
public class DrawLine extends JPanel {
	/**
	 * Creates the Line shape 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {
		
		listShape.add(new Figures(new Line2D.Double(countClick.get(0),countClick.get(1),countClick.get(2),countClick.get(3)), null));
		
		DrawObjectEditor.Line.setBackground(null);
		DrawObjectEditor.Line.setForeground(null);
		DrawObjectEditor.Line.setEnabled(true);
	}
	
	/**
	 * Sets the setEnabled feature of all the Shapes and the Select function
	 */
	public static void setFeatures () {

		DrawObjectEditor.Line.setEnabled(false);
		DrawObjectEditor.Circle.setEnabled(true);
		DrawObjectEditor.Triangle.setEnabled(true);
		DrawObjectEditor.Quadrilateral.setEnabled(true);
		
		DrawObjectEditor.Select.setEnabled(true);
	}
}
