package negocio;

import entidade.Agencia;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAgencia;

public class NAgencia {
    
    PAgencia persistencia;

    public NAgencia() {
        this.persistencia = new PAgencia();
    }

    public void salvar(Agencia parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar o nome da agência!");
        }
        if (parametro.getCnpj() == 0) {
            throw new Exception("É necessário informar o CNPJ da agência!");
        }
        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("É necessário informar o endereço da agência!");
        }
        if (parametro.getTelefone() == 0) {
            throw new Exception("É necessário informar o telefone da agência!");
        }
        
        
        if (parametro.getIdentificador()== 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
        
    }

    public Agencia consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Agencia> listar() throws SQLException {
        return persistencia.listar();
    }
}

    
    

