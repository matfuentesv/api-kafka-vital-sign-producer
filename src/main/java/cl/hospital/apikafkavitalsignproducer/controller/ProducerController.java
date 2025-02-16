package cl.hospital.apikafkavitalsignproducer.controller;

import cl.hospital.apikafkavitalsignproducer.model.VitalSigns;
import cl.hospital.apikafkavitalsignproducer.services.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProducerController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendVitalSigns(@RequestBody VitalSigns vitalSigns) throws JsonProcessingException {
        producerService.sendMessage(vitalSigns);
        return ResponseEntity.ok("Alerta enviada a Kafka.");
    }
}

