package com.sebure.springcommonauth.service;

import com.sebure.springcommonauth.entity.AdminUser;

import java.util.List;

public interface AdminUserService {

    AdminUser getAdminUserByUsername(String username);

    AdminUser saveAdminUser(AdminUser adminUser);
    void deleteAdminUserById(Long id);
    AdminUser getAdminUserById(Long id);
    List<AdminUser> getAdminUserAll();

}
