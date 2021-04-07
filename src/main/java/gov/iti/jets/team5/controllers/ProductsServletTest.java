package gov.iti.jets.team5.controllers;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.services.CategoryService;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.CategoryServiceImpl;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

@WebServlet("/productsTest")
@MultipartConfig
public class ProductsServletTest extends HttpServlet {
    private static final ProductService productService = ProductServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ProductDto> productsList;
        String pageNumberStr = request.getParameter("page");
        String category = request.getParameter("cat");
        long productsCount = productService.fetchNumOfProducts(category);
//        System.out.println("productsCount = " + productsCount);
        if (productsCount < 0) {
            System.out.println("productsCount < 0");
            response.sendRedirect("404.jsp");
            return;
        }
        int num = (int) (Math.round((productsCount / 9) + 0.5));
        int pageNumber = 1;
        if (pageNumberStr != null) {
            try {
                pageNumber = Integer.parseInt(pageNumberStr);
                if (pageNumber > num || pageNumber < 1) {
                    response.sendRedirect("404.jsp");
                    return;
                }
                if (category != null) {
                    productsList = productService.fetchCatProducts(category, pageNumber);
                    if (productsList == null) {
                        response.sendRedirect("404.jsp");
                        return;
                    }
                    request.setAttribute("products", productsList);
                } else {
                    System.out.println(pageNumberStr);
                    pageNumber = Integer.parseInt(pageNumberStr);
                    productsList = productService.fetchProducts(pageNumber);
                    request.setAttribute("products", productsList);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("404.jsp");
                return;
            }
        } else {
            productsList = productService.fetchProducts(1);
            request.setAttribute("products", productsList);
        }
        request.setAttribute("totalCount", productsCount);
        request.setAttribute("numOfPages", num);
        request.setAttribute("currentPage", pageNumber);

        CategoryService categoryService = CategoryServiceImpl.getInstance();
        List<CategoryDto> categoryList = categoryService.fetchCategories();
        request.setAttribute("categories", categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        try {
//            String name = request.getParameter("prodName");
////            String desc = request.getParameter("desc");
//            String price = request.getParameter("prodPrice");
//            String quan = request.getParameter("prodQuan");
//            String [] cats = request.getParameterValues("cats");
//            Part filePart = request.getPart("filename");
//            System.out.println("product name is: " + name);
////            System.out.println("product name is: " + desc);
//            System.out.println("product price is: " + price);
//            System.out.println("product quantity is: " + quan);
//            System.out.println("product num of categories are: " + cats.length);
//            System.out.println("product image file name is: " + filePart.getSubmittedFileName());
//            System.out.println("product image file name is: " + filePart.getInputStream());

//            FileInputStream serviceAccount = new FileInputStream("D:\\JavaWebProject\\OnlineStore\\OnlineStoreApp\\src\\main\\resources\\freshshopiti-firebase-adminsdk-w912w-7c2340beff.json");
//            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(serviceAccount);
//            FirebaseOptions options = FirebaseOptions.builder()
//                    .setCredentials(googleCredentials)
//                    .setStorageBucket("freshshopiti.appspot.com")
//                    .build();
//            FirebaseApp.initializeApp(options);

//            byte [] is = filePart.getInputStream().readAllBytes();
//            byte [] is = filePart.getContentType().getBytes(StandardCharsets.UTF_8);
//            byte [] is = filePart.getContentType().getBytes();
//            byte [] bytes = new byte[filePart.getInputStream().available()];
//            Bucket bucket = StorageClient.getInstance().bucket();
//            BlobId blobId = BlobId.of(bucket.getName(), filePart.getSubmittedFileName());
//            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpg").build();
//            Storage storage = StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build().getService();
//            Blob blob = bucket.getStorage().create(blobInfo, is);
//            Blob blob = storage.create(blobInfo, bytes);
//            URL imgUrl = blob.signUrl(100, TimeUnit.DAYS, Storage.SignUrlOption.signWith((ServiceAccountSigner) googleCredentials));
//            System.out.println(imgUrl+ " THE URL");
//            System.out.println(imgUrl.getRef()+ " THE URL REF");
//            System.out.println(imgUrl.getProtocol()+"://"+imgUrl.getHost()+imgUrl.getFile());

//            if(blob.getContent() == is){
//
//                System.out.println("Fe 7aga 8alat");
//            }
//            System.out.println(is.length);
//            System.out.println(blob.getContent().length);
//            System.out.println(blob.getMediaLink() + " THE MEDIA LINK");
//            System.out.println(blob.getSelfLink()+ " THE SELF LINK");
//            System.out.println(blob.getName()+ " THE NAME");


//            Blob c = bucket.create("test", is, Bucket.BlobTargetOption.doesNotExist());
//            Blob c =  bucket.create(filePart.getSubmittedFileName(), filePart.getInputStream(), Bucket.BlobWriteOption.doesNotExist());
//            System.out.println(c.getMediaLink() + " THE MEDIA LINK");

//        String fileName = filePart.getSubmittedFileName();

//        String file_path = Convert.ToBase64String(image);
//        String key_name = Paths.get(file_path).getFileName().toString();

//        System.out.format("Uploading %s to S3 bucket %s...\n", file_path, bucket_name);
//        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
//        System.out.println(s3 + " S3");
//        try {
////            s3.putObject(bucket_name, key_name, new File(file_path));
//            PutObjectResult result = s3.putObject(bucket_name, filePart.getSubmittedFileName(),
//                    filePart.getInputStream(), objectMetadata);
//            System.out.println(result.getContentMd5() + " UPLOADED");
//            String imgUrl = "https://" + bucket_name + ".s3.amazonaws.com/" + fileName;
//            System.out.println("Check " + imgUrl);
//            var s = s3.getObject("s","s");
//        } catch (AmazonServiceException e) {
//            System.err.println(e.getErrorMessage() + " !!!!!!!!!!!!!!!!!");
//            e.printStackTrace();
////            System.exit(1);
//        }
//        System.out.println("Done!");

//            if(cats != null) System.out.println(cats.length + " cats are");
//            ProductDto productDto = new ProductDto();
//            productDto.setProductName(name);
//            productDto.setProductDescription(desc);
//            productDto.setProductPrice(BigDecimal.valueOf(Double.parseDouble(price)));
//            productDto.setProductQuantity(Integer.parseInt(quan));
//            boolean added = productService.addProduct(productDto, cats);
//            PrintWriter out = response.getWriter();
//            if (added) {
//                out.write("true");
//            } else {
//                out.write("false");
////                response.sendRedirect("addProduct.jsp");
////                return;
//            }
//        } catch (Exception e){
//            e.printStackTrace();
////            response.sendRedirect("addProduct.jsp");
////            return;
//        }
    }
}
