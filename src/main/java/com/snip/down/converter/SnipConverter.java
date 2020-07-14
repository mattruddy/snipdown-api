package com.snip.down.converter;

import com.snip.down.model.Snip;
import com.snip.down.model.dto.SnipRequest;
import com.snip.down.model.dto.SnipResponse;

import java.sql.Timestamp;
import java.util.Date;

public class SnipConverter {

    public static Snip dtoToEntity(SnipRequest request) {
        Snip snip = new Snip();
        snip.setTitle(request.getTitle());
        snip.setBody(request.getBody());
        snip.setCreatedAt(Timestamp.from(new Date().toInstant()));
        return snip;
    }

    public static SnipResponse entityToDto(Snip snip) {
        SnipResponse response = new SnipResponse();
        response.setBody(snip.getBody());
        response.setTitle(snip.getTitle());
        response.setCreatedAt(snip.getCreatedAt());
        response.setId(snip.getId());
        return response;
    }

}
