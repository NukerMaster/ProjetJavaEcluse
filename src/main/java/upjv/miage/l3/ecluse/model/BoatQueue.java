package upjv.miage.l3.ecluse.model;

import java.util.LinkedList;
import java.util.Queue;

// File FIFO des bateaux en attente dans l'écluse
public final class BoatQueue {
    private final Queue<Boat> fifo = new LinkedList<>();

    // Ajoute un bateau dans la file
    public void enqueue(Boat b) { fifo.offer(b); }

    // Retire le premier bateau de la file
    public Boat dequeue() { return fifo.poll(); }

    // Taille actuelle de la file
    public int size() { return fifo.size(); }
}