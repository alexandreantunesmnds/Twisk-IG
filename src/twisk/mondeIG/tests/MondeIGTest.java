package twisk.mondeIG.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MondeIGTest {
    MondeIG monde;

    @BeforeEach
    void setUp() {
        this.monde = new MondeIG();
    }

    @Test
    void ajouter() {
        assertEquals(this.monde.getSize(),1);
        monde.ajouter("Activité");
        assertEquals(this.monde.getSize(),2);
    }

    @Test
    void iterator() {
        Iterator<EtapeIG> it;
        this.monde.ajouter("Activité");
        this.monde.ajouter("Activité");
        it = this.monde.iterator();
        assertEquals(it.next().getNom(),"Piscine");
        assertEquals(it.next().getNom(),"Toboggan");
        assertEquals(it.next().getNom(),"Spa");
        assertFalse(it.hasNext());
    }
}