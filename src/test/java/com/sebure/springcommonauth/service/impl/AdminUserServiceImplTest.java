package com.sebure.springcommonauth.service.impl;

import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.repository.AdminUserRepository;
import com.sebure.springcommonauth.service.AdminUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class AdminUserServiceImplTest {

    @Mock
    AdminUserRepository adminUserRepository;

    @Nested
    @DisplayName("AdminUser 생성")
    class CreateAdminUser {
        private String username;
        private String email;
        private String password;
        private Boolean active;
        private Boolean blocked;

        @BeforeEach
        void setUp() {
            username = "test_admin1";
            email = "test@test.com";
            password = "password";
            active = true;
            blocked = false;
        }

        @Nested
        @DisplayName("정상케이스")
        class SuccessCase {

            @Test
            @DisplayName("새로운 AdminUser 생성")
            void createAdminUser() {
                AdminUser adminUser = AdminUser.create(username, email, password, active, blocked);
                Mockito.when(adminUserRepository.save(Mockito.any(AdminUser.class))).thenReturn(adminUser);

                AdminUserService adminUserService = new AdminUserServiceImpl(adminUserRepository);
                AdminUser result = adminUserService.save(adminUser);

                Assertions.assertThat(result.getEmail()).isEqualTo(email);
                Assertions.assertThat(result.getUsername()).isEqualTo(username);
            }
        }

    }

}