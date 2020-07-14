package com.snip.down.security;

import com.snip.down.model.EndUser;
import com.snip.down.repository.EndUserRepo;
import com.snip.down.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserIdentity {

    private EndUser endUser;
    @Autowired
    private EndUserRepo endUserRepo;

    @Transactional(readOnly = true)
    public void create(String username) {
        EndUser user = endUserRepo.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw new ServiceException("Error");
        }
        this.endUser = user;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
