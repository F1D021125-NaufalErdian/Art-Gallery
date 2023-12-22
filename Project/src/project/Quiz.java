package project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Quiz extends JFrame implements Interface{

    CardLayout cardLayout;
    public String namaKarya, namaArtist;
    public int tahunKarya;
    Connection con = Connect.getConnection();
    int nomorSoal;
    
    
    public Quiz() {
        initComponents();
        cardLayout = new CardLayout();
        Main.setLayout(cardLayout);
        Main.add(countPanel, "Count");
        Main.add(Start, "Start");
        
        image.setSize(162, 208);
        
        Benar.setText(Integer.toString(jumlahBenar));
        Salah.setText(Integer.toString(jumlahSalah));
        
        setImage();
        setLocationRelativeTo(null);
        
        Thread1 thread = new Thread1(count, Main, cardLayout, 5, 0, 0, null);
        thread.start();
        
        Thread1 time = new Thread1(timer,null,null, 65, 0, 0, this);
        time.start();
        
        jPanel1.setBackground(Color.decode("#002147"));
        jPanel2.setBackground(Color.decode("#002147"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new keeptoo.KGradientPanel();
        countPanel = new keeptoo.KGradientPanel();
        count = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Start = new keeptoo.KGradientPanel();
        panel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        BenarLabel = new javax.swing.JLabel();
        SalahLabel = new javax.swing.JLabel();
        Benar = new javax.swing.JLabel();
        Salah = new javax.swing.JLabel();
        BenarLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        timer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(912, 504));

        Main.setLayout(new java.awt.CardLayout());

        countPanel.setPreferredSize(new java.awt.Dimension(912, 504));
        countPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        count.setFont(new java.awt.Font("Times New Roman", 1, 100)); // NOI18N
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countPanel.add(count, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 111, 358, 270));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/count.jpeg"))); // NOI18N
        countPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 920, 530));

        Main.add(countPanel, "card2");

        Start.setkEndColor(new java.awt.Color(0, 255, 204));
        Start.setPreferredSize(new java.awt.Dimension(912, 504));
        Start.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        Start.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 15, -1, -1));

        question.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(255, 255, 255));
        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("Apa nama dari karya di atas?");
        Start.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 259, 458, 26));

        answer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        answer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        answer.setBorder(null);
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });
        Start.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 324, 458, 37));

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        BenarLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BenarLabel.setForeground(new java.awt.Color(255, 255, 255));
        BenarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BenarLabel.setText("Benar :");

        SalahLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SalahLabel.setForeground(new java.awt.Color(255, 255, 255));
        SalahLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SalahLabel.setText("Salah :");

        Benar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Benar.setForeground(new java.awt.Color(255, 255, 255));
        Benar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Salah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Salah.setForeground(new java.awt.Color(255, 255, 255));
        Salah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BenarLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BenarLabel1.setForeground(new java.awt.Color(255, 255, 255));
        BenarLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BenarLabel1.setText("Score");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(BenarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BenarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(Benar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(SalahLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(Salah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BenarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BenarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Benar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SalahLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Salah, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Start.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        timer.setBackground(new java.awt.Color(255, 255, 255));
        timer.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        timer.setForeground(new java.awt.Color(255, 255, 255));
        timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Start.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/ezgif.com-resize.gif"))); // NOI18N
        Start.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 920, 530));

        jLabel2.setText("jLabel2");
        Start.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));

        Main.add(Start, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
       check();
       answer.setText("");
       setImage();
    }//GEN-LAST:event_answerActionPerformed
    
    public static int jumlahBenar;
    public static int jumlahSalah;
    public static int jumlahSoal;
    
    public void setImage(){
        String query = "SELECT nama, artist, tahun,gambar FROM art WHERE no = ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            Random random = new Random();
            int number = random.nextInt(15) + 1;
            stmt.setString(1, Integer.toString(number));
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    namaKarya = rs.getString("nama");
                    namaArtist = rs.getString("artist");
                    tahunKarya = rs.getInt("tahun");
                    String gambar = rs.getString("gambar");
                    ImageIcon imageIcon = new ImageIcon(gambar);
                    Image originalImage = imageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaled = new ImageIcon(scaledImage);
                    image.setIcon(scaled);
                    setQuestion();
                }
            }catch(Exception e){
                
            }
        }catch(Exception e){
            
        }
   }
    
    public void setQuestion(){
        String query = "SELECT question FROM quiz WHERE no = ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            Random random = new Random();
            int number = random.nextInt(3) + 1;
            nomorSoal = number;
            stmt.setString(1,Integer.toString(number));
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    question.setText(rs.getString("question"));
                }
            }catch(Exception e){
                
            }
        }catch(Exception e){
            
        }   
    }
    
    @Override
    public void check(){
        if(nomorSoal == 1){
            if(answer.getText().toLowerCase().equals(namaKarya.toLowerCase())){
                jumlahBenar++;
                Benar.setText(Integer.toString(jumlahBenar));
            }else{
                jumlahSalah++;
                Salah.setText(Integer.toString(jumlahSalah));
            }
        }else if(nomorSoal == 2){
            if(answer.getText().toLowerCase().equals(Integer.toString(tahunKarya).toLowerCase())){
                jumlahBenar++;
                Benar.setText(Integer.toString(jumlahBenar));
            }else{
                jumlahSalah++;
                Salah.setText(Integer.toString(jumlahSalah));
            } 
        }else{
            if(answer.getText().toLowerCase().equals(namaArtist.toLowerCase())){
                jumlahBenar++;
                Benar.setText(Integer.toString(jumlahBenar));
            }else{
                jumlahSalah++;
                Salah.setText(Integer.toString(jumlahSalah));
            }
        }
        jumlahSoal++;
        if(jumlahSoal > 0){
            int score =  (jumlahBenar * 10);
            Connect.updateScore(score, "highscore");
        }
    }
    
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
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Benar;
    private javax.swing.JLabel BenarLabel;
    private javax.swing.JLabel BenarLabel1;
    private keeptoo.KGradientPanel Main;
    private javax.swing.JLabel Salah;
    private javax.swing.JLabel SalahLabel;
    private keeptoo.KGradientPanel Start;
    private javax.swing.JTextField answer;
    private javax.swing.JLabel count;
    private keeptoo.KGradientPanel countPanel;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel question;
    private javax.swing.JLabel timer;
    // End of variables declaration//GEN-END:variables
}
