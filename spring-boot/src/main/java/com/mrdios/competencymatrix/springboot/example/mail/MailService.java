package com.mrdios.competencymatrix.springboot.example.mail;

/**
 * 发邮件接口
 *
 * @author MrDios
 * @date 2017-08-09
 */
public interface MailService {
    /**
     * 简单邮件发送接口
     *
     * @param to      接收人
     * @param subject 主题
     * @param content 邮件内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html格式的邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param content 邮件内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to       接收人
     * @param subject  主题
     * @param content  邮件内容
     * @param filePath 附件地址
     */
    void sendAttachmentMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param content 邮件内容
     * @param rscPath 资源地址
     * @param rscId   资源id
     */
    void sendStaticResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
