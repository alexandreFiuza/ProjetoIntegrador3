package persistencia;

import entidade.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PConta {

    Connection cnn = util.Conexao.getConexao();

    public void incluir(Conta parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO conta (tipo, nomecliente, identificadorcliente, saldo) "
                + " VALUES (?,?,?,?)";

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro.getTipo());
        prd.setString(2, parametro.getNomeCliente());
        prd.setInt(3, parametro.getIdentificadorCliente());
        prd.setDouble(4, parametro.getSaldo());

        prd.execute();
        cnn.close();
    }

    public void alterar(Conta parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE conta SET"
                    + " tipo = ?,"
                    + " nomecliente = ?,"
                    + " identificadorcliente = ?,"
                    + " saldo = ?"
                    + " WHERE identificador = ?";

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setInt(1, parametro.getTipo());
            prd.setString(2, parametro.getNomeCliente());
            prd.setInt(3, parametro.getIdentificadorCliente());
            prd.setDouble(4, parametro.getSaldo());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Conta consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, tipo, nomecliente, identificadorcliente, saldo"
                + " FROM conta WHERE identificador = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Conta retorno = new Conta();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setTipo(rs.getInt("tipo"));
            retorno.setNomeCliente(rs.getString("nomecliente"));
            retorno.setIdentificadorCliente(rs.getInt("identificadorcliente"));
            retorno.setSaldo(rs.getDouble("saldo"));
        }
        return retorno;
    }

    public List<Conta> listar() throws SQLException {

        String sql = "SELECT * FROM conta";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Conta> retorno = new ArrayList<>();

        while (rs.next()) {

            Conta conta = new Conta();

            conta.setIdentificador(rs.getInt("identificador"));
            conta.setTipo(rs.getInt("tipo"));
            conta.setNomeCliente(rs.getString("nomecliente"));
            conta.setIdentificadorCliente(rs.getInt("identificadorcliente"));
            conta.setSaldo(rs.getDouble("saldo"));

            retorno.add(conta);
        }
        return retorno;
    }
}
