package com.ebcs.corda.NodeIdentityLookup;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class NodeIdentity {
    @Id
    @GeneratedValue
    private Long id;

    private String cordaX500Name;

    private String nickname;

    public Long getId() {
        return id;
    }

    public String getCordaX500Name() {
        return cordaX500Name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCordaX500Name(String cordaX500Name) {
        this.cordaX500Name = cordaX500Name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
