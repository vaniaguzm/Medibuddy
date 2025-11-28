package medibuddy.service;

import medibuddy.model.Familiar;
import medibuddy.repository.FamiliarRepository;
import java.util.List;

public class FamiliarService {
    private final FamiliarRepository repository = new FamiliarRepository();

    public void crearFamiliar(Familiar familiar) {
        if (familiar.getAdultoMayorAsociado() == null) {
            throw new IllegalArgumentException("El familiar debe tener un Adulto Mayor asociado.");
        }
        repository.save(familiar);
    }

    // El resto queda igual que tu archivo original
    public List<Familiar> listarFamiliares() { return repository.findAll(); }
    public Familiar buscarFamiliarPorId(int id) { return repository.findById(id); }
    public void actualizarFamiliar(Familiar familiar) { repository.update(familiar); }
    public void eliminarFamiliar(Familiar familiar) { repository.delete(familiar); }
}