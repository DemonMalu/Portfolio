/* Utilizzando esclusivamente una classe enum GiornoDellaSettimana (senza utilizzare la classe Time),
sviluppare un metodo next() per implementare un programma che restituisca a video:
Oggi è GIOVEDI
Domani è VENERDI
Dopodomani è SABATO
Si potrebbe ad esempio utilizzare il metodo ordinal() ereditato dalla classe Enum.
Inizializzare il giorno di oggi all’avvio del programma e ricavare man mano il giorno successivo utilizzando
il metodo next().
GiornoDellaSettimana oggi = GiornoDellaSettimana.GIOVEDI; */

package Giorno;

enum GiornoDellaSettimana{
	LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO,
	DOMENICA;
	
	public GiornoDellaSettimana next() {
		int nextIndex = (this.ordinal() + 1) % values().length;
        return values()[nextIndex];
	}
}

public class Giorni{
	public static void main(String[] args) {
		GiornoDellaSettimana oggi = GiornoDellaSettimana.GIOVEDI;
		System.out.println("Oggi è " + oggi);
		for (int i = 0; i < 2; i++) {
            oggi = oggi.next();
            System.out.println(getGiornoString(oggi, i + 1));
        }
	}

	private static String getGiornoString(GiornoDellaSettimana giorno, int giorni) {
        switch (giorni) {
            case 1:
                return "Domani è " + giorno;
            case 2:
                return "Dopodomani è " + giorno;
            default:
                return giorno.toString();
        }
    }
}