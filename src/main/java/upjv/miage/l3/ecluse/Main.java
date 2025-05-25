package upjv.miage.l3.ecluse;

import upjv.miage.l3.ecluse.ui.CliApp;
import upjv.miage.l3.ecluse.ui.EcluseApp;

// Point d’entrée du programme
public final class Main {
    public static void main(String[] args) {
        // Mode graphique si --gui, sinon console
        if (args.length > 0 && "--gui".equalsIgnoreCase(args[0])) {
            EcluseApp.launch(EcluseApp.class, args);
        } else {
            new CliApp().run();
        }
    }
}