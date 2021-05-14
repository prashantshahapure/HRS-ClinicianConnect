# HRS-ClinicianConnect

Test tasks for Automation Engineer
Additional Information: BASE_URL for testing https://cc.healthrecoverysolutions.com/login 

1.	What page element selectors do you know?
Ans:- id, name, xpath, LinkText, partialLinkText, tagname, CSSSelectors
2.	Rate your JS knowledge from 0 to 10 (or another language, just indicate)
Ans:- Java 4.5
3.	Rate your Cypress/Selenium knowledge from 0 to 10
Ans:- 5.0
4.	Use selectors to get a list of all admins
 <ul class="users_list">
    		<li class="admin">one</li>
     		<li class="user">two</li>
     		<li class="admin">three</li>
     		<li class="user">four</li>
   	</ul>
	Ans:- //ul[@class=’users_list’]/li[@class=’admin’]
	         //ul[@class='users_list']/child::li[@class='admin']

5.	Use selectors to list all users by data attribute name="user"
<ul class="users_list">
    		<li class="admin">one</li>
     		<li name="user"">two</li>
     		<li class="admin">three</li>
     		<li name="user">four</li>
   	</ul>
	Ans:- //ul[@class='users_list']/li[@name='user']
6.	Filter the list by color attribute. The condition is that you first get the complete list of elements and then filter on the attribute. You need to get a list of items with a red marker.
<ul class="users_list">
    		<li class="user" color=”red”>test1</li>
     		<li class="user" color=”green”>test2</li>
     		<li class="user" color=”red”>test3</li>
     		<li class="user" color=”green”>test4</li>
     		<li class="user" color=”red”>test5</li>
     		<li class="user" color=”green”>test6</li>
     		<li class="user" color=”green”>test7</li>
    		<li class="user" color=”red”>test8</li>
     		<li class="user" color=”green”>test9</li>
     		<li class="user" color=”red”>test10</li>
     		<li class="user" color=”green”>test11</li>
   	</ul>
	Ans:- //ul[@class=’users_list’]/li[@color=’red’]
	         //li[@class='user' and starts-with(@color,'red')]

7.	What actions for elements do you know?
Ans:- Click(), entertext(), dragAndDrop(), contextClick(); i.e. double click
Scrollup down, getting text, read, mouseover the webelement 
8.	How to get an element using Cypress/Selenium?
Ans:- Using driver.findElement(By.xpath(“”));

9.	How to work with select in Cypress/Selenium?
Ans:- Using Select class we can word with Select
First find out the webelement and pass it to the select class
WebElement wb = driver.findElement(By.xpath(“”));
Select se = new Select(wb);
se.selectByVisibleText();
se.selectByIndex();
se.selectByValue();
10.	What actions can be applied to an element using Cypress/Selenium?
Ans:- click(), sendKeys(“”); contextClick(); clear(); moveToelement(), dragAndDrop();
getText(); scrollUpDown:- window.scrollBy(0, 400), getAttribute(), 
11.	Does Сypress/Selenium support drag and drop?
Ans:- Yes. Using Actions class we can do it
12.	Does Сypress/Selenium support file uploads? How?
Ans:- Selenium does not support file uploads, but we can do it using AutoIT.
