import java.util.Vector;

public class Produtor1 extends Thread {
    private Vector<String> armazenamento;

    public Produtor1(Vector<String> armz) throws Exception{
        if (armz == null)
            throw new Exception("Armazenamento ausente");
        else
            this.armazenamento = armz;
    }

    private boolean fim = false;

    public void morra(){
        this.fim = true;
    }

    public void run(){
        String log_critico = "[ERRO] Falha de Ligação";
        while (!this.fim){
            this.armazenamento.add(log_critico);
            try {this.sleep(1000);} catch (Exception erro){}
        }
    }



}
