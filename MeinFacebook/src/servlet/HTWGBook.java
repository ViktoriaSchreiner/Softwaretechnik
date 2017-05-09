package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HTWGBook
 */
@WebServlet("/HTWGBook")
public class HTWGBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet.doGet() startet jetzt");		
		//1. Parameter auslesen (hier GET-Parameter)
		String vname = request.getParameter("vorname");
		String nname = request.getParameter("nachname");
		String ort = request.getParameter("wohnort");
		String hobby = request.getParameter("hobby");

		System.out.println(vname+ " " + nname + " " + ort +" " +hobby + "\n");
		
		//2. Session kreieren, Attriute in Session speichern
		HttpSession session = request.getSession();		
		session.setAttribute("vorname", request.getParameter("vorname"));
		session.setAttribute("nname", request.getParameter("nname"));
		session.setAttribute("ort", request.getParameter("ort"));
		session.setAttribute("hobby", request.getParameter("hobby"));
		System.out.println(session.getAttribute("vorname")+" " + session.getAttribute("hobby"));
		
		//2. Antwort/Request schreiben --> Do not forget: function changesettings() einbinden!
		PrintWriter writer = response.getWriter();
		writer.write(" <html>"
				+ "<head>"
				+ "<meta charset=\""
				+ "ISO-8859-1\">"
				+ "<title>MiniFacebook</title>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/frontpage.css\">"
				+ "<script type=\"text/javascript\" src=\"js/einstellungen.js\"></script>"
				+ "</head>"
				+ "<body>"
					+"<h1>Mein Facebook</h1>"
					+"<form method=\"get\" action=\"/MeinFacebook/HTWGBook\">"
					+ "<table>"
						+"<tr>"
							+"<th>Parameter</th>"
							+"<th>Wert</th>"
							+"<th> *** </th>"
						+"</tr>"
						+"<tr>"
							+"<td>Vorname</td>"
							+"<td><input type=\"text\" name=\"vorname\" id = \"vorname\" value ="+ vname +"></td>"
							+"<td><input type=\"button\" onclick =changeSettings('vorname') value=\"ändern\"></td>"
						+"</tr>"
						+"<tr>"
							+"<td>Nachname</td>"
							+"<td><input type=\"text\" name=\"nachname\" id=\"nachname\" value="+ nname +"></td>"							
							+"<td><input type=\"button\" onclick =changeSettings('nachname') value=\"ändern\"></td>"
						+"</tr>"
						+"<tr>"
							+"<td>Wohnort</td>"
							+"<td><input type=\"text\" name=\"wohnort\" id=\"wohnort\" value = "+ort+"></td>"
							+"<td><input type=\"button\" onclick =changeSettings('wohnort') value=\"ändern\"></td>"
						+"</tr>"
						+"<tr>"
							+"<td>Hobby</td>"
							+"<td><input type=\"text\" name=\"hobby\" id=\"hobby\" value = "+hobby+"></td>"
							+"<td><input type=\"button\" onclick =changeSettings('hobby') value=\"ändern\"></td>"
						+"</tr>"
					+"</table>"
					+"</form>"
				+"</body>"
			+"</html>");
		writer.flush();
		writer.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
