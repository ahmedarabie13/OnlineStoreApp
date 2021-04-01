package gov.iti.jets.team5.handlers;

import gov.iti.jets.team5.models.enums.ProductCategory;
import gov.iti.jets.team5.models.enums.ProductStatus;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;


import java.awt.*;
import java.io.IOException;

public class ProductTagHandler extends SimpleTagSupport {
    private String productName;
    private String productImageURL;
    private Double productPrice;
    private ProductStatus productStatus;
    private String productDescription;
    private double productRating;
    private ProductCategory productCategory;
    private Integer productId;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<div class=\"col-lg-3 col-md-6 special-grid top-featured\">");
        out.println("<div class=\"products-single fix\">");
        out.println("<div class=\"box-img-hover\">");
        out.println("<div class=\"type-lb\">");
        out.println("<p class=\"new\">" + productStatus + "</p>");
        out.println("</div>");
        out.println("<img src=" + productImageURL + " class=\"img-fluid\" alt=\"Image\">");
        out.println("<div class=\"mask-icon\">");
        out.println("<ul>");
        out.println("<li><a href=\"shopDetail?id=" + productId + "\"" + "data-toggle=\"tooltip\" data-placement=\"right\" title=\"View\"><i class=\"fas fa-eye\"></i></a></li>");
        out.println("<li ><a href = \"#\" data - toggle = \"tooltip\" data - placement = \"right");
        out.println("title = \"Compare\" ><i class=\"fas fa-sync-alt\" ></i ></a ></li >");
        out.println("<li ><a href = \"#\" data - toggle = \"tooltip\" data - placement = \"right");
        out.println("title = \"Add to Wishlist\" ><i class=\"far fa-heart\" ></i ></a ></li >");
        out.println("</ul >");
        out.println("<a class=\"cart\" href=\"#\" onclick=\"addToCart("+productId+");\"> Add to Cart</a >");
        out.println("</div >");
        out.println("</div >");
        out.println("<div class=\"why-text\" >");
        out.println("<h4 >" + productName + "</h4 >");
        out.println("<h5 > $" + productPrice + "</h5 >");
//        out.println("<h5 > Rating " + productRating + "</h5 >");
        out.println("</div >");
        out.println("</div >");
        out.println("</div >");

        super.doTag();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductRating() {
        return productRating;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
