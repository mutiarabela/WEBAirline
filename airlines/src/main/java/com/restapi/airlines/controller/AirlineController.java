package com.restapi.airlines.controller;

import com.restapi.airlines.model.Airline;
import com.restapi.airlines.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/Airlines")
public class AirlineController { //Airloine controller

    @Autowired
    AirlineService airlineService;

//    @GetMapping(path = "/{idAirline}",
//                produces = { MediaType.APPLICATION_JSON_VALUE,
//                             MediaType.APPLICATION_XML_VALUE  })
//    public ResponseEntity getAirline(@PathVariable String idAirline){ //Get specific Airline
//        AirlineResponseModel getAirlineValue = airlineService.getAirline(idAirline);
//        if (getAirlineValue != null) {
//            return new ResponseEntity<>(getAirlineValue, HttpStatus.OK);
//        } else {
//            throw new AirlineNotFoundException();
//        }
//    }
//
//    @GetMapping()
//    public ResponseEntity getAllAirline(){ //Get all Airline
//        Collection getAllAirlineValue = airlineService.getAllAirline();
//        return new ResponseEntity<>(getAllAirlineValue, HttpStatus.OK);
//    }
//
//    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE },
//            produces = { MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_JSON_VALUE }
//    )
//    public ResponseEntity createAirline(@Valid @RequestBody AirlineDetailsRequestModel airlineDetails){ //Create Airline
//        AirlineResponseModel createAirlineValue = airlineService.createAirline(airlineDetails);
//        return new ResponseEntity<>(createAirlineValue, HttpStatus.CREATED);
//    }
//
//    @PutMapping(path = "/{idAirline}",
//                consumes = { MediaType.APPLICATION_XML_VALUE,
//                             MediaType.APPLICATION_JSON_VALUE },
//                produces = { MediaType.APPLICATION_XML_VALUE,
//                             MediaType.APPLICATION_JSON_VALUE }
//    )
//    public ResponseEntity<AirlineResponseModel> updatePriceAirline(@PathVariable String idAirline, @Valid @RequestBody AirlineDetailsRequestModel airlineDetails){ //Update price Airline
//        AirlineResponseModel updatePriceAirlineValue = airlineService.updatePriceAirline(idAirline, airlineDetails);
//        if (updatePriceAirlineValue != null) {
//            return new ResponseEntity<>(updatePriceAirlineValue, HttpStatus.OK);
//        } else {
//            throw new AirlineNotFoundException("Update Airline Failed, Airline Not Found");
//        }
//    }
//
//    @DeleteMapping(path = "/{idAirline}")
//    public ResponseEntity deleteAirline(@PathVariable String idAirline){ //Delete Airline
//        AirlineResponseModel deleteAirlineValue = airlineService.deleteAirline(idAirline);
//        if (deleteAirlineValue != null) {
//            return new ResponseEntity<>(deleteAirlineValue, HttpStatus.OK);
//        } else {
//            throw new AirlineNotFoundException("Delete Airline Failed, Airline Not Found");
//        }
//    }
    @GetMapping("/asignup")
    public String showCreateForm(@Valid Airline airline, Model model){
        model.addAttribute("airline", airline);
        return "add-airline";
    }

    @PostMapping("/addAirline")
    public String createAirline(@Valid Airline airline, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-airline";
        }
        airlineService.createAirline(airline);
        model.addAttribute("airlines", airlineService.getAllAirline());
        return "airlines";
    }

    @GetMapping("/airlines")
    public String showAllAirline(@Valid Airline airline, BindingResult result, Model model) {
        model.addAttribute("airlines", airlineService.getAllAirline());
        return "airlines";
    }

    @GetMapping("/edit/{idAirline}")
    public String showUpdateForm(@PathVariable("idAirline") int idAirline, Model model) {
        Airline airline = airlineService.getAirline(idAirline);
        model.addAttribute("airline", airline);
        return "update-airline";
    }

    @PostMapping("/update/{idAirline}")
    public String updateAirline(@PathVariable("idAirline") int idAirline, @Valid Airline airline, BindingResult result, Model model) {
        if (result.hasErrors()) {
            airline.setIdAirline(idAirline);
            return "update-airline";
        }
        airlineService.updateAirline(idAirline, airline);
        model.addAttribute("airlines", airlineService.getAllAirline());
        return "index";
    }

    @GetMapping("/delete/{idAirline}")
    public String deleteAirline(@PathVariable("idAirline") int idAirline, Model model) {
        airlineService.deleteAirline(idAirline);
        model.addAttribute("airlines", airlineService.getAllAirline());
        return "index";
    }
}
