# TCS Service Component using JSON Web Tokens

## Exposed endpoints
1. /tcs/cities: This endpoint is accessible to all authenticated users.
2. /tcs/locate/officerId?officerId=1234567&transitNum=12345: This endpoint is accessible to all authenticated users.
3. /tcs/locate/name?firsrName=John&lastName=Doe: This endpoint is accessible to all authenticated users.
4. /tcs/profile/1234567: This endpoint is accessible to all authenticated users.
5. /tcs/users: This endpoint is accessible only to an admin user

## Basic information
1. Client ID: tcsclientid
2. Secret: MaYzkSjmkzPC57L
3. Standard user: User Name = 1234567, Password = jwtpass
4. Admin user: User Name = 9999999, Password = jwtpass

## Generate an access token
For standard user:
```shell
curl tcsclientid:MaYzkSjmkzPC57L@localhost:8080/oauth/token -d grant_type=password 
-d username=1234567 -d password=jwtpass
```
You'll receive a response similar to below
```shell
{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGNzcmVzb3VyY2Vz
aWQiXSwidXNlcl9uYW1lIjoiMTIzNDU2NyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MD
Q2NjM3NjQsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiXSwianRpIjoiMzMyYTAxOGYtYzlkMy00
ODZkLThhNmItMmFlY2Q4OThhZGIxIiwiY2xpZW50X2lkIjoidGNzY2xpZW50aWQifQ.tMt6O_b3Jn_Rjow
vd1P1NuygOiq_wh_x-EIRm8NxTiQ","token_type":"bearer","expires_in":43200,
"scope":"read write","jti":"332a018f-c9d3-486d-8a6b-2aecd898adb1"}
```

For admin user:
```shell
curl tcsclientid:MaYzkSjmkzPC57L@localhost:8080/oauth/token -d grant_type=password 
-d username=9999999 -d password=jwtpass
```
You will receive something like this
```shell
{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGNzcmVzb3VyY2Vza
WQiXSwidXNlcl9uYW1lIjoiOTk5OTk5OSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MDQ2
NjM5MzEsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6ImIyNjk
wYWFjLTI3MjktNDJiMi1hZDc3LTgyZTc5NDVhZDVkYiIsImNsaWVudF9pZCI6InRjc2NsaWVudGlkIn0.ew
Lh3XpoE0EZ6ai644jINbPaexNfyHiIVJR9lQTfMyU","token_type":"bearer","expires_in":43200,
"scope":"read write","jti":"b2690aac-2729-42b2-ad77-82e7945ad5db"}
```

## Use the token to access resources through your RESTful API
Access content available to all authenticated users
Use the generated token as the value of the Bearer in the Authorization header as follows: 
```shell
curl http://localhost:8080/tcs/profile/1234567 -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGNzcmVzb3VyY2VzaWQiXSwidXNlcl9uYW1
lIjoiMTIzNDU2NyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MDQ2NjQxMDcsImF1dGhvcml
0aWVzIjpbIlNUQU5EQVJEX1VTRVIiXSwianRpIjoiM2JhMThmNzItMDU2OS00ZjM3LThkZDYtNTIwMzM1YmM
4ODA0IiwiY2xpZW50X2lkIjoidGNzY2xpZW50aWQifQ.gfSYLMAwu7j2txkmwH0Rj8TbRVpZS1YNPYzQOryk
TIA"
```
The response will be:
```shell
{"officerId":"1234567","firstName":"Lisa","lastName":"Raty","initials":"","shortName":"LRATY",
"officerCardNumber":null,"lastUpdateDate":1504620933788,"absenceStartDate":null,
"absenceEndDate":null,"pipStartDate":null,"pipEndDate":null,"emailAddress":null,"transitNum":null,
"role":null,"level":null,"assignedTransits":[{"branch":{"transitNum":"71001",
"name":"MONTREAL CENTRAL ACCOUNTING UNIT"},"role":"TRANSACTIONAL","level":"ONE"},
{"branch":{"transitNum":"70722","name":"NORTH BAY - BUSINESS BANKING CENTRE"},"role":"MANAGEMENT",
"level":"TWO"},{"branch":{"transitNum":"80002","name":"SCOTIA PLAZA"},"role":"CUSTOMER_SERVICE",
"level":"THREE"}],"authorities":[]}
```

Access content available only to an admin user
Use the generated token as the value of the Bearer in the Authorization header as follows: 
```shell
curl http://localhost:8080/tcs/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGNzcmVzb3VyY2VzaWQiXSwidXNlcl9uYW1lI
joiOTk5OTk5OSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MDQ2NjQzNjEsImF1dGhvcml0aWV
zIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6IjhmYmIyNjRjLWExNjUtNDZhNC1hYjFjL
WQwYWFiNjIwMjM0ZCIsImNsaWVudF9pZCI6InRjc2NsaWVudGlkIn0.vfwVbMlJzhPzTjUzgr5ex_F4tF8wxdD
Bdx9gTViuBNs"
```
The response will be:
```shell
[{"id":1,"username":"1234567","firstName":"Philip","lastName":"Yang","roles":[{"id":1,
"roleName":"STANDARD_USER","description":"Standard User - Has no admin rights"}]},{"id":2,"username":"9999999","firstName":"Admin","lastName":"Admin","roles":[{"id":1,
"roleName":"STANDARD_USER","description":"Standard User - Has no admin rights"},
{"id":2,"roleName":"ADMIN_USER","description":"Admin User - Has permission to perform admin tasks"}]}]
```
