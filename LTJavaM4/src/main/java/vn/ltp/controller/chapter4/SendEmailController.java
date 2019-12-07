package vn.ltp.controller.chapter4;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ltp.domain.MailInfo;

@Controller
public class SendEmailController {

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("sendmail.html")
	public String index() {
		return "chapter4/sendmail";
	}

	@RequestMapping(value = "sendmail.html", method = RequestMethod.POST)
	public String index(@Valid @ModelAttribute("obj") MailInfo obj) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(obj.getEmail());
		message.setSubject(obj.getSubject());
		message.setText(obj.getSubject());
		mailSender.send(message);
		return "chapter4/sendmail";
	}
}
