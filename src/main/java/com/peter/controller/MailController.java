package com.peter.controller;

import com.peter.bean.MailVo;
import com.peter.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lcc
 * @date 2021/5/30 17:39
 */
@Controller
@Slf4j
public class MailController {
    @Autowired
    private MailService mailService;

    /**
     * 发送邮件的主界面
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("from", mailService.getMailSendFrom());//邮件发信人
        return "sendMail";
    }
    /**
     * 发送邮件
     */
    @PostMapping("/mail/send")
    @ResponseBody
    public MailVo sendMail(MailVo mailVo, MultipartFile[] files,boolean html) {
        if(files==null||files.length==0){
            mailVo.setMultipartFiles(null);
        }else {
            mailVo.setMultipartFiles(files);
        }
        return mailService.sendMail(mailVo,html);//发送邮件和附件
    }
}
