package twisk.mondeIG;

import java.util.HashMap;

public class MondeIG {
    HashMap<Integer, EtapeIG> tableEtape = new HashMap<>() ;
    public MondeIG(){
        ActiviteIG act = new ActiviteIG("Toboggan","1",10,10);
        this.tableEtape.put(1,act);
    }
    public void ajouter(String type){

    }
    /*public void ajouterObservateur(Observateur v){

    }
    public void notifierObservateurs{}*/
}
