public class Sistema {
ContaBancaria conta;

    public void criarConta(String nome, float depositoInicial){
        conta = new ContaBancaria(nome, depositoInicial);
        System.out.println("Conta criada com sucesso!");
    }

    public void depositar(float valor) {
        if (conta.getSaldo() < 0) {
            float valorUsadoCheque = -conta.getSaldo();
            float taxa = valorUsadoCheque * 0.20f;
            float totalDevido = valorUsadoCheque + taxa;

            if (valor >= totalDevido) {
                conta.setSaldo(valor - totalDevido);
                System.out.println("Dívida de cheque especial quitada com taxa de 20%.");
            } else {
                conta.setSaldo(conta.getSaldo() + valor);
                System.out.println("Valor depositado foi usado para abater a dívida.");
            }
        } else {
            conta.setSaldo(conta.getSaldo() + valor);
        }
    }

    public void consultarSaldo(){
        System.out.printf("O valor atual em conta é: %.2f\n", conta.getSaldo());
    }

    public void sacar(float valor){
        float saldoDisponivel = conta.getSaldo();
        float limiteCheque = conta.getChequeEspecial();
        if (saldoDisponivel >= valor) {
            conta.setSaldo(saldoDisponivel - valor);
            System.out.printf("Valor de %.2f sacado!, saldo disponível atual: %.2f\n", valor, saldoDisponivel);
        }else if (saldoDisponivel + limiteCheque >= valor){
            float saldoFinal = saldoDisponivel - valor;
            conta.setSaldo(saldoFinal);
            System.out.printf("Saque de %.2f realizado utilizado cheque especial. Saldo atual: %.2f\n", valor, conta.getSaldo());
        }else {
            System.out.println("Saldo e cheque especial insuficientes para realizar o saque.");
        }
    }

    public void consultaChequeEspecial(){
        System.out.printf("Cheque especial disponível no valor de %.2f\n", conta.getChequeEspecial());
    }

    public void pagarBoleto(float valor){
        float saldoDisponivel = conta.getSaldo();
        float limiteCheque = conta.getChequeEspecial();
        if (saldoDisponivel >= valor) {
            conta.setSaldo(saldoDisponivel - valor);
            System.out.printf("Valor de %.2f pago!, saldo disponível atual: %.2f\n", valor, conta.getSaldo());
        } else if (saldoDisponivel + limiteCheque >= valor) {
            float saldoFinal = saldoDisponivel - valor;
            conta.setSaldo(saldoFinal);
            System.out.printf("O boleto no valor de %.2f foi pago utilizando o cheque especial. Saldo disponível: %f\n", valor, conta.getSaldo());
        }else {
            System.out.println("Saldo e cheque especial insuficientes para realizar o pagamento!");
        }
    }
    public void verificarUsoDeChequeEspecial(){
        if(conta.getSaldo() < 0){
            System.out.println("A conta está utilizando cheque especial.");
        }else{
            System.out.println("A conta não está utilizando cheque especial!");
        }
    }
}