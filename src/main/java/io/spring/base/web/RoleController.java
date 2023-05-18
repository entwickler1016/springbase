package io.spring.base.web;

import io.spring.base.common.BaseController;
import io.spring.base.common.Result;
import io.spring.base.dto.RoleDTO;
import io.spring.base.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController implements BaseController<RoleDTO> {

    private final RoleService roleService;

    @Override
    public ResponseEntity<Result> findAll() {

        List<RoleDTO> result = roleService.findAll();

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> findById(String id) {

        RoleDTO result = roleService.findById(id);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> insert(RoleDTO dto) {

        RoleDTO result = roleService.insert(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> update(String id, RoleDTO dto) {

        dto.setRoleId(id);

        RoleDTO result = roleService.update(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> delete(String id) {

        roleService.delete(id);

        return ResponseEntity.ok(new Result());
    }
}
