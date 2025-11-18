package medibuddy.service;

import medibuddy.entity.Fundacion;
import medibuddy.repository.FundacionRepository;
import java.util.List;

public class FundacionService {

    private final FundacionRepository fundacionRepository;

    public FundacionService() {
        this.fundacionRepository = new FundacionRepository();
    }

    public void saveFundacion(Fundacion fundacion) {
        fundacionRepository.save(fundacion);
    }

    public Fundacion getFundacion(Long id) {
        return fundacionRepository.findById(id);
    }

    public List<Fundacion> getAllFundaciones() {
        return fundacionRepository.findAll();
    }

    public void updateFundacion(Fundacion fundacion) {
        fundacionRepository.update(fundacion);
    }

    public void deleteFundacion(Long id) {
        Fundacion fun = getFundacion(id);
        if (fun != null) {
            fundacionRepository.delete(fun);
        }
    }
}