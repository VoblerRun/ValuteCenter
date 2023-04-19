package com.example.valutecenter.service;


import com.example.valutecenter.model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DefaultEmailService implements EmailService {

    private JavaMailSender javaMailSender;

//    @Value("${spring.mail.username}")
//    private String sender;

    @Override
    public String sendSimpleEmail(Email email) {
        {

            // Try block to check for exceptions
            try {

                // Creating a simple mail message
                SimpleMailMessage mailMessage
                        = new SimpleMailMessage();

                // Setting up necessary details
                mailMessage.setFrom("star_scream@inbox.ru");
                mailMessage.setTo(email.getRecipient());
                mailMessage.setText(email.getMessage());
                mailMessage.setSubject(email.getSubject());

                // Sending the mail
                try {
                    javaMailSender.send(mailMessage);
                } catch (MailException mailException) {
                    System.out.println("Mail send failed.");
                    mailException.printStackTrace();
                }
                return "Mail Sent Successfully...";
            }

            // Catch block to handle the exceptions
            catch (Exception e) {
                return "Error while Sending Mail";
            }
        }
    }

        @Override
        public String sendEmailWithAttachment(Email email, String attachment){

            MimeMessage mimeMessage
                    = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper;

            try {
                mimeMessageHelper
                        = new MimeMessageHelper(mimeMessage, true);
//                mimeMessageHelper.setFrom(sender);
                mimeMessageHelper.setTo(email.getRecipient());
                mimeMessageHelper.setText(email.getMessage());
                mimeMessageHelper.setSubject(
                        email.getSubject());

                // Adding the attachment
//                FileSystemResource file
//                        = new FileSystemResource(
//                        new File(details.getAttachment()));

//                mimeMessageHelper.addAttachment(
//                        file.getFilename(), file);

                // Sending the mail
                javaMailSender.send(mimeMessage);
                return "Mail sent Successfully";
            }

            // Catch block to handle MessagingException
            catch (MessagingException e) {

                // Display message when exception occurred
                return "Error while sending mail!!!";
            }
        }
}