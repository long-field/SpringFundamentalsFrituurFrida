package be.vdab.frida.forms;

import javax.validation.constraints.NotNull;

public class SausRadenForm {
    @NotNull
    private final Character letter;

    public SausRadenForm(Character letter) {
        this.letter = letter;
    }

    public Character getLetter() {
        return letter;
    }
}
