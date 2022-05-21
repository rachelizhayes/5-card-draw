# 5-card-draw
Write code to compare two 5-card poker hands. 
The code should rank the two hands by their strengths. Keep unit tests, patterns and extensibility in mind. 
Use any language and any freely available supporting libraries you like. 
You will be evaluated on the structure of your code. Clearly identify any code that you did not write yourself. 
Please provide instructions to compile and run your code and tests (including how to obtain any required dependencies or IDEs). 
The list of poker hands and their order can be found here:
http://en.wikipedia.org/wiki/List_of_poker_hands

Additional notes:
Feel free to ignore jokers/wild cards, they are not necessary for this test
An ace can be either high or low. Eg. A-2-3-4-5 is a straight, 10-J-Q-K-A is also a straight
Please include comments or documentation for any assumptions you made, 
or any part of the implementation that you didn’t have time to complete


## How To Run
NOTE: I started my project with initial boilerplate code from https://spring.io/guides/gs/rest-service/#initial 
1. Check whether git is installed (run `git --version`) on your machine and if not installed, 
install it following instructions here: https://github.com/git-guides/install-git)
2. Clone this repo and cd into project folder “5-card-draw”
3. Check whether Java JDK is installed (run `javac -version`) on your machine and if not installed,
install it for your machine here: https://www.oracle.com/java/technologies/downloads/
4. Run the application by using the `./gradlew bootRun` command
5. Download Postman (instructions here: https://www.postman.com/downloads/) and hit the following endpoint
(or optionally make a call using curl if you prefer to not download Postman)

POST "http://localhost:8080/poker/evaluate" with a body of any number of hands you want (example below):

```aidl
[
    {
        "cards": [
            "ACE_CLUBS",
            "EIGHT_CLUBS",
            "FIVE_CLUBS",
            "ACE_DIAMONDS",
            "ACE_HEARTS"
        ]
    },
    {
        "cards": [
            "KING_CLUBS",
            "EIGHT_CLUBS",
            "QUEEN_CLUBS",
            "FIVE_DIAMONDS",
            "THREE_CLUBS"
        ]
    }
]
```


7. Once complete, exit out of the program with CTRL+C
8. Run unit tests using the `./gradlew test` command
