package io.spring.base.dto;

import io.spring.base.common.BaseDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends BaseDTO {

    private String userId;
    private String email;
    private String name;
    private String password;
    private LocalDateTime passwordUpdatedAt;
    private String phone;
    private Boolean enabled;
    private Integer failedAttempt;
    private Boolean locked;

}
