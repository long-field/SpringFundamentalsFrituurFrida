package be.vdab.frida.repositories;

import be.vdab.frida.domain.Saus;

import java.util.List;

public interface SausRepository {
    List<Saus> findAll();
}
