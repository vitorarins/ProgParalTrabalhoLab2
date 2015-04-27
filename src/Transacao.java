
/**
 * Created by vitor on 4/15/15.
 */
public class Transacao extends Thread {

    private static Banco banco = new Banco();
    private ContaBancaria contaFonte = null;
    private ContaBancaria contaDestino = null;
    private double valueOrPercentage;

    public Transacao(String nome, ContaBancaria contaFonte, ContaBancaria contaDestino, double valueOrPercentage) {

        super(nome);
        this.contaFonte = contaFonte;
        this.contaDestino = contaDestino;
        this.valueOrPercentage = valueOrPercentage;
    }

    public int getVariacao() {

        return 0;
    }

    public void emiteLinhaExtrato() {

    }

    @Override
    public void run() {

        int saldo = contaDestino.getSaldo();

        System.out.println("Cliente " + getName() + " ativo.");

        if (valueOrPercentage <= 1) {
            contaDestino.setSaldo((int) (saldo * (1 + valueOrPercentage)));
            banco.saque(contaFonte, (int) (saldo * valueOrPercentage));
            System.out.println(getName() + " sacou um total de R$" + (saldo * valueOrPercentage));
        } else {
            contaDestino.setSaldo((int) (saldo + valueOrPercentage));
            banco.saque(contaFonte, (int) valueOrPercentage);
            System.out.println(getName() + " sacou um total de R$" + valueOrPercentage);
        }

        System.out.println("Conta Destino, saldo: " + contaDestino.getSaldo());
    }
}
