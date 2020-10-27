# twitterclone
It's a simple spring boot application which is similar to Twitter. I had tried to implement each and every API in different possible means in order to demonstrate my skills at JPA, MVC, Rest APIs, ORM, Architectural, Collections, Native Queries, JsonViews, MySQL level.

#Please note that there is no Spring Security implemented inside the project. 

############################################################################CONFIGURATION#########################################################################

############################################################################USAGE PROCESS#########################################################################
- First of all, in order to create correct database architecture the sql dump named "TwitterCloneDDl.sql" should be sources in MySQL.
- Navigate to the project's class path and run "mvn eclipse:eclipse" command (If Maven is installed on your system) to make the project eclipse compatible.
- Import the project inside your Eclipse.
- In the case, if your MySQL Database has different username/password other than root/root, then please configure them in db.properties file.
- To turn off the JPA SQL queries fired at console level, please set the properties named spring.jpa.show-sql and spring.jpa.properties.hibernate.format_sql to false, by default I had switched it to true.
- If you are running the project inside Eclipse, then open the TwitterApplication.java class inside your eclipse, and run the project.
- If you are running through the command line, then navigate inside project's folder, run command "mvn clean install", now navigate inside the target class and run the given command "java -jar twitter-0.0.1-SNAPSHOT.jar –server.port=8080"; 
- Awesome! Everything is good to go.

Cheers!

############################################################################API DETAILS###########################################################################

The following is the list of APIs provided in the project:
USER REGISTRATION (User A)
	- Url Definition: /createUser
	- API: /users/createUser
	- Method Type: POST
	- Request JSON:
		{
		  "id": 0,
		  "firstname": "Ranjeet",
		  "lastname": "Borate",
		  "username": "ranjeetborate"
		}

USER REGISTRATION (User B)
	- Url Definition: /createUser
	- API: /users/createUser
	- Method Type: POST
	- Request JSON:
		{
		  "id": 0,
		  "firstname": "Karan",
		  "lastname": "Borate",
		  "username": "karanborate"
		}
		
CREATE A POST	
	- Url Definition: /createUserPost
	- API: /userposts/createUserPost
	- Method Type: POST
	- Request JSON:
		{
		  "id": 0,
		  "userid": {
			"id": 1,
			"firstname": "Ranjeet",
			"lastname": "Borate",
			"username": "ranjeetborate"
		  },
		  "postid": {
			"id": 0,
			"postcontent": "This is my first post on twitter clone"
		  }
		}

FOLLOW AN USER BY USERNAME
	- Url Definition: /followUserByUserName/{username}/{loggedInUserId}
	- API: /followers/followUserByUserName
	- Method Type: GET
	- Request JSON: N/A

SEARCH FOR USER HANDLE
	- Url Definition: /findAllUsersByUsername?username=?
	- API: /users/findAllUsersByUsername
	- Method Type: GET
	- Request JSON: N/A

FIND POSTS LIKED BY A USER 
	- Url Definition: /findPostByLikerId/{userId}
	- API: /postsactivity/findPostByLikerId
	- Method Type: GET
	- Request JSON: N/A

LIKE A POST
	- Url Definition: /likePost/{whoId}/{whoseId}/{postId}/{status}
	- API: /postsactivity/likePost
	- Method Type: GET
	- Request JSON: N/A

FETCH ALL POSTS CREATED BY A USER
	- Url Definition: /findAllCreatedPostsByUserId/{userId}
	- API: /userposts/findAllCreatedPostsByUserId
	- Method Type: GET
	- Request JSON: N/A
	
FETCH ALL POSTS WHICH USER LIKED AND ALSO ALL POSTS OF PEOPLE TO WHOME USER FOLLOWS 	
	- Url Definition: /fetchAllActivityOfUser/{userId}
	- API: /userposts/fetchAllActivityOfUser/
	- Method Type: GET
	- Request JSON: N/A

############################################################################ERROR DETAILS#########################################################################

Following are the errors handled by respective APIs:
USER REGISTRATION
	- User with username ranjeetborate already exist, please provide another username
	
CREATE A POST
	- No such user found
	- Post's length must not be greater than 140 characters
	- No valid content provided in the Post

FOLLOW AN USER BY USERNAME
	- No user found with the specified username
	- No such user found or users is not registered

SEARCH FOR USER HANDLE
	- N/A

FIND POSTS LIKED BY A USER 
	- No such user is present

LIKE A POST
	- No such user is present
	- No any post found for the user karanborate
	- No such post exist with the provided post id
	- No such user is present. Please check whether the specified user id exists or not

FETCH ALL POSTS CREATED BY A USER
	- No such user found with the specified Id

FETCH ALL POSTS WHICH USER LIKED AND ALSO ALL POSTS OF PEOPLE TO WHOME USER FOLLOWS 	
	- No such user found with the specified Id

###############################################################################################################################################################

Future Upgrades:
- Currently, all the developed APIs are using primary keys as their parameters, now in next application upgradation, use of actual realtime values(username etc.) will be done.
- More detailed error handling will be accomplished.
- JUnit Tests will be written for the same.
- Database wipeout functionality will be handled at every deployement done on server.
