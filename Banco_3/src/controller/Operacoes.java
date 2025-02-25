package controller;

import java.util.Scanner;
import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Operacoes {
    Scanner scan = new Scanner(System.in);

    public Cliente criarCliente() {
        System.out.println("Nome do Titular: ");
        String nome = scan.nextLine();
        System.out.println("Cpf: ");
        String cpf = scan.nextLine();
        Cliente cliente = new Cliente(nome, cpf, null, null);
        ContaCorrente contaCorrente = criarContaCorrente();
        ContaPoupanca contaPoupanca = criarContaPoupanca();
        contaCorrente.setTitular(nome);
        contaPoupanca.setTitular(nome);
        cliente.setContaCorrente(contaCorrente);
        cliente.setContaPoupanca(contaPoupanca);
        Banco.listaClientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        return cliente;
    }

    public int gerarNumConta(int numconta) {
        numconta = (int) (Math.random() * 9000) + 1000;
        return numconta;
    }

    public ContaCorrente criarContaCorrente() {
        int numconta = gerarNumConta(0);
        double saldo = 0.0;
        ContaCorrente contaCorrente = new ContaCorrente(null, numconta, saldo);
        Banco.listaContaCorrente.add(contaCorrente);
        return contaCorrente;
    }

    public ContaPoupanca criarContaPoupanca() {
        int numconta = gerarNumConta(0);
        double saldo = 0.0;
        ContaPoupanca contaPoupanca = new ContaPoupanca(null, numconta, saldo);
        Banco.listaContaPoupanca.add(contaPoupanca);
        return contaPoupanca;
    }

    public void depositar(int numconta, double valorDepositado) {
        String menu = """
                Escolha em qual conta deseja depositar:
                [1] - Conta Corrente
                [2] - Conta Poupança
                """;
        System.out.println(menu);
        int opcao = scan.nextInt();
        if (opcao == 1) {
            System.out.println("Digite o número da conta: ");
            numconta = scan.nextInt();
            for (ContaCorrente conta : Banco.listaContaCorrente) {
                if (numconta == conta.getNumconta()) {
                    System.out.println("Digite o valor a ser depositado: ");
                    valorDepositado = scan.nextDouble();
                    conta.setSaldo(conta.getSaldo() + valorDepositado);
                    System.out.println("Depósito realizado com sucesso!");
                } 
            }
        } else if (opcao == 2) {
            System.out.println("Digite o número da conta: ");
            numconta = scan.nextInt();
            for (ContaPoupanca contaP : Banco.listaContaPoupanca) {
                if (numconta == contaP.getNumconta()) {
                    System.out.println("Digite o valor a ser depositado: ");
                    valorDepositado = scan.nextDouble();
                    contaP.setSaldo(contaP.getSaldo() + valorDepositado);
                    System.out.println("Depósito realizado com sucesso!");
                } else {
                    System.out.println("Conta não encontrada!");
                }
            }
        }

    }

    public void sacar(int numconta, double valorSaque) {
        System.out.println("Digite o número da conta: ");
        numconta = scan.nextInt();
        for (ContaCorrente conta : Banco.listaContaCorrente) {
            if (numconta == conta.getNumconta()) {
                System.out.println("Digite o valor do Saque: ");
                valorSaque = scan.nextDouble();

                if (valorSaque <= conta.getSaldo()) {
                    conta.setSaldo(conta.getSaldo() - valorSaque);
                    System.out.println("Saque Realizado com Sucesso! -> ");
                    System.out.println("Saldo Atual: " + conta.getSaldo());
                } else {
                    System.out.println("Saldo Insuficiente!");
                }

            } else {
                System.out.println("Conta não encontrada!");
            }
        }
    }

    public void transferir() {
        String menu = """
                Qual o seu tipo de Conta?
                [1] - Conta Corrente
                [2] - Conta Poupança
                """;
        int numcontaOrigem;
        int numcontaDestino;
        double valorTransferir;
        System.out.println(menu);
        int opcao = scan.nextInt();

        if (opcao == 1) {
            System.out.println("Digite o número da sua conta: ");
            numcontaOrigem = scan.nextInt();
            for (ContaCorrente contaOrigem : Banco.listaContaCorrente) {
                if (numcontaOrigem == contaOrigem.getNumconta()) {
                    System.out.println("\nPara qual Conta Deseja enviar ?");
                    numcontaDestino = scan.nextInt();
                    for (ContaCorrente contaDestino : Banco.listaContaCorrente) {
                        if (numcontaDestino == contaDestino.getNumconta()) {
                            System.out.println("Digite o valor a ser transferido: ");
                            valorTransferir = scan.nextInt();
                            if (valorTransferir <= contaOrigem.getSaldo()) {
                                contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransferir);
                                contaDestino.setSaldo(valorTransferir);
                                System.out.println("Transferência Realizada com Sucesso!");
                            } else {
                                System.out.println("Saldo Insuficiente!");
                            }
                        }
                    }
                }
            }
        }

        if (opcao == 2) {
            System.out.println("Digite o número da sua conta: ");
            numcontaOrigem = scan.nextInt();
            for (ContaCorrente contaOrigem : Banco.listaContaCorrente) {
                if (numcontaOrigem == contaOrigem.getNumconta()) {
                    System.out.println("\nPara qual Conta Deseja enviar ?");
                    numcontaDestino = scan.nextInt();
                    for (ContaPoupanca contaDestino : Banco.listaContaPoupanca) {
                        if (numcontaDestino == contaDestino.getNumconta()) {
                            System.out.println("Digite o valor a ser transferido: ");
                            valorTransferir = scan.nextInt();
                            if (valorTransferir <= contaOrigem.getSaldo()) {
                                contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransferir);
                                contaDestino.setSaldo(valorTransferir);
                                System.out.println("Transferência Realizada com Sucesso!");
                            } 
                        }
                    }
                }
            }
        }

    }

    public void consultarCliente() {
        for (Cliente cliente : Banco.listaClientes) {
            System.out.println(cliente);
        }
    }

    public void consultarSaldoCorrente() {
        System.out.println("Digite o número da conta: ");
        int numconta = scan.nextInt();
        for (ContaCorrente conta : Banco.listaContaCorrente) {
            if (numconta == conta.getNumconta()) {
                System.out.println("");
                System.out.println("Saldo da Conta Corrente: " + conta.getSaldo());
            } else {
                System.out.println("Conta não encontrada!");
            }
        }
    }

    public void consultarSaldoPoupança() {
        System.out.println("Digite o número da conta: ");
        int numconta = scan.nextInt();
        for (ContaPoupanca contaP : Banco.listaContaPoupanca) {
            if (numconta == contaP.getNumconta()) {
                System.out.println("");
                System.out.println("Saldo da Conta Poupança: " + contaP.getSaldo());
            }
        }
    }

}
