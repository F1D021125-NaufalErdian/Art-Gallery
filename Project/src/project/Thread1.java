package project;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Thread1 extends Thread{
    JLabel label;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    int count, benar, salah;
    private Quiz quiz;

    public Thread1(JLabel label, JPanel cardPanel, CardLayout cardLayout, int count, int benar, int salah, Quiz quiz) {
        this.label = label;
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.count = count;
        this.benar = benar;
        this.salah = salah;
        this.quiz = quiz;
    }

    @Override
    public void run() {
        try {
            while (count >= 0) {
                if(cardPanel == null){
                    label.setText("00 : " + Integer.toString(count));
                }else{
                    label.setText(Integer.toString(count));
                }
                Thread.sleep(1000);
                count--;
            }
            if(cardPanel != null){
                cardLayout.show(cardPanel, "Start");
            }else{
                String message = String.format("Skor Anda:\nBenar: %d\nSalah: %d", Quiz.jumlahBenar, Quiz.jumlahSalah);
                JOptionPane.showMessageDialog(cardPanel, message, "Informasi Skor", JOptionPane.INFORMATION_MESSAGE);
            }
            if(quiz != null){
                quiz.dispose();
                HomeFrame home = new HomeFrame();
                if(Connect.status.equals("user")){
                    home.getMyButton().setVisible(false);
                }
                home.setVisible(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
