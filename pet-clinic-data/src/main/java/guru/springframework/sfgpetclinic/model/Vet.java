package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)//load everything all at once
    @JoinTable(name = "vet_specialties",joinColumns =@JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialities = new HashSet<>();

    public Set<Specialty> getSpeciality() {
        return getSpeciality();
    }

    public void setSpeciality(Set<Specialty> speciality) {
        this.specialities = speciality;
    }
}
