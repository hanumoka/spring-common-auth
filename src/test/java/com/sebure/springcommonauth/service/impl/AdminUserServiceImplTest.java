package com.sebure.springcommonauth.service.impl;

import com.sebure.springcommonauth.repository.AdminUserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdminUserServiceImplTest {

    @Mock
    AdminUserRepository adminUserRepository;

//    @Nested
//    @DisplayName("게시물 생성")
//    class CreateArticle {
//        private String text;
//
//        @BeforeEach
//        void setup() {
//            text = "새로운 게시물 내용";
//        }
//
//        @Nested
//        @DisplayName("정상 케이스")
//        class SuccessCase {
//            @Test
//            @DisplayName("새로운 게시물 생성")
//            void createArticleSuccess1() {
//                Article article = new Article(text);
//
//                when(articleRepository.save(any(Article.class))).thenReturn(article);
//
//                ArticleService articleService = new ArticleService(articleRepository);
//                Article result = articleService.createArticle(text);
//
//                assertThat(result.getText()).isEqualTo("새로운 게시물 내용");
//            }
//        }
//
//        @Nested
//        @DisplayName("비정상 케이스")
//        class FailCase {
//            @Test
//            @DisplayName("반환된 게시물이 NULL인 경우")
//            void createArticleFail1() {
//                when(articleRepository.save(any(Article.class))).thenReturn(null);
//
//                ArticleService articleService = new ArticleService(articleRepository);
//                Article result = articleService.createArticle(text);
//
//                assertThat(result).isNull();
//            }
//        }
//    }


}