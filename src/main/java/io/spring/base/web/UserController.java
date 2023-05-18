package io.spring.base.web;

import io.spring.base.common.BaseController;
import io.spring.base.common.Result;
import io.spring.base.dto.UserDTO;
import io.spring.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController implements BaseController<UserDTO> {

    private final UserService userService;

    @Override
    public ResponseEntity<Result> findAll() {

        List<UserDTO> result = userService.findAll();

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> findById(String id) {

        UserDTO result = userService.findById(id);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> insert(UserDTO dto) {

        UserDTO result = userService.insert(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> update(String id, UserDTO dto) {

        dto.setUserId(id);

        UserDTO result = userService.update(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> delete(String id) {

        userService.delete(id);

        return ResponseEntity.ok(new Result());
    }
}
