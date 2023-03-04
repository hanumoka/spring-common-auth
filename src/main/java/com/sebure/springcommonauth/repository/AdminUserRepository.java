package com.sebure.springcommonauth.repository;

import com.sebure.springcommonauth.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
}
