package upjv.miage.l3.ecluse.ui;

import upjv.miage.l3.ecluse.controller.LockController;
import upjv.miage.l3.ecluse.event.EventBus;

import java.util.Scanner;

// Interface utilisateur en mode console
public final class CliApp implements Runnable {
    @Override public void run() {
        var ctrl = new LockController();
        EventBus.get().subscribe(System.out::println); // Affichage des logs dans la console

        try (var sc = new Scanner(System.in)) {
            boolean run = true;
            System.out.println("help | pass up | pass down | fault | quit");
            while (run) {
                System.out.print("ECLUSE > ");
                var cmd = sc.nextLine().trim().split("\\s+");
                switch (cmd[0]) {
                    case "help" -> System.out.println("pass up/down, fault, quit");
                    case "pass" -> {
                        if ("down".equals(cmd[1])) ctrl.passDown();
                        else ctrl.passUp();
                    }
                    case "fault" -> ctrl.faultGate();
                    case "quit" -> run = false;
                }
            }
        }
    }
}