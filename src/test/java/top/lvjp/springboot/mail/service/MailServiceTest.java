package top.lvjp.springboot.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("3420308283@qq.com", "测试简单邮件",
                "this is a simple mail");
    }

    @Test
    public void sendHtmlMail() {
        String content = "<html><body><h3>hello world ! 这是一封Html邮件!</h3></body></html>";
        mailService.sendHtmlMail("2505017829@qq.com", "测试 HTML 邮件",content);
    }

    @Test
    public void sendAttachmentMail() {
        String filePath = "D:\\编程学习\\springboot\\spring-boot-book.pdf";
        mailService.sendAttachmentMail("3420308283@qq.com", "测试携带附件", "有附件, 注意查收", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "top001";
        String content="<html><body><h3></h3>" +
                "<h1 style=\"color: red;font-size: 36px\">哈哈哈哈哈哈</h1>" +
                "<img src=\'cid:" +
                 rscId + "\'>" +
                "</body></html>";
        String imgPath = "D:\\截图\\haha.jpg";
        mailService.sendInlineResourceMail("", "",
                content, imgPath, rscId);
    }
}





