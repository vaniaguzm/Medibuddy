package medibuddy.service;

import medibuddy.entity.FundacionEntity;
import medibuddy.repository.FundacionRepository;
import java.util.List;

public class FundacionService {

    private final FundacionRepository fundacionRepository;

    public FundacionService() {
        this.fundacionRepository = new FundacionRepository();
    }

    public void saveFundacion(FundacionEntity fundacion) {
        fundacionRepository.save(fundacion);
    }

    public FundacionEntity getFundacion(Long id) {
        return fundacionRepository.findById(id);
    }

    public List<FundacionEntity> getAllFundaciones() {
        return fundacionRepository.findAll();
    }

    public void updateFundacion(FundacionEntity fundacion) {
        fundacionRepository.update(fundacion);
    }

    public void deleteFundacion(Long id) {
        FundacionEntity fun = getFundacion(id);
        if (fun != null) {
            fundacionRepository.delete(fun);
        }
    }
}