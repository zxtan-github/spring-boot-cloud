package org.tanzongxi.spring.springprovider.restcontroller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SendChannel {

    String SCORE_OUPUT = "mqScoreOutput";

    @Output(SendChannel.SCORE_OUPUT)
    MessageChannel scoreOutput();
}