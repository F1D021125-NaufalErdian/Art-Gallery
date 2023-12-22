package project;

import java.sql.Connection;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Game.Main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HomeFrame extends javax.swing.JFrame {
    public static int panelCount = 1;
    int height = 321;
    ArrayList<String> lukisan = Connect.lukisan;
    ArrayList<String> patung = Connect.patung;
    CardLayout cardLayout;
    ImageIcon selectedImageIcon;
    String image;
    private Clip clip, sound;
    
    public HomeFrame() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(51,51,51));
        setVisible(true);
        
        welcome.setText("Welcome, " + Connect.name);
        
        artPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30,20));
        artPanel.setPreferredSize(new Dimension(570, height));
        artPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 30,20));
        artPanel1.setPreferredSize(new Dimension(570, height));
        
        Main.add(HomePanel, "Home");
        Main.add(Lukisan, "Lukisan");
        Main.add(Patung, "Patung");
        Main.add(Quiz, "Quiz");
        Main.add(Admin, "Admin");
        
        cardLayout = (CardLayout)(Main.getLayout());
        getName("Lukisan", lukisan, artPanel);
        getName("Patung", patung, artPanel1);
        pack();
              
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        artPanel.setBackground(Color.DARK_GRAY);
        artPanel1.setBackground(Color.DARK_GRAY);
                
        jPanel1.setBackground(Color.decode("#002147"));
        
        mouseEnter(Art);
        mouseEnter(Game);
        mouseEnter(admin);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioLukisan);
        group.add(radioPatung);
        
        for(int i = 0; i < lukisan.size(); i++){
            list.addItem(lukisan.get(i));
        }

        for(int i = 0; i < patung.size(); i++){
            list.addItem(patung.get(i));
        }
        
        deskripsi.setLineWrap(true);
        deskripsi.setWrapStyleWord(true);

        playAudio("D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\component\\quiz.wav", clip);
    }
    
    private void playAudio(String filePath, Clip clip) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public void delete(String Delete){
        Connect.delete(Delete); 
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
            height += 270 + 15;
            panel.setPreferredSize(new Dimension(596, height));
        }
    }
    
    public void mouseEnter(JButton button){
        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                button.setFont(button.getFont().deriveFont(Font.BOLD));
            }
            @Override
            public void mouseExited(MouseEvent e){
                button.setFont(button.getFont().deriveFont(Font.PLAIN));
            }
        });
    }
    
    private ImageIcon selectImage() {
        JFileChooser fileChooser = new JFileChooser(new File("D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\Karya"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return new ImageIcon(selectedFile.getAbsolutePath());
        } else {
            return null;
        }
    }

    public JButton getMyButton(){
        return admin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        HomePanel = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        admin = new javax.swing.JButton();
        Art = new javax.swing.JButton();
        Game = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        Game1 = new javax.swing.JButton();
        Art1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Lukisan = new keeptoo.KGradientPanel();
        scrollPanel = new javax.swing.JScrollPane();
        artPanel = new javax.swing.JPanel();
        Filter = new javax.swing.JButton();
        filterList = new javax.swing.JComboBox<>();
        backLukisan = new javax.swing.JLabel();
        Patung = new keeptoo.KGradientPanel();
        Filter1 = new javax.swing.JButton();
        filterList1 = new javax.swing.JComboBox<>();
        scrollPanel1 = new javax.swing.JScrollPane();
        artPanel1 = new javax.swing.JPanel();
        backPatung = new javax.swing.JLabel();
        Quiz = new keeptoo.KGradientPanel();
        startButton = new javax.swing.JButton();
        backQuiz = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Admin = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nomor = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        artist = new javax.swing.JTextField();
        tahun = new javax.swing.JTextField();
        chooseImage = new javax.swing.JButton();
        radioLukisan = new javax.swing.JRadioButton();
        radioPatung = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        list = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));
        setResizable(false);

        Main.setBackground(new java.awt.Color(51, 51, 51));
        Main.setForeground(new java.awt.Color(102, 102, 102));
        Main.setLayout(new java.awt.CardLayout());

        HomePanel.setkEndColor(new java.awt.Color(51, 51, 51));
        HomePanel.setkStartColor(new java.awt.Color(51, 102, 255));
        HomePanel.setMinimumSize(new java.awt.Dimension(1025, 486));
        HomePanel.setOpaque(false);
        HomePanel.setPreferredSize(new java.awt.Dimension(1025, 486));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 72, 111, 25));

        admin.setBackground(new java.awt.Color(153, 153, 153));
        admin.setForeground(new java.awt.Color(0, 0, 0));
        admin.setText("Admin");
        admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 301, 180, 30));

        Art.setBackground(new java.awt.Color(153, 153, 153));
        Art.setForeground(new java.awt.Color(0, 0, 0));
        Art.setText("Art");
        Art.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtActionPerformed(evt);
            }
        });
        jPanel1.add(Art, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 109, 180, 30));

        Game.setBackground(new java.awt.Color(153, 153, 153));
        Game.setForeground(new java.awt.Color(0, 0, 0));
        Game.setText("Quiz");
        Game.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameActionPerformed(evt);
            }
        });
        jPanel1.add(Game, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 205, 180, 30));

        Quit.setBackground(new java.awt.Color(153, 153, 153));
        Quit.setForeground(new java.awt.Color(0, 0, 0));
        Quit.setText("Quit");
        Quit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        jPanel1.add(Quit, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 349, 180, 30));

        Game1.setBackground(new java.awt.Color(153, 153, 153));
        Game1.setForeground(new java.awt.Color(0, 0, 0));
        Game1.setText("Game");
        Game1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Game1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Game1ActionPerformed(evt);
            }
        });
        jPanel1.add(Game1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 253, 180, 30));

        Art1.setBackground(new java.awt.Color(153, 153, 153));
        Art1.setForeground(new java.awt.Color(0, 0, 0));
        Art1.setText("Leaderboard");
        Art1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Art1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Art1ActionPerformed(evt);
            }
        });
        jPanel1.add(Art1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 157, 180, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ART GALLERY");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 6, 216, 60));

        HomePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 320, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/gifgit (1).gif"))); // NOI18N
        HomePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 480));

        Main.add(HomePanel, "card7");

        Lukisan.setkEndColor(new java.awt.Color(0, 51, 255));
        Lukisan.setkStartColor(new java.awt.Color(102, 204, 255));

        scrollPanel.setForeground(new java.awt.Color(102, 102, 102));
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        artPanel.setForeground(new java.awt.Color(102, 102, 102));

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

        Filter.setBackground(new java.awt.Color(255, 255, 255));
        Filter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Filter.setForeground(new java.awt.Color(0, 0, 0));
        Filter.setText("Filter");
        Filter.setBorder(null);
        Filter.setContentAreaFilled(false);
        Filter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

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

        backLukisan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        backLukisan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLukisan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLukisanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LukisanLayout = new javax.swing.GroupLayout(Lukisan);
        Lukisan.setLayout(LukisanLayout);
        LukisanLayout.setHorizontalGroup(
            LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LukisanLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(LukisanLayout.createSequentialGroup()
                        .addComponent(backLukisan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filter)
                        .addGap(18, 18, 18)
                        .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        LukisanLayout.setVerticalGroup(
            LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LukisanLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Filter))
                    .addComponent(backLukisan))
                .addGap(18, 18, 18)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        Main.add(Lukisan, "card2");

        Patung.setkEndColor(new java.awt.Color(0, 51, 255));
        Patung.setkStartColor(new java.awt.Color(51, 204, 255));

        Filter1.setBackground(new java.awt.Color(255, 255, 255));
        Filter1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Filter1.setForeground(new java.awt.Color(0, 0, 0));
        Filter1.setText("Filter");
        Filter1.setBorder(null);
        Filter1.setContentAreaFilled(false);
        Filter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Filter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter1ActionPerformed(evt);
            }
        });

        filterList1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lukisan", "Patung", "Sastra", "Musik" }));
        filterList1.setFocusable(false);
        filterList1.setLightWeightPopupEnabled(false);
        filterList1.setRequestFocusEnabled(false);
        filterList1.setVerifyInputWhenFocusTarget(false);
        filterList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterList1ActionPerformed(evt);
            }
        });

        scrollPanel1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout artPanel1Layout = new javax.swing.GroupLayout(artPanel1);
        artPanel1.setLayout(artPanel1Layout);
        artPanel1Layout.setHorizontalGroup(
            artPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
        );
        artPanel1Layout.setVerticalGroup(
            artPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );

        scrollPanel1.setViewportView(artPanel1);

        backPatung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        backPatung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backPatung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backPatungMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PatungLayout = new javax.swing.GroupLayout(Patung);
        Patung.setLayout(PatungLayout);
        PatungLayout.setHorizontalGroup(
            PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatungLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PatungLayout.createSequentialGroup()
                        .addComponent(backPatung, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filter1)
                        .addGap(18, 18, 18)
                        .addComponent(filterList1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        PatungLayout.setVerticalGroup(
            PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatungLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backPatung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Filter1)))
                .addGap(26, 26, 26)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        Main.add(Patung, "card2");

        Quiz.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startButton.setText("Start");
        startButton.setBorderPainted(false);
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        Quiz.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 120, 36));

        backQuiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        backQuiz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backQuizMouseClicked(evt);
            }
        });
        Quiz.add(backQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 34, 20, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("4. Hanya terdapat 3 jenis pertanyaan dengan karya yang berbeda-beda");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("2. Score akan bertambah sejumlah 10 untuk setiap jawwaban yang benar");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("1. Score pada quiz ini dapat dilihat pada Leaderboard");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("3. Maksimal nilai score yang diperoleh yaitu 100 dengan jumlah pengerjaan soal yang tak terbatas");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("6. Jawaban dapat diketikan pada textfield yang tersedia");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("5. Waktu pengerjaan hanya 1 menit");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("7. Tekan tombol ENTER untuk input jawaban");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel3)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel4)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel5)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel6)
                    .addGap(5, 5, 5)
                    .addComponent(jLabel7)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Quiz.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 820, 280));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Ketentuan");
        Quiz.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 260, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Minimal Japan [5120x3840].jpeg"))); // NOI18N
        Quiz.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 490));

        Main.add(Quiz, "card7");

        Admin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Admin.setkEndColor(new java.awt.Color(0, 204, 204));
        Admin.setkStartColor(new java.awt.Color(153, 153, 255));
        Admin.setPreferredSize(new java.awt.Dimension(1027, 486));
        Admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Masukan Karya");
        Admin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nomor Karya :");
        Admin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 129, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nama Artist : ");
        Admin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 209, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tahun Karya : ");
        Admin.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 249, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Gambar Karya : ");
        Admin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 289, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Nama Karya : ");
        Admin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 169, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Deskripsi Karya :");
        Admin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 129, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Jenis Karya : ");
        Admin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 327, -1, -1));
        Admin.add(nomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 124, 191, -1));
        Admin.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 164, 191, -1));
        Admin.add(artist, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 204, 191, -1));
        Admin.add(tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 244, 191, -1));

        chooseImage.setText("Image");
        chooseImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageActionPerformed(evt);
            }
        });
        Admin.add(chooseImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 284, -1, -1));

        radioLukisan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        radioLukisan.setForeground(new java.awt.Color(0, 0, 0));
        radioLukisan.setText("Lukisan");
        radioLukisan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Admin.add(radioLukisan, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 325, -1, -1));

        radioPatung.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        radioPatung.setForeground(new java.awt.Color(0, 0, 0));
        radioPatung.setText("Patung");
        radioPatung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Admin.add(radioPatung, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 325, -1, -1));

        deskripsi.setColumns(20);
        deskripsi.setRows(5);
        jScrollPane2.setViewportView(deskripsi);

        Admin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 122, 350, 181));

        submit.setText("SUBMIT");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        Admin.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 321, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        Admin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 16, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Hapus Karya");
        Admin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, 40));

        Admin.add(list, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 435, 139, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Nama Karya : ");
        Admin.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 440, -1, -1));

        jButton2.setText("Hapus");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Admin.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 435, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        Admin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 960, 270));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Admin.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 960, 50));

        Main.add(Admin, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
       Quiz quiz =  new Quiz();
       quiz.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_startButtonMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String jenis;
        if(radioLukisan.isSelected()){
            jenis = "Lukisan";
        }else{
            jenis = "Patung";
        }
        Input input = new Input(nomor, nama, artist, tahun, image, jenis, deskripsi);
        input.input();
        nomor.setText("");
        nama.setText("");
        artist.setText("");
        tahun.setText("");
        deskripsi.setText("");
        radioLukisan.setSelected(false); 
        image = "";
    }//GEN-LAST:event_submitActionPerformed

    private void chooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageActionPerformed
        selectedImageIcon = selectImage();
        chooseImage.setText(nama.getText());
        image = selectedImageIcon.getDescription();
    }//GEN-LAST:event_chooseImageActionPerformed

    private void filterList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterList1ActionPerformed
    }//GEN-LAST:event_filterList1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nama = (String) list.getSelectedItem();
        delete(nama);
        System.out.print(nama);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_jLabel19MouseClicked

    private void Filter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter1ActionPerformed
        int index = filterList1.getSelectedIndex();

        switch(index){
            case 0 :
            cardLayout.show(Main, "Lukisan");
            break;
            case 1 :
            cardLayout.show(Main, "Patung");
        }
    }//GEN-LAST:event_Filter1ActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        int index = filterList.getSelectedIndex();

        switch(index){
            case 0 :
            cardLayout.show(Main, "Lukisan");
            break;
            case 1 :
            cardLayout.show(Main, "Patung");
        }
    }//GEN-LAST:event_FilterActionPerformed

    private void filterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterListActionPerformed

    private void backPatungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPatungMouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_backPatungMouseClicked

    private void backLukisanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLukisanMouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_backLukisanMouseClicked

    private void backQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backQuizMouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_backQuizMouseClicked

    private void Game1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Game1ActionPerformed
        try {
            this.setVisible(false);
            Main main = new Main();
            main.setVisible(true);
        } catch (MalformedURLException ex) {
            
        }
    }//GEN-LAST:event_Game1ActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        this.dispose();
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        WelcomeFrame Login = new WelcomeFrame();
        Login.setVisible(true);
        Login.setLocationRelativeTo(null);
    }//GEN-LAST:event_QuitActionPerformed

    private void GameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameActionPerformed
        cardLayout.show(Main, "Quiz");
    }//GEN-LAST:event_GameActionPerformed

    private void ArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtActionPerformed
        cardLayout.show(Main, "Lukisan");
    }//GEN-LAST:event_ArtActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        cardLayout.show(Main, "Admin");
    }//GEN-LAST:event_adminActionPerformed

    private void Art1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Art1ActionPerformed
        Connection con = Connect.getConnection();
        Leaderboard leaderBoard = new Leaderboard();
        while (Leaderboard.listModel.isEmpty()) {
            String sqlLeader = "SELECT * FROM account ORDER BY highscore DESC";
            try (PreparedStatement stmt = con.prepareStatement(sqlLeader)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    int i = 1;
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String highscore = rs.getString("highscore");
                        String score = rs.getString("score");
                        Leaderboard.listModel.addElement(i + ". " + username + " => " + "Quiz = " + highscore + " & Game = " + score);
                        i++;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        leaderBoard.setVisible(true);
    }//GEN-LAST:event_Art1ActionPerformed

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
    private keeptoo.KGradientPanel Admin;
    private javax.swing.JButton Art;
    private javax.swing.JButton Art1;
    private javax.swing.JButton Filter;
    private javax.swing.JButton Filter1;
    private javax.swing.JButton Game;
    private javax.swing.JButton Game1;
    private keeptoo.KGradientPanel HomePanel;
    private keeptoo.KGradientPanel Lukisan;
    private javax.swing.JPanel Main;
    private keeptoo.KGradientPanel Patung;
    private javax.swing.JButton Quit;
    private keeptoo.KGradientPanel Quiz;
    private javax.swing.JButton admin;
    private javax.swing.JPanel artPanel;
    private javax.swing.JPanel artPanel1;
    private javax.swing.JTextField artist;
    private javax.swing.JLabel backLukisan;
    private javax.swing.JLabel backPatung;
    private javax.swing.JLabel backQuiz;
    private javax.swing.JButton chooseImage;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JComboBox<String> filterList;
    private javax.swing.JComboBox<String> filterList1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> list;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomor;
    private javax.swing.JRadioButton radioLukisan;
    private javax.swing.JRadioButton radioPatung;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JScrollPane scrollPanel1;
    private javax.swing.JButton startButton;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tahun;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
