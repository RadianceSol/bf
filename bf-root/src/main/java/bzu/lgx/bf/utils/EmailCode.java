package bzu.lgx.bf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-26 16:51
 * @Description:
 */
public class EmailCode {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setText("111");
        simpleMailMessage.setTo("liuguoxings@126.com");
        simpleMailMessage.setSubject("TEST");
        mailSender.send(simpleMailMessage);
    }
}
