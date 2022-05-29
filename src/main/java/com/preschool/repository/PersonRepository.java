package com.preschool.repository;

import com.preschool.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data SQL repository for the Person entity.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(
        value = "select distinct person from Person person left join fetch person.students",
        countQuery = "select count(distinct person) from Person person"
    )
    Page<Person> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct person from Person person left join fetch person.students")
    List<Person> findAllWithEagerRelationships();

    @Query("select person from Person person left join fetch person.students where person.id =:id")
    Optional<Person> findOneWithEagerRelationships(@Param("id") Long id);

//    @Query("select person from Person person left join fetch person.students where person.id =:id")
    Optional<Person> findOneByIdentificationNumber(String identificationNumber);
}
