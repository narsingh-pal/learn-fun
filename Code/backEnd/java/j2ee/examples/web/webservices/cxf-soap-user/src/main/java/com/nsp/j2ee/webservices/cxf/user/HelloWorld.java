package com.nsp.j2ee.webservices.cxf.user;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

