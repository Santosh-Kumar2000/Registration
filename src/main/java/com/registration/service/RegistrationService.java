package com.registration.service;

import com.registration.dto.RegistrationDto;
import com.registration.entity.RegistrationEntity;

import java.util.List;

public interface RegistrationService {
    RegistrationDto addRegistration(RegistrationDto dto);

    void deleteRegistration(long registrationId);

    RegistrationEntity updateRegistration(long registrationId, RegistrationDto dto);

    List<RegistrationDto> getRegistrations(long registrationId);

    RegistrationEntity getRegistrationById(long registrationId);


//    RegistrationDto addRegistration(RegistrationDto dto);
//    void deleteRegistration(long registrationId);
//    RegistrationEntity updateRegistration(long registrationId, RegistrationDto dto);
//    ResponseEntity getRegistration(long registrationId);
//    List<RegistrationEntity> getRegistrations();
//    RegistrationEntity getRegistrationById(long registrationId);
}
