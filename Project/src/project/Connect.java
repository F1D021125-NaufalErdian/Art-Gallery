package project;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connect {

    private static Component rootPane;
    
    public static ArrayList<String> lukisan = new ArrayList<>();
    public static ArrayList<String> patung = new ArrayList<>();
    public static String name, status;
    
    
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/art-Gallery", "root", "");
            return con;
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean LoginConnection(JPasswordField jPasswordField1, JTextField jTextField1){
        try{
            Connection con = getConnection();
            String sqlQuery = "SELECT * FROM account WHERE username = ? AND password = ?";
            char[] Password = jPasswordField1.getPassword();
            String Password1 = new String(Password);
            String Username = jTextField1.getText();
            
            try(PreparedStatement stmt = con.prepareStatement(sqlQuery)){
                stmt.setString(1, Username);
                stmt.setString(2, Password1);
                
                if(Password.length > 0 || Username.length() > 0){
                    try (ResultSet rs = stmt.executeQuery()){
                        if (rs.next()) {
                            String nama = rs.getString("username");
                            name = nama;
                            rs.getString("password");
                            JOptionPane.showMessageDialog(rootPane, "Login Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                            status = rs.getString("status");
                            if(status.equals("user")){
                                HomeFrame home = new HomeFrame();
                                home.setVisible(true);
                                home.getMyButton().setVisible(false);
                            }else{
                                HomeFrame home = new HomeFrame();
                                home.setVisible(true);
                            }
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Login Gagal!", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Isi Field Terlebih Dahulu!", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Koneksi Gagal", "Gagal", JOptionPane.ERROR_MESSAGE);   
        }
        return false;
    }
    
    public static boolean RegisterConnection(JPasswordField jPasswordField1, JPasswordField jPasswordField2, JTextField jTextField1){
        try{
            Connection con = getConnection();
            String nama = jTextField1.getText();
            char[] pass1 = jPasswordField1.getPassword();
            char[] pass2 = jPasswordField2.getPassword();
            String pass1Confirm = new String(pass1);
            String pass2Confirm = new String(pass2);
            String queryCheck = "SELECT username FROM account WHERE username = ?";
            String queryInsert = "INSERT INTO account (username, password, status) VALUES (?, ?, ?)";
            if(!nama.isEmpty() && !pass1Confirm.isEmpty() && !pass2Confirm.isEmpty()){
                try(PreparedStatement stmtCheck = con.prepareStatement(queryCheck)){
                    stmtCheck.setString(1, nama);
                    try(ResultSet rsCheck = stmtCheck.executeQuery()){
                        if(rsCheck.next()){
                            JOptionPane.showMessageDialog(rootPane, "Username telah dipakai", "Gagal", JOptionPane.WARNING_MESSAGE);
                        }else{
                            if(!pass1Confirm.equals(pass2Confirm)){
                                JOptionPane.showMessageDialog(rootPane, "Password tidak sesuai", "Gagal", JOptionPane.WARNING_MESSAGE);
                            }else{
                                try(PreparedStatement stmtInsert = con.prepareStatement(queryInsert)){
                                    stmtInsert.setString(1, nama);
                                    stmtInsert.setString(2, pass1Confirm);
                                    stmtInsert.setString(3, "user");
                                    int inputBerhasil = stmtInsert.executeUpdate();
                                    if(inputBerhasil > 0){
                                        JOptionPane.showMessageDialog(rootPane, "Register Berhasil, kembali ke menu login", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                                        return true;
                                    }else{
                                        JOptionPane.showMessageDialog(rootPane, "Register Gagal", "Gagal", JOptionPane.WARNING_MESSAGE);
                                    }
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Masukan data dengan benar", "Gagal", JOptionPane.WARNING_MESSAGE);                                    
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static void delete(String nama){
        Connection con = getConnection();
        String query = "DELETE FROM art WHERE nama = ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, nama);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Berhasil dihapus.");
            } else {
                System.out.println("Tida ada nama serupa.");
            }
        }catch(Exception e){
            
        }
    }
    
    
    public static void updateScore(int score, String kolom) {
        Connection con = getConnection();
        String selectName = "SELECT " + kolom + " FROM account WHERE username = ?";
        try (PreparedStatement stmt = con.prepareStatement(selectName)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    float highScore = rs.getFloat(kolom);
                    if (score > highScore && score <= 100) {
                        String update = "UPDATE account SET " + kolom + " = ? WHERE username = ?";
                        try (PreparedStatement updateStmt = con.prepareStatement(update)) {
                            updateStmt.setFloat(1, score);
                            updateStmt.setString(2, name);
                            updateStmt.executeUpdate();
                            System.out.println("High Score Updated!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void getAllNames(String jenis){
        Connection con = getConnection();
        String query = "SELECT nama FROM art WHERE jenis = ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, jenis);
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    String nama = rs.getString("nama");
                    if(jenis == "Lukisan"){
                        lukisan.add(nama);
                    }else if(jenis == "Patung"){
                        patung.add(nama);
                    }
                }
            }catch(Exception e){
                
            }
        }catch(Exception e){
            
        }
    }

}

