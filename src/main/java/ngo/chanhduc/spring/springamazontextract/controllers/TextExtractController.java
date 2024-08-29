package ngo.chanhduc.spring.springamazontextract.controllers;

import ngo.chanhduc.spring.springamazontextract.services.TextExtractorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Chanh-Duc Ngo
 * @created-date 28/08/2024
 */
@RestController
@RequestMapping("/text-extract")
public class TextExtractController {

    private final TextExtractorService textractService;

    public TextExtractController(TextExtractorService textractService) {
        this.textractService = textractService;
    }

    @PostMapping
    public String extractText(@RequestParam("file") MultipartFile imageFile) throws IOException {

        return textractService.extract(imageFile);
    }
}
