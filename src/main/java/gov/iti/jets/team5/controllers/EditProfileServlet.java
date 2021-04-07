package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.EditProfileService;
import gov.iti.jets.team5.services.impl.EditProfileServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "EditProfile", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditProfileService editProfileService = EditProfileServiceImpl.getInstance();
        response.setContentType("text/html");

        String userDateOfBirth = request.getParameter("dob");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(userDateOfBirth + " userDateOfBirth");
            PrintWriter out = response.getWriter();
            UserDto userDto = new UserDto();
            UserDto userDto1= (UserDto) request.getSession().getAttribute("currentUser");
            int userId = userDto1.getId();
            userDto.setFirstName(request.getParameter("firstName"));
            userDto.setLastName(request.getParameter("lastName"));
            userDto.setEmail(request.getParameter("email"));
            userDto.setPassword(request.getParameter("password"));
            userDto.setPhone(request.getParameter("phone"));
            userDto.setCity(request.getParameter("city"));
            userDto.setStreet(request.getParameter("street"));
            userDto.setJob(request.getParameter("job"));
            if(!userDateOfBirth.equals("")){
                Date startDate = (Date) df.parse(userDateOfBirth);
                System.out.println(startDate + " startDate");
                System.out.println(userDateOfBirth + " userDateOfBirth");
                userDto.setDateOfBirth(startDate);
            }
            System.out.println("from post in edit profile servleeeeet");
            Boolean isUpdated = editProfileService.updateUser(userDto, userId);

            if (isUpdated) {
                out.print("Valid");
                System.out.println("passed");
            } else {

                out.print("Not Valid");
                System.out.println("failed");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditProfileService editProfileService = EditProfileServiceImpl.getInstance();
        response.setContentType("text/html");
        UserDto userDto1 = (UserDto) request.getSession().getAttribute("currentUser");
        int userId = userDto1.getId();
        System.out.println("frommmmmm edit profile servleeettt");
        UserDto userDto = editProfileService.getCurrentUser(userId);
        System.out.println("youmnaaaaaaaaaaaaaa" + userId);
        if (userDto == null) {
            response.sendRedirect("404.jsp");
        } else {
            request.setAttribute("onlineUser", userDto);
            request.getRequestDispatcher("editprofile.jsp").forward(request, response);
        }
    }
}
