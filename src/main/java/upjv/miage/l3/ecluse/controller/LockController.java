package upjv.miage.l3.ecluse.controller;

import upjv.miage.l3.ecluse.event.EventBus;

// Classe principale de contrôle de l'écluse
public final class LockController {

    private double level = 1.0; // Niveau de l'eau : 1 = plein, 0 = vide

    public double getLevel() { return level; }

    // Méthode pour faire descendre un bateau 
    public void passDown() {
        EventBus.get().publish("Bateau aval : cycle démarré");
        level = 0.0;
        EventBus.get().publish("Niveau atteint (0)");
    }

    // Méthode pour faire monter un bateau 
    public void passUp() {
        EventBus.get().publish("Bateau amont : cycle démarré");
        level = 1.0;
        EventBus.get().publish("Niveau atteint (1)");
    }

    // Simule une panne de la porte amont
    public void faultGate() {
        EventBus.get().publish("Panne moteur porte amont");
    }
}