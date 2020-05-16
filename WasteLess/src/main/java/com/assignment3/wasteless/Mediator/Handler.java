package com.assignment3.wasteless.Mediator;

public interface Handler <Rq extends Request, Rs extends Response>{

    Rs handleRequest(Rq request);
}
