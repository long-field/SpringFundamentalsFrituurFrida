package be.vdab.frida.forms;

import be.vdab.frida.domain.GastenBoekEntry;

import java.time.LocalDate;

public class GastenBoekEntryForm extends GastenBoekEntry {
    public GastenBoekEntryForm(String naam, String bericht) {
        super(0, naam, LocalDate.now(), bericht); }

}
