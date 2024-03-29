package PGSQL;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author GilbertoNeto
 */

public class DataBaseConnection {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/koalareadsdatabase";
    private String usuario = "postgres";
    private String senha = "212002";
    public Connection conn;
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn=DriverManager.getConnection(caminho, usuario,senha);
            //JOptionPane.showMessageDialog(null, "Conectado\nBem-vindo!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão\nErro: " + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro no ExecutaSQL\nErro: " + ex.getMessage());
        }
    }
    
    public void desconexao(){
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Desconectado\nAté Breve!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao encerrar a conexão\nErro: " + ex.getMessage());   
        }   
    }
    
    public Connection conectaBD(){
        Connection conne = null;
        
        try {
            String url = "jdbc:postgresql://localhost:5432/koalareadsdatabase?user=postgres&password=212002";
            conne = DriverManager.getConnection(url);
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "DBC" + erro.getMessage());
        }
        return conne;
    }
    
}