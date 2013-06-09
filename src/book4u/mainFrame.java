/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package book4u;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 *
 * @author 桌電
 */
public class mainFrame extends javax.swing.JFrame {
    EditPanel text;
    /**
     * Creates new form main
     */
    public mainFrame() {
        this.setAlwaysOnTop(true);
        initComponents();
        JTabbedPane edit = new JTabbedPane();
	JPanel photoFrame = new JPanel();
	JPanel photoEdit = new JPanel();
	JPanel textEdit = new JPanel();
	edit.addTab("框架編輯", photoFrame);
	edit.addTab("圖片編輯", photoEdit);
	edit.addTab("文字編輯", textEdit);
	//加入文字編輯panel
	textEdit.setBackground(new Color(98, 134, 167));
	text = new EditPanel(this);
	textEdit.add(text);
	//加入圖片編輯panel
	photoEdit.setBackground(new Color(98, 134, 167));
	imageEdit photo = new imageEdit();
	photoEdit.add(photo);	
	rightPanel.add(edit,BorderLayout.EAST);
    }

    public centerPanel getCenterPanel()
    {
        return (centerPanel) centerPanel;
    }
    
    public void setRightPanelTextArea(JTextPane textPane)
    {
        EditPanel panel = (EditPanel)rightPanel;
        //panel.call(textPane);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SouthPanel  com = new SouthPanel ();
        bottomPanel = com.addSouthPanel ( );
        leftPanel left=new leftPanel ();
        leftPanel = left.addLeftPanel ( );
        centerPanel = new centerPanel(this);
        rightPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        storeProjectMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        outputPDFmemuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoMenuItem = new javax.swing.JMenuItem();
        redoMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cutMenu = new javax.swing.JMenuItem();
        copyMenu = new javax.swing.JMenuItem();
        pasteMenu = new javax.swing.JMenuItem();
        deleteMenu = new javax.swing.JMenuItem();
        insertMenu = new javax.swing.JMenu();
        pictureFrameMenu = new javax.swing.JMenuItem();
        textBoxMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book4U");
        setBounds(200,50,480,300);

        bottomPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bottomPanel.setMaximumSize(new java.awt.Dimension(800, 500));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 200));

        leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftPanel.setPreferredSize(new java.awt.Dimension(150, 300));

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        centerPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        rightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        fileMenu.setText("檔案");

        storeProjectMenuItem.setText("儲存");
        storeProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeProjectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(storeProjectMenuItem);
        fileMenu.add(jSeparator3);

        outputPDFmemuItem.setText("輸出PDF");
        outputPDFmemuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputPDFmemuItemActionPerformed(evt);
            }
        });
        fileMenu.add(outputPDFmemuItem);

        menuBar.add(fileMenu);

        editMenu.setText("編輯");

        undoMenuItem.setText("復原");
        undoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(undoMenuItem);

        redoMenuItem.setText("重作");
        editMenu.add(redoMenuItem);
        editMenu.add(jSeparator1);

        cutMenu.setText("剪下");
        cutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuActionPerformed(evt);
            }
        });
        editMenu.add(cutMenu);

        copyMenu.setText("複製");
        editMenu.add(copyMenu);

        pasteMenu.setText("貼上");
        pasteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenu);

        deleteMenu.setText("刪除");
        editMenu.add(deleteMenu);

        menuBar.add(editMenu);

        insertMenu.setText("插入");

        pictureFrameMenu.setText("圖框");
        pictureFrameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pictureFrameMenuActionPerformed(evt);
            }
        });
        insertMenu.add(pictureFrameMenu);

        textBoxMenu.setText("文字框");
        textBoxMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBoxMenuActionPerformed(evt);
            }
        });
        insertMenu.add(textBoxMenu);

        menuBar.add(insertMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void storeProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeProjectMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_storeProjectMenuItemActionPerformed

    private void outputPDFmemuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputPDFmemuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputPDFmemuItemActionPerformed

    private void cutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cutMenuActionPerformed

    private void undoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undoMenuItemActionPerformed

    private void pictureFrameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pictureFrameMenuActionPerformed
        centerPanel centerP = (centerPanel)centerPanel;
        centerP.insertPictureFrame();
    }//GEN-LAST:event_pictureFrameMenuActionPerformed

    private void pasteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteMenuActionPerformed

    private void textBoxMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBoxMenuActionPerformed
        centerPanel centerP = (centerPanel)centerPanel;
        JTextPane p = centerP.insertTextArea();  //文字框add到我的centerPanel
        text.call(centerP, p); //這行加入到你的  刪除這行可正常顯示
    }//GEN-LAST:event_textBoxMenuActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JMenuItem copyMenu;
    private javax.swing.JMenuItem cutMenu;
    private javax.swing.JMenuItem deleteMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu insertMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JMenuItem outputPDFmemuItem;
    private javax.swing.JMenuItem pasteMenu;
    private javax.swing.JMenuItem pictureFrameMenu;
    private javax.swing.JMenuItem redoMenuItem;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JMenuItem storeProjectMenuItem;
    private javax.swing.JMenuItem textBoxMenu;
    private javax.swing.JPanel topPanel;
    private javax.swing.JMenuItem undoMenuItem;
    // End of variables declaration//GEN-END:variables
}
