package io.spring.base.dto;

import io.spring.base.common.BaseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO extends BaseDTO {

    private String roleId;

    private String name;

    private String description;

}
