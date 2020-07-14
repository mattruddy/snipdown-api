package com.snip.down.repository;

import com.snip.down.model.Snip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnipRepo extends JpaRepository<Snip, Long> {
}
