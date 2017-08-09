package com.mrdios.competencymatrix.springboot.example.mail;

import com.mrdios.competencymatrix.springboot.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author MrDios
 * @date 2017-08-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MailServiceImpTest {
    private static final String MAIL_TO = "838578616@qq.com";
    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail(MAIL_TO, "spring-boot-mail-simple", "hello this is spring boot mail test,please do not reply");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(MAIL_TO, "spring-boot-mail-html", content);
    }

    @Test
    public void sendAttachmentMail() throws Exception {
        String filePath = "c:\\xinhuanet\\xinhua_config.md";
        mailService.sendAttachmentMail(MAIL_TO, "spring-boot-mail-attachment", "attachment mail test", filePath);
    }

    @Test
    public void sendStaticResourceMail() throws Exception {
        String rscId = "mrdios";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\xinhuanet\\stuff\\最新一寸照片.jpg";
        mailService.sendStaticResourceMail(MAIL_TO, "spring-boot-mail-static-resource", content, imgPath, rscId);
    }
}