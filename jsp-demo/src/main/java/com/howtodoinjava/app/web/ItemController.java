package com.howtodoinjava.app.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.app.service.ItemService;

@Controller
public class ItemController {

  @Autowired
  ItemService itemService;

  @RequestMapping("/view-items")
  public ModelAndView viewBooks(ModelAndView model) {
    model.setViewName("view-items");
    model.addObject("items", itemService.getAll());
    return model;
  }
  @RequestMapping("/welcome")
  @ResponseBody
  public String defaultMethod() {
      return "Welcome to SpringBoot JSP Docker Application";
  }
  
  @GetMapping("/favicon.ico")
  @ResponseBody
  public byte[] favicon() throws IOException {
      Resource resource = new ClassPathResource("/static/favicon.ico");
      InputStream input = resource.getInputStream();
      return readAllBytes(input);
  }

  private byte[] readAllBytes(InputStream is) throws IOException {
      try {
          return Files.readAllBytes(Path.of(is.toString()));
      } finally {
          is.close();
      }
  }
}
