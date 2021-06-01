package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypesService;
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypesService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypesService = petTypesService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypesService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypesService.save(dog);
        PetType cat = new PetType();
        dog.setName("Car");
        PetType savedCatType = petTypesService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");

        Speciality savedRadiology = specialtyService.save(radiology);
        Speciality savedDentistry = specialtyService.save(dentistry);
        Speciality savedSurgery = specialtyService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michal");
        owner1.setLastName("Jordan");
        owner1.setAddress("New York Cirt street ");
        owner1.setCity("Chicago");
        owner1.setTelephone("123123123");
        ownerService.save(owner1);
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Murki");
        owner1.getPets().add(mikesPet);


        Owner owner2 = new Owner();
        owner2.setFirstName("Dion");
        owner2.setLastName("Kadriu");
        owner2.setAddress("Rifat Berisha");
        owner2.setTelephone("044640017");
        owner2.setCity("Prishtina");
        ownerService.save(owner2);
        Vet vet1 = new Vet();

        Pet dionsPet = new Pet();
        dionsPet.setName("fluffli");
        dionsPet.setOwner(owner2);
        dionsPet.setBirthDate(LocalDate.now());
        dionsPet.setPetType(savedCatType);
        owner2.getPets().add(dionsPet);


        vet1.setFirstName("Sam");
        vet1.setLastName("Axw");
        vetService.save(vet1);
        vet1.getSpeciality().add(savedRadiology);
        Vet vet2 = new Vet();

        vet2.setFirstName("Adam");
        vet2.setLastName("Sandler");
        vetService.save(vet2);
        vet2.getSpeciality().add(savedDentistry);
    }
}
