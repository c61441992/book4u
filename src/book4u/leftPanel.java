package book4u;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class leftPanel  extends JFrame{
        private JScrollPane scrollPane;   
	    private JPanel LayoutPanel; //�ŧi�@�ӷs��panel
	    ImageComponent imageComp;
	    private JPanel buttonPanel, imagePanel ;  
	    JFileChooser jfc;
		 
		public JPanel addLeftPanel ( ){
			LayoutPanel= new JPanel();
			LayoutPanel.setLayout( new BorderLayout() );
			JButton userAdd,fileAdd;
		     userAdd = new JButton("+");   
		     fileAdd = new JButton("file");   

		     userAdd.setMargin(new Insets(0, 10, 0, 10));   
		     fileAdd.setMargin(new Insets(0, 10, 0, 10));   
		     buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));   
		     buttonPanel.add(userAdd);
		     buttonPanel.add(fileAdd);
		    imagePanel = new JPanel(new ModifiedFlowLayout(FlowLayout.LEFT, 5,5)); 

		     LayoutPanel.add(buttonPanel,BorderLayout.NORTH);   
		     objectDB ("userPic" );
		  

		 	jfc = new JFileChooser();
			jfc.setMultiSelectionEnabled(true);
			//=======================================================
			userAdd.addActionListener(new ActionListener(){ 
				//�ϥΪ̷s�W�ɮ׫��s�ʧ@
		            @Override
		            public void actionPerformed(ActionEvent arg0) {
		            	ImageIODemo image=new ImageIODemo(); //�ϥΪ̷s�W�ϮץB�s���ɮק���
	                	 imageComp=image.getReturn();
	                	 final String File_name=image.getFile();
		                	        SwingUtilities.invokeLater(new Runnable() {
		                	            public void run() {
		                	            	  ImageIcon image = new ImageIcon(File_name);
		                				    	image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); //���]�Ϥ�j�p
		                				         JLabel imgLabel2= new JLabel(image); 
		                				         imagePanel.add(imgLabel2); //�[�J�Ϥ�
		                				         JScrollBar jscrollBar = scrollPane.getVerticalScrollBar();
		                				         if (jscrollBar != null)
		                				             jscrollBar.setValue(0);//�s�W�Ϥ��N�Ա�Ԩ�̤W��
		                	            }
		                	        }
		                	        );   
		            }
		            }
			);
			fileAdd.addActionListener(new ActionListener(){ 
				//�ϥΪ̷s�W�ɮ׫��s�ʧ@
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	            	jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int returnVal = jfc.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION){
						File[] file = jfc.getSelectedFiles();
						for(File f : file){																		// open
							if(f.isDirectory()){
								 System.out.println(f);
								 String[] filelist = f.list();
								 for(int i=0 ; i<filelist.length;i++){
						    			ImageIcon image = new ImageIcon(f+"/"+filelist[i]);
								    	image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); //���]�Ϥ�j�p
								         JLabel imgLabel2= new JLabel(image); 
								         imagePanel.add(imgLabel2); //�[�J�Ϥ�
						    	}
							} 
						}
				}
	            }
	            }
		);
			//===============================�ϥΪ̷s�W�ɮ׫��s�ʧ@<END>
			return LayoutPanel;
		}
		
		   
		void objectDB (String pathName ) {

			 //�s�Ҧ��פU�����ɦW��
			File file = new File( pathName);
			String[] filelist = file.list();
			//*********************************�s���ɦW��

			//JPanel picturePanelTab = new JPanel();
			 imagePanel.setBackground(Color.WHITE);
			for(int i=0 ; i<filelist.length;i++){
	    			ImageIcon image = new ImageIcon(pathName+"/"+filelist[i]);
			    	image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); //���]�Ϥ�j�p
			         JLabel imgLabel2= new JLabel(image); 
			         imagePanel.add(imgLabel2); //�[�J�Ϥ�
	    	}
			 scrollPane = new JScrollPane(imagePanel); 
			  LayoutPanel. add( scrollPane);  
		}

		class ModifiedFlowLayout extends FlowLayout {
		    public ModifiedFlowLayout(int align, int hgap, int vgap) {
		        super(align, hgap, vgap);
		    }
		    public Dimension minimumLayoutSize(Container target) {
		        return computeSize(target, false);
		    }
		    public Dimension preferredLayoutSize(Container target) {
		        return computeSize(target, true);
		    }
		    private Dimension computeSize(Container target, boolean minimum) {
		        synchronized (target.getTreeLock()) {
		            int hgap = getHgap();
		            int vgap = getVgap();
		            int w = target.getWidth();

		            if (w == 0) {
		                w = Integer.MAX_VALUE;            	
		            }

		            Insets insets = target.getInsets();
		            if (insets == null) {
		                insets = new Insets(0, 0, 0, 0);
		            }
		            int reqdWidth = 0;

		            int maxwidth =180; // w - (insets.left + insets.right + hgap * 2);
		            int n = target.getComponentCount();
		            int x = 0;
		            int y = insets.top;
		            int rowHeight = 0;

		            for (int i = 0; i < n; i++) {
		                Component c = target.getComponent(i);
		                if (c.isVisible()) {
		                    Dimension d =
		                            minimum ? c.getMinimumSize() : c.getPreferredSize();
		                    if ((x == 0) || ((x + d.width) <= maxwidth)) {
		                        if (x > 0) {
		                            x += hgap;
		                        }
		                        x += d.width;
		                        rowHeight = Math.max(rowHeight, d.height);
		                    } else {
		                        x = d.width;
		                        y += vgap + rowHeight;
		                        rowHeight = d.height;
		                    }
		                    reqdWidth = Math.max(reqdWidth, x);
		                }
		            }
		            y += rowHeight;
		            return new Dimension(120, y);
		        }
		    }
		}
		

		
}
