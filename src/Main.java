import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        System.out.println("Bem-vindo(a) ao sistema bancário Bifani!");

        System.out.print("Digite seu nome para criar a conta: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o valor do depósito inicial: ");
        float depositoInicial = scanner.nextFloat();

        sistema.criarConta(nome, depositoInicial);

        int opcao;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Sacar");
            System.out.println("4 - Depositar");
            System.out.println("5 - Pagar Boleto");
            System.out.println("6 - Verificar uso do Cheque Especial");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    sistema.consultarSaldo();
                    break;
                case 2:
                    sistema.consultaChequeEspecial();
                    break;
                case 3:
                    System.out.print("Informe o valor para saque: ");
                    float saque = scanner.nextFloat();
                    sistema.sacar(saque);
                    break;
                case 4:
                    System.out.print("Informe o valor para depósito: ");
                    float deposito = scanner.nextFloat();
                    sistema.depositar(deposito);
                    break;
                case 5:
                    System.out.print("Informe o valor do boleto: ");
                    float boleto = scanner.nextFloat();
                    sistema.pagarBoleto(boleto);
                    break;
                case 6:
                    sistema.verificarUsoDeChequeEspecial();
                    break;
                case 7:
                    System.out.println("Saindo... Obrigado por utilizar o Banco Bifani!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 7);

        scanner.close();
    }
}
