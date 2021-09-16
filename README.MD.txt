Greetings,

this project is example of my work in automation of tests for project "brze vesti(web-site)" that we are doing in my current company.

In my work I am using selenium library, java language and JUnit framework.
Idea that I am using for making construction of projects is based on POM.
I am making one package where I am making for every page on web-site different class where I am writing down locators for web elements on page as attributes of class.
Also in that classes I am writing down actions that I will do with that web elements. Actions I am writing down as methods.
In another package I am making for each page different class, same like in first package, just in this package in every class are only tests.
Because all locators are in first package in every test will be written only methods that are equal to test steps.
So even someone who does not know java will see what every test is doing.
Because in every project there are test steps that are repeating big number of time I made one class, Base Test Methods class where I put all that test steps(methods). 
In that class I put plenty methods that are repeating like BeforeClass, AfterClass and then in every test class I make extends to that Base Test Methods class 
so I do not need to write them down in every test class, only once in Base Test Methods class. Also if I need to change them I change them in only one place, in
Base Test Methods class.
