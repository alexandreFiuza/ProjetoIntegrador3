package negocio;

import entidade.Conta;
import java.sql.SQLException;
import java.util.List;
import persistencia.PConta;


public class NConta {
    
    PConta persistencia;

    public NConta() {
        this.persistencia = new PConta();
    }

    public void salvar(Conta parametro) throws SQLException, Exception {

        if (parametro.getTipo() == 0) {
            throw new Exception("É necessário informar o tipo da conta!");
        }
        if (parametro.getIdentificadorCliente() == 0) {
            throw new Exception("É necessário informar o identificador do cliente!");
        }
        if (parametro.getNomeCliente().isEmpty()) {
            throw new Exception("É necessário informar o nome do cliente!");
        }
        
        if (parametro.getIdentificador() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
        
    }

    public Conta consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Conta> listar() throws SQLException {
        return persistencia.listar();
    }
    
}
