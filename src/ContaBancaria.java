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
    private Condition canWrite = lock.newCondition();
    private Condition canRead = lock.newCondition();
    private boolean occupied = false; // se o buffer estiver ocupado

    ContaBancaria(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
        System.out.println("Conta criada. Saldo inicial: R$" + saldo);
    }

    public int getSaldo() {

        lock.lock();
        try {
            return saldo;
        } finally {
            lock.unlock();
        }
//        return saldo;
    }

    public void setSaldo(int saldo) {

        lock.lock();
        try {

            while (occupied) {
                canWrite.await();
            }

            this.saldo = saldo;

            canRead.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            occupied = false;
            lock.unlock();
        }
//        this.saldo = saldo;
    }

    public int debitarValor(int valor) {

//        if (this.saldo < valor) {
//            System.out.println("Saldo insuficiente para saque.");
//            return -1;
//        } else {
//            this.saldo -= valor;
//            return this.saldo;
//        }

        lock.lock();
        try {
            while (occupied) {
                canWrite.await();
            }

            this.saldo -= valor;

            canRead.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            occupied = false;
            lock.unlock();
            return this.saldo;
        }
    }

}
