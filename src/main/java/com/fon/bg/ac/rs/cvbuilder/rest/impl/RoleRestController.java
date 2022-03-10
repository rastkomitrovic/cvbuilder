package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericCrudRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/roles")
@Tag(name = "Roles", description = "Endpoints for managing roles")
public class RoleRestController extends GenericCrudRestController<RoleDTO, RoleService> {
}
