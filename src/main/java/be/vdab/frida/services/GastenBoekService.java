package be.vdab.frida.services;

import be.vdab.frida.domain.GastenBoekEntry;

import java.util.List;

public interface GastenBoekService {
    long create(GastenBoekEntry entry);
    List<GastenBoekEntry> findAll();
    void delete(Long[] ids);
}
