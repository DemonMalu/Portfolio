/* Creare una classe astratta Saluto che definisca il processo di saluto maschile e femminile.
Il metodo saluta dovrà richiamare in sequenza 3 metodi: • Buongiorno (restituisce la stringa
"Buongiorno ") • Titolo (restituisce "signora " oppure "signor ") - astratto
• Nome (restituisce il nome della persona salutata)
Di seguito il main:
SalutoMaschile pino = new SalutoMaschile("Pino");
SalutoFemminile gina = new SalutoFemminile("Gina");
pino.saluta();
gina.saluta();
Di seguito l’output a video:
Buongiorno signor Pino
Buongiorno signora Gina */

package Saluti;

abstract class Saluto{
	String nome;
	public Saluto(String nome) {
		this.nome=nome;
	}
	public void saluta() {
		buongiorno();
		titolo();
		nome();
	}
	
	private void buongiorno() {
		System.out.print("Buongiorno ");
	}
	
	protected abstract void titolo();
	
	private void nome() {
		System.out.println(nome + ".");
	}
}

class SalutoMaschile extends Saluto{
	
	public SalutoMaschile(String nome) {
		super(nome);
	}

	protected void titolo() {
		System.out.print("signor ");
	}
}

class SalutoFemminile extends Saluto{
	
	public SalutoFemminile(String nome) {
		super(nome);
	}

	protected void titolo() {
		System.out.print("signora ");
	}
}

public class Main{
	public static void main(String[] args) {
		SalutoMaschile pino = new SalutoMaschile("Pino");
		SalutoFemminile gina = new SalutoFemminile("Gina");
		pino.saluta();
		gina.saluta();
	}
}


