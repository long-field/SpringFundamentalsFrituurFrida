package be.vdab.frida.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class SausRaden implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int MAX_VERKEERDE_POGINGEN = 10;
    private String saus;
    private StringBuilder puntjes;
    private int verkeerdePogingen;

    public void reset(String saus) {
        this.saus = saus;
        puntjes = new StringBuilder(".".repeat(saus.length()));
        verkeerdePogingen = 0;
    }

    public void gok(char letter) {
        var letterIndex = saus.indexOf(letter);
        if (letterIndex == -1) {
            verkeerdePogingen++;
        } else {
            do {
                puntjes.setCharAt(letterIndex, letter);
                letterIndex = saus.indexOf(letter, letterIndex + 1);
            } while (letterIndex != -1);
        }
    }

    public String getPuntjes() {
        return puntjes.toString();
    }

    public String getSaus() {
        return saus;
    }

    public int getVerkeerdePogingen() {
        return verkeerdePogingen;
    }

    public boolean isGewonnen() {
        return puntjes.indexOf(".") == -1;
    }

    public boolean isVerloren() {
        return verkeerdePogingen == MAX_VERKEERDE_POGINGEN;
    }


}
