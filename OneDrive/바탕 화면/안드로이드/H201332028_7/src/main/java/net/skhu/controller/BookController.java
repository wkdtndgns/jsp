package net.skhu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.repository.*;
import net.skhu.domain.*;
import net.skhu.model.*;


@Controller
@RequestMapping("book")
public class BookController {

    @Autowired BookRepository bookRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired PublisherRepoitory publisherRepository;
    

    @RequestMapping("list")
    public String list( Pagination pagination, Model model) {
    	 List<Book> books = bookRepository.findAll(pagination);
         model.addAttribute("books", books);

         model.addAttribute("searchBy", BookRepository.searchBy);


        return "book/list";
    }
    
    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Pagination pagination, Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("book", bookRepository.findOne(id));
        model.addAttribute("title", "수정");
        return "book/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Book book, Pagination pagination, Model model) {
        bookRepository.save(book);
   
     
        return "redirect:list?" + pagination.getQueryString();
    }
    
    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model, Pagination pagination) {
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("book", new Book());
        model.addAttribute("title", "등록");
        return "book/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Book book, Model model ,Pagination pagination) {
    	bookRepository.save(book);;
        long recordCount = bookRepository.count();
        long pageCount = (recordCount + 15 - 1) / 15;

        return "redirect:list?pg=" + pageCount;
    }

    
  




}


