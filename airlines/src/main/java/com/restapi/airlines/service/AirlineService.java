package com.restapi.airlines.service;

import com.restapi.airlines.model.Airline;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class AirlineService { //Airline Service
    Airline addAirline;

    HashMap<Integer, Airline> airlines;

    public AirlineService(){ //Create Airline through hardcode
        Airline addFirstAirline = new Airline();

        addFirstAirline.setIdAirline(1);
        int idAirline1 = addFirstAirline.getIdAirline();

        addFirstAirline.setNameAirline("Garuda");
        addFirstAirline.setTypeAirline("Boeing G1");
        addFirstAirline.setAirportOriginAirline("Seokarno Hatta");
        addFirstAirline.setAirportDestinationAirline("Adi Soetjipto");
        addFirstAirline.setDestinationAirline("Yogyakarta");
        addFirstAirline.setPriceAirline(1550000.00);
        addFirstAirline.setDiscountAirline(10);

        if(airlines == null){
            airlines = new HashMap<>();
        }

        airlines.put(idAirline1, addFirstAirline);

        Airline addSecondAirline = new Airline();

        addSecondAirline.setIdAirline(2);
        int idAirline2 = addSecondAirline.getIdAirline();

        addSecondAirline.setNameAirline("Citilink");
        addSecondAirline.setTypeAirline("Boeing C1");
        addSecondAirline.setAirportOriginAirline("Halim Perdana Kusuma");
        addSecondAirline.setAirportDestinationAirline("Adi Soetjipto");
        addSecondAirline.setDestinationAirline("Yogyakarta");
        addSecondAirline.setPriceAirline(750000.00);
        addSecondAirline.setDiscountAirline(20);

        airlines.put(idAirline2, addSecondAirline);

        Airline addThirdAirline = new Airline();

        addThirdAirline.setIdAirline(3);
        int idAirline3 = addThirdAirline.getIdAirline();

        addThirdAirline.setNameAirline("Citilink");
        addThirdAirline.setTypeAirline("Boeing C2");
        addThirdAirline.setAirportOriginAirline("Halim Perdana Kusuma");
        addThirdAirline.setAirportDestinationAirline("Juanda");
        addThirdAirline.setDestinationAirline("Surabaya");
        addThirdAirline.setPriceAirline(1050000.00);
        addThirdAirline.setDiscountAirline(30);

        airlines.put(idAirline3, addThirdAirline);

    }

    public Airline createAirline(Airline airline) { //Create Airline through input
        addAirline = new Airline();

        addAirline.setIdAirline(airline.getIdAirline());
        int idAirline = addAirline.getIdAirline();

        addAirline.setIdAirline(airline.getIdAirline());
        addAirline.setNameAirline(airline.getNameAirline());
        addAirline.setTypeAirline(airline.getTypeAirline());
        addAirline.setDestinationAirline(airline.getDestinationAirline());
        addAirline.setAirportOriginAirline(airline.getAirportOriginAirline());
        addAirline.setAirportDestinationAirline(airline.getAirportDestinationAirline());
        addAirline.setDestinationAirline(airline.getDestinationAirline());
        addAirline.setPriceAirline(airline.getPriceAirline());
        addAirline.setDiscountAirline(airline.getDiscountAirline());

        airlines.put(idAirline, addAirline);
        return addAirline;
    }

    public Airline getAirline (int idAirline) { //Get specific Airline
        return airlines.get(idAirline);
    }

    public Collection<Airline> getAllAirline() { //Get all Airline
        return airlines.values();
    }

    public Airline deleteAirline(int idAirline){ //Delete specific Airline
        return airlines.remove(idAirline);
    }

    public Airline updateAirline (int idAirline, Airline airline) { //Update specific price Airline
        if(airlines.containsKey(idAirline)){
            Airline storedAirline = airlines.get(idAirline);
            idAirline = storedAirline.getIdAirline();

            storedAirline.setIdAirline(idAirline);
            storedAirline.setNameAirline(airline.getNameAirline());
            storedAirline.setTypeAirline(airline.getTypeAirline());
            storedAirline.setDestinationAirline(airline.getDestinationAirline());
            storedAirline.setAirportOriginAirline(airline.getAirportOriginAirline());
            storedAirline.setAirportDestinationAirline(airline.getAirportDestinationAirline());
            storedAirline.setDestinationAirline(airline.getDestinationAirline());
            storedAirline.setPriceAirline(airline.getPriceAirline());
            storedAirline.setDiscountAirline(airline.getDiscountAirline());

            airlines.put(idAirline, storedAirline);
        }
        return airlines.get(idAirline);
    }
}
