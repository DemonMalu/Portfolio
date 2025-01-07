/* Implementare un gestionale di vendite di prodotti generici (Televisore, Smartphone,
Libro) in grado di generare e stampare a video un ordine di acquisto contenente:
- Informazioni sul Cliente che ha acquistato i prodotti
- Specifica dei prodotti acquistati (numero, prezzo unitario...)

Gestire i prodotti libro, televisore e smartphone.
La descrizione di ciascun prodotto dovrà riassumere al suo interno un paio di
informazioni che caratterizzano i 3 prodotti sopra elencati.
La stampa dovrà contenere le informazioni sul cliente, i prodotti acquistati e il totale
pagato 

Modificare l’esercizio per casa in modo da aggiungere due classi enum.
La prima deve rappresentare la categoria del prodotto (CELLULARE,
TELEVISORE, LIBRO)
La seconda deve enumerare lo stato dell’ordine (IN_LAVORAZIONE, SPEDITO,
CONSEGNATO)
Applicare al secondo enum un costruttore in modo tale da poter restituire l’attributo
descrizione tramite un getter (ad esempio per IN_LAVORAZIONE, la descrizione
sarà "In lavorazione")
Restituire a video:
- Lo stato dell’ordine a fine pagina
- La categoria del prodotto nella stampa della riga dell’ordine*/

package Negozio;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Cliente {
    private String nome;
    private String cognome;

    public Cliente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}

class Prodotto {
    protected String nome;
    protected double prezzoUnitario;

    public Prodotto(String nome, double prezzoUnitario) {
        this.nome = nome;
        this.prezzoUnitario = prezzoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }
}

class Libro extends Prodotto {
    private String autore;

    public Libro(String nome, double prezzoUnitario, String autore) {
        super(nome, prezzoUnitario);
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }
}

class Televisore extends Prodotto {
    private int pollici;

    public Televisore(String nome, double prezzoUnitario, int pollici) {
        super(nome, prezzoUnitario);
        this.pollici = pollici;
    }

    public int getPollici() {
        return pollici;
    }
}

class Smartphone extends Prodotto {
    private String marca;

    public Smartphone(String nome, double prezzoUnitario, String marca) {
        super(nome, prezzoUnitario);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}

class Carrello {
    private Cliente cliente;
    private ArrayList<Prodotto> prodotti;
    private LocalDate dataOrdine;

    public Carrello(Cliente cliente, ArrayList<Prodotto> prodotti, LocalDate dataOrdine) {
        this.cliente = cliente;
        this.prodotti = prodotti;
        this.dataOrdine = dataOrdine;
    }

    public void stampaOrdine() {
        System.out.println("Ordine di Acquisto:");
        System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getCognome());
        System.out.println("Data ordine: " + formatDate(dataOrdine));
        System.out.println("Prodotti Acquistati:");
        for (Prodotto prodotto : prodotti) {
            System.out.println("Categoria: " + Categoria.getCategoria(prodotto) + " - " + prodotto.getNome() + " - Prezzo unitario: " + prodotto.getPrezzoUnitario() + "€");
        }
        double totale = calcolaTotale();
        System.out.println("Totale Pagato: " + totale + "€");
        System.out.println("Stato dell'ordine: " + Stato.IN_LAVORAZIONE.getDescrizione());
    }

    private double calcolaTotale() {
        double totale = 0;
        for (Prodotto prodotto : prodotti) {
            totale += prodotto.getPrezzoUnitario();
        }
        return totale;
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }
    
}

enum Categoria{
    TELEVISORE,
    SMARTPHONE,
    LIBRO;
	
	public static Categoria getCategoria(Prodotto prodotto) {
        if (prodotto instanceof Televisore) {
            return Categoria.TELEVISORE;
        } else if (prodotto instanceof Smartphone) {
            return Categoria.SMARTPHONE;
        } else if (prodotto instanceof Libro) {
            return Categoria.LIBRO;
        }
        return null;
    }
}

enum Stato{
    IN_LAVORAZIONE("In lavorazione"),
    SPEDITO("Spedito"),
    CONSEGNATO("Consegnato");

    protected String descrizione;

    Stato(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}

public class Negozio {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Mario", "Rossi");
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        prodotti.add(new Libro("Percy Jackson", 15.99, "Rick Riordan"));
        prodotti.add(new Televisore("Samsung Smart TV", 599.99, 55));
        prodotti.add(new Smartphone("S23", 649.99, "Samsung"));

        LocalDate dataOrdine = LocalDate.of(2021, 5, 24);

        Carrello ordine = new Carrello(cliente, prodotti, dataOrdine);
        ordine.stampaOrdine();
    }
}




