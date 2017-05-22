package servlet;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletListNames
 */
@WebServlet("/ServletListNames")
public class ServletListNames extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListNames() {
		super();
	}

	public String[] readLines(String filename) throws IOException {
		Scanner sc = new Scanner(new File(filename));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}

		String[] arr = lines.toArray(new String[0]);
		sc.close();
		return arr;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String parameter = request.getParameter("wert");
		System.out.println("Anfrage: " + parameter);
		System.out.println(System.getProperty("user.dir"));
		//relative path to file
		String[] arr = readLines(getServletContext().getRealPath("/Data/vornamen.txt"));

		for (String name : arr) {
			boolean istrue = true;
			if (parameter != "") {
				int laenge = name.length() < parameter.length() ? name.length() : parameter.length();
				for (int i = 0; i < laenge; i++) {
					if (!(parameter.length() < i) && !(name.toLowerCase().charAt(i) == parameter.toLowerCase().charAt(i))){							
						istrue = false;
					}
				}
				if(istrue){
				writer.write("<p> " + name + "</p>");
				}
			}
		}

		writer.flush();
		writer.close();
	}

}