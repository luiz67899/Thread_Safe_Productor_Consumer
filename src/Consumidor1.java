import java.util.Vector;

public class Consumidor1 implements Runnable {
    private Vector<String> armazenamento;

    public Consumidor1(Vector<String> armz) throws Exception{
        if (armz == null)
            new Exception("Armazenamento nulo");
        else
            this.armazenamento = armz;
    }

    private Thread tarefa = new Thread(this);

    public void start(){
        this.tarefa.start();
    }

    public void join() throws InterruptedException{
        this.tarefa.join();
    }

    private boolean fim = false;

    public void morra() {
        this.fim = true;
    }

    public void run(){

        if (this.armazenamento.size()==0)
            this.tarefa.yield();
        else {
            String log = this.armazenamento.get(0);
            this.armazenamento.remove(0);
            System.out.println(log);
            try{this.tarefa.sleep(10);} catch (Exception error){}
        }

    }
}
