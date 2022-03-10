package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.TemplateDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericPagingRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.TemplateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/templates")
@Tag(name = "Templates",description = "Endpoints for managing templates")
public class TemplateRestController extends GenericPagingRestController<TemplateDTO, TemplateService> {
}
