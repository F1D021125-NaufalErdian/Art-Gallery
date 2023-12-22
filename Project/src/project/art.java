package project;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class art extends JPanel {
    public static int size = 0;
    public String name, artist, desk, gambar;
    public int tahun = 0;
    public ImageIcon img;

    public art() {
        initComponents();
        image.setSize(169, 195); 
    }
    
    public static int ukuran(){
        return size;
    }
    
    public void setImage(String nama){
        Connection con = Connect.getConnection();
        try{
            String query = "SELECT nama, tahun, artist, gambar, deskripsi FROM art WHERE nama = ?";
            try(PreparedStatement stmt = con.prepareStatement(query)){
                stmt.setString(1, nama);
                try(ResultSet rs = stmt.executeQuery()){
                    while(rs.next()){
                        name = rs.getString("nama");
                        tahun = rs.getInt("tahun");
                        artist = rs.getString("artist");
                        desk = rs.getString("deskripsi");
                        gambar = rs.getString("gambar");
                        ImageIcon imageIcon = new ImageIcon(gambar);
                        img = imageIcon;
                        Image originalImage = imageIcon.getImage();
                        Image scaledImage = originalImage.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon scaled = new ImageIcon(scaledImage);
                        image.setIcon(scaled);
                        title.setText(name);
                    }
                }
            }catch(Exception e){
            
        }
        }catch(Exception e){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 153, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(205, 268));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 19, 169, 195));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("jLabel2");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 232, 169, 16));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/bingkai.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 270));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Description desc = new Description();
        desc.setDesc(name, artist, tahun, img, desk);
        desc.setLocationRelativeTo(null);
        desc.setVisible(true);
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
