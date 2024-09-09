public class Klokke implements Runnable {

    private Kontroll kontroll;
    public boolean fortsett = true;

    public Klokke(Kontroll k){
        kontroll = k;
    }

public void run(){
        while(fortsett){
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                fortsett = false;
            }
            if(kontroll.hentStartTekst().equals("Stopp")){
                kontroll.oppdatering();
            } else {
                fortsett = false;
            }
        }
    }
}
