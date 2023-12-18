package project;

import java.awt.CardLayout;
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
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new keeptoo.KGradientPanel();
        countPanel = new keeptoo.KGradientPanel();
        count = new javax.swing.JLabel();
        Start = new keeptoo.KGradientPanel();
        panel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        BenarLabel = new javax.swing.JLabel();
        SalahLabel = new javax.swing.JLabel();
        Benar = new javax.swing.JLabel();
        Salah = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(912, 504));

        Main.setLayout(new java.awt.CardLayout());

        countPanel.setPreferredSize(new java.awt.Dimension(912, 504));

        count.setFont(new java.awt.Font("Times New Roman", 1, 100)); // NOI18N
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout countPanelLayout = new javax.swing.GroupLayout(countPanel);
        countPanel.setLayout(countPanelLayout);
        countPanelLayout.setHorizontalGroup(
            countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countPanelLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        countPanelLayout.setVerticalGroup(
            countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Main.add(countPanel, "card2");

        Start.setkEndColor(new java.awt.Color(0, 255, 204));
        Start.setPreferredSize(new java.awt.Dimension(912, 504));

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

        question.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(0, 0, 0));
        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("Apa nama dari karya di atas?");

        answer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        answer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        answer.setBorder(null);
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });

        BenarLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BenarLabel.setForeground(new java.awt.Color(0, 0, 0));
        BenarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BenarLabel.setText("Benar :");

        SalahLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SalahLabel.setForeground(new java.awt.Color(0, 0, 0));
        SalahLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SalahLabel.setText("Salah :");

        Benar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Benar.setForeground(new java.awt.Color(0, 0, 0));
        Benar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Salah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Salah.setForeground(new java.awt.Color(0, 0, 0));
        Salah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer.setText("jLabel1");

        javax.swing.GroupLayout StartLayout = new javax.swing.GroupLayout(Start);
        Start.setLayout(StartLayout);
        StartLayout.setHorizontalGroup(
            StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addGroup(StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(answer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(StartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StartLayout.createSequentialGroup()
                        .addComponent(SalahLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Salah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StartLayout.createSequentialGroup()
                        .addComponent(BenarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Benar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(206, 206, 206)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        StartLayout.setVerticalGroup(
            StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StartLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BenarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Benar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SalahLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Salah, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

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
    private keeptoo.KGradientPanel Main;
    private javax.swing.JLabel Salah;
    private javax.swing.JLabel SalahLabel;
    private keeptoo.KGradientPanel Start;
    private javax.swing.JTextField answer;
    private javax.swing.JLabel count;
    private keeptoo.KGradientPanel countPanel;
    private javax.swing.JLabel image;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel question;
    private javax.swing.JLabel timer;
    // End of variables declaration//GEN-END:variables
}
