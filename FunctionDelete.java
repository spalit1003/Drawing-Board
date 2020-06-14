import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Class which handles the Delete Function
 */
public class FunctionDelete extends JPanel {
	/**
	 * Deletes the selected Shape and sets the setEnabled feature for all functions 
	 * @param listShape An ArrayList containing all the shapes 
	 * @param countClick An ArrayList containing coordinates of mouse clicks
	 */
	public static void create (ArrayList<Figures> listShape, ArrayList<Integer> countClick) {
		
		boolean checkExit=false;
		while(!checkExit)
		{
			int n=0;
			int size=listShape.size();
			for (int i=0; i<size; i++)
			{
				n=i;
				if (listShape.get(i).isSelect)
				{
					listShape.remove(listShape.get(i));
					break;
				}
			}

			if (n==size-1 || listShape.isEmpty())
			{
				checkExit=true;
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
