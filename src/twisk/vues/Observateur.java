package twisk.vues;

import twisk.mondeIG.SujetObserve;

public interface Observateur {
    SujetObserve sujetObs = new SujetObserve();
    void reagir();
}
