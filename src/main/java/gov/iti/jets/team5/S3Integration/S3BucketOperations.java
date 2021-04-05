package gov.iti.jets.team5.S3Integration;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import jakarta.servlet.http.Part;

import java.io.IOException;

public class S3BucketOperations {
    static String bucket_name = "freshshop41";

    static String imgUrl = "https://" + bucket_name + ".s3.amazonaws.com/";

    static ObjectMetadata objectMetadata = new ObjectMetadata();

    public static String uploadFile(Part filePart) {
        String key_name = filePart.getSubmittedFileName();
        objectMetadata.setContentType("image/jpg");
        objectMetadata.addUserMetadata("productImage", filePart.getSubmittedFileName());
        try {
            objectMetadata.setContentLength(filePart.getInputStream().readAllBytes().length);
//            final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
            final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
            PutObjectResult result = s3.putObject(bucket_name, key_name, filePart.getInputStream(), objectMetadata);
            System.out.println(result.getContentMd5() + " UPLOADED");
            String url = imgUrl + key_name;
            System.out.println("Check " + imgUrl);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            e.printStackTrace();
            return null;
        }
    }
}
