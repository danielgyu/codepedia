package com.hismayfly.urlshortener.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "urls")
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "original_url", nullable = false)
    private String originalurl;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();

    @CreationTimestamp
    @Column(name = "expires_at", nullable = false)
    private Date expiresAt;
}
