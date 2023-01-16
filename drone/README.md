1. Import the project to a IDE
2. Run the DroneApplication.java class
3. Using Postman run below requests

i.		http://localhost:8080/regDrone
Request Body
{
    "serialNo": "66666",
    "model":"666-DRN",
    "weightLimit":666,
    "batteryCapacity":66,
    "state":"IDLE"
}

ii.		http://localhost:8080/loadDrone
Request Body
{
    "serialNo": "22222",
    "code": "11-MED"
}
{
    "serialNo": "33333",
    "code": "11-MED"
}

iii.	http://localhost:8080/getMedication
Request Body
{
    "serialNo": "22222"
}
{
    "serialNo": "33333"
}

iv.		http://localhost:8080/getAvailDrones

v.		http://localhost:8080/getBatteryLevel
Request Body
{
    "serialNo": "22222"
}
{
    "serialNo": "33333"
}

4. Access http://localhost:8080/h2-console/ to check the database values.
	Driver Class : org.h2.Driver
	JDBC URL : jdbc:h2:mem:droneDB
	User Name : sa
	Password : 
	