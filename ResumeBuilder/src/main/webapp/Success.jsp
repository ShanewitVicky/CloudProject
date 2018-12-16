<%@page import="model.Profile"%>
<%@page import="controller.Dao"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@page import="com.google.appengine.api.images.ImagesServiceFactory"%>
<%@page import="com.google.appengine.api.images.ServingUrlOptions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Success Resume Preview</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>    
    <% BlobstoreService blobService=BlobstoreServiceFactory.getBlobstoreService(); 
    String lastName=(String)session.getAttribute("LastName");
    Dao data=new Dao();
    Profile prof=data.getProfile(lastName);
    String imageUrl;
    %>
        <form class="register" method="post" action="<%= blobService.createUploadUrl("/CreateProfile") %>" enctype="multipart/form-data">
            <h1>Resume Preview</h1>
            <fieldset class="row1">
                <legend>Personal Details
                </legend>
                <p>
                    <h3><%= prof.getLastName() %> <%= prof.getFirstName() %></h3>  
                    <%imageUrl=ImagesServiceFactory.getImagesService().getServingUrl(ServingUrlOptions.Builder.withBlobKey(prof.getImageURL()));%>
                <img alt="Can't Load Image" height="70px" width="50px" src=<%=imageUrl%>>                                         
                </p>
                                               
            </fieldset>
            <fieldset class="row2">
                <legend>Contact Details
                </legend>
                
                <p>
                    <label>Mobile:</label>
                    <label><%= prof.getPhoneNumber() %>
                    </label>
                </p>
                <p>
                    <label>Address:</label>
                    <label class="optional"><%= prof.getStreet() %>
                    </label>
                </p>
                <p>
                   <label>City:</label>
                    <label><%= prof.getCity() %>
                    </label>
                   
                </p>
                <p>
                <label>Country:</label>
                    <label><%= prof.getCountry() %>
                    </label>
                   
                </p>
                <p>
                <label>Website:</label>
                    <label class="optional"><%= prof.getWebsite() %>
                    </label>

                </p>
            </fieldset>
            <fieldset class="row3">
                <legend>Further Information
                </legend>
                <p>
                    <label>Gender:</label>
                    <label><%= prof.getGender() %></label>
                </p>
                <p>
                    <label>Birthdate:</label>
                    <label><%= prof.getDob() %></label>
                  
                </p>
                <p>
                    <label>Nationality:</label>
                    <label><label><%= prof.getNationality() %></label></label>
                    
                </p>
                
                <p>
              
               
            </fieldset>
            
            <fieldset class="row5">
                <legend>Work Experience
                </legend>
                
                <p>
                    <label>Organization Name:</label>
                    <label><%= prof.getWorkCompanyName() %>
                    </label>
                   
                </p>
                <p>
                    <label>Role:</label>
                    <label class="optional"><%= prof.getWorkRole() %>
                    </label>
                   
                </p>
                <p>
                    <label>Technology:</label>
                    <label><%= prof.getTechnology() %>
                    </label>
                    
                </p>
                <p>
                    <label>Company's Website:</label>
                    <label class="optional"><%= prof.getCollegeWebsite() %>
                    </label>
                    

                </p>
            </fieldset>
            <fieldset class="row5">
                <legend>Education Qualification
                </legend>
                
                <p>
                    <label>College:</label>
                    <label><%= prof.getCollegeName() %>
                    </label>
                </p>
                <p>
                    <label>Course:</label>
                    <label><%= prof.getFieldOfStudy() %>
                    </label>
                </p>
                <p>
                <label>Score:</label>
                    <label><%= prof.getGpa() %>
                    </label>
                                  </p>
                <p>
                <label>College Website:</label>
                    <label class="optional"><%= prof.getCollegeWebsite() %>
                    </label>

                </p>
            </fieldset>
            
            <fieldset class="row5">
                <legend>Skillsets
                </legend>                
                <p>
                    <label>Skillset:</label>
                    <legend><%= prof.getSkill() %></legend>
                </p>
              
            </fieldset>
           
            <div><button class="button">Send to my Mail &raquo;</button></div>
        </form>
    </body>
</html>