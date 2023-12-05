/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeFrame extends javax.swing.JFrame {
    art art;
    int panelCount = 1;
    int height = 321;
    int minus = 10;
    ArrayList<String> lukisan = Connect.lukisan;
    ArrayList<String> patung = Connect.patung;
    CardLayout cardLayout;
    
    public HomeFrame() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(51,51,51));
        setVisible(true);
        artPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30,20));
        artPanel.setPreferredSize(new Dimension(570, height));
        artPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 30,20));
        artPanel1.setPreferredSize(new Dimension(570, height));
        Main.add(HomeFrame, "Home");
        Main.add(Lukisan, "Lukisan");
        Main.add(Patung, "Patung");
        cardLayout = (CardLayout)(Main.getLayout());
        getName("Lukisan", lukisan, artPanel);
        getName("Patung", patung, artPanel1);
        pack();
        Filter.setVisible(false);
        filterList.setVisible(false);
        HomePanel.setLayout(new BoxLayout(HomePanel, BoxLayout.Y_AXIS));
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        setImage(label1, "D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\component\\Home2.jpeg");
        setImage(label2, "D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\component\\imageHome.png");
        HomePanelDesc desc = new HomePanelDesc();
        desc.setPreferredSize(new Dimension(HomePanel.getWidth(), HomePanel.getHeight()));
    }
    
    
    public void getName(String jenis, ArrayList<String> string, JPanel panel){
        if(panelCount == 1){
            Connect.getAllNames(jenis);
            for(int i = 0; i < string.size(); i++){
                addPanel(string.get(i), jenis, panel);
            }
        }
        panelCount = 1;
    }
    
    
    public void setImage(JLabel label, String path){
        ImageIcon icon = new ImageIcon(path);
        Image ori = icon.getImage();
        Image scaled = ori.getScaledInstance(HomePanel.getWidth(), HomePanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgScaled = new ImageIcon(scaled);
        label.setPreferredSize(HomePanel.getPreferredSize());
        label.setIcon(imgScaled);
        HomePanel.add(label);
        HomePanel.add(Box.createVerticalStrut(20));
        updateHomePanelSize();
    }
    
    
    
    private void updateHomePanelSize() {
        int totalHeight = 0;
        for (Component component : HomePanel.getComponents()) {
            totalHeight += component.getPreferredSize().height;
        }
        HomePanel.setPreferredSize(new Dimension(1025, totalHeight));
        HomePanel.revalidate();
    }
    
    
    public void addPanel(String nama, String jenis, JPanel panel){
        art art = new art();
        art.setImage(nama);
        if(jenis.equals("Lukisan")){
            panelCount++;
            panel.add(art);
            setHeight(panel);
            panel.revalidate();
            panel.repaint();
        }else if(jenis.equals("Patung")){
            panelCount++;
            panel.add(art);
            setHeight(panel);
            panel.revalidate();
            panel.repaint();
        }
    }
    
    public void setHeight(JPanel panel){
        if (panelCount % 3 == 0) {
            height += 150 - minus;
            panel.setPreferredSize(new Dimension(596, height));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        HomeFrame = new javax.swing.JScrollPane();
        HomePanel = new keeptoo.KGradientPanel();
        Lukisan = new keeptoo.KGradientPanel();
        scrollPanel = new javax.swing.JScrollPane();
        artPanel = new javax.swing.JPanel();
        Patung = new keeptoo.KGradientPanel();
        scrollPanel1 = new javax.swing.JScrollPane();
        artPanel1 = new javax.swing.JPanel();
        filterList = new javax.swing.JComboBox<>();
        Filter = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        Leaderboard = new javax.swing.JLabel();
        Game = new javax.swing.JLabel();
        Art = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));
        setResizable(false);

        Main.setBackground(new java.awt.Color(51, 51, 51));
        Main.setForeground(new java.awt.Color(102, 102, 102));
        Main.setLayout(new java.awt.CardLayout());

        HomeFrame.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        HomePanel.setkEndColor(new java.awt.Color(51, 51, 51));
        HomePanel.setkStartColor(new java.awt.Color(51, 102, 255));
        HomePanel.setOpaque(false);
        HomePanel.setPreferredSize(new java.awt.Dimension(1025, 486));

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        HomeFrame.setViewportView(HomePanel);

        Main.add(HomeFrame, "card4");

        Lukisan.setkEndColor(new java.awt.Color(255, 255, 255));
        Lukisan.setkStartColor(new java.awt.Color(255, 255, 255));

        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout artPanelLayout = new javax.swing.GroupLayout(artPanel);
        artPanel.setLayout(artPanelLayout);
        artPanelLayout.setHorizontalGroup(
            artPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        artPanelLayout.setVerticalGroup(
            artPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(artPanel);

        javax.swing.GroupLayout LukisanLayout = new javax.swing.GroupLayout(Lukisan);
        Lukisan.setLayout(LukisanLayout);
        LukisanLayout.setHorizontalGroup(
            LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LukisanLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        LukisanLayout.setVerticalGroup(
            LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LukisanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        Main.add(Lukisan, "card2");

        Patung.setkEndColor(new java.awt.Color(255, 255, 255));
        Patung.setkStartColor(new java.awt.Color(255, 255, 255));

        artPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout artPanel1Layout = new javax.swing.GroupLayout(artPanel1);
        artPanel1.setLayout(artPanel1Layout);
        artPanel1Layout.setHorizontalGroup(
            artPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        artPanel1Layout.setVerticalGroup(
            artPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        scrollPanel1.setViewportView(artPanel1);

        javax.swing.GroupLayout PatungLayout = new javax.swing.GroupLayout(Patung);
        Patung.setLayout(PatungLayout);
        PatungLayout.setHorizontalGroup(
            PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
            .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PatungLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );
        PatungLayout.setVerticalGroup(
            PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
            .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PatungLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        Main.add(Patung, "card3");

        filterList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lukisan", "Patung", "Sastra", "Musik" }));
        filterList.setFocusable(false);
        filterList.setLightWeightPopupEnabled(false);
        filterList.setRequestFocusEnabled(false);
        filterList.setVerifyInputWhenFocusTarget(false);
        filterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterListActionPerformed(evt);
            }
        });

        Filter.setBackground(new java.awt.Color(51, 51, 51));
        Filter.setForeground(new java.awt.Color(255, 255, 255));
        Filter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filter.setText("Filter");
        Filter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterMouseClicked(evt);
            }
        });

        Home.setForeground(new java.awt.Color(255, 255, 255));
        Home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Home.setText("Home");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });

        Leaderboard.setForeground(new java.awt.Color(255, 255, 255));
        Leaderboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Leaderboard.setText("Leaderboard");

        Game.setForeground(new java.awt.Color(255, 255, 255));
        Game.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Game.setText("Games");

        Art.setForeground(new java.awt.Color(255, 255, 255));
        Art.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Art.setText("Art");
        Art.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(Game, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Leaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Art, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Leaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Game, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Art, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterListActionPerformed

    private void FilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterMouseClicked
        int index = filterList.getSelectedIndex();
        switch(index){
            case 0 :
            cardLayout.show(Main, "Lukisan");
            break;
            case 1 :
            cardLayout.show(Main, "Patung");
        }
    }//GEN-LAST:event_FilterMouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        cardLayout.show(Main, "Home");
        Filter.setVisible(false);
        filterList.setVisible(false);
    }//GEN-LAST:event_HomeMouseClicked

    private void ArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArtMouseClicked
       Filter.setVisible(true);
       filterList.setVisible(true);
       cardLayout.show(Main, "Lukisan");
    }//GEN-LAST:event_ArtMouseClicked

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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Art;
    private javax.swing.JLabel Filter;
    private javax.swing.JLabel Game;
    private javax.swing.JLabel Home;
    private javax.swing.JScrollPane HomeFrame;
    private keeptoo.KGradientPanel HomePanel;
    private javax.swing.JLabel Leaderboard;
    private keeptoo.KGradientPanel Lukisan;
    private javax.swing.JPanel Main;
    private keeptoo.KGradientPanel Patung;
    private javax.swing.JPanel artPanel;
    private javax.swing.JPanel artPanel1;
    private javax.swing.JComboBox<String> filterList;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JScrollPane scrollPanel1;
    // End of variables declaration//GEN-END:variables
}
