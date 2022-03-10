package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericCrudRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.SectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sections")
@Tag(name = "Sections", description = "Endpoints for managing sections")
public class SectionRestController extends GenericCrudRestController<SectionDTO, SectionService> {
}
