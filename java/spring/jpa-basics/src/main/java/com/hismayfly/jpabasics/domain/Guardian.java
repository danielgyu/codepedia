package com.hismayfly.jpabasics.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Guardian {

    @Column(name = "guardian_name")
    private String name;

    @Column(name = "guardian_email")
    private String email;

    @Column(name = "guardian_mobile")
    private String mobile;
}
