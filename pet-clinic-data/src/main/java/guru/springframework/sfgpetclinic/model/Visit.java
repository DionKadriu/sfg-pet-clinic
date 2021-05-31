package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity{
    private LocalDate localDate;
    private String description;
    private Pet pet;

}
