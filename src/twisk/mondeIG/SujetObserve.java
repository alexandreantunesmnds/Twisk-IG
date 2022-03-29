package twisk.mondeIG;

import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<Observateur> obs = new ArrayList<>(10);
    public void ajouterObservateur(Observateur v){
        this.obs.add(v) ;
    }
    public void notifierObservateurs(){
        for (Observateur o : this.obs) {
            o.reagir();
        }
    }
}
