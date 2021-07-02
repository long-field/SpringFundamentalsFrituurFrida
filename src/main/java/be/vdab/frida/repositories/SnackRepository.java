package be.vdab.frida.repositories;

import be.vdab.frida.domain.Snack;

import java.util.List;
import java.util.Optional;

public interface SnackRepository {
    Optional<Snack> findById(long id);
    void update(Snack snack);
    List<Snack> findByBeginNaam(String beginNaam);

}
