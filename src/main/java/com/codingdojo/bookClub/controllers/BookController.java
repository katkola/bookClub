package com.codingdojo.bookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.services.BookService;
import com.codingdojo.bookClub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService userServ;
	
	
	@GetMapping("")
	public String books(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			 return "redirect:/";
		 }
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOnebyId(userId));
		
		
		List<Book> allBooks = bookServ.getAll();
		model.addAttribute("allBooks", allBooks);
		
		return "allBooks.jsp";
	}
	
	@GetMapping("/{book_id}")
	public String showBook(@PathVariable("book_id")Long book_id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			 return "redirect:/";
		 }
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOnebyId(userId));
		
		model.addAttribute("book", bookServ.getById(book_id));
		
		return "oneBook.jsp";
	}
	
	@GetMapping("/{book_id}/edit")
	public String editBook(@PathVariable("book_id")Long book_id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			 return "redirect:/";
		 }
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOnebyId(userId));
		
		model.addAttribute("book", bookServ.getById(book_id));
		
		return "editBook.jsp";
	}
	
	@GetMapping("/add")
	public String bookForm(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			 return "redirect:/";
		 }
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOnebyId(userId));
		
		Book book = new Book();
		model.addAttribute("book", book);
		
		return "newBook.jsp";
	}
	
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = userServ.getOnebyId(userId);
		
		if (result.hasErrors()) {
			model.addAttribute("user", currentUser);
            return "newBook.jsp";
        } 
		else {
			book.setPostedBy(currentUser);
			bookServ.create(book);
			return "redirect:/books";
        }
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT)
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = userServ.getOnebyId(userId);
		
		if (result.hasErrors()) {
			model.addAttribute("user", currentUser);
            return "editBook.jsp";
        } 
		else {
			book.setPostedBy(currentUser);
			bookServ.updateBook(book);
			return "redirect:/books";
        }
	}
	
}
