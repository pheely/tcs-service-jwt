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
curl tcsclientid:MaYzkSjmkzPC57L@localhost:8080/oauth/token -d grant_type=password -d username=1234567 -d password=jwtpass
```
You'll receive a response similar to below
```shell
{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGNzcmVzb3VyY2VzaWQiXSwidXNlcl9uYW1lIjoiMTIzNDU2NyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MDQ2NjM3NjQsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiXSwianRpIjoiMzMyYTAxOGYtYzlkMy00ODZkLThhNmItMmFlY2Q4OThhZGIxIiwiY2xpZW50X2lkIjoidGNzY2xpZW50aWQifQ.tMt6O_b3Jn_Rjowvd1P1NuygOiq_wh_x-EIRm8NxTiQ","token_type":"bearer","expires_in":43200,"scope":"read write","jti":"332a018f-c9d3-486d-8a6b-2aecd898adb1"}
```
