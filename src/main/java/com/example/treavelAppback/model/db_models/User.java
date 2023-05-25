package com.example.treavelAppback.model.db_models;


import com.example.treavelAppback.consts.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



/**
 * The error you are encountering is related to the creation of the "user" table in Hibernate.
 * It seems that "user" is a reserved keyword in most databases,
 * and therefore, you cannot use it directly as a table name.*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "users")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE,
            generator = "user_sequence")
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    /**
     * getAuthorities() fonksiyonu, kullanıcının yetkilerini bir Collection nesnesi olarak döndürür.
     * Bu yetkiler genellikle uygulamanın veya sistemdeki kullanıcının rol ve izinlerini temsil eder.
     **/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }


    /**
     * isAccountNonExpired(): Bu fonksiyon, kullanıcının hesap süresinin dolup dolmadığını kontrol eder.
     * Eğer hesap süresi dolmuşsa (genellikle belirli bir süre sonra), fonksiyonun false dönmesi beklenir
     * ve bu durumda kullanıcının hesabı süresi dolmuş olarak kabul edilir.
     * Eğer hesap süresi dolmamışsa, fonksiyonun true dönmesi beklenir.
     **/

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * isAccountNonLocked() fonksiyonu kullanıcının hesabının kilitli olup olmadığını belirler.
     * Eğer locked değişkeni true ise, fonksiyon false değerini döndürür ve kullanıcının hesabının kilitli olduğunu ifade eder.
     * Eğer locked değişkeni false ise, fonksiyon true değerini döndürür ve kullanıcının hesabının kilitli olmadığını ifade eder.
     **/

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * isCredentialsNonExpired(): Bu fonksiyon, kullanıcının kimlik bilgilerinin (genellikle şifre gibi)
     * süresinin dolup dolmadığını kontrol eder. Eğer kimlik bilgilerinin süresi dolmuşsa (örneğin, belirli bir süre sonra
     * şifrenin yenilenmesi gerekiyorsa), fonksiyonun false dönmesi beklenir ve bu durumda kullanıcının kimlik bilgileri süresi
     * dolmuş olarak kabul edilir. Eğer kimlik bilgilerinin süresi dolmamışsa, fonksiyonun true dönmesi beklenir.
     **/

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
