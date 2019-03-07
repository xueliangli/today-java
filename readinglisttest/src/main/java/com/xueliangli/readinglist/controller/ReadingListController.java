package com.xueliangli.readinglist.controller;

import com.xueliangli.readinglist.domain.Book;
import com.xueliangli.readinglist.service.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: chapter1
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 14:47
 **/
//组件扫描将其自动注册为一个 bean，将所有的处理器方法映射到 / 这个 URL 路径上
@Controller
@RequestMapping("/")
public class ReadingListController {
    //应用程序前端的Spring MVC控制器
    private ReadingListRepository readingListRepository;

    //
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    //根据路径指定读者处理 get 请求
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        //从仓库中获取列表
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        //返回 readingList 作为呈现模型的逻辑视图名称，所以必须创建该视图
        return "readingList";
    }

    //处理 post 请求
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    //将请求数据绑定到 book 对象上
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        //更改 book 对象属性为读者姓名
        book.setReader(reader);
        //保存修改后的对象
        readingListRepository.save(book);
        //重定向到/{reader}（控制器中的另一个方法会处理该请求）。
        return "redirect:/{reader}";
    }
}
