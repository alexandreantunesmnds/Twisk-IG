package twisk.mondeIG.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.PointDeControleIG;

import static org.junit.jupiter.api.Assertions.*;

class ArcIGTest {
    EtapeIG etape1;
    EtapeIG etape2;
    PointDeControleIG point1;
    PointDeControleIG point2;
    ArcIG arc;
    @BeforeEach
    void setUp() {
        this.etape1 = new ActiviteIG("Toboggan","id1",100,100);
        this.etape2 = new ActiviteIG("Restaurant","id2",400,500);
        this.point1 = new PointDeControleIG(100,200,"id1",this.etape1);
        this.point2 = new PointDeControleIG(200,300,"id2",this.etape2);
        this.arc = new ArcIG(this.point1,this.point2);
    }
    @Test
    void getPoint1(){
        assertEquals(this.arc.getPoint1().getNomEtape(),this.etape1.getNom());
    }

    @Test
    void getPoint2(){
        assertEquals(this.arc.getPoint2().getNomEtape(),this.etape2.getNom());

    }
}