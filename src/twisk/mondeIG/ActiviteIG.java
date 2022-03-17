package twisk.mondeIG;

import twisk.outils.TailleComposants;

import java.util.Iterator;

public class ActiviteIG extends EtapeIG {
    public ActiviteIG(String nom, String idf, int larg, int haut){
        super(nom,idf,larg,haut);
        PointDeControleIG pc1,pc2,pc3,pc4;
        pc1 = new PointDeControleIG(this.getPosX()+larg/2,this.getPosY()-(int) TailleComposants.getInstance().getCircleSize()*2,"id1",this);
        pc2 = new PointDeControleIG(this.getPosX()+larg/2,this.getPosY()+haut,"id2",this);
        pc3 =new PointDeControleIG(this.getPosX()-(int) TailleComposants.getInstance().getCircleSize()*2,this.getPosY()+haut/2,"id3",this);
        pc4 = new PointDeControleIG(this.getPosX()+larg,this.getPosY()+haut/2,"id4",this);
        this.pcList.add(pc1);
        this.pcList.add(pc2);
        this.pcList.add(pc3);
        this.pcList.add(pc4);
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pcList.iterator();
    }

    public String getNom(){
        return this.nom;
    }
    public String getId(){
        return this.identifiant;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public int getLarg(){
        return this.largeur;
    }
    public int getHaut(){
        return this.hauteur;
    }
}
