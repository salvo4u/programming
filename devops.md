*LINKS*
https://missing.csail.mit.edu/2020/version-control/
https://benzne.com/devops/#devopsimplementation

*ASKS*
Consider a few system design problems:
	- Messenger
	- Netflix
	- CDN
	- Code deployment system
	- Instagram
	- Crawler

How can these be designed from an architecture point using AWS and Devops.


###What You Will Need :
Passion to work in an exciting, fast paced environment
Good conceptual understanding of the building blocks of modern web-based infrastructure: DNS, TCP/IP, Networking, HTTP, SSL/TLS
Strong Linux skills
Experience with automation of code builds and deployments
Strong command line skills to automate routine system administration tasks
An eye for monitoring - our ideal candidate should be able to look at complex infrastructure and be able to figure out what to monitor as well as how
Databases: MySQL, PostgreSQL and cloud-based relational database solutions like Amazon RDS, database replication and scalability
High Availability: Load Balancing (ELB), Reverse Proxies, CDNs etc.
Scripting Languages: Python/Bash/Shell/Perl
Experience with Virtualisation and Docker
CI/CD automation experience

###GIT
	git init
	git add
	git commit
	git stash
	git push
	git fetch
	git pull
	git reset
	git rm     -- 
	git squash --  
	git rebase --  do use this to merge changes and use squash later 
	git cherrypick
	git diff
	git clean
	git diff
	git reset --hard myhash --> used to undo changes 
	git reset --soft myhash --> used to undo changes 
	git clean --> used to clean unstaged files in the working directory
	git merge branch1 --> will merge branch1 to master branch

#undoing changes
#conflict resolution

#Specify your name with the below command.
	git config user.name "Anshul Gupta"
	git config user.email "anshulgolu123@gmail.com"

#Add remote to your existing repository using : 
	git remote add origin https://github.com/salvo4u/testlab.git

#In most of the cases the file ./.git/config is edited and entries are made in this file 
#Git tags 2 types used to release.Any code to any release tag specifically before will be released in the push.
	Annotated tags   --> git tag -a v1.4 -m "Comments"
	Lightweight tags --> git tag v1.4-1w
#Find differences in 2 branches[git diff commitid1 commitid2]
#Undo last commit in git 


###DOCKER

#Installation
	* Install docker on Centos 7
	* Print Hello-world using docker	
	* Run curl script in docker
	* Run docker as non root --> add ur self in the docker grp 
	[sudo usermod -aG docker $USER]
	* 

#Practice
	Docker is a container based technology used to run images
	Docker can be helpful in provisioning different libraries for different applications
	Docker can combine itself with applications like abcd.war + Docker file ---> Image


#Commands of Docker
	docker run nginx --> will run this application locally and if the image does not exist it will pull it through from docker hub

	docker ps

	docker ps -a --> tells about previous stopped containers also

	docker rm mycontainer --> tells to remove a container permanently

	docker images --> to see the list of images

	docker rmi nginx --> to remove the image and make sure there are no containers that run the image

	docker pull nginx --> will pull the remote image on our machine

	U can not run an image of an OS using docker.
	Docker is meant for applications not 

	docker exec mycontainer cat /etc/config --> will run a command on a container and show the output there and then
	docker run -it centos bash --> will give u the shell of the centos
	docker attach 

	Volumes

#TakeAway 1
	https://github.com/cloudxlab/factorial-project-docker-multi-container
	https://github.com/cloudxlab/react-project-docker
	Build a git repo[Node] --> Build a docker file[] --> install this file on a AWS machine --> Run the code on a machine in the browser


