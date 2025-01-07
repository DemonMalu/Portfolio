package Calendario;
import java.util.Scanner;

public class Calendario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int NUMERO_MESI = 12;
        int[][] calendario = new int[NUMERO_MESI][31];
        for (int i = 0; i < NUMERO_MESI; i++) {
            int giorniInQuestoMese;
            switch (i) {
                case 1:
                    giorniInQuestoMese = 28;
                    break;
                case 3:
                case 5:
                case 8:
                case 10:
                    giorniInQuestoMese = 30;
                    break;
                default:
                    giorniInQuestoMese = 31;
            }
            calendario[i] = new int[giorniInQuestoMese];
        }
        
        System.out.println("Inserisci l'anno:");
        int anno = scanner.nextInt();
        
        System.out.println("Inserisci il mese (1-12):");
        int mese = scanner.nextInt();
        while (mese < 1 || mese > 12) {
            System.out.println("Il mese inserito non è valido. Inserisci un numero compreso tra 1 e 12:");
            mese = scanner.nextInt();
        }
        int giorniInQuestoMese = calendario[mese - 1].length;
        if (mese == 2) {
            if (anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0)) {
                giorniInQuestoMese = 29;
            }
        }
        
        System.out.println("Inserisci il giorno (1-" + giorniInQuestoMese + "):");
        int giorno = scanner.nextInt();
        while (giorno < 1 || giorno > giorniInQuestoMese) {
            System.out.println("Il giorno inserito non è valido. Inserisci un numero compreso tra 1 e " + calendario[mese - 1].length + ":");
            giorno = scanner.nextInt();
        }
        
        int giornoSettimana = calcolaGiornoSettimana(anno, mese, giorno);
        String nomeGiornoSettimana = nomeGiorno(giornoSettimana);
        System.out.println("Il giorno corrispondente è " + nomeGiornoSettimana);
        
        scanner.close();
    }
    
    public static int calcolaGiornoSettimana(int anno, int mese, int giorno) {
        int q = giorno;
        int m = mese;
        int j = anno / 100;
        int k = anno % 100;
        
        if (m == 1 || m == 2) {
            m += 12;
            k--;
        }
        
        int h = (q + (int)((m + 1) * 26.0 / 10) + k + (int)(k / 4) + (int)(j / 4) + 5 * j) % 7;
        
        return h;
    }
    
    public static String nomeGiorno(int giornoSettimana) {
        switch (giornoSettimana) {
            case 0: return "Sabato";
            case 1: return "Domenica";
            case 2: return "Lunedì";
            case 3: return "Martedì";
            case 4: return "Mercoledì";
            case 5: return "Giovedì";
            case 6: return "Venerdì";
            default: return "";
        }
    }
}

