import java.util.Vector;

public class Programa {

    public static void main(String[] args) {
        try {
            Vector<String> armazenamento;
            armazenamento = new Vector<String>();
            System.out.println("Tecle ENTER para ativar as tarefas e");
            System.out.println("Tecle novamente ENTER para terminar o programa.");
            Teclado.getUmString();

            Produtor1 t1 = new Produtor1(armazenamento);
            t1.start();

            Produtor2 t2 = new Produtor2(armazenamento);
            t2.start();

            Consumidor1 c1 = new Consumidor1(armazenamento);
            c1.start();
            Teclado.getUmString();
            //Matar primeiros as produtoras
            t1.morra();
            t2.morra();
            c1.morra();

            t1.join();
            t2.join();
            c1.join();

            System.out.println ("Execucao do programa finalizada.");


        } catch (Exception e) {
            System.err.println("Erro ao inicializar os produtores: " + e.getMessage());
            e.printStackTrace();
        }



    }

}
