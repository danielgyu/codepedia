package com.hismayfly.urlshortener.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "huid")
@Getter
@Setter
public class Huid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "huid_id")
    private Integer id;

    @OneToOne(mappedBy = "huid", fetch = FetchType.LAZY)
    private Url url;

    @Column(nullable = false, unique = true)
    private String uuid;
}
