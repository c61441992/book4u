package book4u;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class SouthPanel  extends JFrame{
		
	    private JPanel LayoutPanel; //�ŧi�@�ӷs��panel
	    ImageComponent imageComp;
	    
		public JPanel addSouthPanel ( ){
			LayoutPanel= new JPanel();
			LayoutPanel.setLayout( new BorderLayout() );
			JButton userAdd=new JButton("+");
			userAdd.setBounds(250,0,50,20);
			//getContentPane().add( LayoutPanel );
		    final String str[ ] = { "�����˦�" , "�B�n" , "�I��" , "����w"} ;
		    final JTabbedPane tab = new JTabbedPane ( ) ;
		        for ( int i=0 ; i <4 ; i++ ) 
		        		tab.add(str[i],createPanel(str[i]));
		     tab.setBackground(Color.WHITE);		
		     LayoutPanel.add(userAdd );
		     LayoutPanel.add( tab );
			//=======================================================
			userAdd.addActionListener(new ActionListener(){ 
				//�ϥΪ̷s�W�ɮ׫��s�ʧ@
		            @Override
		            public void actionPerformed(ActionEvent arg0) {
		            	ImageIODemo image=new ImageIODemo(); //�ϥΪ̷s�W�ϮץB�s���ɮק���
		                	 imageComp=image.getReturn();
		                	 final String File_name=image.getFile();
		                	  final int temp = tab.getSelectedIndex(); //Ū��ثe�Ҧb��Jpanel��m
		                	  System.out.println(temp);
		                	        SwingUtilities.invokeLater(new Runnable() {
		                	            public void run() {
		                	            	switch(temp){
		                	            	case 0:
		                	                new ImageSaveToGifDemo(File_name,"pageMode");
		                	                break;
		                	            	case 1:
		                	            		 new ImageSaveToGifDemo(File_name,"mask");
		                	            	     break;
		                	            	case 2:
		                	            		 new ImageSaveToGifDemo(File_name,"bground");
		                	            	     break;
		                	            	case 3:
		                	            		 new ImageSaveToGifDemo(File_name,"pic");
		                	            	     break;                	
		                	            	}
		                	            	 tab.removeAll(); //�M���Ҧ���tab��K���s�إ߷s��tab((���sŪ���ɮפ������
		                	            	 //�]��tab��final�L�k�����s�W�ϥΪ̤W�Ǫ��Ϯ�
		                	            	 //�ҥH�βM���Ҧ���tab���sŪ���ɮ׸�Ƥ�K���D�ϥΪ̤W�Ǫ��ɮ�
			                	                for ( int i=0 ; i <4 ; i++ ) 
			                		        		tab.add(str[i],createPanel(str[i]));   
		                	            }
		                	        }
		                	        );   
		            }
		            }
			);
			//===============================�ϥΪ̷s�W�ɮ׫��s�ʧ@<END>
			return LayoutPanel;
		}
		
		JScrollPane  createPanel(String str){ //panel�ﶵ
	    	JScrollPane jp= new JScrollPane(); //���Ʊ�i�Ԫ�panel
	    	switch (str){
		    	case "�����˦�":
		    		 jp.getViewport().add( objectDB ("pageMode" ) );//�����ج[����
		    		break;
		        case "�B�n":
		        	 jp.getViewport().add( objectDB ("mask" ) ); //���I����B���L�����k
		        	break;
		        case "�I��":
		        	 jp.getViewport().add( objectDB ("bground" ) );//����w���ɮצs�bbground��Ƨ����U
		        	break;
		        case "����w":
		          jp.getViewport().add( objectDB ("pic" ) ); //����w���ɮצs�bpic��Ƨ����U
		          	break;
	        }
	        return jp;
	    }
	    
		JPanel objectDB (String pathName ) {
			 //�s�Ҧ��פU�����ɦW��
			File file = new File( pathName);
			String[] filelist = file.list();
			//*********************************�s���ɦW��
			
			JPanel picturePanelTab = new JPanel();
			picturePanelTab.setBackground(Color.WHITE);
			for(int i=0 ; i<filelist.length;i++){
	    			ImageIcon image = new ImageIcon(pathName+"/"+filelist[i]);
			    	image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); //���]�Ϥ�j�p
			        JLabel imgLabel2= new JLabel(image); 
			        picturePanelTab.add(imgLabel2); //�[�J�Ϥ�
                                DragSource dragSource = DragSource.getDefaultDragSource();
                                dragSource.createDefaultDragGestureRecognizer(imgLabel2, 
                                DnDConstants.ACTION_COPY_OR_MOVE,new DragAndDropDragGestureListener());

                        }
                picturePanelTab.setLayout(new FlowLayout(FlowLayout.LEFT , 10 , 10)); //����V�����
	    	return picturePanelTab;
		}
                
    class DragAndDropDragGestureListener implements DragGestureListener { 
        public void dragGestureRecognized(DragGestureEvent dge) { 
            JLabel label = (JLabel)dge.getComponent(); 
            DragAndDropTransferable dragAndDropTransferable = new 
            DragAndDropTransferable(label); 
            dge.startDrag(DragSource.DefaultCopyDrop, dragAndDropTransferable, new DragAndDropDragSourceListener()); 
        } 
    }
    class DragAndDropTransferable implements Transferable { 
        private JLabel label;
        DragAndDropTransferable(JLabel label) {
            this.label = label;
        }
        DataFlavor flavors[] = {DataFlavor.stringFlavor}; 
        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return flavors;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return true;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            return label;
        }
        
    }
    
    class DragAndDropDragSourceListener implements DragSourceListener
    {

        @Override
        public void dragEnter(DragSourceDragEvent dsde) {
            DragSourceContext context = dsde 
            .getDragSourceContext(); 
            int dropAction = dsde.getDropAction(); 
            if ((dropAction & DnDConstants.ACTION_COPY) != 0) { 
              context.setCursor(DragSource.DefaultCopyDrop); 
            } else if ((dropAction & DnDConstants.ACTION_MOVE) != 0) { 
              context.setCursor(DragSource.DefaultMoveDrop); 
            } else { 
              context.setCursor(DragSource.DefaultCopyNoDrop); 
            } 
        }

        @Override
        public void dragOver(DragSourceDragEvent dsde) {
        }

        @Override
        public void dropActionChanged(DragSourceDragEvent dsde) {
       }

        @Override
        public void dragExit(DragSourceEvent dse) {
       }

        @Override
        public void dragDropEnd(DragSourceDropEvent dsde) {
       }
        
    }
    
    public class ClickThroughLabel extends JLabel implements MouseListener,MouseMotionListener 
    {

        private ClickThroughLabel(ImageIcon image) {
            super(image);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
 }

        @Override
        public void mousePressed(MouseEvent e) {
   }

        @Override
        public void mouseReleased(MouseEvent e) {
   }

        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
                   }

        @Override
        public void mouseDragged(MouseEvent e) {
                    }

        @Override
        public void mouseMoved(MouseEvent e) {
                    }
    }
    
}
