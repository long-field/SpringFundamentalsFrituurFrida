package be.vdab.frida.domain;

public class Saus {
    private final long id;
    private final String naam;
    private final String[] ingredienten;

    public Saus(long id, String naam, String[] ingredienten) {
        this.id = id;
        this.naam = naam;
        this.ingredienten = ingredienten;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String[] getIngredienten() {
        return ingredienten;
    }
}
