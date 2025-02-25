package view;

import java.util.Scanner;

import controller.Banco;
import controller.Operacoes;
import model.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Operacoes operacoes = new Operacoes();
        String menu = """
                [1] - Cadastrar Cliente
                [2] - Consultar Conta Corrente
                [3] - Consultar Conta Poupança
                [4] - Depositar
                [5] - Sacar
                [6] - Transferir
                [7] - Consultar lista de Clientes
                [8] - Sair
                """;
        int opcao = 0;
        while (true) {
            System.out.println(menu);
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    operacoes.criarCliente();
                    break;
                case 2:
                    operacoes.consultarSaldoCorrente();
                    break;
                case 3:
                    operacoes.consultarSaldoPoupança();
                    break;
                case 4:
                    operacoes.depositar(0,0);
                    break;
                case 5:
                    operacoes.sacar(0, 0);
                    break;
                case 6:
                    operacoes.transferir();
                    break;
                case 7:
                    operacoes.consultarCliente();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
