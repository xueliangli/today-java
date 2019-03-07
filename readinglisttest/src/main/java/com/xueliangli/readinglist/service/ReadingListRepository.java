package com.xueliangli.readinglist.service;

import com.xueliangli.readinglist.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book,Long> {
    //通过继承获得了很多常用的持久化操作方法，并且新增了根据读者用户名查找资料的方法
    List<Book> findByReader(String reader);
}
