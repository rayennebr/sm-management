package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Categorie;
import com.rayennebr.smmanagement.mappers.ICategorieMapper;
import com.rayennebr.smmanagement.repositories.CategorieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategorieServiceTest {

    @Mock
    private  CategorieRepository categorieRepository;

    @Mock
    private ICategorieMapper iCategorieMapper;

    @InjectMocks
    private CategorieService categorieService;

    private AutoCloseable closeable;

    private Categorie categorie;

    @BeforeEach
    void setUp() {
        categorie=Categorie.builder()
                .catId(UUID.randomUUID())
                .catDes("test categorie")
                .build();
        closeable= MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    @DisplayName("should add categorie")
    void should_add_categorie()
    {
        //Given
        var addedCategorie=categorie;
        //when
        when(categorieRepository.save(categorie)).thenReturn(addedCategorie);
        Categorie result = categorieService.saveCategorie(categorie);
        //then
        verify(categorieRepository,times(1)).save(addedCategorie);
        assertEquals(addedCategorie,categorie);
    }

     @Test
     @DisplayName("should get all categories")
     void should_get_all_categories()
      {
          //given
         Categorie categorie1=Categorie.builder()
                 .catId(UUID.randomUUID())
                 .catDes("test 1")
                 .build();
         Categorie categorie2=Categorie.builder()
                 .catId(UUID.randomUUID())
                 .catDes("test 2")
                 .build();
         var listCategories= List.of(categorie1,categorie2,categorie);
         //when
          when(categorieRepository.findAll()).thenReturn(listCategories);
          var result=categorieService.getAllCategorie();
          //then
          assertEquals(result,listCategories);
          verify(categorieRepository,times(1)).findAll();
          assertNotNull(result);
      }

    @Test
    @DisplayName("should update categorie")
    void should_update_categorie() {
        // Given
        Categorie categorie = new Categorie();
        categorie.setCatId(UUID.randomUUID());
        categorie.setCatDes("Original Description");

        Categorie updatedCategorie = new Categorie();
        updatedCategorie.setCatId(categorie.getCatId());
        updatedCategorie.setCatDes("Updated Description");

        // Mocking findById to return the original categorie
        when(categorieRepository.findById(categorie.getCatId())).thenReturn(Optional.of(categorie));

        // Mocking the mapper to simulate updating the fields in the original category
        doAnswer(invocation -> {
            Categorie source = invocation.getArgument(0);
            Categorie target = invocation.getArgument(1);
            target.setCatDes(source.getCatDes());
            return null;
        }).when(iCategorieMapper).mapToUpdate(any(Categorie.class), any(Categorie.class));

        // Mock saveAndFlush to return the updated category
        when(categorieRepository.saveAndFlush(categorie)).thenReturn(categorie);

        // Act
        Categorie result = categorieService.updateCategorie(categorie.getCatId(), updatedCategorie);

        // Assert
        verify(categorieRepository, times(1)).findById(categorie.getCatId());
        verify(iCategorieMapper, times(1)).mapToUpdate(updatedCategorie, categorie);
        verify(categorieRepository, times(1)).saveAndFlush(categorie);

        assertNotNull(result);
        assertEquals("Updated Description", result.getCatDes());
    }
}