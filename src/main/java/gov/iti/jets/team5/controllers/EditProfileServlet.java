package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.EditProfileService;
import gov.iti.jets.team5.services.RegisterService;
import gov.iti.jets.team5.services.impl.EditProfileServiceImpl;
import gov.iti.jets.team5.services.impl.RegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditProfile", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditProfileService editProfileService = EditProfileServiceImpl.getInstance();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserDto userDto = new UserDto();
        userDto.setFirstName(request.getParameter("firstName"));
        userDto.setLastName(request.getParameter("lastName"));
        userDto.setEmail(request.getParameter("email"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setPhone(request.getParameter("phone"));
        userDto.setCity(request.getParameter("city"));
        userDto.setStreet(request.getParameter("street"));
        userDto.setJob(request.getParameter("job"));
        userDto.setDateOfBirth(request.getParameter("dob"));

        Boolean isUpdated = editProfileService.updateUser(userDto);

        if(isUpdated){
            out.print("Vaild");

        } else {

            out.print("Not Vaild");
          //  request.setAttribute("failedToUpdate","true");
           // request.getRequestDispatcher("editprofile.jsp").forward(request,response);
        }
    }
}
