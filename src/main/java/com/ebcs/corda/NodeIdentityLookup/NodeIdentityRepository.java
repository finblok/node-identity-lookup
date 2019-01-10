package com.ebcs.corda.NodeIdentityLookup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeIdentityRepository extends JpaRepository<NodeIdentity, String> {
    NodeIdentity findFirstByCordaX500Name(String x500Name);
}
