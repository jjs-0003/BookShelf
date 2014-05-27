package jp.co.jjs.java_seminar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class BookSeach
 */
@WebServlet("/BookSeach")
public class BookSeach extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/crud")
    private DataSource ds;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSeach() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        ArrayList<String> bookList = new ArrayList<>();

        String name = request.getParameter("name");
        String result = "";

        session.setAttribute("name", name);

        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("SELECT * FROM BOOKSHELF WHERE TITLE LIKE ? ")) {

            ps.setString(1, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (rs.getString("title") != null) {
                        result = rs.getString("title");
                        Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setTitle(rs.getString("title"));
                        book.setIsbn(rs.getString("isbn"));
                        book.setAuthor(rs.getString("author"));
                        book.setPublisher(rs.getString("publisher"));
                        book.setPrice(rs.getInt("price"));
                        bookList.add(book.showAll());
                    }
                }
            }

            if (result.equals("")) {
                result = "そのような本はありません。";
                session.setAttribute("list", result);
            }else{
                session.setAttribute("list", bookList);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatchar = request.getRequestDispatcher("/WEB-INF/JSP/result.jsp");
        dispatchar.forward(request, response);

    }

}
