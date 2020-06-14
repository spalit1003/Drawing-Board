import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which draws the Circle shape
 */
public class DrawCircle extends JPanel {
	/**
	 * Creates the Circle shape 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {
		
		double r=Math.pow((Math.pow(countClick.get(2)-countClick.get(0),2)+Math.pow(countClick.get(3)-countClick.get(1),2)),0.5);
		listShape.add(new Figures(new Ellipse2D.Double(countClick.get(0)-r,countClick.get(1)-r, 2*r, 2*r), null));
		
		DrawObjectEditor.Circle.setBackground(null);
		DrawObjectEditor.Circle.setForeground(null);
		DrawObjectEditor.Circle.setEnabled(true);
	}
	
	/**
	 * Sets the setEnabled feature of all the Shapes and the Select function
	 */
	public static void setFeatures () {

		DrawObjectEditor.Line.setEnabled(true);
		DrawObjectEditor.Circle.setEnabled(false);
		DrawObjectEditor.Triangle.setEnabled(true);
		DrawObjectEditor.Quadrilateral.setEnabled(true);
		
		DrawObjectEditor.Select.setEnabled(true);
	}
}
