package persistencia;

import entidade.Agencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PAgencia{
    
    Connection cnn = util.Conexao.getConexao();

    public void incluir(Agencia parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO agencia (nome, cnpj, endereco, telefone) "
                + " VALUES (?,?,?,?)";

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());
        prd.setInt(2, parametro.getCnpj());
        prd.setString(3, parametro.getEndereco());
        prd.setInt(4, parametro.getTelefone());

        prd.execute();
        cnn.close();
    }

    public void alterar(Agencia parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE agencia SET"
                    + " nome = ?,"
                    + " cnpj = ?,"
                    + " endereco = ?,"
                    + " telefone = ?"
                    + " WHERE identificador = ?";

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setString(1, parametro.getNome());
            prd.setInt(2, parametro.getCnpj());
            prd.setString(3, parametro.getEndereco());
            prd.setInt(4, parametro.getTelefone());
            prd.setInt(5, parametro.getIdentificador());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Agencia consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome, cnpj, endereco, telefone"
                + " FROM agencia WHERE identificador = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Agencia retorno = new Agencia();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setCnpj(rs.getInt("cnpj"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getInt("telefone"));
        }
        return retorno;
    }

    public List<Agencia> listar() throws SQLException {

        String sql = "SELECT * FROM agencia";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Agencia> retorno = new ArrayList<>();

        while (rs.next()) {
            
            Agencia agencia = new Agencia();

            agencia.setIdentificador(rs.getInt("identificador"));
            agencia.setNome(rs.getString("nome"));
            agencia.setCnpj(rs.getInt("cnpj"));
            agencia.setEndereco(rs.getString("endereco"));
            agencia.setTelefone(rs.getInt("telefone"));

            retorno.add(agencia);
        }
        return retorno;
    }
    
    
}
