package io.spring.base.dto;

import io.spring.base.common.BaseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorityDTO extends BaseDTO {

    private String authorityId;

    private String name;

    private String description;

}
