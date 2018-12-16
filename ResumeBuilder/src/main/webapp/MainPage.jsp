<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Home Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>    
    <% BlobstoreService blobService=BlobstoreServiceFactory.getBlobstoreService(); %>
        <form class="register" method="post" action="<%= blobService.createUploadUrl("/CreateProfile") %>" enctype="multipart/form-data">
            <h1>Resume Builder</h1>
            <fieldset class="row1">
                <legend>Personal Details
                </legend>
                <p>
                    <label>FirstName *
                    </label>
                    <input type="text" name="firstname"/>
                    <label>Last Name *
                    </label>
                    <input type="text" name="lastname"/>                    
                </p>
                                
                </p>
            </fieldset>
            <fieldset class="row2">
                <legend>Contact Details
                </legend>
                
                <p>
                    <label>Phone *
                    </label>
                    <input type="text" maxlength="10" name="phone"/>
                </p>
                <p>
                    <label class="optional">Street
                    </label>
                    <input type="text" class="long" name="street"/>
                </p>
                <p>
                    <label>City *
                    </label>
                    <input type="text" class="long" name="city"/>
                </p>
                <p>
                    <label>Country *
                    </label>
                    <select name="country">
                        <option>
                        </option>
                        <option value="United States" >United States
                        </option>
                    </select>
                </p>
                <p>
                    <label class="optional">Website
                    </label>
                    <input class="long" type="text" value="http://" name="website"/>

                </p>
            </fieldset>
            <fieldset class="row3">
                <legend>Further Information
                </legend>
                <p>
                    <label>Gender *</label>
                    <input type="radio" value="Male" name="gen"/>
                    <label class="gender">Male</label>
                    <input type="radio" value="Female" name="gen"/>
                    <label class="gender">Female</label>
                </p>
                <p>
                    <label>Birthdate *
                    </label>
                    <select class="date" name="date">
                        <option value="1">01
                        </option>
                        <option value="2">02
                        </option>
                        <option value="3">03
                        </option>
                        <option value="4">04
                        </option>
                        <option value="5">05
                        </option>
                        <option value="6">06
                        </option>
                        <option value="7">07
                        </option>
                        <option value="8">08
                        </option>
                        <option value="9">09
                        </option>
                        <option value="10">10
                        </option>
                        <option value="11">11
                        </option>
                        <option value="12">12
                        </option>
                        <option value="13">13
                        </option>
                        <option value="14">14
                        </option>
                        <option value="15">15
                        </option>
                        <option value="16">16
                        </option>
                        <option value="17">17
                        </option>
                        <option value="18">18
                        </option>
                        <option value="19">19
                        </option>
                        <option value="20">20
                        </option>
                        <option value="21">21
                        </option>
                        <option value="22">22
                        </option>
                        <option value="23">23
                        </option>
                        <option value="24">24
                        </option>
                        <option value="25">25
                        </option>
                        <option value="26">26
                        </option>
                        <option value="27">27
                        </option>
                        <option value="28">28
                        </option>
                        <option value="29">29
                        </option>
                        <option value="30">30
                        </option>
                        <option value="31">31
                        </option>
                    </select>
                    <select name="month">
                        <option value="1">January
                        </option>
                        <option value="2">February
                        </option>
                        <option value="3">March
                        </option>
                        <option value="4">April
                        </option>
                        <option value="5">May
                        </option>
                        <option value="6">June
                        </option>
                        <option value="7">July
                        </option>
                        <option value="8">August
                        </option>
                        <option value="9">September
                        </option>
                        <option value="10">October
                        </option>
                        <option value="11">November
                        </option>
                        <option value="12">December
                        </option>
                    </select>
                    <input class="year" type="text" size="4" maxlength="4" name="year"/>e.g 1976
                </p>
                <p>
                    <label>Nationality *
                    </label>
                    <select name="nationality">
                        <option value="0">
                        </option>
                        <option value="United States">United States
                        </option>
                    </select>
                </p>
                <p>
                     <label>Photo
                    </label>
                    <input type="file" name="userimage"/>
                    </p>
                <p>
              
               
            </fieldset>
            
            <fieldset class="row5">
                <legend>Work Experience
                </legend>
                
                <p>
                    <label>Company Name *
                    </label>
                    <input type="text" maxlength="10" name="companyName"/>
                </p>
                <p>
                    <label class="optional">Role
                    </label>
                    <input type="text" class="long" name="role"/>
                </p>
                <p>
                    <label>Technology
                    </label>
                    <input type="text" class="long" name="technology"/>
                </p>
                <p>
                    <label class="optional">Company Website
                    </label>
                    <input class="long" type="text" value="http://" name="companywebsite"/>

                </p>
            </fieldset>
            <fieldset class="row5">
                <legend>Education Qualification
                </legend>
                
                <p>
                    <label>College Name *
                    </label>
                    <input type="text" maxlength="10" name="collegename"/>
                </p>
                <p>
                    <label>Field of Study
                    </label>
                    <input type="text" class="long" name="fieldofstudy"/>
                </p>
                <p>
                    <label>GPA
                    </label>
                    <input type="text" class="long" name="gpa"/>
                </p>
                <p>
                    <label class="optional">College Website
                    </label>
                    <input class="long" type="text" value="http://" name="collegewebsite"/>

                </p>
            </fieldset>
            
            <fieldset class="row5">
                <legend>Skillsets
                </legend>                
                <p>
                    Enter skills separated by comma (,)
                    
                    <textarea name="skillsets" rows="5" cols="100" ></textarea>
                </p>
              
            </fieldset>
            <fieldset class="row5">
                <legend>Terms and Mailing
                </legend>
                <p class="agreement">
                    <input type="checkbox" value=""/>
                    <label>*  I accept the <a href="#">Terms and Conditions</a></label>
                </p>
                <p class="agreement">
                    <input type="checkbox" value=""/>
                    <label>I want to receive personalized offers by your site</label>
                </p>
                <p class="agreement">
                    <input type="checkbox" value=""/>
                    <label>Allow partners to send me personalized offers and related services</label>
                </p>
            </fieldset>
            <div><button class="button">Create Resume &raquo;</button></div>
        </form>
    </body>
</html>