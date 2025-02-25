package model;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome, String cpf, ContaCorrente contaCorrente, ContaPoupanca contaPoupanca ){
        this.nome = nome;
        this.cpf = cpf;
        this.contaCorrente = contaCorrente;
        this.contaPoupanca = contaPoupanca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    @Override
    public String toString() {
        return "\n------------------------" + "\nCliente: " + nome + "\nCpf: " + cpf + "\n" +
        "\nContaCorrente: " + contaCorrente + "\n" + "\nContaPoupanca: " + contaPoupanca; }
}
