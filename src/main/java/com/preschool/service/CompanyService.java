package com.preschool.service;

import com.preschool.domain.Company;
import com.preschool.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Company}.
 */
@ApplicationScoped
@Transactional
public class CompanyService {

    private final Logger log = LoggerFactory.getLogger(CompanyService.class);

    private final CompanyRepository companyRepository;

//    private final FilesStorageService filesStorageService;


    public CompanyService(CompanyRepository companyRepository) {//, FilesStorageService filesStorageService) {
        this.companyRepository = companyRepository;
//        this.filesStorageService = filesStorageService;
    }


    public Company save(Company company) {
        log.debug("Request to save Company : {}", company);
//        Util.commonCreateFields(company);
        companyRepository.persist(company);
        log.debug("new ID : {}", company.getId());
//        if (entity.getLogo() != null)
//            filesStorageService.persist(entity.getLogo());
        return company;
    }


    public Optional<Company> partialUpdate(Company company) {
        log.debug("Request to partially update Company : {}", company);

        return companyRepository
                .findByIdOptional(company.getId())
                .map(existingCompany -> {
                    if (company.getName() != null) {
                        existingCompany.setName(company.getName());
                    }
                    if (company.getAddress() != null) {
                        existingCompany.setAddress(company.getAddress());
                    }
                    if (company.getrNC() != null) {
                        existingCompany.setrNC(company.getrNC());
                    }
                    if (company.getEmail() != null) {
                        existingCompany.setEmail(company.getEmail());
                    }
                    if (company.getTelephone() != null) {
                        existingCompany.setTelephone(company.getTelephone());
                    }
                    if (company.getCellPhone() != null) {
                        existingCompany.setCellPhone(company.getCellPhone());
                    }
                    if (company.getLogo() != null) {
                        existingCompany.setLogo(company.getLogo());
                    }
                    if (company.getMotto() != null) {
                        existingCompany.setMotto(company.getMotto());
                    }
                    if (company.getPrimaryColor() != null) {
                        existingCompany.setPrimaryColor(company.getPrimaryColor());
                    }
                    if (company.getSecundaryColor() != null) {
                        existingCompany.setSecundaryColor(company.getSecundaryColor());
                    }
                    if (company.getMission() != null) {
                        existingCompany.setMission(company.getMission());
                    }
                    if (company.getVision() != null) {
                        existingCompany.setVision(company.getVision());
                    }
                    if (company.getValues() != null) {
                        existingCompany.setValues(company.getValues());
                    }
//                if (company.getCreatedBy() != null) {
//                    existingCompany.setCreatedBy(company.getCreatedBy());
//                }
//                if (company.getCreatedDate() != null) {
//                    existingCompany.setCreatedDate(company.getCreatedDate());
//                }
//                    TODO descomentar esto
//                    if (company.getUpdatedBy() != null) {
//                        existingCompany.setUpdatedBy(company.getUpdatedBy());
//                    }
//                if (company.getUpdatedDate() != null) {
//                    existingCompany.setUpdatedDate(company.getUpdatedDate());
//                }
//                if (company.getIsDelete() != null) {
//                    existingCompany.setIsDelete(company.getIsDelete());
//                }
//                if (company.getIsActive() != null) {
//                    existingCompany.setIsActive(company.getIsActive());
//                }
                    companyRepository.persist(existingCompany);
                    return existingCompany;
                });
    }


//    //    @Transactional(readOnly = true)
//    public Page<Company> findAll(Pageable pageable) {
//        log.debug("Request to get all Companies");
//        return companyRepository.findAll(pageable);
//    }


    //    @Transactional(readOnly = true)
    public Optional<Company> findOne(Long id) {
        log.debug("Request to get Company : {}", id);
        return companyRepository.findByIdOptional(id);
    }

    //    @Override
    public void delete(Long id) {
        log.debug("Request to delete Company : {}", id);
        companyRepository.deleteById(id);
    }
}
