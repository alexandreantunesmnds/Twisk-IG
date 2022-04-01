package twisk.mondeIG;

import javafx.scene.shape.Arc;
import twisk.exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;
import twisk.vues.Observateur;
import twisk.vues.VueArcIG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{
    private HashMap<String, EtapeIG> tableEtape = new HashMap<>(10) ;
    private ArrayList<ArcIG> arcList = new ArrayList<>(10);
    private PointDeControleIG point;
    private EtapeIG etape;
    private ArrayList<EtapeIG> etapes = new ArrayList<>(10); //étapes selectionnées
    private int relier = 0;

    public MondeIG(){
        this.ajouter("Activité");
    }
    public void ajouter(String type) {
        if (type.equals("Activité")) {
            String id = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
            int larg = TailleComposants.getInstance().getLargBox();
            int haut = TailleComposants.getInstance().getHautBox();
            switch (id) {
                case "1":
                    EtapeIG act1 = new ActiviteIG("Piscine", id, larg, haut);
                    tableEtape.put(id, act1);
                    break;
                case "2":
                    EtapeIG act2 = new ActiviteIG("Toboggan", id, larg, haut);
                    tableEtape.put(id, act2);
                    break;
                case "3":
                    EtapeIG act3 = new ActiviteIG("Spa", id, larg, haut);
                    tableEtape.put(id, act3);
                    break;
                case "4":
                    EtapeIG act4 = new ActiviteIG("Boutique", id, larg, haut);
                    tableEtape.put(id, act4);
                    break;
                case "5":
                    EtapeIG act5 = new ActiviteIG("Restaurant", id, larg, haut);
                    tableEtape.put(id, act5);
                    break;
                default:
                    EtapeIG actDef = new ActiviteIG("Etape "+ id,id,larg,haut);
                    tableEtape.put(id, actDef);
                    break;
            }
            //On retire les sélections à chaque nouvel ajout d'étape
            for (EtapeIG etapes : this.etapes){
                etapes.etapeDeSelect();
            }
            this.etapes.clear();
            this.notifierObservateurs();
        }
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return tableEtape.values().iterator();
    }
    public Iterable<ArcIG> iteratorArc() {
        return arcList;
    }
    public int getSize(){
        return tableEtape.size();
    }
    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {
        if (Objects.equals(pt1.getNomEtape(), pt2.getNomEtape())) {
            throw(new TwiskException("\nAjout de l'arc impossible : vous essayez de relier une étape à elle même\n"));
        }
        else{
            for (ArcIG arc : this.iteratorArc() ) {
                if (Objects.equals(arc.getPoint2().getNomEtape(), pt2.getNomEtape())){
                    throw(new TwiskException("\nAjout de l'arc impossible : vous essayez de relier 2 fois une étape\n"));
                }
            }
            this.arcList.add(new ArcIG(pt1, pt2));
            //quand l'arc est ajouté on informe que les deux points sont reliés
            this.relier = 1;
            this.point = null;
            notifierObservateurs();
        }
    }
    //les conditions à ajouter pour la validité des arcs : une etape ne peut être reliée que par un arc(ou aucun) avec une autre étape ; un point de controle doit relié un autre point de controle (+ d'une autre étape)
    public void selectionPoint(PointDeControleIG point) throws TwiskException {
        for (ArcIG arc : this.iteratorArc() ) {
            if (arc.getPoint1() == point || arc.getPoint2() == point){
                return;
            }
        }
        if (this.point != null && this.relier == 0){//si le point est initialisé et si la liaison est possible alors on peut ajouter l'arc
            ajouter(this.point,point);
        }
        else{
            this.point = point;
            this.relier = 0;
        }
    }
    public void selectionEtapes(EtapeIG etape) {
        if (this.etape != null && this.etape.getNom().equals(etape.getNom())) {
            this.etape.etapeDeSelect();
            this.etapes.remove(this.etape);
        } else {
            this.etape = etape;
            this.etape.etapeSelect();
            this.etapes.add(etape);
        }
        notifierObservateurs();
    }

    public void supprimerEtapes(){
        if (this.etape != null) { // si aucune étape n'est encore selectionnée on ne fait rien
            for (EtapeIG etapes : this.etapes) {
                if (etapes.getSelected() == 1) {
                    this.tableEtape.remove(etapes.getId());
                    if (this.arcList.size() != 0) {
                        this.arcList.removeIf(arc -> arc.getPoint1().getNomEtape().equals(etapes.getNom()) || arc.getPoint2().getNomEtape().equals(etapes.getNom()));
                        for (ArcIG arc : this.iteratorArc()) {
                            if (arc.getPoint1().getNomEtape().equals(etapes.getNom())) {
                                this.arcList.remove(arc);
                            }
                            notifierObservateurs();
                        }
                    }
                }
                notifierObservateurs();
            }
        }
    }
    public void renommerEtape(String nom){
        if(this.etapes != null && this.etapes.size() == 1) {
            this.etape.nom = nom;
            notifierObservateurs();
        }
    }
    public HashMap<String, EtapeIG> getHash(){
        return this.tableEtape;
    }
    public void positionEtapes(int dragEventX, int dragEventY, EtapeIG etp){
        etp.setPosX(dragEventX - (etp.getLarg())/2);
        etp.setPosY(dragEventY - (etp.getHaut())/2);

        etp.getPoint().get(0).setX(etp.getPosX());
        etp.getPoint().get(0).setY(etp.getPosY() + (etp.getHaut())/2);

        etp.getPoint().get(1).setX(etp.getPosX() + (etp.getLarg())/2);
        etp.getPoint().get(1).setY(etp.getPosY());

        etp.getPoint().get(2).setX(etp.getPosX() + etp.getLarg());
        etp.getPoint().get(2).setY(etp.getPosY() + (etp.getHaut())/2);

        etp.getPoint().get(3).setX(etp.getPosX() + (etp.getLarg())/2);
        etp.getPoint().get(3).setY(etp.getPosY() + etp.getHaut());
        this.notifierObservateurs();
    }
}
