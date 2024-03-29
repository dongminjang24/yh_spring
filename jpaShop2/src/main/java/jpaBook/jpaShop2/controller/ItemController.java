package jpaBook.jpaShop2.controller;

import jpaBook.jpaShop2.domain.item.Book;
import jpaBook.jpaShop2.domain.item.Item;
import jpaBook.jpaShop2.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("items/new")
    public String create(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());


        itemService.saveItem(book);
        return "redirect:/";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> item = itemService.findItem();
        model.addAttribute("items", item);
        return "items/itemList";
    }

    @GetMapping("/items/{id}/edit")
    public String updateView(@PathVariable("id") Long id, Model model) {
        Book one = (Book) itemService.findOne(id);
        model.addAttribute("form", one);
        return "items/updateItemForm";
    }

    @PostMapping("/items/{id}/edit")
    public String update(@PathVariable Long id, BookForm form) {
//        Book book = (Book) itemService.findOne(id);
//        book.setName(form.getName());
//        book.setPrice(form.getPrice());
//        book.setStockQuantity(form.getStockQuantity());
//        book.setAuthor(form.getAuthor());
//        book.setIsbn(form.getIsbn());
//
//        itemService.saveItem(book);

        itemService.updateItem(id, form.getName(), form.getPrice(), form.getStockQuantity());
        return "redirect:/items";
    }

}
