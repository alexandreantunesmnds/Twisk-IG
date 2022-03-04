package twisk.mondeIG;

import java.util.HashMap;
import java.util.Iterator;

public class MondeIG implements Iterable<EtapeIG> {
    HashMap<Integer, EtapeIG> tableEtape = new HashMap<>() ;
    public MondeIG(){
        ActiviteIG act = new ActiviteIG("Toboggan","1",10,10);
        this.tableEtape.put(1,act);
    }
    public void ajouter(String type){

    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return tableEtape.values().iterator();
    }
    /*public void ajouterObservateur(Observateur v){

    }
    public void notifierObservateurs{}*/
}
