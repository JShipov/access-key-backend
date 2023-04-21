package com.example.accesskeybackend.template.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

@Service
public class IPv6CheckService {

    private static final Logger logger = LoggerFactory.getLogger(IPv6CheckService.class);

    public boolean checkIPv6Support(String siteUrl) {
        try {
            URI uri = new URI(siteUrl);
            String host = uri.getHost() != null ? uri.getHost() : siteUrl;
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress address : addresses) {
                if (address instanceof Inet6Address) {
                    return true;
                }
            }
        } catch (UnknownHostException | URISyntaxException e) {
            logger.error("Failed to check IPv6 support for site: {}", siteUrl, e);
        }
        return false;
    }
}
