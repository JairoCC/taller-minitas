package com.keycode.TallerMinitas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name="roles")
@Getter
@Setter
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;

    private String authority;

    public Role(){
        super();
    }

    public Role(Integer roleId, String authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
