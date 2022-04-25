package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v8_0_11;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductJdbcRepositoryTest {

    static EmbeddedMysql embeddedMysql;

    @BeforeAll
    static void setUp() {

        MysqldConfig mysqldConfig= aMysqldConfig(v8_0_11)
                .withCharset(UTF8)
                .withPort(2215)
                .withUser("test", "test1234!")
                .withTimeZone("Asia/Seoul")
                .build();
         embeddedMysql = anEmbeddedMysql(mysqldConfig)
                .addSchema("test-order_mgmt",classPathScript("schema.sql"))
                .start();

    }
    
    @AfterAll
    static void tearDown() {
        embeddedMysql.stop();
    }

    Product newProduct = new Product(UUID.randomUUID(), "new-product", Category.COFFEE_BEAN_PACKAGE, 1000L);

    @Autowired ProductJdbcRepository repository;

    @Test
    @Order(1)
    void testInsert() {
        repository.insert(newProduct);

        List<Product> all = repository.findAll();
        assertThat(all).isNotEmpty();
    }

    @Test
    @Order(2)
    void testFindByName(){
        Optional<Product> product = repository.findByName(newProduct.getProductName());
        assertThat(product).isPresent();
    }


    @Test
    @Order(3)
    void testFinById(){
        Optional<Product> product = repository.findById(newProduct.getProductId());
        assertThat(product).isPresent();
    }


    @Test
    @Order(4)
    void testFinByCategory(){
        List<Product> products = repository.findByCategory(newProduct.getCategory());
        assertThat(products).isNotEmpty();
    }
}