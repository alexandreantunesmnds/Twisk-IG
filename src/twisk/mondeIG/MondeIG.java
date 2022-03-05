package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.util.HashMap;
import java.util.Iterator;

public class MondeIG implements Iterable<EtapeIG> {
    HashMap<String, EtapeIG> tableEtape = new HashMap<>() ;
    public MondeIG(){
        this.ajouter("Activité");
    }
    public void ajouter(String type) {
        if (type.equals("Activité")) {
            String id = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
            switch (id) {
                case "1":
                    EtapeIG act1 = new ActiviteIG("Piscine", id, 10, 10);
                    tableEtape.put(id, act1);
                    break;
                case "2":
                    EtapeIG act2 = new ActiviteIG("Toboggan", id, 10, 10);
                    tableEtape.put(id, act2);
                    break;
                case "3":
                    EtapeIG act3 = new ActiviteIG("Spa", id, 10, 10);
                    tableEtape.put(id, act3);
                    break;
                case "4":
                    EtapeIG act4 = new ActiviteIG("Boutique", id, 10, 10);
                    tableEtape.put(id, act4);
                    break;
                case "5":
                    EtapeIG act5 = new ActiviteIG("Restaurant", id, 10, 10);
                    tableEtape.put(id, act5);
                    break;

            }
        }
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return tableEtape.values().iterator();
    }
    public int getSize(){
        return tableEtape.size();
    }
    /*public void ajouterObservateur(Observateur v){

    }
    public void notifierObservateurs{}*/
}
