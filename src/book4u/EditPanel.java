package book4u;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
//����C��
import javax.swing.colorchooser.ColorSelectionModel;
//wordArt Dialog
public class EditPanel extends JPanel {
	private JRadioButton leftRadio ;
	private JRadioButton centerRadio ;
	private JRadioButton rightRadio ;
	private JCheckBox boldBox;
	private JCheckBox italicBox;
	private JCheckBox underlineBox;
	private JComboBox FontSizeDropDown;
	private String FontSizeNum[] = {"20","22","24","26","28","36","48","52","56","60","64","68","72","76","80","84","88","92","96"};
	private JComboBox typeFaceDropDown;
	private JButton ClipboardBtn,colorSet;
	private String typeFaceNames[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();  //��o�t�Φr��
	public JTextPane testText1;
	private JTextField ClipboardHeight,ClipboardWidth;
	private Color rsltColor = Color.BLACK;
	private static final Color colorRGB = new Color(98, 134, 167);
	int fonts = 20;
	float drawStroke = 1.0f;
	int bold = Font.PLAIN;
	int italic=Font.PLAIN;
	String fontfamily = "Serif";
	//��r���N�v
	private ImageIcon choice = new ImageIcon(getClass().getResource("images/choice.jpg"));
	private ImageIcon imghollowWord = new ImageIcon(getClass().getResource("images/hollowWord.jpg"));
	private ImageIcon ShearFont = new ImageIcon(getClass().getResource("images/ShearFont.png"));
	private ImageIcon D3font = new ImageIcon(getClass().getResource("images/3Dfont.png"));
	private ImageIcon D2shadow = new ImageIcon(getClass().getResource("images/2Dshadow.png"));
	ImageIcon[] images = {choice,imghollowWord,ShearFont,D3font,D2shadow};
	Integer[] imageIndex = new Integer[images.length];
	private JComboBox wordArt;
	private JPanel testTextPanel;


	public void call(centerPanel panel, JTextPane textPane)
	{
                this.testText1 = textPane;
                testText1.setBounds(textPane.getX(), textPane.getY(),textPane.getWidth(), textPane.getWidth());
                testText1.setFont(new Font(fontfamily,Font.PLAIN,fonts));
                panel.add(testText1,0);
	}
	public EditPanel(final mainFrame frame)
	{	
		this.setLayout(new BorderLayout());
		testText1 = new JTextPane();
		
		/*---�s�W�Ҧ��s��\��panel---*/
		JTabbedPane edit = new JTabbedPane();
		JPanel photoFrame = new JPanel();
		JPanel photoEdit = new JPanel();
		JPanel textEdit = new JPanel();
		edit.addTab("�ج[�s��", photoFrame);
		edit.addTab("�Ϥ�s��", photoEdit);
		edit.addTab("��r�s��", textEdit);
		
		/*---text�s��\��---*/
		JPanel textPanel = new JPanel();
		//�r����D
		JLabel typeFace = new JLabel("<html><u>1. �r�� :</u></html>");
		typeFace.setFont(new Font("�L�n������", Font.BOLD, 20));
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
	    c0.gridy = 0;
	    c0.gridwidth= 3;
        c0.anchor = GridBagConstraints.WEST;
		//�r��
		typeFaceDropDown = new JComboBox(typeFaceNames);
		typeFaceDropDown.setMaximumRowCount(4);
		typeFaceDropDown.setSelectedIndex(4);
		typeFaceDropDown.setPreferredSize(new Dimension(170,25));
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
	    c1.gridy = 1;
	    c1.gridwidth= 2;
	    c1.anchor = GridBagConstraints.WEST;
		//�j�p
		FontSizeDropDown = new JComboBox(FontSizeNum);
		FontSizeDropDown.setMaximumRowCount(4);
		FontSizeDropDown.setSelectedIndex(0);
		FontSizeDropDown.setPreferredSize(new Dimension(50,25));
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 2;
	    c2.gridy = 1;
	    c2.anchor = GridBagConstraints.WEST;
	    //�m��,�a��,�a�k
	    ButtonGroup radioGroup = new ButtonGroup();
	    leftRadio = new JRadioButton("�a��",true);
	    leftRadio.setBackground(colorRGB);
	    centerRadio = new JRadioButton("�m��");
	    centerRadio.setBackground(colorRGB);
	    rightRadio = new JRadioButton("�a�k");
	    rightRadio.setBackground(colorRGB);
	    radioGroup.add(leftRadio);
	    radioGroup.add(centerRadio);
	    radioGroup.add(rightRadio);
	    GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
	    c3.gridy = 2;
	    c3.anchor = GridBagConstraints.WEST;
	    GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
	    c4.gridy = 2;
	    c4.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 2;
	    c5.gridy = 2;
	    c5.anchor = GridBagConstraints.EAST;
	    
	    //����, ���u, ����
	    boldBox = new JCheckBox("����");
	    boldBox.setBackground(colorRGB);
	    italicBox = new JCheckBox("����");
	    italicBox.setBackground(colorRGB);
	    underlineBox = new JCheckBox("���u");
	    underlineBox.setBackground(colorRGB);
	    GridBagConstraints c7 = new GridBagConstraints();
	    c7.gridx = 0;
	    c7.gridy = 3;
	    c7.anchor = GridBagConstraints.WEST;
	    GridBagConstraints c8 = new GridBagConstraints();
	    c8.gridx = 1;
	    c8.gridy = 3;
	    c8.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints c9 = new GridBagConstraints();
	    c9.gridx = 2;
	    c9.gridy = 3;
	    c9.anchor = GridBagConstraints.EAST;
	    
	    //�C��
	    JLabel color = new JLabel("  �C��:");
	    color.setFont(new Font("�L�n������", Font.BOLD, 16));
	    GridBagConstraints c10 = new GridBagConstraints();
	    c10.gridx = 0;
	    c10.gridy = 4;
	    c10.gridwidth= 3;
	    c10.anchor = GridBagConstraints.WEST;
	    
	    colorSet=new JButton("�r���C��");
	    
	    colorSet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				testText1.setForeground(this.chooseColor(testText1));
				colorSet.setForeground(rsltColor);
			}
			private Color chooseColor(Component comp)
			{
			   rsltColor =JColorChooser.showDialog(comp,"�C����",comp.getBackground());
			   return rsltColor;
			}
		});
		GridBagConstraints c11 = new GridBagConstraints();
	    c11.gridx = 1;
	    c11.gridy = 4;
	    c11.anchor = GridBagConstraints.WEST;
	    
	    
	    //���j�u
	    LineComponent line = new LineComponent(0, 20, 200, 20, Color.WHITE);  //fx,fy,tx,ty
        line.setStroke(new BasicStroke(3f));
        GridBagConstraints c13 = new GridBagConstraints();
        c13.gridx = 0;
	    c13.gridy = 5;
	    c13.gridwidth= 3;
        c13.anchor = GridBagConstraints.WEST;
	    //�i���]�wlabel
	    JLabel advanceSetup = new JLabel("<html><u>2. ��r���N�v :</u></html>");
	    advanceSetup.setFont(new Font("�L�n������", Font.BOLD, 20));
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 0;
	    c12.gridy = 6;
	    c12.gridwidth= 3;
        c12.anchor = GridBagConstraints.WEST;
        //��r���N�v
        for (int i = 0; i < imageIndex.length; i++) 
        {
        	imageIndex[i] = i;
        }
        wordArt = new JComboBox(imageIndex);    	
        ComboBoxRenderer renderer= new ComboBoxRenderer(images);
        renderer.setPreferredSize(new Dimension(200, 30));
        wordArt.setRenderer(renderer);
        wordArt.setMaximumRowCount(images.length);
        GridBagConstraints c14 = new GridBagConstraints();
	    c14.gridx = 0;
	    c14.gridy = 7;
	    c14.gridwidth= 3;
	    c14.anchor = GridBagConstraints.WEST;
	    
	    //���j�u
	    LineComponent line2 = new LineComponent(0, 30, 200, 30, Color.WHITE);  //fx,fy,tx,ty
        line2.setStroke(new BasicStroke(3f));
        GridBagConstraints c18 = new GridBagConstraints();
        c18.gridx = 0;
	    c18.gridy = 8;
	    c18.gridwidth= 3;
        c18.anchor = GridBagConstraints.WEST;
        
	    //��~��
	    JLabel ClipboardLabel = new JLabel("<html><u>3. ��~�� :</u></html>");
	    ClipboardLabel.setFont(new Font("�L�n������", Font.BOLD, 20));
		GridBagConstraints c15 = new GridBagConstraints();
		c15.gridx = 0;
	    c15.gridy = 9;
	    c15.gridwidth= 3;
	    c15.anchor = GridBagConstraints.WEST;
	    
	    //��~�O�j�p
	    JLabel ClipboardShapeLabel = new JLabel("  Width * Height : ");
	    ClipboardLabel.setFont(new Font("�L�n������", Font.BOLD, 20));
		GridBagConstraints c17 = new GridBagConstraints();
		c17.gridx = 0;
	    c17.gridy = 10;
	    c17.gridwidth= 3;
        c17.anchor = GridBagConstraints.WEST;
        
        JPanel heightAndWidth = new JPanel();
        heightAndWidth.setBackground(colorRGB);
        ClipboardWidth = new JTextField("300",4);
        ClipboardWidth.setFont(new Font("�L�n������", Font.BOLD, 14));
        ClipboardWidth.setHorizontalAlignment(ClipboardWidth.CENTER);
        JLabel multi = new JLabel("*");
        ClipboardHeight = new JTextField("200",4);
        ClipboardHeight.setFont(new Font("�L�n������", Font.BOLD, 14));
        ClipboardHeight.setHorizontalAlignment(ClipboardHeight.CENTER);
        heightAndWidth.add(ClipboardWidth);
        heightAndWidth.add(multi);
        heightAndWidth.add(ClipboardHeight);
        GridBagConstraints c19 = new GridBagConstraints();
		c19.gridx = 0;
	    c19.gridy = 11;
	    c19.gridwidth= 3;
        c19.anchor = GridBagConstraints.WEST;
        //�إ�Btn
	    ClipboardBtn = new JButton("�إ߶�~��");
	    ClipboardBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				new G2dClipboardDemo(frame,EditPanel.this,"��~��",true, Integer.parseInt(ClipboardWidth.getText()),Integer.parseInt(ClipboardHeight.getText()));
			}
		});
	    GridBagConstraints c16 = new GridBagConstraints();
		c16.gridx = 0;
	    c16.gridy = 14;
	    c16.gridwidth= 3;
        c16.anchor = GridBagConstraints.WEST;
	    
        
		//�[�JtextPanel
	    textPanel.setBackground(colorRGB);
		textPanel.setLayout(new GridBagLayout());
		textPanel.add(typeFace,c0);
		textPanel.add(typeFaceDropDown,c1);
		textPanel.add(FontSizeDropDown,c2);
		textPanel.add(leftRadio,c3);
		textPanel.add(centerRadio,c4);
		textPanel.add(rightRadio,c5);
		textPanel.add(boldBox,c7);
		textPanel.add(italicBox,c8);
		textPanel.add(underlineBox,c9);
		textPanel.add(color,c10);
		textPanel.add(colorSet,c11);
		textPanel.add(advanceSetup,c12);
		textPanel.add(line,c13);
		textPanel.add(wordArt,c14);
		textPanel.add(line2,c18);
		textPanel.add(ClipboardLabel,c15);
		textPanel.add(ClipboardShapeLabel,c17);
		textPanel.add(heightAndWidth,c19);
		textPanel.add(ClipboardBtn,c16);
		
		textEdit.add(textPanel);
		textEdit.setBackground(colorRGB);
		
		 //register events for TextEdit
		TextFontHandler handler = new TextFontHandler();
		typeFaceDropDown.addItemListener(handler);
		FontSizeDropDown.addItemListener(handler);
		leftRadio.addItemListener(handler);
	    centerRadio.addItemListener(handler);
	    rightRadio.addItemListener(handler);
	    boldBox.addItemListener(handler);
	    underlineBox.addItemListener(handler);
	    italicBox.addItemListener(handler);
	    wordArt.addItemListener(new ItemListener()
	    {
	    	public void itemStateChanged(ItemEvent event)
		    {
	    		if(event.getStateChange() == ItemEvent.SELECTED)
	    		{	
	    			System.out.println(wordArt.getSelectedIndex());
	    			switch(wordArt.getSelectedIndex())
	    			{
	    				case 1:
	    					//�Ťߦr
	    					new Dialog(frame,EditPanel.this,"�s���r���N�v��r",true,1);
	    					break;
	    				case 2:
	    					//����r
	    					new Dialog(frame,EditPanel.this,"�s���r���N�v��r",true,2);
	    					break;
	    				case 3:
	    					//����r
	    					new Dialog(frame,EditPanel.this,"�s���r���N�v��r",true,3);
	    					break;
	    				case 4:
	    					//���v
	    					new Dialog(frame,EditPanel.this,"�s���r���N�v��r",true,4);
	    					break;
	    				default:
	    					break;
	    			}
	    			wordArt.setSelectedIndex(0);
	    		}
	    		
	    			
		    }
	    });

            
            
	    this.add(edit,BorderLayout.EAST);
	    
		
	}
	private class TextFontHandler implements ItemListener
	{

		public void itemStateChanged(ItemEvent e)
	    {		
			if(e.getSource() == boldBox)
			{
		         if(e.getStateChange() == ItemEvent.SELECTED)
		            bold = Font.BOLD;
		         else if(e.getStateChange() == ItemEvent.DESELECTED)
		            bold = Font.PLAIN;
		    }
			else if(e.getSource() == underlineBox)
			{
		         if(e.getStateChange() == ItemEvent.SELECTED)
		         {	 
		        	SimpleAttributeSet attrs = new SimpleAttributeSet();
		            StyleConstants.setUnderline(attrs, true);
		            String tempStr = testText1.getText();
		            testText1.setText("");
		     		try {
						testText1.getDocument().insertString(0,tempStr,attrs);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		         }
		         else if(e.getStateChange() == ItemEvent.DESELECTED){
		        	 SimpleAttributeSet attrs = new SimpleAttributeSet();
			         StyleConstants.setUnderline(attrs, false);
			         String tempStr = testText1.getText();
			         testText1.setText("");
			         try {
						testText1.getDocument().insertString(0,tempStr,attrs);
					 } catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					 }    
		         }
		    }
			else if(e.getSource() == centerRadio)
			{
		         if(e.getStateChange() == ItemEvent.SELECTED)
		         {
		        	 StyledDocument doc = testText1.getStyledDocument();
		        	 SimpleAttributeSet center = new SimpleAttributeSet();
		        	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		        	 doc.setParagraphAttributes(0, doc.getLength(), center, false);
		         }
		    }
			else if(e.getSource() == rightRadio)
			{
		         if(e.getStateChange() == ItemEvent.SELECTED)
		         {
		        	 StyledDocument doc = testText1.getStyledDocument();
		        	 SimpleAttributeSet center = new SimpleAttributeSet();
		        	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
		        	 doc.setParagraphAttributes(0, doc.getLength(), center, false);
		         }
		    }
			else if(e.getSource() == leftRadio)
			{
		         if(e.getStateChange() == ItemEvent.SELECTED)
		         {
		        	 StyledDocument doc = testText1.getStyledDocument();
		        	 SimpleAttributeSet center = new SimpleAttributeSet();
		        	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
		        	 doc.setParagraphAttributes(0, doc.getLength(), center, false);
		         }
		    }
			else if(e.getSource() == italicBox)
			{
		         if(e.getStateChange() == ItemEvent.SELECTED)
		            italic = Font.ITALIC;
		         else if(e.getStateChange() == ItemEvent.DESELECTED)
		            italic = Font.PLAIN;    
		    }
			if(e.getSource() == FontSizeDropDown)
			{
				
				 if(e.getStateChange() == ItemEvent.SELECTED){
					 fonts = Integer.parseInt((String)FontSizeDropDown.getSelectedItem());
				 }
			}
			if(e.getSource() == typeFaceDropDown)
			{
				
				 if(e.getStateChange() == ItemEvent.SELECTED)
					 fontfamily = (String)typeFaceDropDown.getSelectedItem();
			}
			testText1.setFont(new Font(fontfamily, (bold + italic) , fonts)); 
	    }  
	}
	class ComboBoxRenderer extends JLabel implements ListCellRenderer 
	{
		ImageIcon[] imagePic;
		public ComboBoxRenderer(ImageIcon[] image) 
		{
			imagePic = image;
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
		}
	 
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus) 
		{
			//Get the selected index. (The index param isn't
			//always valid, so just use the value.)
			int selectedIndex = ((Integer)value).intValue();
			 
			//Set the icon and text.
			ImageIcon icon = imagePic[selectedIndex];
			setIcon(icon);
			if (icon != null) {
				//setText(language);
				setFont(list.getFont());
			}
			return this;
		}
		public void paint(Graphics g) {
	        setBackground(Color.WHITE);
	        super.paint(g);
	    }
	}
}