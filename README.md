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
1. Install Git if you do not already have it (instructions here: https://github.com/git-guides/install-git)
2. Clone this repo
3. Download java if you do not already have it  (instructions here: https://java.com/en/download/). You can check if you already have it 
installed by running `java -version` in your terminal 
4. Install HomeBrew (https://brew.sh) so that we can easily install Gradle (`brew install gradle`). If you already have Gradle you can skip this step; this project was built using Gradle 7.4.2
5. Since we are using Gradle, you can now run the application by using the `./gradlew bootRun` command 
6. Download Postman (instructions here: https://www.postman.com/downloads/) and hit the following endpoint 
(or optionally make a call using curl if you prefer to not download Postman)

POST "http://localhost:8080/poker/evaluate" with a body of any number of hands you want (example below):

```aidl
[
    {
        "cards": [
            "ACE_CLUBS",
            "EIGHT_CLUBS",
            "FIVE_CLUBS",
            "FIVE_DIAMONDS",
            "TWO_CLUBS"
        ]
    },
    {
        "cards": [
            "ACE_CLUBS",
            "EIGHT_CLUBS",
            "FIVE_CLUBS",
            "FIVE_DIAMONDS",
            "THREE_CLUBS"
        ]
    }
]
```


7. Once complete, exit out of the program with CTRL+C
8. Run unit tests using the `./gradlew test` command
