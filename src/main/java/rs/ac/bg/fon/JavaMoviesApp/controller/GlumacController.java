package rs.ac.bg.fon.JavaMoviesApp.controller;


import java.util.List;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.JavaMoviesApp.converter.GlumacConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Glumac;
import rs.ac.bg.fon.JavaMoviesApp.dto.GlumacDto;
import rs.ac.bg.fon.JavaMoviesApp.service.GlumacService;

@RestController
@RequestMapping("/api")
public class GlumacController {
	private GlumacService glumacService;
	private GlumacConverter glumacConverter;

	public GlumacController(GlumacService glumacService, GlumacConverter glumacConverter) {
		this.glumacService = glumacService;
		this.glumacConverter = glumacConverter;
	}

	@GetMapping("/glumci")
	public ResponseEntity<List<GlumacDto>> getGlumci() {
		List<Glumac> glumci=glumacService.getAllGlumci();
		List<GlumacDto> glumciDto=glumci.stream().map(glumacConverter::toDto).toList();
		return new ResponseEntity<>(glumciDto, HttpStatus.OK);
	}
}
