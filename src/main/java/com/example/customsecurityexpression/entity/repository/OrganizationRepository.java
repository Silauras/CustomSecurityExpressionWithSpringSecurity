package com.example.customsecurityexpression.entity.repository;

import com.example.customsecurityexpression.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Silauras
 * Created on 18.06.2021 at 13:35
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    public Organization findByName(String name);
}
