## Instructions
### Patient
**_localhost:8080/patient_**

**GET:** get all users

**POST:** post a new patient using a JSON, Id will be auto-generated
>
> 
>{ 
>  
>   "name" : "{name}"
> 
>   "numb_of_appoints" : {#}
> 
> }
> 


**_localhost:8080/patient/{id}_**

to find a patient by id

**_localhost:8080/patient/{id}_**

to DELETE that Id using method DELETE on postman

**_localhost:8080/patient/query?name={NAME}_**

to find by name 
