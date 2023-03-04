package com.sebure.springcommonauth.service;

import com.sebure.springcommonauth.entity.AdminUser;

import java.util.List;

public interface AdminUserService {

    AdminUser save(AdminUser adminUser);
    void deleteById(Long id);
    AdminUser getById(Long id);
    List<AdminUser> getAll();

}
