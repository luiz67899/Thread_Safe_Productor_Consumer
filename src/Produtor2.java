import java.util.Vector;

public class Produtor2 extends Thread{
    private Vector<String> armazenamento;

    public Produtor2(Vector<String> armz) throws Exception{
        if (armz == null)
            throw new Exception("Armazenamento nulo");
        else
            this.armazenamento = armz;
    }

    private boolean fim = false;

    public void morra(){
        this.fim = true;
    }

    public void run(){
        String logAutenticado = "[INFO] Utilizador Autenticado";

        while (!this.fim){
            this.armazenamento.add(logAutenticado);
            try{this.sleep(500);}catch (Exception erro){}
        }
    }

}
