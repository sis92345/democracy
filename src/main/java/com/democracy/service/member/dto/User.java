package com.democracy.service.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
@Getter
@Setter
@Entity
@Table( name = "member" )
@ToString
public class User implements UserDetails {

    @Id
    private String id;
    private String password;
    private String name;
    private String role;
    private String email;
    @Column( name = "join_type" )
    private Integer join_type;
    @Column( name = "input_date" )
    private LocalDateTime input_date;


    public User(String userId, String userPw, String userName) {
        this.id = userId;
        this.password = userPw;
        this.name = userName;
        this.role = "USER";
        this.input_date = LocalDateTime.now();
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role));
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.id;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJoin_type() {
        return join_type;
    }

    public void setJoin_type(int join_type) {
        this.join_type = join_type;
    }

    public LocalDateTime getInput_date() {
        return input_date;
    }

    public void setInput_date(LocalDateTime input_date) {
        this.input_date = input_date;
    }
}
