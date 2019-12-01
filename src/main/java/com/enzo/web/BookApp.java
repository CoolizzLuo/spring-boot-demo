package com.enzo.web;

import com.enzo.domain.Book;
import com.enzo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author EnzoLuo
 * @create 2019-11-27
 */
@RestController
@RequestMapping("/api/v1")
public class BookApp {

    @Autowired
    private BookService bookService;

    /**
     * 獲取讀書清單列表
     * @return
     */
    @GetMapping("/books")
    public Page<Book> getAll(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable) {
        return bookService.findAllByPage(pageable);
    }

//    @PostMapping("/books")
//    public Book post(@RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
//
//        return bookService.save(book);
//    }

    // 自動注入
    @PostMapping("/books")
    public Book post(Book book) {
        return bookService.save(book);
    }


    @GetMapping("books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    /**
     * 更新一個書單
     * @param id
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PutMapping("books")
    public Book update(@RequestParam long id, String name, String author, String description, int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.save(book);
    }

    /**
     * 刪除一個書單
     * @param id
     */
    @DeleteMapping("books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookService.deleteOne(id);
    }

    @PostMapping("/books/by")
    public int findBy(@RequestParam long id, int status, int uid) {
//        return bookService.findByAuthor(author);
//        return bookService.findByAuthorAndStatus(author, status);
//        return bookService.findByDescriptionEndsWith(description);

//        return bookService.findByJPQL(len);

//        return bookService.updateByJPQL(status, id);
//        return bookService.deleteByJPQL(id);

        return bookService.deleteAndUpdata(id, status, uid);
    }

}
