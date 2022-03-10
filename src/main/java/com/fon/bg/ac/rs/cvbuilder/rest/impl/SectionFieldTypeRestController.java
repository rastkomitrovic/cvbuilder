package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldTypeDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericCrudRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.SectionFieldTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sectionFieldTypes")
@Tag(name = "Section field types",description = "Endpoints for managing section field types")
public class SectionFieldTypeRestController extends GenericCrudRestController<SectionFieldTypeDTO, SectionFieldTypeService> {
}
