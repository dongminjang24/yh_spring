package jpaBook.jpaShop2.domain.service;

import jakarta.persistence.EntityManager;
import jpaBook.jpaShop2.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager entityManager;
    @Test
    public void updateTest() throws Exception {
        Book book = entityManager.find(Book.class, 1L);

        book.setName("asdfdsf");

        //변경감지 == dirty checking

    }
}
