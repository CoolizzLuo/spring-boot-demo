package com.enzo.service;

import com.enzo.domain.Book;
import com.enzo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author EnzoLuo
 * @create 2019-11-27
 */
@Service  // 方便在Controller裡調用
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 查詢所有的書單列表
     * @return
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 分頁查詢書單列表
     * @return
     */
    public Page<Book> findAllByPage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    /**
     * 提交一個書單資訊
     * @param book
     * @return
     */
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 取得一條書單資訊
     * @param id
     * @return
     */
    public Book findOne (long id) {
        return bookRepository.findOne(id);
    }

    /**
     * 刪除一條書單資訊
     * @param id
     */
    public void deleteOne (long id) {
        bookRepository.delete(id);
    }

    /**
     * 根據 author 查詢一個書單列表
     * @param author
     * @return
     */
    public List<Book> findByAuthor (String author) {
        return bookRepository.findByAuthor(author);
    }

    /**
     * 使用 author, status 查詢一個書單列表
     * @param author
     * @param status
     * @return
     */
    public List<Book> findByAuthorAndStatus (String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    /**
     * 以desc結尾查詢
     * @param desc
     * @return
     */
    public List<Book> findByDescriptionEndsWith (String desc) {
        return bookRepository.findByDescriptionEndsWith(desc);
    }

    /**
     * 自定義查詢
     * @param len
     * @return
     */
    public List<Book> findByJPQL(int len) {
        return bookRepository.findByJPQL(len);
    }

    /**
     * 自定義更新
     * @param status
     * @param id
     * @return
     */
    @Transactional
    public int updateByJPQL(int status, long id) {
        return bookRepository.updateByJPQL(status, id);
    }


    /** 自訂義刪除
     * @param id
     * @return
     */
    @Transactional
    public int deleteByJPQL(long id) {
        return bookRepository.deleteByJPQL(id);
    }


    /**
     * 測試事務操作方法
     * @param id
     * @param status
     * @param uid
     * @return
     */
    @Transactional
    public int deleteAndUpdata(long id, int status, long uid) {

        int dcount = bookRepository.deleteByJPQL(id);

        int ucount = bookRepository.updateByJPQL(status, uid);

        return dcount + ucount;
    }

}
