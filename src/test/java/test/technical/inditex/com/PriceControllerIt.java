package test.technical.inditex.com;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import test.technical.inditex.com.presentation.dto.PriceDto;
import test.technical.inditex.com.presentation.dto.PriceRequestDto;

import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIt {

    public static final String URL_GET_PRICE= "/inditex/technical-test/prices/";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test_GetPrice_day14_hour10_one() throws Exception {

        PriceRequestDto input = priceRequestDtoBuild( 14,  10) ;

        String inputJson = objectMapper.writeValueAsString(input);

        MvcResult result = mockMvc.perform(get(URL_GET_PRICE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("ZARA"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.currentDate").value("2020-06-14T10:00:00"))
                .andReturn();

        String outputJson = result.getResponse().getContentAsString();
        log.info("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA) {} ", outputJson);
    }


    @Test
    void test_GetPrice_day14_hour16_two() throws Exception {

        PriceRequestDto input = priceRequestDtoBuild( 14,  16) ;

        String inputJson = objectMapper.writeValueAsString(input);

        MvcResult result = mockMvc.perform(get(URL_GET_PRICE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("ZARA"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.currentDate").value("2020-06-14T16:00:00"))
                .andReturn();

        String outputJson = result.getResponse().getContentAsString();
        PriceDto output = objectMapper.readValue(outputJson, PriceDto.class);
        log.info("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA) {} ", outputJson);
    }


    @Test
    void test_GetPrice_day14_hour21_Three() throws Exception {

        PriceRequestDto input = priceRequestDtoBuild( 14,  21) ;

        String inputJson = objectMapper.writeValueAsString(input);

        MvcResult result = mockMvc.perform(get(URL_GET_PRICE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("ZARA"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.currentDate").value("2020-06-14T21:00:00"))
                .andReturn();

        String outputJson = result.getResponse().getContentAsString();
        PriceDto output = objectMapper.readValue(outputJson, PriceDto.class);

        log.info("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA) {} ", outputJson);

    }


    @Test
    void test_GetPrice_day15_hour10_four() throws Exception {

        PriceRequestDto input = priceRequestDtoBuild( 15,  10 );

        String inputJson = objectMapper.writeValueAsString(input);

        MvcResult result = mockMvc.perform(get(URL_GET_PRICE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("ZARA"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(30.5))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.currentDate").value("2020-06-15T10:00:00"))
                .andReturn();

        String outputJson = result.getResponse().getContentAsString();
        PriceDto output = objectMapper.readValue(outputJson, PriceDto.class);

        log.info("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA) {} ", outputJson);
    }

    @Test
    void test_GetPrice_day16_hour21_five() throws Exception {

        PriceRequestDto input = priceRequestDtoBuild( 16, 21 );

        String inputJson = objectMapper.writeValueAsString(input);

        MvcResult result = mockMvc.perform(get(URL_GET_PRICE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("ZARA"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.currentDate").value("2020-06-16T21:00:00"))
                .andReturn();

        String outputJson = result.getResponse().getContentAsString();
        PriceDto output = objectMapper.readValue(outputJson, PriceDto.class);

        log.info("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA) {} ", outputJson);
    }

    private PriceRequestDto priceRequestDtoBuild(Integer day, Integer hour) {
        PriceRequestDto input= new PriceRequestDto();
        input.setBrandId(1);
        input.setProductId(35455);
        input.setCurrentDate(LocalDateTime.of(2020, 6, day, hour, 0, 0));
        return input;
    }
}




