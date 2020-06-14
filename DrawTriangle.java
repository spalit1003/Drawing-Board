import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which draws the Triangle shape
 */
public class DrawTriangle extends JPanel {
	/**
	 * Creates the Triangle shape 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countCLick) {

		Polygon tri=new Polygon();
		tri.addPoint(countCLick.get(0), countCLick.get(1));
		tri.addPoint(countCLick.get(2), countCLick.get(3));
		tri.addPoint(countCLick.get(4), countCLick.get(5)); 
		listShape.add(new Figures(tri, null));

		DrawObjectEditor.Triangle.setBackground(null);
		DrawObjectEditor.Triangle.setForeground(null);
		DrawObjectEditor.Triangle.setEnabled(true);
	}

	/**
	 * Sets the setEnabled feature of all the Shapes and the Select function
	 */
	public static void setFeatures () {

		DrawObjectEditor.Line.setEnabled(true);
		DrawObjectEditor.Circle.setEnabled(true);
		DrawObjectEditor.Triangle.setEnabled(false);
		DrawObjectEditor.Quadrilateral.setEnabled(true);

		DrawObjectEditor.Select.setEnabled(true);
	}
}
