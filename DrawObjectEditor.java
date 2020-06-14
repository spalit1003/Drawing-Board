import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author shreyapalit
 * Drawing Editor from where the program begins, holds all the different buttons and actions
 */
public class DrawObjectEditor {

	static DrawObjectEditor d = new DrawObjectEditor(); // Creating an object for class DrawObjectEditor
	static ArrayList<Figures> listShape=new ArrayList<>(); // An ArrayList containing all the shapes 
	static ArrayList<Integer> countClick=new ArrayList<>(); // An ArrayList containing coordinates of mouse clicks 
	static JFrame frame; // Frame containing the Drawing Editor
	/**
	 * Button variables for the 9 buttons in the Drawing Editor
	 */
	static JButton Line; 
	static JButton Circle; 
	static JButton Triangle; 
	static JButton Quadrilateral; 
	static JButton Select; 
	static JButton Move; 
	static JButton Delete; 
	static JButton Copy; 
	static JButton Random;
	static boolean isSelect = false; // Boolean variable checking whether a Shape is selected or not 
	static colorChoose c = d.new colorChoose(); // Class object of JPanel extension

	/**
	 * Main function from where the program starts by creating the buttons and performing their respective Action Handler
	 */
	public static void main(String[] args) {

		frame= new JFrame("Draw Object Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,450);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		frame.getContentPane().add(BorderLayout.SOUTH, panel);

		Line= new JButton("Line");
		Line.addActionListener(new ActionListener (){  
			public void actionPerformed(ActionEvent e) {  
				DrawLine.setFeatures();
				countClick.clear(); 
			}  
		});  
		panel.add(Line);

		Circle= new JButton("Circle");
		Circle.addActionListener(new ActionListener (){  
			public void actionPerformed(ActionEvent e) {  
				DrawCircle.setFeatures();
				countClick.clear(); 
			}  
		});  
		panel.add(Circle);

		Triangle= new JButton("Triangle");
		Triangle.addActionListener(new ActionListener (){  
			public void actionPerformed(ActionEvent e) {  
				DrawTriangle.setFeatures();
				countClick.clear(); 
			}  
		});  
		panel.add(Triangle);

		Quadrilateral= new JButton("Quadrilateral");
		Quadrilateral.addActionListener(new ActionListener (){  
			public void actionPerformed(ActionEvent e) {  
				DrawQuadrilateral.setFeatures();
				countClick.clear(); 
			}  
		});  
		panel.add(Quadrilateral);

		Select= new JButton("Select");
		Select.addActionListener(new ActionListener (){  
			public void actionPerformed(ActionEvent e) {  
				FunctionSelect.setFeatures();
				countClick.clear(); 
			}  
		});  
		panel.add(Select);

		Move= new JButton("Move");
		Move.addActionListener(new ActionListener (){  
			public void actionPerformed(ActionEvent e) {  
				FunctionMove.setFeatures();
				countClick.clear(); 
				frame.repaint();
			}  
		});  
		panel.add(Move);

		Delete= new JButton("Delete");
		Delete.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(!Select.isEnabled())
				{ 
					FunctionDelete.create(listShape, countClick);
					frame.repaint();
				}
			}
		});
		panel.add(Delete);

		Copy= new JButton("Copy");
		Copy.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(!Select.isEnabled())
				{ 
					FunctionCopy.create(listShape, countClick);
					frame.repaint();
				}
			}
		});
		panel.add(Copy);

		Random= new JButton("Random Color");
		Random.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(!Select.isEnabled())
				{ 
					FunctionRandomColor.create(listShape, countClick);
					isSelect = true;
					frame.repaint();
				}
			}
		});
		panel.add(Random);

		DrawObjectEditor.Move.setEnabled(false);
		DrawObjectEditor.Move.setBackground(Color.GRAY);
		DrawObjectEditor.Move.setForeground(Color.WHITE);
		
		DrawObjectEditor.Delete.setEnabled(false);
		DrawObjectEditor.Delete.setBackground(Color.GRAY);
		DrawObjectEditor.Delete.setForeground(Color.WHITE);
		
		DrawObjectEditor.Copy.setEnabled(false);
		DrawObjectEditor.Copy.setBackground(Color.GRAY);
		DrawObjectEditor.Copy.setForeground(Color.WHITE);
		
		DrawObjectEditor.Random.setEnabled(false);
		DrawObjectEditor.Random.setBackground(Color.GRAY);
		DrawObjectEditor.Random.setForeground(Color.WHITE);

		c.addMouseListener(d.new MouseEvents());
		frame.getContentPane().add(BorderLayout.CENTER, c);
		frame.setVisible(true);	
	}

	/**
	 * @author shreyapalit
	 * Implements MouseListener for the different mouse events
	 */
	public class MouseEvents implements MouseListener {
		/**
		 * Action to be followed when mouse is clicked, by checking the different number of clicks and calling the respective shape classes
		 */
		public void mouseClicked(MouseEvent e) {

			if(!Line.isEnabled()) 
			{
				if (countClick.size() < 2)
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
				}
				else 
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
					DrawLine.create(listShape, countClick);
					frame.repaint();
				}
			}

			if(!Circle.isEnabled()) 
			{
				if (countClick.size() < 2)
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
				}
				else
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
					DrawCircle.create(listShape, countClick);
					frame.repaint();
				}
			}

			if(!Triangle.isEnabled()) 
			{
				if (countClick.size() < 4)
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
				}
				else
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
					DrawTriangle.create(listShape, countClick);
					frame.repaint();
				}
			} 

			if(!Quadrilateral.isEnabled())
			{
				if (countClick.size() < 6) 
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
				}
				else
				{
					countClick.add(e.getX());
					countClick.add(e.getY());
					DrawQuadrilateral.create(listShape, countClick);
					frame.repaint();
				}
			}

			if(!Select.isEnabled())
			{
				countClick.add(e.getX());
				countClick.add(e.getY());
				int c=5;
				for (Figures i : listShape)
				{
					if (i.shape.intersects(e.getX()-c, e.getY()-c, 2*c, 2*c)) 
						i.isSelect=true;
				}
				frame.repaint();
			}
		}
		
		/**
		 * Action to be followed when mouse is pressed
		 */
		public void mousePressed(MouseEvent e) {

			if(!Move.isEnabled() && !Select.isEnabled())
			{
				countClick.add(e.getX());
				countClick.add(e.getY());
			}
		}
		
		/**
		 * Action to be followed when mouse is released
		 */
		public void mouseReleased(MouseEvent e) {

			if(!Move.isEnabled() && !Select.isEnabled()) 
			{
				countClick.add(e.getX());
				countClick.add(e.getY());
				FunctionMove.create(listShape, countClick);
				frame.repaint();
			}
		}

		public void mouseEntered(MouseEvent e) { } // Action to be followed when mouse is entered
		public void mouseExited(MouseEvent e) { } // Action to be followed when mouse is exited

	}

	/**
	 * @author shreyapalit
	 * Deals with the graphics when a shape is selected or not
	 */
	public class colorChoose extends JPanel {
		/**
		 * Sets color to shape when a shape is clicked or not
		 */
		public void paintComponent(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;
			for (Figures i : listShape) 
			{
				if (i.isSelect) 
					g2.setColor(Color.green);
				else 
					g2.setColor(Color.black);

				g2.draw(i.shape);
				if (i.color!=null)
				{
					g2.setPaint(i.color);
					g2.fill(i.shape);
				}

			}
			isSelect=false;
		}
	}
}



