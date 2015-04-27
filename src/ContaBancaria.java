import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitor on 4/15/15.
 */
public class ContaBancaria {

    int numero;
    private int saldo;

    ContaBancaria(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
        System.out.println("Conta criada. Saldo inicial: R$" + saldo);
    }

    public int getNumero(){

        return this.numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void emiteExtrato() {


    }

    public int debitarValor(int valor) {

        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return -1;
        } else {
            this.saldo -= valor;
            return this.saldo;
        }

//        lock.lock();
//        try {
//            if (this.saldo < valor) {
//                System.out.println("Saldo insuficiente para saque.");
//                return -1;
//            } else {
//                this.saldo -= valor;
//                return this.saldo;
//            }
//        } finally {
//            lock.unlock();
//        }
    }

}
