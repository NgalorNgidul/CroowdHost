package com.croowd.images;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetProspectImage
 */
@WebServlet(name = "getProspectImage", description = "Retrieve image for prospect/project", urlPatterns = { "/getProspectImage" })
public class GetProspectImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String path = "/home/simbiosis/croowd/images";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProspectImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String id = request.getParameter("id");

		File file = null;
		String filename = path + "/noimage.jpg";
		if (type != null && id != null && !type.isEmpty() && !id.isEmpty()) {
			String validFilename = path + "/prospect/" + type + "/" + id
					+ ".jpg";
			file = new File(validFilename);
			if (file.exists() && !file.isDirectory()) {
				filename = validFilename;
			} else {
				file = null;
			}
		}

		if (file == null) {
			file = new File(filename);
		}

		String mime = getServletContext().getMimeType(filename);
		if (mime == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		response.setContentType(mime);
		response.setHeader("Content-Length", String.valueOf(file.length()));

		Files.copy(file.toPath(), response.getOutputStream());
	}

}
