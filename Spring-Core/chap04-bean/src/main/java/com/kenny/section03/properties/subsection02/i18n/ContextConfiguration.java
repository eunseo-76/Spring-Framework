package com.kenny.section03.properties.subsection02.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {

    // 직접 만든 클래스는 component scan을 이용한다고 했지만,
    // 가져다 써야 할 기능은 bean 등록을 한다.

    // MessageSource 타입 : 스프링 컨테이너 안에서 메세지를 읽어와 처리한다.
    // messageSource 이름에 오타가 있으면 가져오지 못한다.

    // messageSource bean을 등록한다.
    @Bean
    public MessageSource messageSource() {
        /* 접속하는 세션의 로케일에 따라 자동 재로딩하는 용도의 MessageSource 구현체 */
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        /* 다국어 메세지를 읽어올 properties 파일의 이름을 설정 */
        // message_en_US.properties 에서 국가 빼고 message만 작성
        messageSource.setBasename("section03/properties/subsection02/i18n/message");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
