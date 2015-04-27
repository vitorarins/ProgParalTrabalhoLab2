import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vitor on 4/15/15.
 */
public class ContaBancaria {

    int numero;
    private int saldo;
    private Lock lock = new ReentrantLock();
//    private Condition canWrite = lock.newCondition();
//    private Condition canRead = lock.newCondition();
//    private boolean occupied = false; // se o buffer estiver ocupado

    ContaBancaria(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
        System.out.println("Conta criada. Saldo inicial: R$" + saldo);
    }

    public int getSaldo() {

//        lock.lock();
        return saldo;
    }

    public void setSaldo(int saldo) {

//        try {
//            this.saldo = saldo;
//        } finally {
//            lock.unlock();
//        }
        this.saldo = saldo;
    }

    public int debitarValor(int valor) {

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
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return -1;
        } else {
            this.saldo -= valor;
            return this.saldo;
        }
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
