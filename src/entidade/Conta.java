package entidade;


public class Conta {
    
    private int identificador;
    private String nomeCliente;
    private int identificadorCliente;
    private int tipo;
    private double saldo;
    
    public Conta(int identificador, int tipo, double saldo, int identificadorCliente, String nomeCliente) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.saldo = saldo;
        this.identificadorCliente = identificadorCliente;
        this.nomeCliente = nomeCliente;
    }
    
    public Conta() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdentificadorCliente() {
        return identificadorCliente;
    }

    public void setIdentificadorCliente(int identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
