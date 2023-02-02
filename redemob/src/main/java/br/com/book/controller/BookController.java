/** Classe responsável pelo controle das requisições
 * @author Matheus Aguinelo
 * @version 1.0
 * @since Release 0.0.01 da aplicação
 */

package br.com.book.controller;

import br.com.book.entity.Author;
import br.com.book.entity.Book;
import br.com.book.service.AuthorService;
import br.com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd() {

        ModelAndView mv = new ModelAndView("bookform");
        List<Author> authorList = this.authorService.getAuthorList();
        mv.addObject("authorList", authorList);
        return mv;
    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Book book, BindingResult result,
                           RedirectAttributes redirect) {

        if (result.hasErrors()) {
            redirect.addFlashAttribute("mensagem",
                    "Não foi possível enviar a solicitação, tente novamente mais tarde");
            return "redirect:/rocket";
        }

        this.bookService.save(book);
        redirect.addFlashAttribute("mensagem",
                "Solicitação enviada com sucesso");
        return "redirect:/dadosAdm";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("bookform");
        List<Author> authorList = this.authorService.getAuthorList();
        mv.addObject("authorList", authorList);
        Book book = this.bookService.findById(id);
        mv.addObject("book", book);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);
        return "redirect:/dadosAdm";
    }


    @PostMapping("/book/form/save2")
    public String homeAdm(@Valid Book book, BindingResult result,
                          RedirectAttributes redirect) {

        if (result.hasErrors()) {
            redirect.addFlashAttribute("mensagem",
                    "Não foi possível enviar a solicitação, tente novamente mais tarde");
            return "redirect:/dadosAdm";
        }

        this.bookService.save(book);
        redirect.addFlashAttribute("mensagem",
                "Solicitação enviada com sucesso");
        return "redirect:/dadosAdm";
    }

    @PostMapping("/book/form/cliente")
    public String homeCliente(@Valid Book book, BindingResult result,
                              RedirectAttributes redirect) {
        redirect.addFlashAttribute("mensagem",
                "Não foi possível acessar a página, tente novamente mais tarde");
        return "redirect:/loginUser";
    }
}
