package com.registration.repository;

import com.registration.entity.RegistrationEntity;
import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {

}
