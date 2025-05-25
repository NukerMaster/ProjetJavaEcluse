package upjv.miage.l3.ecluse.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Application JavaFX (interface graphique)
public final class EcluseApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Chargement de l'IHM depuis le fichier FXML
        Parent root = FXMLLoader.load(getClass().getResource("/ui/MainView.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Simulation d'écluse");
        stage.show();
    }
}