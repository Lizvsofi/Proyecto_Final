package mx.uam.cua.nodo_c.messaging;

import mx.uam.cua.nodo_c.config.RabbitConfig;
import mx.uam.cua.nodo_c.model.FragmentMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class FragmentPublisher {

    private final RabbitTemplate rabbitTemplate;

    public FragmentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicar(FragmentMessage mensaje) {

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                "",
                mensaje
        );

        System.out.println("Mensaje enviado:");
        System.out.println("Nodo: " + mensaje.getNodo());
        System.out.println("Video: " + mensaje.getVideo());
        System.out.println("Fragmento: " + mensaje.getFragmento());
    }
}
