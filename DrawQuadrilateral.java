import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which draws the Quadrilateral shape
 * 
 */
public class DrawQuadrilateral extends JPanel {
	/**
	 * Creates the Quadrilateral shape 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {

		Polygon quad=new Polygon();
		quad.addPoint(countClick.get(0), countClick.get(1));
		quad.addPoint(countClick.get(2), countClick.get(3));
		quad.addPoint(countClick.get(4), countClick.get(5));
		quad.addPoint(countClick.get(6), countClick.get(7));
		listShape.add(new Figures(quad, null));
		
		DrawObjectEditor.Quadrilateral.setBackground(null);
		DrawObjectEditor.Quadrilateral.setForeground(null);
		DrawObjectEditor.Quadrilateral.setEnabled(true);
	}
	
	/**
	 * Sets the setEnabled feature of all the Shapes and the Select function
	 */
	public static void setFeatures () {

		DrawObjectEditor.Line.setEnabled(true);
		DrawObjectEditor.Circle.setEnabled(true);
		DrawObjectEditor.Triangle.setEnabled(true);
		DrawObjectEditor.Quadrilateral.setEnabled(false);
		
		DrawObjectEditor.Select.setEnabled(true);
	}
}
