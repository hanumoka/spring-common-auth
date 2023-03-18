package com.sebure.springcommonauth.controller;


import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.service.AdminUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackages = "com.sebure.springcommonauth")
@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(AdminUserControllerTest.class)
class AdminUserControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AdminUserService adminUserService;

    @Test
    @DisplayName("AdminUser 단건조회 테스트")
    void getMemberListTest() throws Exception {
        //TODO: 로드된 모든 빈을 나중에 조회해 보자.

        Assertions.assertThat(mvc).isNotNull();

//        AdminUser adminUser = AdminUser.create("aaa", "bbb", "password", true, true);
//
//        given(adminUserService.getAdminUserById(1L)).willReturn(adminUser);
//
//        AdminUser result = adminUserService.getAdminUserById(1L);
//
//        mvc.perform(get("/api/v1/admin-users/1").with(anonymous()))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk())
//                ;
    }
}