package vn.microservice.streaming.email.streams.topology;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import vn.microservice.streaming.common.lib.dto.OrderValidationPer3MinStreamDTO;

import java.util.function.Consumer;

/**
 * @author Tuan.Truong [Brian]
 * @version 1.0
 * This class helps to trigger for sending email
 * @date 1/8/2021 11:40 AM
 */
@EnableBinding
public class EmailProcessorTopology {
    private final static Logger log = LoggerFactory.getLogger(EmailProcessorTopology.class);

    private final static String EMAIL_SERVICE = "Email Service";

    @Bean
    public Consumer<KStream<Long, OrderValidationPer3MinStreamDTO>>  orderEmailProcess() {
        return input -> input.peek((k, v) -> log.info("Receive Completed order for sending email {}", v));
    }
}
