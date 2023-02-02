/** Classe responsável por definir as rotas das requisições
 * @author Matheus Aguinelo
 * @version 1.0
 * @since Release 0.0.01 da aplicação
 */

package br.com.book.controller;

import br.com.book.entity.Book;
import br.com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @GetMapping("/rocket")
    public ModelAndView getList() {
        List<Book> bookList = this.bookService.findAll();

        ModelAndView mv = new ModelAndView("bookform");
        mv.addObject("bookList", bookList);
        return mv;
    }

    @GetMapping("/dadosAdm")
    public ModelAndView getAdm() {
        List<Book> bookList = this.bookService.findAll();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("bookList", bookList);
        return mv;
    }

    @GetMapping("/loginAdm")
    public ModelAndView loginAdm() {
        List<Book> bookList = this.bookService.findAll();

        ModelAndView mv = new ModelAndView("loginAdm");
        mv.addObject("bookList", bookList);
        return mv;
    }

    @GetMapping("/loginUser")
    public ModelAndView loginUser() {
        List<Book> bookList = this.bookService.findAll();

        ModelAndView mv = new ModelAndView("loginUser");
        mv.addObject("bookList", bookList);
        return mv;
    }
}
