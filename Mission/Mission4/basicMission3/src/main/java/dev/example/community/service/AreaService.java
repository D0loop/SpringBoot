package dev.example.community.service;

import dev.example.community.controller.dto.AreaDto;
import dev.example.community.entity.AreaEntity;
import dev.example.community.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;

        List<AreaEntity> list = new ArrayList<>();
        list.add(new AreaEntity(1L, "서울시", "서초구", "서초동", 37.4877, 127.0174));
        list.add(new AreaEntity(2L, "서울시", "강남구", "역삼동", 37.4999, 127.0374));
        list.add(new AreaEntity(3L, "서울시", "강남구", "삼성동", 37.5140, 127.0565));

        list.forEach(item -> {
            this.areaRepository.save(item);
        });
    }

    public AreaDto createArea(AreaDto areaDto){
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setRegionMajor(areaDto.getRegionMajor());
        areaEntity.setRegionMinor(areaDto.getRegionMinor());
        areaEntity.setRegionPatch(areaDto.getRegionPatch());
        areaEntity.setLatitude(areaDto.getLatitude());
        areaEntity.setLongitude(areaDto.getLongitude());
        areaEntity = areaRepository.save(areaEntity);

        return new AreaDto(areaEntity);
    }

    public AreaDto readArea(Long id) {
        Optional<AreaEntity> areaEntityOptional = areaRepository.findById(id);
        if (areaEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new AreaDto(areaEntityOptional.get());
    }

    public List<AreaDto> readAreaAll(){
        List<AreaDto> areaDtoList = new ArrayList<>();
        areaRepository.findAll().forEach(areaEntity -> areaDtoList.add(new AreaDto(areaEntity)));
        return areaDtoList;
    }
}
