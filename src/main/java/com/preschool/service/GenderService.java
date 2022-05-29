package com.preschool.service;

import com.preschool.domain.Gender;
import com.preschool.repository.GenderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Gender}.
 */
@ApplicationScoped
@Transactional
public class GenderService  {

    private final Logger log = LoggerFactory.getLogger(GenderService.class);

    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public Gender save(Gender gender) {
        log.debug("Request to save Gender : {}", gender);
//        Util.commonCreateFields(gender);
         genderRepository.persist(gender);
         return gender;
    }

    public Optional<Gender> partialUpdate(Gender gender) {
        log.debug("Request to partially update Gender : {}", gender);

        return genderRepository
            .findByIdOptional(gender.getId())
            .map(existingGender -> {
                if (gender.getDescription() != null) {
                    existingGender.setDescription(gender.getDescription());
                }
//                if (gender.getCreatedBy() != null) {
//                    existingGender.setCreatedBy(gender.getCreatedBy());
//                }
//                if (gender.getCreatedDate() != null) {
//                    existingGender.setCreatedDate(gender.getCreatedDate());
//                }
                if (gender.getUpdatedBy() != null) {
                    existingGender.setUpdatedBy(gender.getUpdatedBy());
                }
//                if (gender.getUpdatedDate() != null) {
//                    existingGender.setUpdatedDate(gender.getUpdatedDate());
//                }
//                if (gender.getIsDelete() != null) {
//                    existingGender.setIsDelete(gender.getIsDelete());
//                }
//                if (gender.getIsActive() != null) {
//                    existingGender.setIsActive(gender.getIsActive());
//                }
                genderRepository.persist(existingGender);
                return existingGender;
            });
    }

//    @Transactional(readOnly = true)
    public List<Gender> findAll() {
        log.debug("Request to get all Genders");
        return genderRepository.listAll();
    }

//    @Transactional(readOnly = true)
    public Optional<Gender> findOne(Long id) {
        log.debug("Request to get Gender : {}", id);
        return genderRepository.findByIdOptional(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Gender : {}", id);
        genderRepository.deleteById(id);
    }
}
