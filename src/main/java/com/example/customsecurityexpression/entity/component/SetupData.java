package com.example.customsecurityexpression.entity.component;

import com.example.customsecurityexpression.entity.Organization;
import com.example.customsecurityexpression.entity.Privilege;
import com.example.customsecurityexpression.entity.User;
import com.example.customsecurityexpression.entity.repository.OrganizationRepository;
import com.example.customsecurityexpression.entity.repository.PrivilegeRepository;
import com.example.customsecurityexpression.entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Silauras
 * Created on 18.06.2021 at 13:34
 */

@Component
public class SetupData {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @PostConstruct
    public void init(){
        initPrivileges();
        initOranizations();
        initUsers();
    }

    private void initPrivileges(){
        Privilege privilege1 = new Privilege("FOO_READ_PRIVILEGE");
        privilegeRepository.save(privilege1);

        Privilege privilege2 = new Privilege("FOO_WRITE_PRIVILEGE");
        privilegeRepository.save(privilege2);
    }

    private void initOranizations(){
        Organization org1 = new Organization("FirstOrg");
        organizationRepository.save(org1);

        Organization org2 = new Organization("SecondOrg");
        organizationRepository.save(org2);
    }

    private void initUsers(){
        Privilege privilege1 = privilegeRepository.findByName("FOO_READ_PRIVILEGE");
        Privilege privilege2 = privilegeRepository.findByName("FOO_WRITE_PRIVILEGE");

        User user1 = new User();
        user1.setUsername("john");
        user1.setPassword("123");
        user1.setPrivileges(new HashSet<Privilege>(Arrays.asList(privilege1)));
        user1.setOrganization(organizationRepository.findByName("FirstOrg"));
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("tom");
        user2.setPassword("111");
        user2.setPrivileges(new HashSet<Privilege>(Arrays.asList(privilege1, privilege2)));
        user2.setOrganization(organizationRepository.findByName("SecondOrg"));
        userRepository.save(user2);
    }
}
