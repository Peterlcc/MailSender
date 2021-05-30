package com.peter.service;

import com.peter.bean.MailVo;

/**
 * @author lcc
 * @date 2021/5/30 17:34
 */
public interface MailService {
    MailVo sendMail(MailVo mailVo);
    MailVo sendMail(MailVo mailVo,boolean html);
    String getMailSendFrom();
}
