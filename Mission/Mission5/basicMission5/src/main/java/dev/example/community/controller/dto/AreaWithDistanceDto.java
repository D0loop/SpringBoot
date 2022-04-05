package dev.example.community.controller.dto;

import dev.example.community.entity.AreaEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaWithDistanceDto {
    private Long distance;
    private Long id;
    private String regionMajor;
    private String regionMinor;
    private String regionPatch;
    private Double latitude;
    private Double longitude;

}
