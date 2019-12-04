# dropwizard-basic-auth

To run

Start with:
>>java -jar java -jar target/hello-world-1.0-SNAPSHOT.jar server example.yml

Postman 
GET http://localhost:10000/protected/admin

Header Authorization Basic dfjkhdskjhfgkjdsahkj

Header is created by choosing Basic Auth (in Postman) with user chief-wizard, password secret, updated request

Response shall be

Hey there, chief-wizard. It looks like you are an admin.

Try to rename chief-wizard to chief-wiz and update request

Response shall be
Credentials are required to access this resource.


***
For those unsure. Basic Auth and update request generates the base64 encoded authorization string in the header.

Read here for a small discussion on base64
https://stackoverflow.com/questions/13661384/why-base64-in-basic-authentication
