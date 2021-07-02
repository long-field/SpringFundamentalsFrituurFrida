package be.vdab.frida.forms;

import javax.validation.constraints.NotBlank;

public class BeginNaamForm {

  @NotBlank private String begin;

    public String getBegin() {
        return begin;
    }

    public BeginNaamForm(String begin) {
        this.begin = begin;
    }
}
