package upjv.miage.l3.ecluse.ui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import upjv.miage.l3.ecluse.controller.LockController;
import upjv.miage.l3.ecluse.event.EventBus;

// Contrôleur FXML de l'IHM JavaFX
public final class MainController {

    // Composants de l'interface
    @FXML private ProgressBar levelBar;
    @FXML private TextArea logArea;
    @FXML private Circle gateUpIcon, gateDownIcon;
    @FXML private Button btnDown, btnUp, btnFault;

    private final LockController ctrl = new LockController();

    // Initialisation état par défaut et abonnements
    @FXML private void initialize() {
        levelBar.setProgress(1.0);
        gateUpIcon.setFill(Color.GREEN);
        gateDownIcon.setFill(Color.RED);

        // Mise à jour des logs dans l'IHM via EventBus
        EventBus.get().subscribe(msg ->
            Platform.runLater(() -> logArea.appendText(msg + "\n")));
    }

    // Action : bateau descend (vidange)
    @FXML private void passDown() {
        animateLevel(levelBar.getProgress(), 0.0);
        gateUpIcon.setFill(Color.RED);
        gateDownIcon.setFill(Color.GREEN);
        ctrl.passDown();
    }

    // Action : bateau monte (remplissage)
    @FXML private void passUp() {
        animateLevel(levelBar.getProgress(), 1.0);
        gateUpIcon.setFill(Color.GREEN);
        gateDownIcon.setFill(Color.RED);
        ctrl.passUp();
    }

    // Action : simulation de panne
    @FXML private void faultGate() {
        gateUpIcon.setFill(Color.ORANGE);
        ctrl.faultGate();
    }

    // Animation de la jauge de niveau
    private void animateLevel(double from, double to) {
        var tl = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(levelBar.progressProperty(), from)),
            new KeyFrame(Duration.seconds(4), new KeyValue(levelBar.progressProperty(), to))
        );
        tl.play();
    }
}