package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.util.TestDataUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OfferControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestDataUtils testDataUtils;

    private User testUser, testAdmin;
    private Offer testOffer, testAdminOffer;

    @BeforeEach
    void setUp() {
        testUser = testDataUtils.createTestUser("user@xample.com");
        testAdmin = testDataUtils.createTestAdmin("admin@xample.com");

        var testModel = testDataUtils.createTestModel(testDataUtils.createBrandTest());

        testOffer = testDataUtils.createTestOffer(testUser, testModel);
        testAdminOffer = testDataUtils.createTestOffer(testAdmin, testModel);
    }

    @AfterEach
    void tearDown() {
        testDataUtils.cleanUpDatabase();
    }

    @Test
    void testDeleteByAnonymousUser_Forbidden() throws Exception {

        mockMvc.perform(delete("/offers/{id}", testOffer.getId())
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection());
        // .andExpect(view().name("redirect:users/login"));
        // TODO: check redirection url to login w/o schema
    }

    @Test
    @WithMockUser(username = "admin@xample.com", roles = {"ADMIN", "USER"})
    void testDeleteByAdmin() throws Exception {

        mockMvc.perform(delete("/offers/{id}", testOffer.getId())
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:all"));
    }

    @Test
    @WithMockUser(username = "user@xample.com", roles = {"USER"})
    public void testDeleteByOwner() throws Exception {

        mockMvc.perform(delete("/offers/{id}", testOffer.getId())
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:all"));
    }

    @Test
    @WithMockUser(username = "user@xample.com", roles = {"USER"})
    public void testDeleteByNotOwned_Forbidden() throws Exception {

        mockMvc.perform(delete("/offers/{id}", testAdminOffer.getId())
                        .with(csrf())
                )
                .andExpect(status().isForbidden());
    }

    @WithUserDetails(value = "userski@example.com",
            userDetailsServiceBeanName = "testUserDataService")
    @Test
    public void testAddOffer() throws Exception {

        mockMvc.perform(post("/offers/add")
                        .param("modelId", "1")
                        .param("price", "500")
                        .param("engine", "GASOLINE")
                        .param("transmission", "MANUAL")
                        .param("year", "1900")
                        .param("mileage", "1000")
                        .param("description", "test+description")
                        .param("imageUrl", "image://test.png")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/offers/all"));

    }
}
