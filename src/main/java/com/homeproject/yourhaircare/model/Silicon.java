package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Silicon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String detail;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "silicon")
    private List<SiliconCosmetic> cosmeticsWithSilicon;
}
