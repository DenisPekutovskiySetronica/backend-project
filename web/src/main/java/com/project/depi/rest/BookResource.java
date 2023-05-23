package com.project.depi.rest;

import com.project.depi.dto.BookDto;
import com.project.depi.service.WebBookshelfService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("${url.mapping_prefix}")
@Slf4j
public class BookResource {

    private final WebBookshelfService webBookshelfService;

    public BookResource(WebBookshelfService webBookshelfService) {
        this.webBookshelfService = webBookshelfService;
    }

    @GetMapping("/card")
    public String getCard() {
        return "card";
    }

    @GetMapping(value = "/books",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listAllBooks(Model model) {
        model.addAttribute("json", webBookshelfService.listAllBooks());
        return "books";
    }

    @PostMapping(value = "/books/add")
    public String addBook(@RequestBody BookDto bookDto) {
        System.out.println(bookDto);
        webBookshelfService.addBook(bookDto);
        return "books";
    }

    @PutMapping("/books/edit/{id}")
    public String editBook(@PathVariable String id, @RequestBody BookDto bookDto) {
        webBookshelfService.editBook(Long.valueOf(id), bookDto);
        return "books";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable String id) {
        webBookshelfService.deleteById(Long.valueOf(id));
        return "books";
    }
}

