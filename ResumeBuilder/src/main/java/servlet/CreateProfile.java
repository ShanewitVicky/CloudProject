package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import controller.Dao;
import model.Profile;
import model.User;

/**
 * Servlet implementation class CreateProfile
 */
@WebServlet("/CreateProfile")
public class CreateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		ObjectifyService.register(Profile.class);
		ObjectifyService.register(User.class);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao data = new Dao();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("UserName");
		Key<User> frKeyUser=Key.create(User.class,userName); 
		BlobstoreService blobService = BlobstoreServiceFactory.getBlobstoreService();
		Map<String, List<BlobKey>> uploadValues = blobService.getUploads(request);
		BlobKey image = uploadValues.get("userimage").get(0);
		// String
		// imageurl=ImagesServiceFactory.getImagesService().getServingUrl(ServingUrlOptions.Builder.withBlobKey(image));

		String date = request.getParameter("date") + "-" + request.getParameter("month") + "-"
				+ request.getParameter("year");
		Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("request.getParameter(\"collegewebsite\")" + request.getParameter("collegewebsite"));
		Profile profileData = new Profile(request.getParameter("firstname"), request.getParameter("lastname"),
				new Long(request.getParameter("phone")), request.getParameter("street"), request.getParameter("city"),
				request.getParameter("country"), request.getParameter("website"), request.getParameter("gen"),
				dateOfBirth, request.getParameter("nationality"), request.getParameter("companyName"),
				request.getParameter("role"), request.getParameter("technology"),
				request.getParameter("companywebsite"), request.getParameter("collegename"),
				request.getParameter("fieldofstudy"), request.getParameter("gpa"),
				request.getParameter("collegewebsite"), request.getParameter("skillsets"), image,frKeyUser);
		Object obj = data.createResume(profileData);
		if (obj != null) {
			session.setAttribute("LastName", profileData.getLastName());
			request.getRequestDispatcher("/Success.jsp").forward(request, response);

		} else {

			request.getRequestDispatcher("/Failure.jsp").forward(request, response);

		}
	}

}
