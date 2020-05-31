package pl.zimny.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Profile extends AbstractEntity {

    @Column
    Long userId;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    ProfileDetails profileDetails;

}
