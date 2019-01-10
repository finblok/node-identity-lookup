package com.ebcs.corda.NodeIdentityLookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NodeIdentityResource {
    private final Logger log = LoggerFactory.getLogger(NodeIdentityResource.class);

    public NodeIdentityResource() {}



}
