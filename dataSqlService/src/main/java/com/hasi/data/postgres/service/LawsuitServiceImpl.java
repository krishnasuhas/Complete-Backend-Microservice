package com.hasi.data.postgres.service;

import com.hasi.data.postgres.entity.Lawsuit;
import com.hasi.data.postgres.repository.LawsuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class LawsuitServiceImpl implements LawsuitService {

    @Autowired
    LawsuitRepository lawsuitRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Lawsuit> getAllLawsuit() {
        return lawsuitRepository.findAll();
    }

    @Override
    public Lawsuit getLawsuitById(String lawsuitId) {
        return lawsuitRepository.findById(lawsuitId).orElse(null);
    }

    @Override
    public Lawsuit addNewLawsuit(Lawsuit lawsuit) {
        return lawsuitRepository.save(lawsuit);
    }

    @Override
    public Lawsuit updateLawsuit(Lawsuit lawsuit) {
        return lawsuitRepository.save(lawsuit);
    }

    @Override
    public void deleteLawsuit(String lawsuitId) {
        lawsuitRepository.deleteById(lawsuitId);
    }

    @Override
    public Long countLawsuitByLawyerId(String lawyerId) {
        return lawsuitRepository.countByLawyerId(lawyerId);
    }

    @Override
    public Long countLawsuitByClientId(String clientId) {
        return lawsuitRepository.countByClientId(clientId);
    }
}
