package io.spring.base.web;

import io.spring.base.common.BaseController;
import io.spring.base.common.Result;
import io.spring.base.dto.AuthorityDTO;
import io.spring.base.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authority")
@RequiredArgsConstructor
public class AuthorityController implements BaseController<AuthorityDTO> {

    private final AuthorityService authorityService;

    @Override
    public ResponseEntity<Result> findAll() {

        List<AuthorityDTO> result = authorityService.findAll();

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> findById(String id) {

        AuthorityDTO result = authorityService.findById(id);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> insert(AuthorityDTO dto) {

        AuthorityDTO result = authorityService.insert(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> update(String id, AuthorityDTO dto) {

        dto.setAuthorityId(id);

        AuthorityDTO result = authorityService.update(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> delete(String id) {

        authorityService.delete(id);

        return ResponseEntity.ok(new Result());
    }
}
