package com.snip.down.service;

import com.snip.down.converter.SnipConverter;
import com.snip.down.model.Snip;
import com.snip.down.model.dto.SnipRequest;
import com.snip.down.model.dto.SnipResponse;
import com.snip.down.repository.SnipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class SnipService {

    private final SnipRepo snipRepo;

    @Autowired
    public SnipService(SnipRepo snipRepo) {
        this.snipRepo = snipRepo;
    }

    @Transactional
    public SnipResponse createSnip(SnipRequest request) {
        Snip snip = SnipConverter.dtoToEntity(request);
        snipRepo.save(snip);
        return SnipConverter.entityToDto(snip);
    }

    @Transactional(readOnly = true)
    public SnipResponse getSnip(long id) {
        Optional<Snip> snip = snipRepo.findById(id);
        if (snip.isPresent()) {
            return SnipConverter.entityToDto(snip.get());
        }
        return null;
    }

}
