package com.registration.controller;

import com.registration.dto.RegistrationDto;
import com.registration.entity.RegistrationEntity;
import com.registration.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // http:localhost:8080/api/v1/registration/addRegistration

//    @PostMapping("/addRegistration")
//    public ResponseEntity<RegistrationDto> addRegistration(@RequestBody RegistrationDto dto){
//        RegistrationDto registrationDto = registrationService.addRegistration(dto);
//        return new ResponseEntity<>(registrationDto, HttpStatus.CREATED);
//    }

    // Delete the registration id;

    // http://localhost:8080/api/v1/registration?registrationId=1

//    @DeleteMapping
//    public ResponseEntity<String> deleteRegistration(@RequestParam long registrationId){
//        registrationService.deleteRegistration(registrationId);
//        return new ResponseEntity<>("Record is Deleted", HttpStatus.OK);
//    }


// http://localhost:8080/api/v1/registration/1

//    @PutMapping("/{registrationId}")
//    public ResponseEntity<RegistrationEntity> updateRegistration(
//            @PathVariable long registrationId,
//            @RequestBody RegistrationDto dto
//    ){
//        RegistrationEntity registration= registrationService.updateRegistration(registrationId, dto);
//        return new ResponseEntity<>(registration, HttpStatus.OK);
//    }

    // Get all Registration Data
    // http://localhost:8080/api/v1/registration/getRegistrationById?registrationId=1

//    @GetMapping("/getRegistrationById")
//    public ResponseEntity <List<RegistrationEntity>> getRegistrations(){
//        List<RegistrationEntity> registrationEntity = registrationService.getRegistrations();
//        return new ResponseEntity<>(registrationEntity, HttpStatus.OK);
//    }

//    @GetMapping("/getRegById")
//    public ResponseEntity<RegistrationEntity> getRegistration(
//            @RequestParam long registrationId // Changed parameter name to match the service method
//    ){
//        RegistrationEntity registrationEntity = registrationService.getRegistrationById(registrationId);
//        return new ResponseEntity<>(registrationEntity, HttpStatus.OK);
//    }

    @PostMapping("/addRegistration")
    public ResponseEntity<?> addRegistration(
           @Valid @RequestBody RegistrationDto dto,
           BindingResult result
    ){
        if(result .hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.OK);
        }

        RegistrationDto registrationDto= registrationService.addRegistration(dto);
        return new ResponseEntity<>(registrationDto, HttpStatus.CREATED);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long registrationId){
        registrationService.deleteRegistration(registrationId);
        return new ResponseEntity<>("Record is deleted", HttpStatus.OK);
    }
    @PutMapping("/{registrationId}")
    public ResponseEntity<RegistrationEntity> updateRegistration(
            @PathVariable long registrationId,
            @RequestBody RegistrationDto dto
    ){
       RegistrationEntity registrationEntity = registrationService.updateRegistration(registrationId, dto);
        return new ResponseEntity<>(registrationEntity, HttpStatus.OK);
    }
    @GetMapping("/getRegistrationById")
    public ResponseEntity <List<RegistrationDto>> getRegistrations(@RequestParam long registrationId){
       List <RegistrationDto> registrationEntitiesDto = registrationService.getRegistrations(registrationId);
       return new ResponseEntity<>(registrationEntitiesDto, HttpStatus.OK);
    }
    @GetMapping("/{getRegById}")
    public ResponseEntity<RegistrationEntity> getRegistration(
            @RequestParam long registrationId
    ){
       RegistrationEntity registrationEntity = registrationService.getRegistrationById(registrationId);
       return new ResponseEntity<>(registrationEntity, HttpStatus.OK);
    }
}


