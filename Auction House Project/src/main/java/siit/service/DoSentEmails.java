package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import siit.db.UserDao;
import siit.model.EmailConfig;

@Service
public class DoSentEmails {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private UserDao userDao;

    private final String sender = "Vart2020@gmail.com";

    public void getMailReady(String email) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername(emailConfig.getUsername());
        javaMailSender.setPassword(emailConfig.getPassword());
        javaMailSender.setHost(emailConfig.getHost());
        javaMailSender.setPort(emailConfig.getPort());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        mailMessage.setSubject("Password Reset");
        mailMessage.setText("Hello," + userDao.getUserByEmail(email).getName() + " Your new password is: password " + " We strongly recomand to change it after the login!");

        javaMailSender.send(mailMessage);

    }


}
