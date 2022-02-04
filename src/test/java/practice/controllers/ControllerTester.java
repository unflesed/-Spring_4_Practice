package practice.controllers;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import practice.persistence.model.Car;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-ctx.xml"})
@WebAppConfiguration
@FixMethodOrder
public class ControllerTester {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testController1() throws Exception{
        mockMvc.perform(get("/car/all")).andDo(print()).andExpect(view().name("/car"));
    }

    @Test
    public void testController2() throws Exception{
        mockMvc.perform(post("/car/add")
                        .param("mark", "BMW")
                        .param("model", "x5")
                        .param("engine", String.valueOf(1500))
                        .param("price", String.valueOf(11500))
                        .param("speed", String.valueOf(200))
                        .flashAttr("car", new Car()))
                        .andExpect(status().is3xxRedirection())
                        .andDo(print());

    }

    @Test
    public void testController3() throws Exception{
        mockMvc.perform(get("/car/remove/{id}", 5))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

    @Test
    public void testController4() throws Exception{
        mockMvc.perform(post("/car/findByMark").param("mark", "BMW"))
                .andExpect(status().is2xxSuccessful())
                .andReturn().getModelAndView().getModel().get("cars");
    }

    @Test
    public void testController5() throws Exception{
        mockMvc.perform(post("/car/findByMarkAndModelAndSpeed").param("mark", "BMW")
                        .param("model", "x5")
                        .param("speed", String.valueOf(220)))
                .andExpect(status().is2xxSuccessful())
                .andReturn().getModelAndView().getModel().get("cars");
    }

    @Test
    public void testController6() throws Exception{
        mockMvc.perform(get("/car/remove").param("mark", "Audi"))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }
}
