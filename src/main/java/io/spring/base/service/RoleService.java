package io.spring.base.service;

import io.spring.base.common.BaseService;
import io.spring.base.domain.Role;
import io.spring.base.dto.RoleDTO;
import io.spring.base.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements BaseService<RoleDTO> {

    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    @Override
    public List<RoleDTO> findAll() {

        List<Role> entity = roleRepository.findAll();

        List<RoleDTO> result = entity.stream()
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .toList();

        return result;
    }

    @Override
    public RoleDTO findById(String id) {

        Optional<Role> entity = roleRepository.findById(id);

        RoleDTO result = entity
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .orElseThrow(EntityNotFoundException::new);

        return result;
    }

    @Override
    public RoleDTO insert(RoleDTO dto) {

        Role entity = modelMapper.map(dto, Role.class);
        roleRepository.save(entity);

        RoleDTO result = modelMapper.map(entity, RoleDTO.class);
        return result;
    }

    @Override
    public RoleDTO update(RoleDTO dto) {

        RoleDTO tmp = Optional.ofNullable(findById(dto.getRoleId())).orElseThrow(EntityNotFoundException::new);

        Role entity = modelMapper.map(dto, Role.class);
        roleRepository.save(entity);

        RoleDTO result = modelMapper.map(entity, RoleDTO.class);
        return result;
    }

    @Override
    public void delete(String id) {

        RoleDTO tmp = Optional.ofNullable(findById(id)).orElseThrow(EntityNotFoundException::new);

        roleRepository.deleteById(id);
    }
}
