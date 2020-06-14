import java.awt.Color;
import java.awt.Shape;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class containing details of Shape 
 */
public class Figures extends JPanel {

	Shape shape;
	Color color;
	boolean isSelect;

	/**
	 * Parameterized Constructor
	 */
	public Figures(Shape shape, Color color) {
		this.shape=shape;
		this.color=color;
	}
}