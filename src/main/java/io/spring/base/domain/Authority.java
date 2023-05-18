package io.spring.base.domain;

import io.spring.base.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "authority",
    indexes = {@Index(columnList = "deleted")}
)
@SQLDelete(sql = "UPDATE authority SET deleted = true WHERE authority_id = ?")
public class Authority extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "authority_id", updatable = false, nullable = false,  unique = true, columnDefinition = "VARCHAR(36)")
    private String authorityId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<>();

}