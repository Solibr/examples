package ru.arvoglade.springSecurityWithDatabaseExample.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

@Data
@Entity
public class Authority implements GrantedAuthority {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @Enumerated(EnumType.STRING)
    private Role role;

    public Authority() {}

    public Authority(Role role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.role.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return obj instanceof Authority ? this.role.toString().equals(((Authority)obj).role.toString()) : false;
        }
    }

    public int hashCode() {
        return this.role.toString().hashCode();
    }

    public String toString() {
        return this.role.toString();
    }
}
