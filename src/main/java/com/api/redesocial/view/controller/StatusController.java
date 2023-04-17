package com.api.redesocial.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.redesocial.services.UsuarioService;
import com.api.redesocial.shared.UsuarioDto;
import com.api.redesocial.view.model.UsuarioRequest;
import com.api.redesocial.view.model.UsuarioResponse;

@RestController
@RequestMapping("/status")
public class StatusController {
    
	@GetMapping
	public String status() {
		return "running";
	}
	
}