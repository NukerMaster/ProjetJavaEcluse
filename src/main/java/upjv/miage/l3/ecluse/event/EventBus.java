package upjv.miage.l3.ecluse.event;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

// Bus d'événements : permet la communication entre composants
public final class EventBus {

    private static final EventBus INSTANCE = new EventBus();
    public static EventBus get() { return INSTANCE; }

    private final CopyOnWriteArrayList<Consumer<String>> subs = new CopyOnWriteArrayList<>();
    private EventBus() {}

    // Abonnement d'un consommateur 
    public void subscribe(Consumer<String> c) { subs.add(c); }

    // Diffusion d'un message à tous les abonnés
    public void publish(String msg) { subs.forEach(c -> c.accept(msg)); }
}