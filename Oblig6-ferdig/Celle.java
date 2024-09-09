public class Celle{
    boolean levende = false;
    Celle[] naboer = new Celle[8];
    int antNaboer = 0;
    int antLevendeNaboer = 0;

    public Celle(){
        levende = false;
    }
    public void settDoed(){
        levende = false;
    } 
    public void settLevende(){
        levende = true;
    }
    public boolean erLevende(){
        if (levende == true){
            return true;
        } else {
            return false;
        }
    }

    public void endreStatus(){
        if(levende == true){
            this.settDoed();
        } else {
            this.settLevende();
        }
    }

    public char hentStatusTegn(){
        if (levende == true){
            return 'O';
        } else {
            return '.';
        }
    }
    public void leggTilNabo(Celle enCelle){
        naboer[antNaboer] = enCelle;
        antNaboer++;
    }
    public void tellLevendeNaboer(){
        antLevendeNaboer = 0;
        for (int i = 0; i < 8; i++){
            if(naboer[i] != null && naboer[i].erLevende()){
                antLevendeNaboer++;
            }
        }
    }
    public void oppdaterStatus(){
        if(levende){
            if(antLevendeNaboer > 3 || antLevendeNaboer < 2){
                levende = false;
            }
        } else {
            if(antLevendeNaboer == 3){
                levende = true;
            }
        }
    }
}