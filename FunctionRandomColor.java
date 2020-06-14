import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which handles the Random Color Function
 */
public class FunctionRandomColor extends JPanel {
	/**
	 * Randomly color fills the selected Shape and sets the setEnabled feature for all functions 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {

		for (int i=0; i<listShape.size(); i++) 
		{ 
			if (listShape.get(i).isSelect) 
			{
				listShape.get(i).color=new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
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
