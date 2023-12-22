package Game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import project.Connect;
import project.HomeFrame;
import project.Interface;


public class Main extends JFrame implements Runnable, Interface{
    private Thread animationThread, countdownThread;
    private boolean stop, tambah;
    public int score = 0;
    ArrayList<String> enemy = new <String>ArrayList();
    private int initialX = 790;
    private int initialY = 230; 
    private Timer pauseTimer;
    private int kecepatan = 20;
    
    public Main() {
        initComponents();

        enemy.add("D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\component\\pisa.png");
        enemy.add("D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\component\\liberty-removebg-preview.png");
        enemy.add("D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\component\\Guangzhou-removebg-preview.png");
        
        animationThread = new Thread(this);
        animationThread.start();
        
        jLabel2.addKeyListener(new JumpKeyListener());
        jLabel2.setFocusable(true);
        
        this.setPreferredSize(new Dimension(jLabel1.getWidth(), jLabel1.getHeight()));
        Random random = new Random();
        
        int index = random.nextInt(enemy.size());
        jLabel4.setIcon(new ImageIcon(enemy.get(index)));
        
        this.setLocationRelativeTo(null);
        jLabel3.setText("Score : " + score);

    }
    
    public void run() {
        while (true) {
            if (!stop) {
                moveJLabel4();
                check();
                updateScore();
            }
            try {
                Thread.sleep(kecepatan);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private class JumpKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                int currentY = jLabel2.getY();
                jLabel2.setLocation(jLabel2.getX(), currentY - 70);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           pauseTimer = new Timer(700, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    int initialY = 190;
                    jLabel2.setLocation(jLabel2.getX(), initialY);
                    pauseTimer.stop();
                }
            });
            pauseTimer.setRepeats(false); 
            pauseTimer.start();
        }
    }
    
    @Override
    public void check(){
        if(jLabel2.getBounds().intersects(jLabel4.getBounds())){
            stop = true;
            System.out.print("Stop");
            int option = JOptionPane.showConfirmDialog(this, "Game Over! Main lagi?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                restartGame();
            } else {
                HomeFrame home = new HomeFrame();
                if(Connect.status.equals("user")){
                    home.getMyButton().setVisible(false);
                }
                home.setVisible(true);
            }
        }
    }
    
    
    private void restartGame() {
        stop = false;
        jLabel3.setText("Score : " + score);
        tambah = false;

        jLabel2.setLocation(20, 190);
        Random random = new Random();
        int index = random.nextInt(enemy.size());
        jLabel4.setIcon(new ImageIcon(enemy.get(index)));
        jLabel4.setLocation(740,230);
    }
    
    private void moveJLabel4() {
        int currentX = jLabel4.getX();
        int newX = currentX - 5;
        
        if (newX + jLabel4.getWidth() < 0) {
            Random random = new Random();
            int index = random.nextInt(enemy.size());
            jLabel4.setIcon(new ImageIcon(enemy.get(index)));
            newX = getWidth();
            kecepatan -= 0.001;
            tambah = true;
        }
        jLabel4.setLocation(newX, jLabel4.getY());
    }
    
    public void updateScore(){
        if(tambah){
            score += 10;
            jLabel3.setText("Score : " + score);
            Connect.updateScore(score, "score");
            tambah = false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(790, 300));
        setPreferredSize(new java.awt.Dimension(790, 335));
        setSize(new java.awt.Dimension(790, 300));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 120, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 30, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/cat-run.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Furwind_-Adventure-Platformer_-Avaliable-on-steam-and-itch.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
