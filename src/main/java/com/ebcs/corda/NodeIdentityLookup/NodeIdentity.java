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

}
