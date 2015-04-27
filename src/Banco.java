/**
 * Created by vitorarins on 26/04/15.
 */
public class Banco {

    public boolean saque(ContaBancaria conta, int valor) {
//        int novoSaldo = conta.debitarValor(valor);
//        if (novoSaldo == -1)
//            return false;
//        System.out.println(Thread.currentThread().getName() + " sacou R$" + valor
//                + ". Saldo apos o saque: R$" + novoSaldo);
//        return true;
        int saldo = conta.getSaldo();
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
        int novoSaldo = saldo - valor;
        System.out.println(Thread.currentThread().getName() + " sacou R$" + valor
                + ". Saldo apos o saque: R$" + novoSaldo);
//        if (saldo != conta.getSaldo())
//            System.out.println(">>> ERRO NO CLIENTE " + Thread.currentThread().getName()
//                    + ": R$" + saldo + " != R$" + conta.getSaldo());
        conta.setSaldo(novoSaldo);
        return true;
    }
}
