package twisk.vues;

import twisk.mondeIG.MondeIG;

public interface Observateur {
    MondeIG monde = new MondeIG();
    public void reagir();
}
