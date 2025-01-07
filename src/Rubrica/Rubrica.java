/* Sviluppare un’app per gestire una rubrica telefonica.
Procedere creando 2 classi:
• Contatto(String nome, String cognome, String numero)
• GestoreRubrica() contenente un array di massimo 200 contatti
E all’interno della classe GestoreRubrica creare 2 metodi:
• aggiungiContatto() che permette di aggiungere un oggetto di tipo contatto all’array contatti
• stampa() che restituisce una stringa unica contenente la rubrica formattata come da esempio qui sotto
(ricordati che il carattere a capo è \n)
Rubrica
---------------------------
Roberto Baggio: 3334567890
Roberto Mancini: 3345645678
Alex Del Piero: 3569828402
Francesco Totti: 3498726632 */

package Rubrica;
import java.util.Scanner;

class Contatto {
	protected String nome;
	protected String cognome;
	protected String numero;
	public Contatto(String nome, String cognome, String numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero() {
        return numero;
    }
}
class GestoreRubrica {
	protected Contatto[] contatti;
	public int j;
	public GestoreRubrica(){
		this.contatti = new Contatto[200];
		this.j = 0;
	}
	protected void aggiungiContatto(Contatto contatto) {
		if (j < 200) {
            contatti[j] = contatto;
            j++;
        } else {
            System.out.println("La rubrica è piena, impossibile aggiungere altri contatti.");
        }
	}
	
	protected void rimuoviContatto(Scanner scanner) {
		System.out.println("Inserisci il nome del contatto da rimuovere:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome del contatto da rimuovere:");
        String cognome = scanner.nextLine();

        for (int i = 0; i < j; i++) {
            if (contatti[i].getNome().equals(nome) && contatti[i].getCognome().equals(cognome)) {
                for (int k = i; k < j - 1; k++) {
                    contatti[k] = contatti[k + 1];
                }
                contatti[j - 1] = null;
                j--;
                System.out.println("Contatto rimosso con successo");
                return;
            }
        }
        System.out.println("Contatto non trovato");
    }
	
	protected String stampa() {
		StringBuilder result = new StringBuilder();
        result.append("Rubrica\n");
        result.append("---------------------------\n");
        for (int i = 0; i < j; i++) {
            Contatto contatto = contatti[i];
            result.append(contatto.getNome()).append(" ").append(contatto.getCognome()).append(": ").append(contatto.getNumero()).append("\n");
        }
        return result.toString();
	}
}

public class Rubrica {
	  public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		  GestoreRubrica gestoreRubrica = new GestoreRubrica();

	        Contatto contatto1 = new Contatto("Roberto", "Baggio", "3334567890");
	        Contatto contatto2 = new Contatto("Roberto", "Mancini", "3345645678");
	        Contatto contatto3 = new Contatto("Alex", "Del Piero", "3569828402");
	        Contatto contatto4 = new Contatto("Francesco", "Totti", "3498726632");

	        gestoreRubrica.aggiungiContatto(contatto1);
	        gestoreRubrica.aggiungiContatto(contatto2);
	        gestoreRubrica.aggiungiContatto(contatto3);
	        gestoreRubrica.aggiungiContatto(contatto4);
	        
	        System.out.println("Benvenuto nella rubrica telefonica");

	        while (true) {
	            System.out.println("\nCosa vuoi fare?");
	            System.out.println("1. Aggiungi contatto");
	            System.out.println("2. Rimuovi contatto");
	            System.out.println("3. Visualizza rubrica");
	            System.out.println("4. Esci");

	            int scelta = scanner.nextInt();
	            scanner.nextLine();
	            switch (scelta) {
                case 1:
                    System.out.println("Inserisci nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci cognome:");
                    String cognome = scanner.nextLine();
                    System.out.println("Inserisci numero di telefono:");
                    String numero = scanner.nextLine();
                    Contatto nuovoContatto = new Contatto(nome, cognome, numero);
                    gestoreRubrica.aggiungiContatto(nuovoContatto);
                    System.out.println("Contatto aggiunto con successo.");
                    break;
                case 2:
                	gestoreRubrica.rimuoviContatto(scanner);
                    break;
                case 3:
                    System.out.println(gestoreRubrica.stampa());
                    break;
                case 4:
                    System.out.println("Arrivederci");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
	            }
	        }
	  }
}