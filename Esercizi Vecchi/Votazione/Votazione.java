/* Sviluppare un programma che simuli una votazione.
In ingresso abbiamo n oggetti di tipo Maggiorenne(String nome)
Facciamo votare ciascuno di loro tramite il metodo vota() appartenente alla classe Maggiorenne.
Ogni maggiorenne possiede una particolare Tessera Elettorale con un piccolo spazietto per apporre il
timbro di voto a riprova della propria votazione.
Il programma dovrà essere in grado di restituire il numero totale di elettori e il numero totale di votanti.
Inoltre tramite il metodo haVotato() dovrà essere in grado di restituire a video se un oggetto
maggiorenne ha votato o meno.

Un esempio di output a video:
Numero totale elettori:8
Numero votanti:6
Nina ha votato! */

package Votazione;

import java.util.Scanner;

class Maggiorenne {
	protected String nome;
	static Boolean voto;
	protected static Maggiorenne[] votante;
	public static int j;
	
	public Maggiorenne(String nome) {
        this.nome = nome;
        this.voto = false;
        this.votante = new Maggiorenne[100];
        this.j = 0;
    }
	
	public String getNome() {
        return nome;
    }
	
	protected static void aggiungiVotante(Maggiorenne votanti) {
		if (j < 200) {
            votante[j] = votanti;
            j++;
        } else {
            System.out.println("La lista è piena, impossibile aggiungere altri votanti.");
        }
	}
	
	protected static void rimuoviVotante(Scanner scanner) {
		System.out.println("Inserisci il nome del votante da rimuovere:");
        String nome = scanner.nextLine();

        for (int i = 0; i < j; i++) {
            if (votante[i].getNome().equals(nome)) {
                for (int k = i; k < j - 1; k++) {
                    votante[k] = votante[k + 1];
                }
                votante[j - 1] = null;
                j--;
                System.out.println("Votante rimosso con successo");
                return;
            }
        }
        System.out.println("Votante non trovato");
    }
	
    public static Boolean vota() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Inserire il proprio voto:");
        String votato = scanner.nextLine();
    	voto = true;
    	return voto;
    }
}

public class Votazione {
	  public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		  
		  while (true) {
	            System.out.println("\nCosa vuoi fare?");
	            System.out.println("1. Aggiungi un votante");
	            System.out.println("2. Rimuovi un votante");
	            System.out.println("3. Vota");
	            System.out.println("4. Lista Elettori");
	            System.out.println("5. Visualizza chi ha votato");
	            System.out.println("6. Esci");

	            int scelta = scanner.nextInt();
	            scanner.nextLine();
	            switch (scelta) {
              case 1:
            	  System.out.println("Inserisci nome:");
                  String nome = scanner.nextLine();
                  Maggiorenne nuovoVotante = new Maggiorenne(nome);
                  Maggiorenne.aggiungiVotante(nuovoVotante);
                  System.out.println("Votante aggiunto con successo");
            	  Maggiorenne maggiorenne = new Maggiorenne(nome);
                  break;
              case 2:
              	  Maggiorenne.rimuoviVotante(scanner);
                  break;
              case 3:
                  Maggiorenne.vota();
                  break;
              case 4:
            	  System.out.println("\nLista Elettori");
  	              System.out.println("1. Mario Rossi");
  	              System.out.println("2. Anna Bianchi");
 	              System.out.println("3. Carlo Verdi");
 	              System.out.println("4. Giulia Russo");
  	              System.out.println("5. Marco Ferrari");
  	              System.out.println("6. Laura Neri");
            	  break;
              case 5:
            	  
                  break;
              case 6:
                  System.out.println("Arrivederci");
                  scanner.close();
                  return;
              default:
                  System.out.println("Scelta non valida. Riprova.");
	          }
		  }
	  }
}