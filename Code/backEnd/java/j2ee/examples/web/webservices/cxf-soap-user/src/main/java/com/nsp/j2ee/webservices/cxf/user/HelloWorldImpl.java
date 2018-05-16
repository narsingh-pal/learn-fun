
package com.nsp.j2ee.webservices.cxf.user;

import javax.jws.WebService;

@WebService(endpointInterface = "com.nsp.j2ee.webservices.cxf.user.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

