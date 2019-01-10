package com.ebcs.corda.NodeIdentityLookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NodeIdentityResource {
    private final Logger log = LoggerFactory.getLogger(NodeIdentityResource.class);

    NodeIdentityRepository nodeIdentityRepository;

    public NodeIdentityResource(NodeIdentityRepository nodeIdentityRepository) {
        this.nodeIdentityRepository = nodeIdentityRepository;
    }

    @GetMapping("/all")
    public List<NodeIdentity> getAllIdentities() {
        return nodeIdentityRepository.findAll();
    }

    @GetMapping("/node/{x500name}")
    public NodeIdentity getNodeIdentity(@PathVariable String x500name) {
        return nodeIdentityRepository.findFirstByCordaX500Name(x500name);
    }

    @GetMapping("/node/nickname/{x500name}")
    public String getNodeNickname(@PathVariable String x500name) {
        return nodeIdentityRepository.findFirstByCordaX500Name(x500name).getNickname();
    }

    @GetMapping("/node/nickname/new/{x500name}/{newName}")
    public String getNodeNickname(@PathVariable String x500name, @PathVariable String newName) {

        NodeIdentity nodeIdentity = nodeIdentityRepository.findFirstByCordaX500Name(x500name);
        nodeIdentity.setNickname(newName);

        nodeIdentityRepository.save(nodeIdentity);

        return nodeIdentityRepository.findFirstByCordaX500Name(x500name).getNickname();
    }

}
