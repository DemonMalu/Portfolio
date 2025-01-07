package com.divinita.SpringJDBCDivinita;

import java.net.URI;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.Desktop;

import com.divinita.SpringJDBCDivinita.model.Divinita;
import com.divinita.SpringJDBCDivinita.repo.DivineRepo;

@SpringBootApplication
public class SpringJdbcDivinitaApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = SpringApplication.run(SpringJdbcDivinitaApplication.class, args);
		
		Divinita divinita = context.getBean(Divinita.class);
		DivineRepo repo = context.getBean(DivineRepo.class);
		
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI("http://localhost:8888"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

		System.out.println(" ");
		System.out.println("Ciao Chaos! Benvenuto nella gerarchia divina. "
				+ "Sii il creatore della tua stessa gerarchia di divinità!");

		while (true) {
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1. Aggiungi divinità");
            System.out.println("2. Rimuovi divinità");
            System.out.println("3. Sostituisci o modifica divinità");
            System.out.println("4. Visualizza divinità");
            System.out.println("5. Visualizza gerarchia");
            System.out.println("6. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {

            case 1:
            	
            	System.out.println("Inserire l'id:");
                divinita.setId(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Inserire nome:");
                divinita.setNome(scanner.nextLine());
                System.out.println("Inserire razza:");
                divinita.setRazza(scanner.nextLine());
                System.out.println("Inserire abilità:");
                divinita.setAbilita(scanner.nextLine());
                System.out.println("Inserire equipaggiamento:");
                divinita.setEquipaggiamento(scanner.nextLine());
                
                repo.save(divinita);
                System.out.println("Divinità aggiunta con successo.");
                break;
                
            case 2:

            	System.out.println("Inserire l'id della divinità da rimuovere");
                divinita.setId(scanner.nextInt());
                repo.deleteById(divinita);
                System.out.println("Divinità rimossa con successo");
                break;
                
            case 3:
            	
            	System.out.println("Inserire l'id della divinità da modificare o sostituire");
                divinita.setId(scanner.nextInt());
                scanner.nextLine();
                
                System.out.println("Inserire nuovo nome:");
                divinita.setNome(scanner.nextLine());
                System.out.println("Inserire nuova razza:");
                divinita.setRazza(scanner.nextLine());
                System.out.println("Inserire nuove abilità:");
                divinita.setAbilita(scanner.nextLine());
                System.out.println("Inserire nuovo equipaggiamento:");
                divinita.setEquipaggiamento(scanner.nextLine());
                
                repo.update(divinita);
                System.out.println("Divinità modificata con successo.");
                break;
                
            case 4:
            	
                System.out.println("Inserire l'id della divinità da visualizzare");
                divinita.setId(scanner.nextInt());
                System.out.println("La divinità selezionata è: " + repo.view(divinita.getId()));
                break;
                
            case 5:
            	
            	System.out.println("Le divinità presenti nel db sono: " + repo.findAll());
            	break;
            	
            case 6:
            	
                System.out.println("Arrivederci divino Chaos!");
                scanner.close();
                System.exit(0);
                return;
                
            default:
            
                System.out.println("Scelta non valida scusate! Riprovate!");
            
            }

        }

	}

}




