package com.registration.service;

import com.registration.dto.RegistrationDto;
import com.registration.entity.RegistrationEntity;
import com.registration.exception.ResourceNotFoundException;
import com.registration.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationImpl implements RegistrationService {
    private RegistrationRepository registrationRepository;

    public RegistrationImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @Override
    public RegistrationDto addRegistration(RegistrationDto dto) {
        RegistrationEntity entity = dtoToEntity(dto);

        RegistrationEntity savedRegistration = registrationRepository.save(entity);

        RegistrationDto rd = entityToDto(savedRegistration);
        return rd;
    }

    RegistrationEntity dtoToEntity(RegistrationDto dto){
        RegistrationEntity entity = new RegistrationEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;
    }

    RegistrationDto entityToDto (RegistrationEntity entity){
        RegistrationDto rd = new RegistrationDto();
        rd.setId(entity.getId());
        rd.setName(entity.getName());
        rd.setEmail(entity.getEmail());
        rd.setMobile(entity.getMobile());
        rd.setDate(new Date());
        return rd;
    }


    @Override
    public void deleteRegistration(long registrationId) {
        registrationRepository.deleteById(registrationId);
    }

    @Override
    public RegistrationEntity updateRegistration(long registrationId, RegistrationDto dto) {
        Optional<RegistrationEntity> byId = registrationRepository.findById(registrationId);
        RegistrationEntity registrationEntity = byId.get();
        registrationEntity.setName(dto.getName());
        registrationEntity.setEmail(dto.getEmail());
        registrationEntity.setMobile(dto.getMobile());
        return registrationRepository.save(registrationEntity);
    }

    @Override
    public List<RegistrationDto> getRegistrations(long registrationId) {
        List<RegistrationEntity> registrationEntity = registrationRepository.findAll();
        List<RegistrationDto> rd = registrationEntity.stream().map(p -> entityToDto(p)).collect(Collectors.toList());
        return rd;
    }


//    @Override
//    public RegistrationEntity getRegistrationById(long registrationId) {
//        RegistrationEntity  registrationEntity= registrationRepository.findById(registrationId).get();
//        return regi       strationEntity;
//    }

    @Override
    public RegistrationEntity getRegistrationById(long registrationId) {
        RegistrationEntity  registrationEntity= registrationRepository.findById(registrationId).orElseThrow(
                () -> new ResourceNotFoundException("user not found with id: "+ registrationId)
        );
        return registrationEntity;
    }
}

//    @Override
//    public RegistrationDto addRegistration(RegistrationDto dto) {
//        RegistrationEntity entity = new RegistrationEntity();
//        //entity.setId(dto.getId());
//        entity.setName(dto.getName());
//        entity.setEmail(dto.getEmail());
//        entity.setMobile(dto.getMobile());
//        RegistrationEntity savedRegistration = registrationRepository.save(entity);

//        RegistrationDto rd = new RegistrationDto();
//        rd.setId(savedRegistration.getId());
//        rd.setName(savedRegistration.getName());
//        rd.setEmail(savedRegistration.getEmail());
//        rd.setMobile(savedRegistration.getMobile());
//        return rd;
//    }

//    @Override
//    public void deleteRegistration(long registrationId) {
//        registrationRepository.deleteById(registrationId);
//    }

//    @Override
//    public RegistrationEntity updateRegistration(long registrationId, RegistrationDto dto) {
//        Optional<RegistrationEntity> byId = registrationRepository.findById(registrationId);
//        RegistrationEntity registrationEntity = byId.get();
//        registrationEntity.setName(dto.getName());
//        registrationEntity.setEmail(dto.getEmail());
//        registrationEntity.setMobile(dto.getMobile());
//        return registrationRepository.save(registrationEntity);
//    }

//    @Override
//    public ResponseEntity getRegistration(long registrationId) {
//        Optional<RegistrationEntity> byId = registrationRepository.findById(registrationId);
//        RegistrationEntity registration = byId.get();
//        return null;
//    }

//    @Override
//    public List<RegistrationEntity> getRegistrations() {
//        return registrationRepository.findAll();
//    }

//    @Override
//    public RegistrationEntity getRegistrationById(long registrationId) {
//        // Corrected the variable initialization
//        RegistrationEntity registrationEntity = registrationRepository.findById(registrationId).get();
//        return registrationEntity;
//    }

//    @Override
//    public RegistrationEntity getRegistrationById(long registrationId){
//        RegistrationEntity registrationEntity = registrationRepository.findById(registrationId).orElseThrow(
//                ()-> new ResourceNotFoundException("user can not found with id: " + registrationId)
//        );
//        return registrationEntity;
//    }

//}
