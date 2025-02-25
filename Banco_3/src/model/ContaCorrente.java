package model;

public class ContaCorrente extends Conta {

    public ContaCorrente(String titular, int numconta, double saldo) {
        super(titular, numconta, saldo);
    }

    @Override
    public int getByID(int numconta) {
        numconta = this.getNumconta();
        return super.getByID(numconta);
    }

    @Override
    public String toString() {
        return super.toString();
    } 
    
}
