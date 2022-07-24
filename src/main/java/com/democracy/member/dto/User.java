package com.democracy.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class User implements UserDetails {

    private String userId;
    private String userPw;
    private String userName;
    private String userRole;
    private LocalDateTime insertDt;
    private LocalDateTime updateDt;



    public User(String userId, String userPw, String userName) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userRole = "USER";
        this.insertDt = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.userRole));
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.userPw;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.userId;
    }

    public String getUserRealName() {
        return this.userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public LocalDateTime getInsertDt() {
        return insertDt;
    }

    public void setInsertDt(LocalDateTime insertDt) {
        this.insertDt = insertDt;
    }

    public LocalDateTime getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(LocalDateTime updateDt) {
        this.updateDt = updateDt;
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
}
