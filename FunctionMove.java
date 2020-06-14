import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which handles the Move Function
 */
public class FunctionMove extends JPanel {
	/**
	 * Moves the selected Shape and sets the setEnabled feature for all functions 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {

		for (int i=0; i<listShape.size();i++)
		{
			if (listShape.get(i).isSelect) 
			{
				AffineTransform at = new AffineTransform();
				at.translate(-(countClick.get(0)-countClick.get(2)), -(countClick.get(1)-countClick.get(3)));
				listShape.set(i, new Figures(at.createTransformedShape(listShape.get(i).shape), listShape.get(i).color));
				listShape.get(i).isSelect=false;
			}
		}

		DrawObjectEditor.Select.setBackground(null);
		DrawObjectEditor.Select.setForeground(null);
		DrawObjectEditor.Select.setEnabled(true);
		
		DrawObjectEditor.Move.setEnabled(false);
		DrawObjectEditor.Delete.setEnabled(false);
		DrawObjectEditor.Copy.setEnabled(false);
		DrawObjectEditor.Random.setEnabled(false);
	}
	
	/**
	 * Sets features for the Move function
	 */
	public static void setFeatures () {
		
		DrawObjectEditor.Move.setBackground(Color.GRAY);
		DrawObjectEditor.Move.setForeground(Color.WHITE);
		DrawObjectEditor.Move.setEnabled(false);
	}

}
