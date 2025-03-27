
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public boolean cadastrarProduto(ProdutosDTO produto) throws SQLException {
        try {
            conectaDAO conexao = new conectaDAO();
            conexao.conectar();
            
            String sql = "INSERT INTO produtosDTOO(id, nome, valor, status) VALUES(?, ?, ?, ?);"; 
            //Usar a String e transformar em SQL usando Prepared Statement
            PreparedStatement query = conexao.connectDB().prepareStatement(sql);
            /*query.setString(1, produto.getId(Integer.setInt(Id)));
            query.setString(2, produto.getNome());
            query.setString(3, produto.getValor(Integer.setInt(valor)));
            query.setString(4, produto.getStatus());
            */
            query.setInt(1, produto.getId());
            query.setString(2, produto.getNome());
            query.setInt(3, produto.getValor());
            query.setString(4, produto.getStatus());
            query.execute();
            
            //desconectar do banco
            
            conexao.desconectar();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: "+e.getMessage());
            return false;
        }

        //conn = new conectaDAO().connectDB();
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
