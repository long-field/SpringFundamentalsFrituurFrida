package be.vdab.frida.repositories;

import be.vdab.frida.domain.GastenBoekEntry;

import java.util.List;

public interface GastenBoekRepository {
    long create(GastenBoekEntry entry);
    List<GastenBoekEntry> findAll();
    void delete(Long[] ids);
}
