package com.example.springbootactuator.endpoint;

import lombok.*;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="javatechie",enableByDefault = true)
public class MyEndpoint {

    @ReadOperation
    public MyEndpointResponse features(){
        return new MyEndpointResponse(2662,"Java_Techie", "Active");
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MyEndpointResponse{
    private int id;
    private String name;
    private String status;
}
