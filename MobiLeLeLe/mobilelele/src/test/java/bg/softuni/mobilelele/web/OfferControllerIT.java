package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.util.TestDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OfferControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestDataUtils testDataUtils;

    private User testUser;
    private Offer testOffer;

    @BeforeEach
    void setUp() {
        testUser = testDataUtils.createTestUser("user@xample.com");
        var testModel = testDataUtils.createTestModel(testDataUtils.createBrandTest());
        testOffer = testDataUtils.createTestOffer(testUser, testModel);

    }

    @Test
    void testDeleteByAnonymousUser_Forbidden() throws Exception {

        mockMvc.perform(delete("/offers/{id}", testOffer.getId())
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection());
        //.andExpect(redirectedUrl("/users/login"));
    }

    void testDeleteByAdmin() {

    }

    public void testDeleteByOwner() {

    }

    public void testDeleteByNotOwned_Forbidden() {

    }

}
