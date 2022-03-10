package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericCrudRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.SectionFieldService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sectionFields")
@Tag(name = "Section fields", description = "Endpoints for managing section fields")
public class SectionFieldRestController extends GenericCrudRestController<SectionFieldDTO, SectionFieldService> {
}
