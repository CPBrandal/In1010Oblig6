public class Verden {
    int genNr = 0;
    Rutenett rutenett;
    int rad;
    int kolonne;

    public Verden(int rad, int kolonne){
        this.rad = rad;
        this.kolonne = kolonne;
        rutenett = new Rutenett(rad, kolonne);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }
    public void tester(){
        System.out.println("ant nabo: " + rutenett.hentCelle(0, 0).antNaboer);
        System.out.println("ant levende nabo: " + rutenett.hentCelle(0, 0).antLevendeNaboer);
        System.out.println("Levende: " + rutenett.hentCelle(0, 0).erLevende());
        System.out.println("ant nabo: " + rutenett.hentCelle(0, 2).antNaboer);
        System.out.println("ant levende nabo: " + rutenett.hentCelle(0, 2).antLevendeNaboer);
        System.out.println("Levende: " + rutenett.hentCelle(0, 2).erLevende());
        System.out.println("ant nabo: " + rutenett.hentCelle(2, 2).antNaboer);
        System.out.println("ant levende nabo: " + rutenett.hentCelle(2, 2).antLevendeNaboer);
        System.out.println("Levende: " + rutenett.hentCelle(2, 2).erLevende());
    }

    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Generasjonsnummer: " + genNr);
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
        System.out.println("");
    }

    public void oppdatering(){
        for(int i = 0; i < rad; i++){
            for(int x = 0; x < kolonne; x++){
                if(rutenett.hentCelle(i, x) != null){
                    rutenett.hentCelle(i, x).tellLevendeNaboer();
                }
            }
        }
        for(int i = 0; i < rad; i++){
            for(int x = 0; x < kolonne; x++){
                if(rutenett.hentCelle(i, x) != null){
                    rutenett.hentCelle(i, x).oppdaterStatus();
                }
            }
        }
        genNr++;
    }
}
