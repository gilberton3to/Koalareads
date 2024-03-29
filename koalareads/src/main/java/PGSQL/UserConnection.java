package PGSQL;

import KR.Acesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author GilbertoNeto
 */
public class UserConnection {

    Connection conn;

    public ResultSet autenticacaoUsuario(Acesso objacesso) {
        conn = new DataBaseConnection().conectaBD();

        try {
            String sql = "select * from admins where login_admins = ? and senha_admins = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objacesso.getLogin_admins());
            pstm.setString(2, objacesso.getSenha_admins());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no Acesso" + erro);
            return null;
        }
    }

}
