# Alfred
Alfred is an Android keyboard assistant that performs various functions for you. To use Alfred, you need to switch your input method to the Alfred keyboard. After doing that, you can use Alfred in the following manner:

You: Alfred inform me ebola # Alfred finds you a NYTimes article about Ebola
You: Alfred: Here's your NYTimes article: (nytimes article)
Friend: Alfred weather me
Friend: Alfred:  

## Customizing Alfred
Adding features to Alfred is quite simple. Here's how to do it:
1. Fork the Alfred repo
2. Create a class that follows the following format:
```
package com.example.android.softkeyboard;

//Import statements here

public class <Classname> {

    private static final String API_KEY = <API_KEY>;

    public static String <Method_Name>(String query) {
		//Do what you want Alfred to do here
    }
}
```
3.  In Bot.java, add a case in the switch statement in the format:
```
        case "<command> me":
        	String command_result = <Classname>.<Method_name>(params)
        	String short_url = Bot.shortenURL(command_result);
        	response = !command_result.equals("") ? "Alfred: Here's what you requested: " + short_url : "Alfred: I can't find anything on that";
            break;
```
4.  That's it!

##Original Developers
+ Siddharth Ramakrishnan (siddharthvader)
+ Niger Little-Poole (nlittlepoole)
+ Brian Zeng (thebrianzeng)
