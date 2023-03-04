package com.sebure.springcommonauth.repository;

import com.sebure.springcommonauth.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRoleRepository extends JpaRepository<AdminUser, Long> {
}
