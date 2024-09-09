import java.util.ArrayList;

public class Kontroll{

    Verden v1;
    GUIUtsyn gui;
    ArrayList<Thread> traadliste = new ArrayList<>();

    Kontroll(){
        v1 = new Verden(8, 12);
    }

    public void endreTekst(){
        if(gui.start.getText().equals("Start")){
            gui.start.setText("Stopp");
        } else {
            gui.start.setText("Start");
        }
    }

    public void oppdatering(){
        v1.oppdatering();
        gui.settCelleTegn();
        gui.visAntLevende();
    }

    public void startKlokke(){
        if(traadliste.size()>0){
            traadliste.get(0).interrupt();
            traadliste.remove(0);
        }
        this.endreTekst();
        Klokke kl = new Klokke(this);
        Thread traad = new Thread(kl);
        traad.start();
        traadliste.add(traad);
    }

    public String hentStartTekst(){
        return gui.startTekst();
    }

    public void visAntLevende(){
        gui.visAntLevende();
    }

    public void avslutt(){
        System.out.println("Avslutter");
        System.exit(0);
    }

    public void endreStatus(int rad, int kol){
        v1.rutenett.hentCelle(rad, kol).endreStatus();
        gui.settCelleTegn();
    }

    public void startGUI(){
        gui = new GUIUtsyn(this);
    }
}
