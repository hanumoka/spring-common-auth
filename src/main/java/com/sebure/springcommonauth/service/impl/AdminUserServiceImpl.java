package com.sebure.springcommonauth.service.impl;

import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.repository.AdminUserRepository;
import com.sebure.springcommonauth.service.AdminUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository adminUserRepository;


    public AdminUserServiceImpl(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    public AdminUser getAdminUserByUsername(String username) {
        return adminUserRepository.findByUsername(username).orElse(null);
    }

    @Transactional
    @Override
    public AdminUser saveAdminUser(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    @Transactional
    @Override
    public void deleteAdminUserById(Long id) {
        adminUserRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public AdminUser getAdminUserById(Long id) {
        return adminUserRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AdminUser> getAdminUserAll() {
        return adminUserRepository.findAll();
    }
}
