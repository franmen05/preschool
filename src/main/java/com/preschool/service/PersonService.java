package com.preschool.service;

import com.preschool.domain.Person;
import com.preschool.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Person}.
 */
@Service
@Transactional
public class PersonService {

    private final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;
    private final UserService userService;
//    private final FilesStorageService filesStorageService;

    public PersonService(PersonRepository personRepository, UserService userService
//                         ,FilesStorageService filesStorageService
    ) {
        this.personRepository = personRepository;
        this.userService = userService;
//        this.filesStorageService = filesStorageService;
    }

    public Person save(Person person) {
        log.debug("Request to save Person : {}", person);
//        Util.commonCreateFields(person);
//        var user=userService.createUser(AdminUserDTO.build(person));
//        person.setUser(user);

        var entity=  personRepository.save(person);
//        if(entity.getPicture()!=null)
//            filesStorageService.persist(entity.getPicture());
        return entity;
    }


    public Person update(Person person) {
        log.debug("Request to save Person : {}", person);
        var entity=  personRepository.save(person);
//        if(entity.getPicture()!=null)
//            filesStorageService.persist(entity.getPicture());
        return entity;
    }


    public Optional<Person> partialUpdate(Person person) {
        log.debug("Request to partially update Person : {}", person);

        return personRepository
            .findById(person.getId())
            .map(existingPerson -> {
                if (person.getFirstName() != null) {
                    existingPerson.setFirstName(person.getFirstName());
                }
                if (person.getLastName() != null) {
                    existingPerson.setLastName(person.getLastName());
                }
                if (person.getBirthday() != null) {
                    existingPerson.setBirthday(person.getBirthday());
                }
                if (person.getIdentificationNumber() != null) {
                    existingPerson.setIdentificationNumber(person.getIdentificationNumber());
                }
                if (person.getAddress() != null) {
                    existingPerson.setAddress(person.getAddress());
                }
                if (person.getEmail() != null) {
                    existingPerson.setEmail(person.getEmail());
                }
                if (person.getPicture() != null) {
                    existingPerson.setPicture(person.getPicture());
                }
                if (person.getTelephone() != null) {
                    existingPerson.setTelephone(person.getTelephone());
                }
                if (person.getCellphone() != null) {
                    existingPerson.setCellphone(person.getCellphone());
                }
//                if (person.getCreatedBy() != null) {
//                    existingPerson.setCreatedBy(person.getCreatedBy());
//                }
//                if (person.getCreatedDate() != null) {
//                    existingPerson.setCreatedDate(person.getCreatedDate());
//                }
                if (person.getUpdatedBy() != null) {
                    existingPerson.setUpdatedBy(person.getUpdatedBy());
                }
//                if (person.getUpdatedDate() != null) {
//                    existingPerson.setUpdatedDate(person.getUpdatedDate());
//                }
//                if (person.getIsDelete() != null) {
//                    existingPerson.setIsDelete(person.getIsDelete());
//                }
//                if (person.getIsActive() != null) {
//                    existingPerson.setIsActive(person.getIsActive());
//                }

//                Util.commonUpdateFields(existingPerson);
                return existingPerson;
            })
            .map(personRepository::save);
    }

    @Transactional
    public Page<Person> findAll(Pageable pageable) {
        log.debug("Request to get all People");
        return personRepository.findAll(pageable);
    }

    public Page<Person> findAllWithEagerRelationships(Pageable pageable) {
        return personRepository.findAllWithEagerRelationships(pageable);
    }

    @Transactional
    public Optional<Person> findOne(Long id) {
        log.debug("Request to get Person : {}", id);
        return personRepository.findOneWithEagerRelationships(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Person : {}", id);
        findOne(id).ifPresent(person -> userService.deleteUser(person.getUser().getLogin()));
        personRepository.deleteById(id);
    }
}
