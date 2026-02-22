package com.coutodev.marmiMvp.domain.Parceiros;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParceiroRepository extends JpaRepository<Parceiro, UUID> {
}
