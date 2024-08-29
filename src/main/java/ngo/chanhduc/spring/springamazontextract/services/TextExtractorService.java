package ngo.chanhduc.spring.springamazontextract.services;

import ngo.chanhduc.spring.springamazontextract.annotations.ValidFileType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.Block;
import software.amazon.awssdk.services.textract.model.BlockType;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextResponse;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author Chanh-Duc Ngo
 * @created-date 28/08/2024
 */
@Service
public class TextExtractorService {

    private final TextractClient te;

    public TextExtractorService(TextractClient te) {
        this.te = te;
    }

    public String extract(@ValidFileType MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        DetectDocumentTextResponse response = te.detectDocumentText(request ->
                request.document(document ->
                        document.bytes(SdkBytes.fromByteArray(imageBytes))
                                .build())
                        .build());
        return transformTextDetectionResponse(response);

    }

    private String transformTextDetectionResponse(DetectDocumentTextResponse response) {
        return response.blocks()
                .stream()
                .filter(block -> block.blockType().equals(BlockType.LINE))
                .map(Block::text)
                .collect(Collectors.joining(" "));
    }

    public String extract(String bucketName, String objectKey) {
        DetectDocumentTextResponse response = te.detectDocumentText(request ->
                request.document(document ->
                        document.s3Object(s3Object ->
                                s3Object.bucket(bucketName)
                                        .name(objectKey)
                                        .build())
                        .build())
                .build());

        return transformTextDetectionResponse(response);
    }

}
