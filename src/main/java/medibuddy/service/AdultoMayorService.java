package medibuddy.service;

import medibuddy.model.AdultoMayor;
import medibuddy.model.Medicamento;
import medibuddy.repository.AdultoMayorRepository;
import java.util.List;

public class AdultoMayorService {

    private final AdultoMayorRepository repository = new AdultoMayorRepository();

    public void crearAdultoMayor(AdultoMayor adultoMayor) {
        repository.save(adultoMayor);
    }

    public List<AdultoMayor> listarAdultosMayores() {
        return repository.findAll();
    }

    public AdultoMayor buscarAdultoMayorPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarAdultoMayor(AdultoMayor adultoMayor) {
        repository.update(adultoMayor);
    }

    public void eliminarAdultoMayor(AdultoMayor adultoMayor) {
        repository.delete(adultoMayor);
    }

    public void agregarMedicamentoAAdultoMayor(int idAdultoMayor, Medicamento medicamento) {
        AdultoMayor adultoMayor = buscarAdultoMayorPorId(idAdultoMayor);
        if (adultoMayor != null) {
            adultoMayor.agregarMedicamento(medicamento);
            actualizarAdultoMayor(adultoMayor);
        }
    }
}
