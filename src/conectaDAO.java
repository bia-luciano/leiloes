
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {
    private Connection conexao;
       
    public Connection connectDB(){
        return conexao;
    }
        

    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=alessiA22!");
            System.out.println("SUCESSO DE CONEXÃO");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar a classe de conexão!");//erro de java
        } catch (SQLException ex) {
            System.out.println("Falha ao conectar com o banco! Erro de SQL");//erro de sql

        }
    }

    public void desconectar() {
        try {
            if (conexao != null && conexao.isClosed()) {
                conexao.close();
                System.out.println("DESCONECTADO COM SUCESSO.");
            }
        } catch (SQLException e){
            System.out.println("Erro ao desconectar.");

            }
        }
    }


