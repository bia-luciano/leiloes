
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    public Connection connectDB(){
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");  
        conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=alessiA22!&useSSL=false");
    } catch (ClassNotFoundException | SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
    }
    return conn;
}

    
}
