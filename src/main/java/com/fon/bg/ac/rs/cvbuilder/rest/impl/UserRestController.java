package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.UserDTO;
import com.fon.bg.ac.rs.cvbuilder.rest.GenericPagingRestController;
import com.fon.bg.ac.rs.cvbuilder.service.impl.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UserRestController extends GenericPagingRestController<UserDTO,UserService> {

}
