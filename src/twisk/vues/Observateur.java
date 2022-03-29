package twisk.vues;

import twisk.mondeIG.MondeIG;
import twisk.mondeIG.SujetObserve;

public interface Observateur {
    SujetObserve sujetObs = new SujetObserve();
    public void reagir();
}
