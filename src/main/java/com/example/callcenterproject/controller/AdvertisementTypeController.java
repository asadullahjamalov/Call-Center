package com.example.callcenterproject.controller;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;
import com.example.callcenterproject.service.inter.AdvertisementTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/advertisement-type")
public class AdvertisementTypeController {

    private final AdvertisementTypeService advertisementTypeService;

    public AdvertisementTypeController(AdvertisementTypeService advertisementTypeService) {
        this.advertisementTypeService = advertisementTypeService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementTypeResponseDto> createAdvertisementType(@RequestBody AdvertisementTypeRequestDto requestDto) {
        log.info("Advertisement type created successfully");
        return new ResponseEntity<>(advertisementTypeService.createAdvertisementType(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{advertisementTypeId}")
    public ResponseEntity<AdvertisementTypeResponseDto> getAdvertisementTypeById(@PathVariable long advertisementTypeId) {
        log.info("Get Advertisement type by id successfully");
        return new ResponseEntity<>(advertisementTypeService.getAdvertisementTypeById(advertisementTypeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdvertisementTypeResponseDto>> getAllAdvertisementTypes() {
        log.info("Get all advertisement types successfully");
        return new ResponseEntity<>(advertisementTypeService.getAllAdvertisementTypes(), HttpStatus.OK);
    }

    @PutMapping("/{advertisementTypeId}")
    public ResponseEntity<AdvertisementTypeResponseDto> updateAdvertisementTypeById(@RequestBody AdvertisementTypeRequestDto requestDto,
                                                                             @PathVariable long advertisementTypeId) {
        log.info("Update advertisement type by id successfully");
        return new ResponseEntity<>(advertisementTypeService.updateAdvertisementTypeById(requestDto, advertisementTypeId), HttpStatus.OK);
    }
}
