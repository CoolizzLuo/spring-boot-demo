package com.enzo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author EnzoLuo
 * @create 2019-11-27
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    List<Book> findByDescriptionEndsWith(String des);

//    @Query("select b from Book b where length(b.name) > ?1 and b.author = ?2")
//    @Query("select b from Book b where length(b.name) > ?1")  // JPQL BOOK指定的是實體類別
//    @Query("select b from book b where length(name) > ?1")  // book 資料庫table名
    @Query(value = "select * from book where length(name) > ?", nativeQuery = true)  // nativeQuery開始SQL語法
    List<Book> findByJPQL(int len);

    @Transactional
    @Modifying
    @Query("update Book b set b.status = ?1 where id = ?2")
    int updateByJPQL(int status, long id);

    @Transactional
    @Modifying
    @Query("delete from Book b where b.id = ?1")
    int deleteByJPQL(long id);
}
