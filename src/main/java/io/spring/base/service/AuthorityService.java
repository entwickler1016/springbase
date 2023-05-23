package io.spring.base.service;

import io.spring.base.common.BaseService;
import io.spring.base.domain.Authority;
import io.spring.base.repository.AuthorityRepository;
import io.spring.base.dto.AuthorityDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityService implements BaseService<AuthorityDTO> {

    private final ModelMapper modelMapper;
    private final AuthorityRepository authorityRepository;


    @Override
    public List<AuthorityDTO> findAll() {

        List<Authority> entity = authorityRepository.findAll();

        List<AuthorityDTO> result = entity.stream()
                .map(authority -> modelMapper.map(authority, AuthorityDTO.class))
                .toList();
        return result;
    }

    @Override
    public AuthorityDTO findById(String id) {

        Optional<Authority> entity = authorityRepository.findById(id);

        AuthorityDTO result = entity
                .map(authority -> modelMapper.map(authority, AuthorityDTO.class))
                .orElseThrow(EntityNotFoundException::new);
        return result;
    }

    @Override
    public AuthorityDTO insert(AuthorityDTO dto) {

        Authority entity = modelMapper.map(dto, Authority.class);
        authorityRepository.save(entity);

        AuthorityDTO result = modelMapper.map(entity, AuthorityDTO.class);
        return result;
    }

    @Override
    public AuthorityDTO update(AuthorityDTO dto) {

        AuthorityDTO tmp = Optional.ofNullable(findById(dto.getAuthorityId())).orElseThrow(EntityNotFoundException::new);

        Authority entity = modelMapper.map(dto, Authority.class);
        authorityRepository.save(entity);

        AuthorityDTO result = modelMapper.map(entity, AuthorityDTO.class);
        return result;
    }

    @Override
    public void delete(String id) {

        AuthorityDTO tmp = Optional.ofNullable(findById(id)).orElseThrow(EntityNotFoundException::new);

        authorityRepository.deleteById(id);

    }
}
