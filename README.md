## Instructions

- Check that MySQL server is running
- Check that your credentials correspond to the ones presented on src/main/resources/application.properties
- RUN the code, you can make tests using localhost or postman

You can use the commands and URL of the next example with appoinments, medical speciality, patients and Physicians
### Patient as example
**_localhost:8080/patient_**

**GET:** get all users

**PUT:** to update a user you will need the id 
>
>
>{
>   "id" : {id that u want to modify}
> 
>   "name" : "{name}"
>
>   "numb_of_appoints" : {#}
>
> }
>


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


### Finally Have Fun :)
