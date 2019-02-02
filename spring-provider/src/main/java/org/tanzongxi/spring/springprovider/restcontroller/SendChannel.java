package org.tanzongxi.spring.springprovider.restcontroller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SendChannel {

    @Output("exchangeName2")
    MessageChannel scoreOutput();
}