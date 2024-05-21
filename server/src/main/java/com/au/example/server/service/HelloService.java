package com.au.example.server.service;


import com.au.example.stubs.HelloReply;
import com.au.example.stubs.HelloRequest;
import com.au.example.stubs.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest request,
                         StreamObserver<HelloReply> responseObserver) {
        final String message = "Hello " + request.getName();
        final HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
