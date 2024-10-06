/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.JavaMoviesApp.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.GenericConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.ZanrConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.dto.ZanrDto;
import rs.ac.bg.fon.JavaMoviesApp.service.ZanrService;

/**
 *
 * @author Administrator
 */ 
@RestController
@RequestMapping("/zanrovi")
public class ZanrController {

    private final ZanrService zanrService;
    private final GenericConverter<ZanrDto, Zanr> zanrConverter = new ZanrConverter();

    public ZanrController(ZanrService zanrService) {
        this.zanrService = zanrService;
    }

    @GetMapping
    public List<ZanrDto> getAllZanrovi() {
        return zanrService.getAllZanrovi().stream()
                .map(zanrConverter::toDto)
                .collect(Collectors.toList());
    }
}
