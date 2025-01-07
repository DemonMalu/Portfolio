/* Costruiamo un calendario del mese di gennaio 2024.
Tramite una struttura iterativa inserire in un array di 31 campi i numeri interi da 1 a
31. Invece tramite la sintassi diretta istanziare un array di Stringhe composto dai
giorni della settimana («Lunedì», «Martedì»...)
Tramite una struttura iterativa diversa dalla precedente, pubblicare a video la
coppia di numero del giorno associato al nome del giorno della settimana.
1 Gennaio Domenica
2 Gennaio Lunedi
3 Gennaio Martedi
4 Gennaio Mercoledi
ecc  */

package Gennaio;

public class Gennaio {
	  public static void main(String[] args) {
	    String [] calendario = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
	    int j = 0;
	    for(int i = 1; i<=31; i++){
	    	if(j<calendario.length) {
	    		System.out.println(calendario[j] + " " + i + " " + "Gennaio");
	    		j++;
	    	}
	    	else {
	    		j = 0;
	    		i--;
	    	}
	    }
	  }
}