package com.codecool.Servlets;

import com.codecool.Model.Poem;
import com.codecool.Services.Exceptions.NoPoemFoundException;
import com.codecool.Services.IPoemService;
import com.codecool.Services.PoemService;
import com.codecool.Servlets.Exceptions.UserIdInputIsNullException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/profile")
public class PoemServlet extends AbstractServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            IPoemService ps = new PoemService(connection);

            String userId = req.getParameter("id");
            if (userId == null){
                sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, "No input received");
                throw new UserIdInputIsNullException();
            }

            int userIntId = Integer.parseInt(userId);
            ps.setId(userIntId);

            List<Poem> result = ps.fetchPoem();
            System.out.println(result.size());
            for(Poem p: result){
                System.out.println(p);
            }
            sendMessage(resp, HttpServletResponse.SC_OK, result);

        }
        catch (SQLException e) {
            e.printStackTrace();
            sendMessage(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Opps, an error has occured, please contact with the administrator");
        }
        catch (NoPoemFoundException e) {
            System.out.println("no poem found");
            sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, "No poem found");
        }
        catch (IOException i){
            i.printStackTrace();
            throw new IOException(i);
        }
        catch (UserIdInputIsNullException u) {
            sendMessage(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Failed to recieve data from the client");
        }
    }
}
