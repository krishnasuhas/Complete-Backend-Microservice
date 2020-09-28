package com.hasi.data.postgres.service;

import com.hasi.data.postgres.entity.Lawsuit;

import java.util.List;

public interface LawsuitService {
    List<Lawsuit> getAllLawsuit();

    Lawsuit getLawsuitById(String lawsuitId);

    Lawsuit addNewLawsuit(Lawsuit lawsuit);

    Lawsuit updateLawsuit(Lawsuit lawsuit);

    void deleteLawsuit(String lawsuitId);

    Long countLawsuitByLawyerId(String lawyerId);

    Long countLawsuitByClientId(String clientId);
}
