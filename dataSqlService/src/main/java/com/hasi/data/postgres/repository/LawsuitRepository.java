package com.hasi.data.postgres.repository;

import com.hasi.data.postgres.entity.Lawsuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LawsuitRepository extends JpaRepository<Lawsuit, String> {
    Optional<Lawsuit> findByClientId(String clientId);

    Optional<Lawsuit> findByLawyerId(String lawyerId);

    Long countByLawyerId(String lawyerId);

    Long countByClientId(String clientId);
}
