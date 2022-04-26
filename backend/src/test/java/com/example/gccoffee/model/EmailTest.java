package com.example.gccoffee.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EmailTest {

    @Test
    void 이메일_생성_성공_정상이메일문자열() {
        Email email = new Email("hello@gmail.com");

        assertThat(email).isNotNull();
        assertThat(email.getAddress()).isEqualTo("hello@gmail.com");
    }

    @Test
    void 이메일_생성_실패_임의의문자열() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Email("abcd"));
    }

    @Test
    void 이메일_동일성_성공(){
        Email email1 = new Email("hello@gmail.com");
        Email email2 = new Email("hello@gmail.com");

        assertThat(email1).isEqualTo(email2);
    }

    @Test
    void 이메일_동일성_실패(){
        Email email1 = new Email("hello1@gmail.com");
        Email email2 = new Email("hello2@gmail.com");

        assertThat(email1).isNotEqualTo(email2);
    }


}