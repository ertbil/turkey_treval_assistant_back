package com.example.treavelAppback.config;


import com.example.treavelAppback.model.db_models.Place;
import com.example.treavelAppback.repository.PlaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlaceConfig {
    @Bean
    CommandLineRunner commandLineRunner(PlaceRepository repository) {
        return args -> {

            Place hagiaSophia = new Place(
                    1L,
                    "Ayasofya",
                    "İstanbul",
                    "Camii",
                    "Tarih Turizmi",
                    "Ayasofya, İstanbul'un Fatih ilçesinde bulunan ve 537 yılında kilise olarak inşa edilen, 1453 yılında ise camiye çevrilmiş bir yapıdır. İstanbul'un en önemli mimari eserlerinden biridir. İstanbul'un simgesi ve kültürel mirasıdır. Ayasofya, 1935 yılında müze olarak açılmıştır. 2020 yılında ise cami olarak yeniden açılmıştır.",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Ayasofya_2020.jpg/1200px-Ayasofya_2020.jpg",
                    "Adres: Ayasofya Mahallesi, Ayasofya Caddesi, 34122 Fatih/İstanbul",
                    "T1 tramvayı ile Sultanahmet'e ulaşabilirsiniz.");


            Place blueMosque = new Place(
                    2L,
                    "Sultan Ahmet Camii",
                    "İstanbul",
                    "Camii",
                    "Tarih Turizmi",
                    "Sultan Ahmet Camii, İstanbul'un Fatih ilçesinde bulunan ve 1609 yılında inşa edilen camidir. İstanbul'un en önemli camilerinden biridir. İstanbul'un simgesi ve kültürel mirasıdır.",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Exterior_of_Sultan_Ahmed_I_Mosque_in_Istanbul%2C_Turkey_002.jpg/405px-Exterior_of_Sultan_Ahmed_I_Mosque_in_Istanbul%2C_Turkey_002.jpg",
                    "Adres: Sultanahmet Mahallesi, Sultanahmet Camii Caddesi, 34122 Fatih/İstanbul",
                    "T1 tramvayı ile Sultanahmet'e ulaşabilirsiniz.");

            repository.saveAll(
                    List.of(hagiaSophia, blueMosque)
            );


        };


    }
}

