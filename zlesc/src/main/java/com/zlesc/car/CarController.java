package com.zlesc.car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
class CarController {

  private final CarRepository repository;

  CarController(CarRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/car")

  List<Car> all() {
    return repository.findAll();
  }

  @PostMapping("/car")
  Car newCar(@RequestBody Car newCar) {
    return repository.save(newCar);
  }

  @GetMapping("/car/{id}")
  Car one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new CarNotFoundException(id));
  }

  @PutMapping("/car/{id}")
  Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

    return repository.findById(id)
        .map(Car -> {
          Car.setBrand(newCar.getBrand());
          Car.setModel(newCar.getModel());
          Car.setMileage(newCar.getMileage());
          Car.setNewprice(newCar.getNewprice());
          Car.setPrice(newCar.getPrice());
          Car.setFirstpayment(newCar.getFirstpayment());
          Car.setCc(newCar.getCc());
          Car.setLicensedate(newCar.getLicensedate());
          Car.setBhairbag(newCar.isBhairbag());
          Car.setBcentrearmrest(newCar.isBcentrearmrest());
          Car.setFhairbag(newCar.isFhairbag());
          Car.setFairbag(newCar.isFairbag());
          Car.setFcentrearmrest(newCar.isFcentrearmrest());
          Car.setPpowerseat(newCar.isPpowerseat());
          Car.setSpowerseat(newCar.isSpowerseat());
          Car.setAfterradar(newCar.isAfterradar());
          Car.setButtonstart(newCar.isButtonstart());
          Car.setFormerradar(newCar.isFormerradar());
          Car.setGps(newCar.isGps());
          Car.setImmobilizer(newCar.isImmobilizer());
          Car.setMfl(newCar.isMfl());
          Car.setParkassist(newCar.isParkassist());
          Car.setTurbo(newCar.isTurbo());
          Car.setU_id(newCar.getU_id());
          return repository.save(Car);
        })
        .orElseGet(() -> {
          newCar.setId(id);
          return repository.save(newCar);
        });
  }

  @DeleteMapping("/car/{id}")
  void deleteCar(@PathVariable Long id) {
    repository.deleteById(id);
  }

  // @RequestParam("id") Long id
  @PostMapping("/car/image")
  @ResponseBody
  ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
    String fileName = file.getOriginalFilename();
    String filePath = "/home/ceelia/Documents/code/fullstack/ZLESC/zlesc/src/main/resources/static/images" + fileName;
    File convFile = new File(filePath);
    convFile.createNewFile();
    FileOutputStream fos = new FileOutputStream(convFile);
    fos.write(file.getBytes());
    fos.close();
    return ResponseEntity.ok("File uploaded successfully");
  }
}