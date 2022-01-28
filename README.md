# Telecom Operator Demo
This project is using an in memory H2 DB to initialize dummy data when it starts.
After running the project, data will initialize and following API endpoints are available to use:


### [GET] /api/v1/phoneNumbers
* To retrieve all stored Phone Numbers

### [GET] /api/v1/phoneNumbers/{customerId}
* To retrieve all phone numbers associated to selected customer

### [PUT] /api/v1/phoneNumbers/{phoneNumberId}
* To activate selected Phone Number



