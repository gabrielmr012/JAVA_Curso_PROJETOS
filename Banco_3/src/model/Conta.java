package model;


public abstract class Conta {
    private String titular;
    private int numconta;
    private double saldo;

// determina que as variáveis dessa classe sejam as msm dos parametros do método
    public Conta (String titular, int numconta, double saldo){
        this.titular = titular;
        this.numconta = numconta;
        this.saldo = saldo;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumconta(int numconta) {
        this.numconta = numconta;
    }

    public int getNumconta() {
        return numconta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public int gerarNumConta(int numconta){
        numconta = (int)(Math.random() * 9000) + 1000;
        return numconta;
    }

    public int getByID(int numconta){
        numconta = this.numconta;
        return numconta;
    }

    @Override
    public String toString() {
        return "\nTitular: " + getTitular() + 
        "\nNumero da Conta: " + getNumconta() + "\nSaldo: " + getSaldo();
    }  
}
