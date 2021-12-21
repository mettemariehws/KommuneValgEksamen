package com.example.demo.services;

import com.example.demo.model.Party;
import com.example.demo.model.Politican;
import com.example.demo.repository.PoliticianRep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PoliticanServiceTest {

@Mock
PoliticianRep politikkerRep;

@InjectMocks
PoliticanService politikkerService;

@BeforeEach
    void setup(){
    MockitoAnnotations.initMocks(this);

    ArrayList<Politican> politikkerTestTable = new ArrayList<>();

    Party part1 = new Party(1, "SF", politikkerTestTable);
    Party part2 = new Party(1, "DF", politikkerTestTable);

    Politican pol1 = new Politican(1,"Hans", "Vej",part1);
    Politican pol2 = new Politican(2,"Arne", "HanErForCool",part2);
    Politican pol3 = new Politican(3,"Jesper", "Sørensen",part1);

    politikkerTestTable.add(pol1);
    politikkerTestTable.add(pol2);
    politikkerTestTable.add(pol3);

    //Get all pols
    Mockito.when(politikkerRep.findAll()).thenReturn(politikkerTestTable);

    //Add pol and update
   Mockito.when(politikkerRep.save(pol1)).thenReturn(pol1);

   //Get specific pol and update
    Mockito.when(politikkerRep.findById(1)).thenReturn(java.util.Optional.of(pol1));
}

@Test
void getAllPoliticansTest(){

    //Arrange
    List<Politican> testList;

    //Act
    testList = politikkerService.getAllPoliticans();

    //Assert
    assertEquals(3, testList.size());
    Mockito.verify(politikkerRep, times(1)).findAll();
}

@Test
    void deletePoliticansTest(){

    //Arrange
    ArrayList<Politican> politikkerTestTable = new ArrayList<>();

    Party part1 = new Party(4, "SF", politikkerTestTable);
    Politican pol1 = new Politican(1,"Hans", "Vej",part1);

    //Act
    politikkerService.deletePoliticans(pol1.getPoliticans_id());

    //Assert
    Mockito.verify(politikkerRep).deleteById(pol1.getPoliticans_id());
}

    @Test
    void addPoliticansTest(){

        //Arrange
        ArrayList<Politican> politikkerTestTable = new ArrayList<>();

        Party part1 = new Party(4, "SF", politikkerTestTable);
        Politican pol1 = new Politican(1,"Hans", "Vej",part1);

        //Act
        politikkerService.addPolitican(pol1);

        //Assert
        Mockito.verify(politikkerRep, times(1)).save(Mockito.any(Politican.class));
    }

    @Test
    void getSpecificPoliticanTest(){
        //Arrange

        //Act
        Politican test = politikkerService.getSpecificPolitican(1);

        //Assert
        assertEquals("Hans", test.getName());
        assertEquals("Vej", test.getLastname());
        Mockito.verify(politikkerRep, times(1)).findById(1);
    }

    @Test
    void updatePoliticanTest(){
        //Arrange
        Politican polToUpdate = politikkerService.getSpecificPolitican(1);

        //Act
        polToUpdate.setName("Hanne");
        politikkerService.updatePolitican(polToUpdate);

        //Assert
        assertEquals("Hanne", politikkerService.getSpecificPolitican(1).getName());
        Mockito.verify(politikkerRep, times(1)).save(polToUpdate);
    }

}