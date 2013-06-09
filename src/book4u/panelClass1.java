package book4u;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class panelClass1 extends JPanel {


    JPanel editor;

	panelClass1 (){

	        //editor.setBorder(BorderFactory.createLineBorder(Color.black));

	        JPanel img = new JPanel();
	        img.setPreferredSize(new Dimension(30,40));
	        img.setBounds(100,100,200,200);
	        img.setBorder(BorderFactory.createLineBorder(Color.black));
                setLayout(null);
	        add(img);
	}
	
}
