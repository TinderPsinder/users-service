package pl.zimny.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Picture extends AbstractEntity {

    @ManyToOne
    ProfileDetails profileDetails;

    @Column
    String url;
}
