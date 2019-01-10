## All Users

### /register
Allows the user to create an account and register their details to the website.
The user's account will be created and saved, and the user will be able to login using this account.

### /login
Allows the user to login to their account, if they have registered their account,
and directs them to the main page for their account's respective access.


## Customers

### /customer/{id}
Displays a page the customer can use to navigate the sections of the website they can access.

### /customer/{id}/update_address
Displays a page allowing the user to edit the details of their registered address.

### /customer/{id}/update_drone
Displays a page allowing the user to edit the details of their registered drone.

### /customer/15/add_course
Shows a list of courses which have been scheduled, and allows the user to assign
themself to one of these courses.

### /customer/15/course_progression
Displays the user's progress through a course.


## Instructors

### /instructor/{id}
Displays a page listing the courses the instructor is scheduled to lead.

### /instructor/customers/{id}
Displays a table of all of the customers who are assigned to courses lead by the instructor.


## Administrators

### /admin/{id}
Displays the admin user's address and a list of all of details about all registered customers.
Includes a search bar the admin can use to search for a specific customer's details.

### /admin_search
Displays a table of customer matching the following specified search criteria:
First name, last name, or preferred location.

### /admin/{id}/createcoursedate
Allows the admin user to register a new course by completing a form, which customers can
then assign themselves to.  

### /admin/{id}/results
Displays a count of how many results have been registered, alongside a table of all
completed results.
