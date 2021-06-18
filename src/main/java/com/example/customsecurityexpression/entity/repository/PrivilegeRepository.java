package com.example.customsecurityexpression.entity.repository;

import com.example.customsecurityexpression.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Silauras
 * Created on 18.06.2021 at 13:35
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    public Privilege findByName(String name);
}
