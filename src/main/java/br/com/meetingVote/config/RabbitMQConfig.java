package br.com.meetingVote.config;

import br.com.meetingVote.Const.RabbitMQConst;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConfig {
    private final String EXCHANGE_NAME= "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConfig(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding binding(Queue queue, DirectExchange exchange){
       return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add(){
        Queue queueTotal = this.queue(RabbitMQConst.QUEUE_VOTE_TOTAL);
        Queue queueYes = this.queue(RabbitMQConst.QUEUE_VOTE_YES);
        Queue queueNo = this.queue(RabbitMQConst.QUEUE_VOTE_NO);

        DirectExchange exchange = this.directExchange();

        Binding connectionTotal = this.binding(queueTotal, exchange);
        Binding connectionYes = this.binding(queueYes, exchange);
        Binding connectionNo = this.binding(queueNo, exchange);

        this.amqpAdmin.declareQueue(queueTotal);
        this.amqpAdmin.declareQueue(queueYes);
        this.amqpAdmin.declareQueue(queueNo);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(connectionTotal);
        this.amqpAdmin.declareBinding(connectionNo);
        this.amqpAdmin.declareBinding(connectionYes);

    }

}
