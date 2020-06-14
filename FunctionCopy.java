import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which handles the Copy Function
 */
public class FunctionCopy extends JPanel {
	/**
	 * Copies the selected Shape and sets the setEnabled feature for all functions 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {

		for (int i=0; i<listShape.size();i++) 
		{
			if (listShape.get(i).isSelect) 
			{
				AffineTransform at = new AffineTransform();
				at.translate((int)(Math.random() * (50)), (int)(Math.random() * (50)));
				listShape.add(new Figures( at.createTransformedShape(listShape.get(i).shape), listShape.get(i).color));
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
}
