//package com.enzo.web;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author EnzoLuo
// * @create 2019-11-26
// */
////@Controller
//@RestController
//@RequestMapping("/v1")
//public class HelloController {
////    @RequestMapping(value = "/hello",method = RequestMethod.POST)
//    @PostMapping("say")
//    public String hello() {
//        return "Hello spring boot";
//    }
//
//
//    @GetMapping("/books")
//    public Object getall(@RequestParam("page") int page, @RequestParam(value = "size",defaultValue = "10") int size) {
//
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", "動物世界");
//        book.put("author", "凱倫強");
//        book.put("isbn", "88456789");
//
//        Map<String, Object> book2 = new HashMap<>();
//        book2.put("name", "JAVA自學寶典");
//        book2.put("author", "麥可華斯基");
//        book2.put("isbn", "39102028");
//
//        List<Map> contents = new ArrayList<>();
//        contents.add(book);
//        contents.add(book2);
//
//        Map<String, Object> pagemap = new HashMap<>();
//        pagemap.put("page", page);
//        pagemap.put("size", size);
//        pagemap.put("content", contents);
//
//        return pagemap;
//    }
//
//
//    /**
//     * 正則表達式: {參數名:正則表達式}
//     * @param id
//     * @param username
//     * @return
//     */
//    @GetMapping("/books/{id}/{username:[a-z_]+}")
////    public Object getOne(@PathVariable("id") long bid)
//    public Object getOne(@PathVariable long id, @PathVariable String username) {
//        System.out.println(" ---- id:" + id + " username: " + username);
//
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", "Eagle");
//        book.put("isbn", "51234882129");
//        book.put("authur", "Enzo");
//        book.put("username", username);
//        return book;
//    }
//
//
//    @PostMapping("/books")
//    public Object post(@RequestParam("name") String name,
//                       @RequestParam("author") String author,
//                       @RequestParam("isbn") String isbn) {
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", name);
//        book.put("author", author);
//        book.put("isbn", isbn);
//
//        return book;
//    }
//}
