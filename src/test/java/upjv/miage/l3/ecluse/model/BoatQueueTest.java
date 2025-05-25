package upjv.miage.l3.ecluse.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

// Test unitaire de la classe BoatQueue
public class BoatQueueTest {

    @Test
    void ajouteEtRetireUnBateau() {
        BoatQueue q = new BoatQueue();
        Boat b = new Boat(1, "up");
        q.enqueue(b);
        assertThat(q.dequeue()).isEqualTo(b); // Vérifie que le bateau récupéré est bien celui inséré
    }
}
