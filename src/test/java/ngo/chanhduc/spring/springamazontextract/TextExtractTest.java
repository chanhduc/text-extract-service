package ngo.chanhduc.spring.springamazontextract;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Chanh-Duc Ngo
 * @created-date 29/08/2024
 */

@AutoConfigureMockMvc
@SpringBootTest
public class TextExtractTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testExtractText() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "document1.pdf",
                "application/pdf", new ClassPathResource("document1.pdf").getInputStream().readAllBytes());

        this.mvc.perform(multipart("/text-extract")
                .file(mockMultipartFile))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to Text Extractor Service!"));
    }
}
