package com.croowd.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadProspectImage
 */
@WebServlet(name = "uploadProspectImage", urlPatterns = { "/uploadProspectImage" })
@MultipartConfig(location = "/home/simbiosis/croowd/images/prospect/small")
public class UploadProspectImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadProspectImage() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("prospectId") + ".jpg";

		if (request.getContentType() != null
				&& request.getContentType().toLowerCase()
						.indexOf("multipart/form-data") > -1) {
			for (Part part : request.getParts()) {
				if (part.getName().equalsIgnoreCase("picture")) {
					part.write(fileName);
				}
			}
		} else {
			System.out.println(request.getContentType());
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
