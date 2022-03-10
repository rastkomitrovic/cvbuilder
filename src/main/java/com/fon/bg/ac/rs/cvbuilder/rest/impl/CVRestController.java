package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.CVDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericPagingRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.CVService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cvs")
@Tag(name = "CVs", description = "Endpoints for managing CVs")
public class CVRestController extends GenericPagingRestController<CVDTO, CVService> {
}
