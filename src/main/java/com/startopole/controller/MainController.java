package com.startopole.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import com.startopole.model.entity.FormMessage;
import com.startopole.model.entity.Gallery;
import com.startopole.model.entity.Section;
import com.startopole.model.viewModel.IndexViewModel;
import com.startopole.services.ArticleService;
import com.startopole.services.GalleryService;
import com.startopole.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
public class MainController {

    @Autowired
    ArticleService articleService;

    @Autowired
    GalleryService galleryService;

    @Autowired
    SectionService sectionService;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String indexPage(Map<String, Object> map) {

        IndexViewModel indexViewModel = new IndexViewModel();
        Gallery gallery = new Gallery();
        Section section = new Section();

        map.put("article",indexViewModel);
        map.put("articleList",indexViewModel.getAllArticle(articleService.getAllArticle()));
        map.put("gallery", gallery);
        map.put("galleryList", galleryService.getAllGalleries());
        map.put("section", section);
        map.put("historySectionList", sectionService.getAllSections("HISTORIA"));
        map.put("trainingSectionList", sectionService.getAllSections("TRENINGI"));
        map.put("contactSectionList", sectionService.getAllSections("KONTAKT"));
        map.put("message", new FormMessage());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public String generalPanel() {

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        GrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
        GrantedAuthority user = new SimpleGrantedAuthority("ROLE_USER");
        GrantedAuthority coach = new SimpleGrantedAuthority("ROLE_COACH");

        if (authorities.contains(admin))
            return "redirect:/adminPanel";

        else if (authorities.contains(user))
            return "redirect:/userPanel";

        else if (authorities.contains(coach))
            return "redirect:/coachPanel";

        else
            return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }

    @RequestMapping(value="/sendMessage", method= RequestMethod.POST)
    public String doActions(@ModelAttribute FormMessage message, @RequestParam String action)
            throws MessagingException {

        if ("send".equals(action.toLowerCase())) {

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("startopoletest@gmail.com", "Startopole123");
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(message.getEmail()));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("startopoletest@gmail.com"));
            msg.setSubject(message.getTopic());

            String content = "Wiadomość od: "+message.getEmail()+"<br><hr><br>"+message.getContent();

            msg.setContent(content, "text/html; charset=UTF-8");
            msg.setSentDate(new Date());

            Transport.send(msg);
        }

        return "redirect:/index#section5";
    }
}