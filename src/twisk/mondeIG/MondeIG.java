package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.util.HashMap;
import java.util.Iterator;

public class MondeIG implements Iterable<EtapeIG> {
    HashMap<String, EtapeIG> tableEtape = new HashMap<>() ;
    public MondeIG(){
        this.ajouter("Activité");
    }
    public void ajouter(String type){
        String id = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
        if (type.equals("Activité")){
            EtapeIG act = new ActiviteIG("Piscine",id,10,10);
            tableEtape.put(id,act);
        }

    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return tableEtape.values().iterator();
    }
    /*public void ajouterObservateur(Observateur v){

    }
    public void notifierObservateurs{}*/
}
