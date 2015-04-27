import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // cria novo pool de threads com duas threads
        ExecutorService application = Executors.newFixedThreadPool(2);

        ContaBancaria contaA = new ContaBancaria(65, 100);
        ContaBancaria contaB = new ContaBancaria(66, 200);
        ContaBancaria contaC = new ContaBancaria(67, 300);

        Transacao T = new Transacao("A", contaA, contaB, 0.1);
        Transacao U = new Transacao("C", contaC, contaB, 0.1);

        try // tenta iniciar a produtora e a consumidora
        {
            application.execute( T );
            application.execute( U );
        } // fim do try
        catch ( Exception exception )
        {
            exception.printStackTrace();
        } // fim do catch

        application.shutdown();
    }
}
