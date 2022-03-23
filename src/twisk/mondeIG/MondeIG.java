package twisk.mondeIG;

import javafx.scene.shape.Arc;
import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;
import twisk.vues.Observateur;
import twisk.vues.VueArcIG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class MondeIG implements Iterable<EtapeIG>{
    private ArrayList<Observateur> obs = new ArrayList<>(10);
    private HashMap<String, EtapeIG> tableEtape = new HashMap<>(10) ;
    private ArrayList<ArcIG> arcList = new ArrayList<>(10);
    private PointDeControleIG point;
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
            this.notifierObservateurs();
        }
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return tableEtape.values().iterator();
    }
    public Iterator<ArcIG> iteratorArc() {
        return arcList.iterator();
    }
    public int getSize(){
        return tableEtape.size();
    }
    public void ajouterObservateur(Observateur v){
        this.obs.add(v) ;
    }
    public void notifierObservateurs(){
        for (Observateur o : this.obs) {
            o.reagir();
        }
    }
    public int getNbArcs(){
        return arcList.size();
    }
    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2){
        if (Objects.equals(pt1.getNomEtape(), pt2.getNomEtape())){
            System.out.println("\nAjout de l'arc impossible : vous essayez de relier une étape à elle même\n");
        }
        else if (this.getNbArcs() > 0){//1 etape ne oeut pas aller 2 fois au même endroit à revoir
            for (Iterator<ArcIG> it = this.iteratorArc(); it.hasNext();){
                ArcIG arc = it.next();
                    if (Objects.equals(arc.getPoint1().getNomEtape(), pt1.getNomEtape()) || Objects.equals(arc.getPoint2().getNomEtape(), pt2.getNomEtape())){
                        System.out.println("Ajout de l'arc impossible : vous essayez de relier 2 étapes déjà reliées entre-elles");
                    }
                    if (arc.getPoint1().getPosX() == pt1.getPosX() && arc.getPoint1().getPosY() == pt1.getPosY() || arc.point2.getPosX() == pt1.getPosX() && arc.point2.getPosY() == pt1.getPosY() || arc.point1.getPosX() == pt2.getPosX() && arc.point1.getPosY() == pt2.getPosY() || arc.point2.getPosX() == pt2.getPosX() && arc.point2.getPosY() == pt2.getPosY()){
                        System.out.println(" Ajout de l'arc impossible : Vous essayez de relier 2 points de contrôles déjà reliés");
                    }
                }
        }
        else {
            this.arcList.add(new ArcIG(pt1, pt2));
            notifierObservateurs();
        }
         //les conditions à ajouter pour la validité des arcs : une etape ne peut être reliée que par un arc(ou aucun) avec une autre étape ; un point de controle doit relié un autre point de controle (+ d'une autre étape)
    }
    public void selectionPoint(PointDeControleIG point){
        if (this.point != null){//si le point est initialisé on peut ajouter l'arc
            ajouter(this.point,point);
        }
        this.point = point;
    }
}
