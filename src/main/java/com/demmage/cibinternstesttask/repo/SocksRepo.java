package com.demmage.cibinternstesttask.repo;

import com.demmage.cibinternstesttask.domain.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Vadim Guseynov
 */

@Repository
public interface SocksRepo extends JpaRepository<Socks, Long> {

    Optional<Socks> findByColorAndCottonPart(String color, int cottonPart);

    Optional<Socks> findByColorAndCottonPartEquals(String color, int cottonPart);

    Optional<Socks> findByColorAndCottonPartGreaterThan(String color, int cottonPart);

    Optional<Socks> findByColorAndCottonPartLessThan(String color, int cottonPart);

}