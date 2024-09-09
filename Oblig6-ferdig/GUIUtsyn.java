import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUIUtsyn{
    private Kontroll kontroll;
    public JButton start, avslutt;
    private JButton[][] rutenett = new JButton[8][12];
    private JFrame vindu;
    private JLabel antallLevende;
    private JPanel panel, top, celler;

    class Oppdater implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
                kontroll.startKlokke();
            }
    }

    class Avslutt implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            kontroll.avslutt();
        }
    }

    class EndreStatus implements ActionListener{
        int rad;
        int kol;
        EndreStatus(int r, int k){
            rad = r;
            kol = k;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            kontroll.endreStatus(rad,kol);
            kontroll.visAntLevende();
        }
    }
    

    GUIUtsyn(Kontroll k){
        kontroll = k;
    
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.exit(1);
        }
        vindu = new JFrame("Game Of Life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        vindu.add(panel);

        top = new JPanel();
        top.setLayout(new BorderLayout());
        panel.add(top, BorderLayout.NORTH);

        start = new JButton("Start");
        start.addActionListener(new Oppdater());

        avslutt = new JButton("Avslutt");
        avslutt.addActionListener(new Avslutt());

        antallLevende = new JLabel("Antall levende celler: ");

        top.add(antallLevende, BorderLayout.WEST);
        top.add(start,BorderLayout.CENTER);
        top.add(avslutt, BorderLayout.EAST);

        celler = new JPanel();
        celler.setLayout(new GridLayout(8,12));
        panel.add(celler, BorderLayout.CENTER);
        for(int rad = 0; rad < 8; rad++){
            for(int kol = 0; kol < 12; kol++){
                JButton b = new JButton("");
                rutenett[rad][kol] = b;
                b.addActionListener(new EndreStatus(rad,kol));
                celler.add(b);
            }
        }

    vindu.pack();
    vindu.setSize(800, 500);
    vindu.setLocationRelativeTo(null);
    vindu.setVisible(true);
    this.settCelleTegn();
    this.visAntLevende();
    }

    public void visAntLevende(){
        int i = kontroll.v1.rutenett.antallLevende();
        antallLevende.setText("Antall levende celler: " + i + " ");
    }

    public void endreTekst(){ 
        if(start.getText().equals("Start")){
            start.setText("Stopp");
        } else {
            start.setText("Start");
        }
    }

    public String startTekst(){
        return start.getText();
    }

    public void settCelleTegn(){
        for(int rad = 0; rad < 8; rad++){
            for(int kol = 0; kol < 12; kol++){
                if (kontroll.v1.rutenett.hentCelle(rad, kol).erLevende() == true){
                    rutenett[rad][kol].setText("*");
                } else {
                    rutenett[rad][kol].setText("");
                }
            }
    }
}
}