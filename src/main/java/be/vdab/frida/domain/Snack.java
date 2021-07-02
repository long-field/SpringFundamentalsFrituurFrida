package be.vdab.frida.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class Snack {
    private final long id;
    @NotBlank
    private String naam;
    @NotNull
    @PositiveOrZero
    private BigDecimal prijs;

    public Snack(long id, String naam, BigDecimal prijs) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
}
