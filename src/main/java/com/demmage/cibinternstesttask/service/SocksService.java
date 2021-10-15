package com.demmage.cibinternstesttask.service;

import com.demmage.cibinternstesttask.domain.Socks;
import com.demmage.cibinternstesttask.exception.BadSocksException;
import com.demmage.cibinternstesttask.exception.NoSuchOperationException;
import com.demmage.cibinternstesttask.exception.NoSuchSocksQuantityException;
import com.demmage.cibinternstesttask.exception.SocksNotFoundException;
import com.demmage.cibinternstesttask.repo.SocksRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Vadim Guseynov
 */

@Service
@RequiredArgsConstructor
public class SocksService {

    private final SocksRepo repo;

    public int get(String color, String operation, int cottonPart) {
        switch (operation) {
            case "moreThan":
                return repo.findByColorAndCottonPartGreaterThan(color, cottonPart).orElseThrow(SocksNotFoundException::new).getQuantity();
            case "equal":
                return repo.findByColorAndCottonPartEquals(color, cottonPart).orElseThrow(SocksNotFoundException::new).getQuantity();
            case "lessThan":
                return repo.findByColorAndCottonPartLessThan(color, cottonPart).orElseThrow(SocksNotFoundException::new).getQuantity();
            default:
                throw new NoSuchOperationException("No such operation - " + operation);
        }
    }

    public void acceptIncome(Socks socks) {
        validate(socks);

        Optional<Socks> optional = repo.findByColorAndCottonPart(socks.getColor(), socks.getCottonPart());
        if (optional.isPresent()) {
            Socks socksFromRepo = optional.get();

            socksFromRepo.setQuantity(socks.getQuantity() + socksFromRepo.getQuantity());

            repo.save(socksFromRepo);
        } else {
            repo.save(socks);
        }
    }

    public void acceptOutcome(Socks socks) {
        validate(socks);

        Socks socksFromRepo = repo.findByColorAndCottonPart(socks.getColor(), socks.getCottonPart()).orElseThrow(SocksNotFoundException::new);

        if (socksFromRepo.getQuantity() - socks.getQuantity() < 0) {
            throw new NoSuchSocksQuantityException();
        }

        socksFromRepo.setQuantity(socksFromRepo.getQuantity() - socks.getQuantity());
        repo.save(socksFromRepo);
    }

    private void validate(Socks socks) {
        if (socks.getQuantity() <= 0) {
            throw new BadSocksException("Invalid quantity");
        } else if (socks.getCottonPart() < 0 || socks.getCottonPart() > 100) {
            throw new BadSocksException("Invalid cotton part value");
        }
    }
}
