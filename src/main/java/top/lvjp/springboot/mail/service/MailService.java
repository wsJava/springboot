package top.lvjp.springboot.mail.service;

public interface MailService {

    /**
     * 发送简单邮件
     * @param to 邮件接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送 HTML 邮件
     * @param to 邮件接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to 邮件接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param filePath 携带的附件
     */
    void sendAttachmentMail(String to, String subject, String content, String filePath);

    /**
     * 发送携带静态资源的邮件
     * @param to 邮件接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param rscPath 静态资源路径
     * @param rscId 静态资源 id
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
