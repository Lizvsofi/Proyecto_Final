package mx.uam.cua.nodo_a.messaging;

import mx.uam.cua.nodo_a.config.RabbitConfig;
import mx.uam.cua.nodo_a.model.FragmentMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FragmentListener {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void recibir(FragmentMessage mensaje) {

        System.out.println("================================");
        System.out.println("Mensaje recibido");
        System.out.println("Nodo: " + mensaje.getNodo());
        System.out.println("Video: " + mensaje.getVideo());
        System.out.println("Fragmento: " + mensaje.getFragmento());
        System.out.println("================================");
    }
}