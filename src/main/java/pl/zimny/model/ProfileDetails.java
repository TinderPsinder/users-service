package pl.zimny.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDetails extends AbstractEntity{

    @OneToOne
    Profile profile;

    @Column
    String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profileDetails")
    List<Picture> pictures;

    @Column
    String breed;

    @Column
    Integer age;

    public ProfileDetails(String description, List<Picture> pictures){
        this.description = description;
        this.pictures = pictures;
    }
}
