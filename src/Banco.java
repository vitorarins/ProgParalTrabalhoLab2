/**
 * Created by vitorarins on 26/04/15.
 */
public class Banco {

    public boolean saque(ContaBancaria conta, int valor) {
        int novoSaldo = conta.debitarValor(valor);
        if (novoSaldo == -1)
            return false;
        System.out.println(Thread.currentThread().getName() + " sacou R$" + valor
                + ". Saldo apos o saque: R$" + novoSaldo);
        return true;
    }
}
