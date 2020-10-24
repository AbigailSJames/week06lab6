package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 818736
 */
public class ShoppingListServlet extends HttpServlet 
{

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
       HttpSession session = request.getSession();
       
       if(action == null || action.equals(""))
       {
         getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       }
       else if(action.equals("logout"))
        {
          session.invalidate();
          session = request.getSession();
          getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
       else
       {   
           String username = request.getParameter("username");
           session = request.getSession();
           session.setAttribute("username", username);
           getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);  

       }
         
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        String action = request.getParameter("action");
        ArrayList<String> shopList = (ArrayList<String>) session.getAttribute("shoplist");
        
        switch(action)
        {
           
            case "add":
                if (shopList == null)
                {
                    shopList = new ArrayList<>();
                    String item = request.getParameter("listItem");
                    shopList.add(item);
                    session.setAttribute("shoplist", shopList);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
                else
                {
                     String item = request.getParameter("listItem");
                     shopList.add(item);
                     session.setAttribute("shoplist", shopList);
                     getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
            break;
            case "delete":
                String radio = request.getParameter("listItems");
                shopList.remove(shopList.indexOf(radio));
                session.setAttribute("shoplist", shopList);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            break;
        }
        
    }

}
