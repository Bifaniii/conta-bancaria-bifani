public class ContaBancaria {
    private String nome;
    private float saldo;
    private float chequeEspecial;

    public ContaBancaria(String nome, float depositoInicial){
        this.nome = nome;
        this.saldo = depositoInicial;

        if (depositoInicial <= 500){
            this.chequeEspecial = 50;
        }else {
            this.chequeEspecial = depositoInicial / 2;
        }
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public float getSaldo(){
        return saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public float getChequeEspecial(){
        return chequeEspecial;
    }
    public void setChequeEspecial(float chequeEspecial){
        this.chequeEspecial = chequeEspecial;
    }

}
