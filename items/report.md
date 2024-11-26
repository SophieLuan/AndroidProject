# [G12 - Team Name] Report


## Table of Contents

1. [Team Members and Roles](#team-members-and-roles)
2. [Summary of Individual Contributions](#summary-of-individual-contributions)
3. [Application Description](#application-description)
4. [Application UML](#application-uml)
5. [Application Design and Decisions](#application-design-and-decisions)
6. [Summary of Known Errors and Bugs](#summary-of-known-errors-and-bugs)
7. [Testing Summary](#testing-summary)
8. [Implemented Features](#implemented-features)
9. [Team Meetings](#team-meetings)
10. [Conflict Resolution Protocol](#conflict-resolution-protocol)

## Administrative


- Firebase Repository Link: <https://console.firebase.google.com/u/0/project/gp-24s2-56f54/overview> 
   - Confirm: [x] I have already added comp21006442@gmail.com as a Editor to the Firebase project prior to due date.
- Two user accounts for markers' access are usable on the app's APK (do not change the username and password unless there are exceptional circumstances. Note that they are not real e-mail addresses in use):
   - Username: comp2100@anu.edu.au	Password: comp2100 [X] // TODO: check if done
   - Username: comp6442@anu.edu.au	Password: comp6442 [X] // TODO: check if done

## Team Members and Roles
The key area(s) of responsibilities for each member

| UID      |     Name     |                                                                    Role |
|:---------|:------------:|------------------------------------------------------------------------:|
| u7897414 |  Lujin Sun   |               Organize meetings, assign tasks and participate in design |
| u7604123 | Xuefei Luan  | Make overall design, provide data sources and participate in the design |
| u7727795 | Zhengyu Peng |       Improve the logic of feature design and participate in the design |
| u7799455 | Zhizhao Sun  |  Implement the basic feature search and load show data,surprise feature |
| u7748243 |  Ziang Wang  |              Responsible for UI design and participate in other designs |


## Summary of Individual Contributions


1. **u7748243, Ziang Wang**  I have 20% contribution, as follows: <br>
  - **Code Contribution in the final App**
    - Feature UXUI, UI-Layout - methods: [onConfigurationChanged](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L212-230) and [setupListeners](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L232-302). xml files: [login.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/login.xml) and [login.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/login.xml) , [activity_main.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_main.xml) and [activity_main.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_main.xml) , [activity_create_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_create_post.xml) and [activity_create_post.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_create_post.xml) , [activity_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_post.xml) and [activity_post.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_post.xml) , [activity_create_comment.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_create_comment.xml) and [activity_create_comment.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_create_comment.xml) , [activity_chat.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_chat.xml) and [activity_chat.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_chat.xml) ,  [activity_chat_detail.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_chat_detail.xml) and [activity_chat_detail.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_chat_detail.xml) , [activity_profile.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_profile.xml) and [activity_profile.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_profile.xml) , [activity_item.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_item.xml) , [activity_load_show_data.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_load_show_data.xml) , [item_comment.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_comment.xml) , [item_message.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_message.xml) , [item_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_post.xml) , [item_user.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_user.xml).
    - Feature UIFeedback - codes: [Start chatting feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/3c9056b59f8b44f5bea3b44b3352fdf1f387bd7b/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java#L65-78) , [Send message feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/3c9056b59f8b44f5bea3b44b3352fdf1f387bd7b/app/app/src/main/java/com/example/smartcityapp/P2P/ChatDetailActivity.java#L95-108) , [Logout feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/3c9056b59f8b44f5bea3b44b3352fdf1f387bd7b/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java#L106-118) , [Search feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L74-86) , [Cancel comment feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/postActivity/CreateCommentActivity.java#L80-89) , [Like and unlike feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java#L108-122) , [Adding comment feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java#L124-138).
    - Adapter binding data from json to RecyclerView - class ActivityAdapter: [ActivityAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/ActivityAdapter.java#L17-83) 
    - Extended tests - [TokenizerTest](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/TokenizerTest.java#L69-157) and [ParserTest](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/ParserTest.java#L63-172) <br><br>

  - **Code and App Design**
    - For the UI design of the app, proposed a clean and consistent design with a red and white color scheme that is applied throughout the app. This includes the titles, buttons, and navigation areas, ensuring that the design remains cohesive across all screens. I focused on making the UI intuitive and user-friendly, with clear button layouts and appropriate spacing for various screen sizes and orientations (portrait and landscape).
    - The tools used for the design included Android Studio for building the XML layout files and Adobe XD for initial wireframing and visual design mockups. These tools allowed me to prototype and implement the design efficiently, ensuring the app provided a consistent and visually appealing user experience. <br><br>

  - **Others**: 
    - Recorded the details of the first meeting in [team-meeting-1.md](team-meeting-1.md) before Checkpoint 1, and completed the part about Tokenizers and Parsers in the report before Checkpoint 2.
    - Added [MIT License](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/LICENSE) to the app and completed the task of identifying and explaining ethical issues in Surprise Feature. <br><br>
<br>
2. **u7604123, Xuefei Luan**  I have 20% contribution, as follows: <br>
  - **Code Contribution in the final App**
    - Feature 1 [Datafiles]: <br>
        - [activities.json (local)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/raw/activity.json?ref_type=heads)<br>
        - [post.json (firebase)](https://console.firebase.google.com/u/0/project/gp-24s2-56f54/database/gp-24s2-56f54-default-rtdb/data)<br>
    - Feature 2 [Load and Show Data(Post Page)]: <br>
        - [PostActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads)<br>
        - [Post.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/Post.java?ref_type=heads)<br>
        - [PostAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java?ref_type=heads)<br>
    - Feature 3 [Interact-Micro(Like, Comment, Create Posts)]: <br>
        - [CreatePostActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreatePostActivity.java), <br>
        - [CommentModel.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentModel.java), <br>
        - [CommentAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentAdapter.java), <br>
        - [CreateCommentActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreateCommentActivity.java), <br>
        - [PostAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java?ref_type=heads)<br>
    - Feature 4 [Interact-Follow(Display liked posts from FB)]:<br>
        - [Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java)<br>
        - [PostAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java?ref_type=heads)<br>
    - Feature 5 [Interact-Profile(Display users profile from FB)]: <br>
        - [Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java)<br>
    
  - **Code and App Design** 
   - **Adapter Pattern:**
    - The Adapter Pattern is used in [PostAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java?ref_type=heads), and [CommentAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentAdapter.java). These adapters serve as bridges between the RecyclerView and the underlying data models (posts and comments) by converting them into a format that can be displayed in the UI. 
   - **Data structure:** 
    - **ArrayList and List:** For example in [PostActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads),[CommentAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentAdapter.java) using ArrayList  provides a scalable, flexible, and efficient way to store and manage a dynamic set of data (like posts and comments) that can change over time. 
    - **HashMap**: Using HashMap in [Post.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/Post.java?ref_type=heads), where the likedBy field is initialized as a HashMap to keep track of which users have liked a post. A HashMap allows constant-time performance for insertions and lookups, which is essential for efficiently managing the 'like' functionality in our app.
  - **Others**: (only if significant and significantly different from an "average contribution") 
    - Firebase setup, features.mp4 video, Minute Madness PowerPoint and presentation.
    <br>
3. **u7799455, Zhizhao Sun** I have 20% contribution, as follows:<br>
- **Code Contribution in the final App**
    -  1) Basic feature: Search
    - [Datafiles]: [activities.json (local)] fix some error for search (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/raw/activity.json?ref_type=heads)
    - class Token: [Token.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/Token.java)
    - class Tokenizer: [Tokenizer.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/Tokenizer.java)
    - class Parser: [Parser.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/Parser.java)
    - class AndEXP: [AndEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/AndEXP.java)
    - class EXP: [EXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/EXP.java)
    - class OrEXP: [OrEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/OrEXP.java)
    - class CaeEXP: [CaeEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/CaeEXP.java)
    - class TypeEXP: [TypeEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/TypeEXP.java)
    - class ParticipantsEXP: [ParticipantsEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/ParticipantsEXP.java)
    - class DateEXP: [DateEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/DateEXP.java)
    - class StrEXP: [StrEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/StrEXP.java)
    - class EqualEXP: [EqualEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/EqualEXP.java)
    - class NullEXP: [NullEXP.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/NullEXP.java)
    - class Parser: [Parser.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/Parser.java)
    - class CreateUniqueID: [CreateUniqueID.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/CreateUniqueID.java)
    - class CAEParserFactory: [CAEParserFactory] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/CAEParserFactory.java)
    -  2) Basic feature: load show data
    - class DataActivity: [DataActivity.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/loadData/DataActivity.java)
    - class DataManagement: [DataManagement.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/loadData/DataManagement.java)
    - class ActivityAdapter: [ActivityAdapter.java] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/ActivityAdapter.java?ref_type=heads)
    -  3) Factory Method Design Pattern 
    - Abstract class CaeEXP
    - class DateEXP
    - class ParticipantsEXP
    - class TypeEXP
    - class CAEParserFactory
  - **Code and App Design**
  - design the [activity_item.xml]

4. **u7727795, Zhengyu Peng**  I have 20% contribution, as follows: <br>
  - **Code Contribution in the final App**
    - Feature 1[Login]:
       - [Login.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/Login.java?ref_type=heads#L20-91) 
       - [Signup.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/Login.java?ref_type=heads#L20-91)
       - [UserSession.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/UserSession.java?ref_type=heads#L24-95)

    - Feature 2[Intereact-Follow]:
       - [PostAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java?ref_type=heads#L151-253)(Participate in the completion of the like button interaction function)
       - [Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java?ref_type=heads#L133-160)

    - Feature 3[Data-Profile]:
       - [Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java?ref_type=heads#L43-161)

    - Unit Test:
       - [ChatAdapterTest.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/ChatAdapterTest.java?ref_type=heads#L26-97)
       - [CommentModelTest.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/CommentModelTest.java?ref_type=heads#L12-59)
       - [PostTest.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/PostTest.java?ref_type=heads#L17-89)
       - [SignupTest.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/SignupTest.java?ref_type=heads#L26-84)
       - [UserSessionTest.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/UserSessionTest.java?ref_type=heads#L25-83)

    - Complete the Android lifecycle callback method
       - [MainActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java?ref_type=heads#L183-209)

  - **Code and App Design**
    - **Singleton pattern**
    - The pattern is used in[Uession.java], recording information about the logged-in user.
    
    - **UI Design**
    - Add the necessary controls to implement the function, such as input fields and buttons for login and registration, and lists to display personal likes, etc. At the same time, participate in the design of the entire app page jump logic.
    
  - **Others**
    - Set up some of the Firebase functionality and file storage structure. 
   


5. **u7897414, Lujin Sun**  I have 20% contribution, as follows: <br>
- **Code Contribution in the final App**
    - 1) Feature [DataStream]:
    - [MainActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java?ref_type=heads#L46-157)
    - 2) Feature [Search]:
    - [AVLNode.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/AVLNode.java)
    - [AVLTree.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/AVLTree.java)
    - 3) Feature [P2P-DM]:
    - [Chat.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/Chat.java)
    - [ChatActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java)
    - [ChatAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatAdapter.java)
    - [ChatDetailActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatDetailActivity.java)
    - [Message.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/Message.java)
    - [User.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/User.java)
    - [UserAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/UserAdapter.java)
- **Code and App Design**
    - **Adapter Pattern:**
    - The Adapter Pattern is used in [ChatAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatAdapter.java), and [UserAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/UserAdapter.java). These adapters serve as bridges between the RecyclerView and the underlying data models (users and chats) by converting them into a format that can be displayed in the UI.
    - **Data structure:**
    - **ArrayList and List:** For example in [ChatActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java), [ChatDetailActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatDetailActivity.java) using ArrayList  provides a scalable, flexible, and efficient way to store and manage a dynamic set of data that can change over time.
    - **HashMap**: Using HashMap in [Chat.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/Chat.java), where the message is initialized as a HashMap to keep track of which users have send a message. A HashMap allows constant-time performance for insertions and lookups, which is essential for efficiently managing the 'chat' functionality in our app.
    - partly design the [activity_chat.xml],[activity_chat_detail.xml],[item_message.xml] and [item_user.xml]

- **Others**: 
    - Set up some of the Firebase functionality. Build the apk file of app. 
    - Recorded the team-meeting from 2-4.



## Application Description


[Application photos](media/_examples/ApplicationPhotos.png) <br>

*The smart city application called "CommuniTide" is designed to enhance community engagement by providing residents with 
a platform to explore and participate in local activities, share updates, and communicate with one 
another. It allows users to browse various community activities, view details like activity type, 
number of participants, and schedule, and search for activities based on their interests. Additionally, 
the app enables residents to post content, mark posts as favorites, and chat with other users. After 
logging in, users can manage and access their favorite posts, fostering a more connected and interactive 
community environment.*


### Problem Statement


*The purpose of this smart city app is to provide community residents with an interactive platform to 
engage in various activities and connect with each other. The app allows users to view and explore a 
variety of activities happening in the community, including details such as types, participant numbers, 
and schedules. Residents can search for activities based on their interests and preferences. Additionally, 
users can view posts shared by other residents, mark them as favorites, and create their own posts to 
share with the community. The app also offers a person-to-person chat feature, enabling direct 
communication between users. After logging in, residents can easily access and manage their favorite 
posts for future reference.*

### Application Use Cases and/or Examples


**Target Users: Residents of the same or nearby communities**

1. *Lily just moved to a new neighborhood and wants to meet other residents.*
2. *She finds an update in the app about wanting to go hiking on the weekend, as it's types is 'social activity.'*
3. *Tom, another resident in the area, sees the same activity and comments that he and a few friends are also planning a hike and invites her to join.*
4. *They use the app's person to person messaging feature to coordinate the details and agree on a meeting time and place.*
5. *After the activity, Lily posts her views from the hike, sharing the experience with the community.*

**Target Users: Neighbors looking to organize community events**

1. *Mark wants to organize a community clean-up event and uses the app to create an event post, inviting residents from nearby areas.*
2. *Other residents using the app, interested in participating, RSVP to the event through the app after login or easy signup.*
3. *Mark uses the app's person to person chat feature to discuss details with participants, such as supplies and meeting points.*
4. *After the clean-up, participants share their thoughts in the app, encouraging more people to join future events.*

**Target Users: People interested in local social updates**

1. *Sarah frequently updates her daily activities and shares interesting moments from her life on the app through creating posts.*
2. *Her neighbors can like her posts, fostering casual social interactions and conversations.*
3. *Sarah notices that several residents are interested in similar hobbies and uses the app to arrange a local gathering for people with common interests.*

*List all the use cases in text descriptions or create use case diagrams. Please refer to https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-use-case-diagram/ for use case diagram.*

<hr> 

### Application UML

[Login](media/_examples/Login.png)
[P2P](media/_examples/P2P.png)
[PostAndProfile](media/_examples/PostAndProfile.png)
[SearchAndLoadData](media/_examples/SearchAndLoadData.png)<br>

<hr>

## Code Design and Decisions

This is an important section of your report and should include all technical decisions made. Well-written justifications will increase your marks for both the report as well as for the relevant parts (e.g., data structure). This includes, for example,

Parser:
- Details about the parser (describe the formal grammar and language used)

This grammar defines simple logical expressions involving categories, equality, and logical conjunctions/disjunctions.

Parser Design Details:
1. Tokenizer Integration: The Parser uses a Tokenizer to sequentially process tokens such as "AND", "OR", "=", and category-related tokens. 
2. Recursive Parsing: The parser employs recursive functions to evaluate the expression rules, allowing for nesting of logical operations (AND and OR).
3. Expressions and Terms: Custom expression classes such as AndEXP, OrEXP, EqualEXP, and StrEXP are used to represent the components of the grammar and handle specific evaluations.
4. Category and String Evaluation: The parser is equipped to handle category terms (e.g., type, participants, date) and their associated string or integer comparisons.


- Decisions made (e.g., explain why you chose one or another data structure, why you used a specific data model, etc.)

Key Design Decisions For Parser:
1. Modularity and Extensibility: The use of classes for different expressions (AndEXP, OrEXP, etc.) ensures that the parser is modular and can be extended for additional logical operators in the future.
2. Error Handling: The Token class includes a custom IllegalTokenException to handle parsing errors, ensuring that invalid tokens can be caught and addressed effectively.
3. Efficient Token Matching: The Tokenizer trims and sequentially processes input strings, detecting logical operators and comparison symbols efficiently.
4. Simple Evaluation Logic: Each expression class includes an evaluate() method to handle specific evaluations, keeping the parser logic clean and focused on token handling.

Data Structure Choice: AVLTree:
1. Balanced Binary Search Tree
   Reason: The AVL tree is a self-balancing binary search tree, ensuring that the height remains logarithmic in the number of elements. This guarantees that the time complexity for search, insert, and delete operations is O(log n) in the worst case.
   Alternative Consideration: A standard binary search tree (BST) could have been an option. However, without self-balancing, a regular BST can degenerate into a linked list in the worst case, leading to O(n) time complexity for operations.
2. Rotation Operations for Balance:
   Reason: The AVL tree maintains balance through left and right rotations. After each insert operation, rotations are applied to ensure the tree remains balanced, and this ensures efficient query performance.
   Design Decision: In the doInsert method, left (rotateLeft) and right (rotateRight) rotations are implemented. These rotations are conditionally applied based on the balance factor (getBalance), ensuring that the tree remains balanced after insertion.
3. Recursive Insertion:
   Reason: Recursive insertion simplifies the logic by abstracting away the need for explicit stack management. Each insertion recursively navigates the tree, ultimately inserting a new node at the correct subtree, and rebalancing the tree as necessary.
   Design Decision: The recursive approach for insertion (doInsert) ensures clean, maintainable code that naturally handles the tree traversal without additional complexity.
4. Search Function Integration with Parser:
   Reason: The search function is integrated with a custom Tokenizer and Parser, which allows for more advanced querying capabilities, such as logical expressions (AND, OR). This goes beyond simple string matching and supports more sophisticated searches.
   Design Decision: In the doSearch method, the parser is utilized to process the query string and match it against node values. This design decision provides the search functionality with the flexibility to handle complex expressions and can easily be extended in the future.
5. Memory Efficiency:
   Reason: The AVL tree implementation manages memory efficiently by only storing minimal data per node, including the key, value, and child node references. The height of the node is stored to assist in balancing, but no unnecessary data is retained.
   Design Decision: The node class only contains essential information (key, value, left, and right child references) to avoid unnecessary memory overhead, making the AVL tree suitable for handling large datasets efficiently.

Design Patterns:
1. Interpreter Pattern:
   Reason: The integration of the Tokenizer and Parser suggests the use of the Interpreter Pattern, which allows the system to interpret and process logical queries. This pattern is particularly useful when a system needs to evaluate expressions and interpret commands based on a formal grammar.
   Design Decision: The search functionality leverages a parser class to evaluate logical expressions in queries, enabling the system to interpret complex search conditions. This pattern makes the search logic highly extensible, allowing new types of expressions to be added easily in the future.

LogIn and UserSession:
- Design Patterns: Singleton Pattern in UserSession

1. Singleton Pattern:
   Reason: The UserSession class implements the singleton pattern to ensure that only one instance of the session exists throughout the app's lifecycle. This prevents multiple instances from managing conflicting session data and ensures consistency in tracking user login status.
   Design Decision: The static getInstance() method guarantees that only one instance of UserSession is created. By using lazy initialization (if (instance == null)), the class ensures that the session instance is only created when needed, optimizing resource usage.
2. Thread-Safe Singleton:
   Reason: The getInstance() method is synchronized to prevent race conditions in multithreaded environments. If multiple threads try to access the UserSession simultaneously (for example, when user data is accessed across different parts of the app), this synchronization ensures that only one thread can create the session instance.
   Design Decision: Synchronizing the method ensures thread safety without incurring unnecessary overhead, as the check for an existing instance (instance == null) occurs before locking.

- Session Persistence Using SharedPreferences

1. Persistent User Data:
   Reason: SharedPreferences is used to store user session data (username, login status) persistently. This allows the session to be restored even after the app is closed or the device is rebooted.
   Design Decision: Upon initialization, the constructor retrieves stored preferences (e.g., isLoggedIn and username) and loads them into the UserSession. Similarly, the setLoggedIn() method updates the stored values when the session state changes, ensuring that the session remains consistent across app launches.
2. Application Context for Consistency:
   Reason: The class uses the ApplicationContext to ensure that the session is tied to the app's lifecycle rather than a specific activity. This prevents memory leaks and ensures that the session instance remains valid even if the user navigates between different activities.
   Design Decision: By using context.getApplicationContext(), the class ensures that the session's preferences are not tied to any individual activity’s context, which could be destroyed during the app's lifecycle.

-Design for Flexibility and Ease of Use
1. Single Point of Access:
   Reason: By centralizing user session management within a single class, the app ensures that all components interact with user data in a consistent way, reducing the chance of errors or inconsistent states.
   Design Decision: The UserSession class offers clear methods to manage login status and retrieve the username. This encapsulation simplifies how other parts of the app access and manage the session, leading to cleaner and more maintainable code.
2. Extensibility:
   Reason: The design can easily be extended to manage additional user session details (e.g., roles, preferences, etc.) by adding more methods or preferences within the same class. This makes it flexible for future growth as the app evolves.
   Design Decision: The use of SharedPreferences combined with a single point of access for session management allows for easy expansion without significant changes to existing code.
- 
- Details about the design patterns used (where in the code, justification of the choice, etc)

*Please give clear and concise descriptions for each subsections of this part. It would be better to list all the concrete items for each subsection and give no more than `5` concise, crucial reasons of your design.

<hr>

### Data Structures

*I used the following data structures in my project:*

1. *ArrayList*
   * *Objective: used for storing post and comment for Interact-Micro feature.
   * used for storing message for P2P-DM feature.
   * *Code Locations: defined in [PostActivity.java, methods onDataChange](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads#L70-98) and [ChatActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java); processed using [onDataChange](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java#L93-106)
   * *Reasons:*
      * *ArrayList provides efficient random access, which is useful for handling the dynamic data retrieved from Firebase.*
      * *It allows dynamic resizing, which is essential since the number of posts retrieved can vary, and this flexibility is not available in fixed-size structures like arrays.*
      * The ArrayList can easily be cleared and re-populated when new data is fetched (postList.clear()) with an average time complexity of O(1) for adding elements.

2. *HashMap*
   * *Objective: Used in the Post class to track which users liked a post (likedBy map) for Interact-Micro feature.
   * Used in the Chat class to store message data (message map) before adding it to the Firestore database for P2P-DM feature.
   * *Code Locations: defined in [Chat.java, methods sendMessage](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/Chat.java#L34-58) and [Post.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/Post.java?ref_type=heads#L22-35).
   * *Reasons:*
      * *The HashMap in the Post class (likedBy) is used to efficiently track which users have liked a post, with keys representing user IDs and values indicating whether the user has liked the post (true/false). This provides O(1) time complexity for checking, adding, and removing user likes.*
      * *The HashMap is preferred here because it allows for quick lookups to determine if a specific user has already liked the post, which is essential for toggling likes efficiently.*
      * In the Chat class, the message map is used to structure message details (sender, text, timestamp) in a key-value format before sending it to Firestore. This is convenient for storing heterogeneous data types and allows easy integration with Firestore, which expects data in map-like formats.*
      * The HashMap allows the dynamic creation of message objects without requiring a separate class for each message structure, simplifying the storage of different types of data (strings and long integers) in one place.* 

3. *AVLTree*
   * *Objective: used for efficiently managing and retrieving DataActivity objects in a balanced way for search feature.
   * *Code Locations: defined in [AVLTree.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/AVLTree.java?ref_type=heads) and [AVLNode.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/AVLNode.java?ref_type=heads).
   * *Reasons:*
      * *Balanced Search Tree: The AVL Tree structure is used because it maintains a balanced tree, ensuring that search operations are performed efficiently with a time complexity of O(log n). This is particularly important for handling large datasets, where maintaining balance helps in reducing search, insert, and delete times.*
      * *Efficient Searching: When a user performs a search, the search method uses a recursive in-order traversal (doSearch) to find matches based on the given query. This traversal ensures that all matching nodes are efficiently located in a balanced manner.*
      * Data Organization: The AVL Tree organizes data (DataActivity objects) in a way that facilitates both insertion and search in a balanced structure. This helps in quickly adding new data and retrieving relevant results without the risk of skewed branches that can degrade performance.*
      * Automatic Balancing: The tree is self-balancing due to the implementation of rotations (rotateLeft and rotateRight). This ensures that even after multiple insertions or deletions, the depth of the tree remains minimal, which is key for maintaining efficient search operations.*


<hr>

### Design Patterns


1. *Interpreter Pattern*
   * *Objective: uused for interpreting and evaluating logical search queries, allowing the system to process user inputs that involve complex expressions such as logical conditions and category-value comparisons.*
   * *Code Locations: implemented in [Parser class, methods parseExp, parseTerm, parseCategory, parseStr](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/Parser.java?ref_type=heads#L34-134) and [Tokenizer class, methods next, current](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/Tokenizer.java?ref_type=heads#L17-58). These work together to process and evaluate expressions.*
   * *Reasons:*
      * *The integration of the Tokenizer and Parser suggests the use of the Interpreter Pattern, which allows the system to evaluate complex search queries based on formal grammar rules.*
      * *This pattern is highly extensible, allowing new types of search expressions to be easily added in the future, enhancing flexibility and scalability of the search functionality.*

2. *Singleton Pattern*
   * *Objective: used for managing and persisting the user session state across the application.*
   * *Code Locations: defined in [Usersession.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/UserSession.java?ref_type=heads#L24-95) ; processed using [checkLoginMethod](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/Login.java?ref_type=heads#L58-89) .*
   * *Reasons:*
      * *It helps to decouple the data logic from the UI logic.*
      * *By centralizing login and session management, this pattern avoids redundancy and provides a global point of access, making session handling more maintainable and efficient.*
      * *It also facilitates persistent storage of login information using SharedPreferences, allowing the user session to survive app restarts.*

3. * *Adapter Pattern*
   * *Objective: used for binding and displaying a list of messages or users in the UI components such as RecyclerView for chat and user lists.*
   * *Code Locations: defined in [PostAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java?ref_type=heads), [CommentAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentAdapter.java), [ChatAdapter class, methods onBindViewHolder, onCreateViewHolder](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatAdapter.java?ref_type=heads#L77-131) and [UserAdapter class, methods onBindViewHolder, onCreateViewHolder](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/UserAdapter.java?ref_type=heads#L63-101); applied in [ChatDetailActivity, method onCreate](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java?ref_type=heads#L39-113).*
   * *Reasons:*
      * *The Singleton pattern ensures that only one instance of UserSession exists throughout the application's lifecycle, effectively maintaining a consistent state for the user session.*
      * *By creating separate view holders for each message and user, it simplifies the process of rendering a list of varying data types.*
      * *The pattern ensures flexibility in managing changes to the underlying data model without affecting the UI logic, making it easier to extend or modify the display logic.*
<hr>


### Parser

### <u>Grammar(s)</u>

The parser follows a context-free grammar (CFG) to interpret logical expressions with categories, comparison operators, and logical connectors. The grammars designed are as follows:

Production Rules:
```
    <exp> : : = <term> | <term> AND <exp> | <term> OR <exp>
    <term> : : = <category> "=" <str>
    <category> : : = "type" | "participants"  | "date"
    <str> : : = string | integer
```

Main Expression Grammar: This grammar defines how a term can stand alone or be combined using logical operators (AND, OR).
```
    <exp> : : = <term> | <term> AND <exp> | <term> OR <exp>
```

Term Grammar: A term is a comparison between a category (e.g., type, participants, date) and a string or integer value.
```
    <term> : : = <category> "=" <str>
```

Category Grammar: Categories are fixed, predefined options in the input data, referring to types of entities that can be compared.
```
    <category> : : = "type" | "participants"  | "date"
```


### <u>Tokenizers and Parsers</u>

Tokenisers and parsers are used for searching.

A tokenizer breaks down a string of input text into a series of tokens that the parser can understand. The key steps in building a tokenizer include:
- Input Handling: The tokenizer receives a raw string of input text.
- String Trimming and Cleanup: Before extracting tokens, the tokenizer trims unnecessary spaces and other irrelevant characters.
- Pattern Matching: The tokenizer uses predefined patterns to identify and extract tokens.
- Token Creation: Once the tokenizer recognizes a piece of text as a token, it wraps it into a Token object (defined in Token.java) that includes the token’s value and its type (e.g., AND, OR, EQUAL, etc.).
- Advancing Tokens: The tokenizer moves through the input, advancing one token at a time, and updates the current token. This is important for sequential parsing, where tokens are processed one by one.

A parser processes the tokens generated by the tokenizer according to the grammar rules. It breaks down these tokens into meaningful syntactic structures. The key steps to building a parser include:
- Token Navigation: The parser uses the tokenizer to fetch and move between tokens. It looks at the current token and decides what grammar rule applies (e.g., whether it’s part of an expression, term, etc.).
- Recursive Parsing: The parser follows recursive methods to parse complex expressions. For example, parsing an expression like type = "event" AND participants = 5 involves first parsing type = "event" as a term, and then processing the logical AND with the next term (participants = 5).
- Expression Classes: Custom classes (AndEXP, OrEXP, EqualEXP, etc.) represent the various components of the grammar. The parser uses these to build a syntax tree.
- Evaluation and Execution: Once the entire expression is parsed, the parser evaluates it using the classes that represent the parsed components.

Advantages of the Tokenizer-Parser Design:
- Separation of Concerns: The tokenizer and parser are separate components, which keeps the design modular and easier to maintain. The tokenizer focuses on lexical analysis (splitting input into tokens), while the parser focuses on syntactic analysis (organizing tokens into a logical structure).
- Error Handling: Both components can independently manage errors. The tokenizer throws exceptions for illegal tokens, while the parser handles invalid syntax by raising errors during parsing.
- Recursive and Extensible: The parser design is recursive, allowing for the easy handling of nested expressions and logical operators. Extending the grammar (e.g., adding new operators like NOT) would only require additional classes and minor changes to the parsing logic.
- Efficient Token Processing: The tokenizer processes tokens sequentially, minimizing backtracking and ensuring efficient parsing of complex expressions.

<hr>


## Implemented Features


### Basic Features
1. [LogIn]. Users can register and log in to the app using their email accounts to access the full functionality of the app. (easy)
   * Code: [Login.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/Login.java?ref_type=heads#L20-91), [Signup.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/Login.java?ref_type=heads#L20-91),[UserSession.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/UserSession.java?ref_type=heads#L24-95)
   * Link to the Firebase repo: [link](https://console.firebase.google.com/u/0/project/gp-24s2-56f54/overview)
   * Description of feature: The app uses Firebase Authentication to store user login data, enabling registration and login functionality. Registered users are assigned a random avatar and receive a unique UID, which ensures accurate user identification. This UID allows users to perform various actions later on, such as creating posts, commenting, and engaging in P2P activities. <br>
   * Description of your implementation: 
   - 1) User Registration (Signup Class): Firebase Integration: The Signup class provides user registration functionality through Firebase Authentication. It uses the registerUser method to create a new user account using an email and password.
        User Data Management: Upon successful registration, a unique UID is generated for the user, which is used to store user details in the Firebase Realtime Database. This data includes the user’s name (derived from the email), a randomly assigned avatar path, and the UID itself, allowing precise identification.
        Avatar Assignment: The assignAvatar method assigns a random avatar to each new user, with paths pointing to images stored in Firebase Storage. This helps in visually distinguishing users.
   - 2) User Login (Login Class): User Authentication: The Login class handles the user login process through Firebase Authentication. The checkLogin method verifies the provided credentials (email and password) and logs the user in if the authentication is successful.
        Session Management: After a successful login, UserSession.getInstance(this).setLoggedIn(true, username, userId) is called to maintain the user session, enabling users to be recognized within the app until they log out.
        Navigation Handling: On successful login, an intent is created to navigate to the MainActivity, providing a seamless experience for users accessing the app's main features.
   - 3) User Session Management (UserSession Class): Singleton Pattern: The UserSession class follows the Singleton design pattern, ensuring that only one instance of the session exists for the entire application, simplifying session management.
        Session Persistence: User login status, username, and UID are stored in SharedPreferences, ensuring the user remains logged in between app sessions.
        User Data Initialization: The method setLoggedIn initializes or clears user data based on the login status. If logged in, it creates a reference in Firebase Realtime Database for storing user-specific data, such as likes (user_likes), allowing personalized operations within the app.
        Convenience Methods: Methods like isLoggedIn() and getUsername() are provided to easily access the current user's session details, helping the rest of the app adapt based on the user's login state.
   <br>

2. [DataFiles]. The app must use a data set (which you may create) where each entry represents a meaningful piece of information relevant to the app. The data set must be represented and stored in a structured format as taught in the course. It must contain at least 2,500 valid instances. (easy)
   * Code to the Data File [activities.json (local)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/raw/activity.json?ref_type=heads), [post.json (firebase)](https://console.firebase.google.com/u/0/project/gp-24s2-56f54/database/gp-24s2-56f54-default-rtdb/data)
   * Link to the Firebase repo: [link](https://console.firebase.google.com/u/0/project/gp-24s2-56f54/overview)

3. [LoadShowData]. The app must load and display data instances from the data set. Data must be retrieved from either a local file (e.g., JSON, XML) or Firebase. (easy)
   * Code: [Post.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/Post.java?ref_type=heads), [PostAdapter.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java) , [PostActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads), [load and show local data]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/tree/main/app/app/src/main/java/com/example/smartcityapp/loadData)
   * Description of your implementat
      - **Load and Show Local Data:**<br>
      *Data Loading*: The DataManagement class reads data from a JSON file, creates DataActivity objects, assigns unique IDs, and organizes the activities into an AVL tree.
      *Displaying Data*: The loadShowData activity takes the list of DataActivity objects and displays them in a RecyclerView using an adapter, allowing users to browse through the loaded activities.
     - **Load and Show Firebase Data:**<br>
      1) **Firebase Reference:** A [DatabaseReference]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java #L76) to the "post" node in Firebase is established.
      2) **ListView Setup:** An [ArrayList<Post>](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java # L70-73)holds the posts, and a [PostAdapter]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads#L70-73) populates the [ListView]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads#L70-73). 
      3) **Data Retrieval (PostActivity):** Using [addValueEventListener](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads#L79-105), the app listens for post data changes in Firebase. Each post snapshot is mapped to a `Post` object, and the post ID is retrieved and set.
      4) **Sorting (PostActivity):** Posts are sorted by timestamp in descending order (most recent first).
      5) **Adapter Update (PostAdapter):** The [PostAdapter]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads#102) is notified of changes, and it updates the UI with the latest posts.
      6) **Error Handling (PostActivity):** If the retrieval fails, a [toast message]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads#L101-103) is displayed.



4. [DataStream]. The app can periodically load and display different data from a data file. (medium)
    * Code: [activities.json (local)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/raw/activity.json?ref_type=heads) and [MainActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java?ref_type=heads#L46-157)
    * Description of feature: The app can periodically load and display different data from a local JSON file, refreshing the page every ten seconds with randomized data. When the user utilizes the search function, the refreshed data will also meet the search criteria. Additionally, the data refresh feature will automatically pause when the user leaves the home page. <br>
    * Description of your implementation: 
   - 1) Data Loading (loadShowData method): The loadShowData method is used to read and display data from a local JSON file. In this method, data is loaded using the loadDataFromJson(this) method of the DataManagement class, and the loaded data is stored in activityList. A RecyclerView and ActivityAdapter are used to display the data. The data is randomized using Collections.shuffle(activityList), and the top 10 items are selected for display in the RecyclerView. After each data load and display, a notification is shown to the user with Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show() indicating that the data has been updated.
   - 2) Scheduled Updates (dataStreamRunnable and Handler usage): The implementation of data streaming updates is achieved using a combination of Handler and Runnable. A Runnable object named dataStreamRunnable is defined, where the run method calls loadShowData() to periodically load and display new data. The method handler.postDelayed(this, 10000) is used to set up a repeated invocation every 10 seconds, enabling the data to refresh at regular intervals.
   - 3) Lifecycle Management:Data refresh is managed effectively across the Activity lifecycle:In the onResume() method, data refreshing is started using handler.post(dataStreamRunnable). In the onPause(), onStop(), and onDestroy() methods, handler.removeCallbacks(dataStreamRunnable) is called to stop the data refresh, preventing resource waste or app crashes. This ensures that data updates are paused when the user leaves the page and resume when the user returns.* <br>

5. [Search]. 
    * Code: search package(https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/tree/main/app/app/src/main/java/com/example/smartcityapp/Search?ref_type=heads)
    * Description of your implement:
   - **Token class to save extracted token from tokenizer.**<br>
   - The following are the different types of tokens: 
   - CAE: type, participants, date;
   - EQUAL: = ;
   - AND:AND ;
   - OR: OR ;
   - STR: string  or  integer.
   - **Tokenization class**<br>
   - Tokenization is the process of splitting a string into small units called, 'Tokens', to be passed onto the Parser.
   - **Abstract class Exp to represent expressions**<br>
   - **Class Parser parse the input string**
   - **Class CreateUniqueID could create a unique identifier for each activity to be used for AVL tree searches.**
   - **Class AVLNode and AVLTree could insert and search date by using the unique ID.**


6. [UXUI]. The app must maintain a consistent design language throughout, including colors, fonts, and UI element styles, to provide a cohesive user experience. The app must also handle orientation changes (portrait to landscape and vice versa) gracefully, ensuring that the layout adjusts appropriately. (easy)
   * Code: [login.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/login.xml) and [login.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/login.xml) , [activity_main.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_main.xml) and [activity_main.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_main.xml) , [activity_create_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_create_post.xml) and [activity_create_post.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_create_post.xml) , [activity_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_post.xml) and [activity_post.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_post.xml) , [activity_create_comment.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_create_comment.xml) and [activity_create_comment.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_create_comment.xml) , [activity_chat.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_chat.xml) and [activity_chat.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_chat.xml) ,  [activity_chat_detail.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_chat_detail.xml) and [activity_chat_detail.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_chat_detail.xml) , [activity_profile.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_profile.xml) and [activity_profile.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_profile.xml) , [activity_item.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_item.xml) , [activity_load_show_data.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_load_show_data.xml) , [item_comment.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_comment.xml) , [item_message.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_message.xml) , [item_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_post.xml) , [item_user.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_user.xml) , methods [onConfigurationChanged](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L212-230) and [setupListeners](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L232-302). <br>

   * Description of feature: <br>
     - The app is designed to ensure a consistent and cohesive user experience by maintaining a unified design language across all screens and features. This includes using consistent color schemes, fonts, and UI element styles throughout the app to create a visually harmonious interface. The color palette, typography, and button styles are uniform, allowing users to navigate intuitively without any visual discrepancies. <br>
     - Additionally, the app is optimized to handle orientation changes seamlessly. Whether the user is in portrait or landscape mode, the layout adjusts gracefully, ensuring that UI components are repositioned and resized appropriately for the best user experience. This responsive design allows users to interact with the app on a variety of screen sizes and orientations without losing functionality or clarity. The result is a flexible, accessible app that adapts to the user's preferences while providing a visually consistent and pleasant experience. <br>

   * Description of your implementation: <br>
     - The app’s design is implemented with a consistent color scheme of red and white throughout all its elements, ensuring a unified and clean visual experience. For instance, titles at the top of each page use red and white, while buttons at the bottom of the page are either red or black, maintaining a cohesive design style across all screens. <br>
     - To handle different screen orientations, the main pages (Home, Post, Chats, Profile) are implemented with separate layouts for portrait and landscape modes. These layout files are stored in the [layout](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/tree/main/app/app/src/main/res/layout) folder for portrait mode and the [layout-land](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/tree/main/app/app/src/main/res/layout-land) folder for landscape mode. This ensures that the app’s UI adjusts appropriately when the device orientation changes, offering a smooth user experience. <br>
     - In the [MainActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java), two key methods are added to support orientation changes: [onConfigurationChanged](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L212-230) and [setupListeners](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L232-302). The [onConfigurationChanged](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L212-230) method allows the app to dynamically switch between portrait and landscape layouts for the Home page without recreating the activity, while the [setupListeners](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L232-302) method ensures that the necessary button listeners are re-initialized after each orientation change. This implementation provides a responsive interface that adapts to various orientations while maintaining functionality and consistency across different views. <br>

7. [UIFeedback]. The UI must provide clear and informative feedback for user actions, including error messages to guide users effectively. (easy)
   * Code: [Login feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Login/Login.java#L58-88) , [Start chatting feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/3c9056b59f8b44f5bea3b44b3352fdf1f387bd7b/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java#L65-78) , [Send message feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/3c9056b59f8b44f5bea3b44b3352fdf1f387bd7b/app/app/src/main/java/com/example/smartcityapp/P2P/ChatDetailActivity.java#L95-108) , [Logout feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/3c9056b59f8b44f5bea3b44b3352fdf1f387bd7b/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java#L106-118) , [Search feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L74-86) , [Cancel comment feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/postActivity/CreateCommentActivity.java#L80-89) , [Like and unlike feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java#L108-122) , [Adding comment feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/5b708eea4efe769aa2ac3003e911ad2bc22da778/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java#L124-138) , [Create post feedback](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreatePostActivity.java#L89-99). <br>

   * Description of feature: <br>
     - The app is designed to provide clear and informative feedback for all user interactions, ensuring an intuitive and user-friendly experience. Every time a user takes an action, such as creating a post, posting a comment, or sendinging a message, the UI responds with relevant feedback. For example, when a user successfully posts a comment or sends a message, a toast message such as "Comment added!" or "Send successfully" is displayed to confirm the action. <br>
     - In cases where an error occurs, such as a failed login or an invalid input, the app provides immediate and descriptive error messages to guide the user. These error messages clearly explain what went wrong and offer instructions on how to correct the issue, ensuring that the user can quickly resolve any problems. This approach to feedback ensures that users are always aware of the results of their actions, making the app easy to navigate and reducing frustration during interactions. <br>

   * Description of your implementation: <br>
     - In the app, user interactions are enhanced by providing immediate feedback through toast notifications. When a button is clicked, a prompt pops up at the bottom of the page using the Toast.makeText method. This implementation ensures that users are informed about the result of their actions in real-time. For instance, when the user clicks a button to post a comment, submit a search, or navigate to a different page, a toast message such as "Comment added!" or "View results" is displayed briefly at the bottom of the screen. <br>
     - The Toast.makeText method is used to create these non-intrusive notifications, ensuring they appear for a short duration without interrupting the user's workflow. This approach provides quick, visible feedback, keeping users informed while maintaining a smooth and uninterrupted app experience. Each button action is paired with a relevant toast message to ensure clarity and improve overall user interaction with the app. <br>
  <br>

### Custom Features
Feature Category: User Interactivity <br>
1. [Interact-Micro]. The app must provide the ability to micro-interact with items or users (e.g., like, block, connect to another user) with interactions stored in-memory. (easy)
    * Code: [Post.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/Post.java?ref_type=heads), [PostAdapter.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java) , [PostActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads)
[CreateCommentActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreateCommentActivity.java).
[CreatePostActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreatePostActivity.java?ref_type=heads)
[CommentModel.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentModel.java?ref_type=heads)
[CommentAdapter.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentAdapter.java?ref_type=heads)
    * Description of the feature: Users can give likes to others’ posts, comment on others’ posts, and create their own posts with post title and post content, with interactions stored in Firebase for persistence.
    * Description of your implementation:   
    - **Like function:**
    - The [PostAdapter.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java) manages the interaction, ensuring that the like button updates visually and the total like count is synchronized with Firebase. The app tracks whether a user has already liked a post to prevent duplicate likes.
    - **Comment function:**
    - Comments are added by users via a text input in [CreateCommentActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreateCommentActivity.java). Upon submission, the comment data (user, avatar, text, timestamp) is stored in Firebase and displayed under the relevant post. The [CommentAdapter.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CommentAdapter.java?ref_type=heads) dynamically updates the UI to display new comments as they are added.
    - **Create Post function:**
    - The [CreatePostActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/CreatePostActivity.java?ref_type=heads) allows users to create new posts with a title and content. Once a post is submitted, it is saved to Firebase with metadata including the user who posted, the timestamp, and any associated avatar. The new post is then displayed on the homepage via [PostActivity.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostActivity.java?ref_type=heads)

<br><br>


2. [Interact-Follow] The app must provide the ability to follow, save or collect items. There must be a section that displays all items followed, saved or collected by a user, with items grouped and ordered. This information should be stored in-memory. (hard)
    * Code: [Post.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/Post.java?ref_type=heads), [PostAdapter.java]( https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/postActivity/PostAdapter.java), 
[Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java?ref_type=heads)

    * Description of the feature: The app provides the ability to like and save posts, which is stored in Firebase and displayed in a user’s profile as liked posts.
    * Description of your implementation: 
    - **Like and Save Posts:** When a user likes a post, this like action is saved to Firebase under the user’s profile. The liked posts are tracked under each user’s data in Firebase, making them available to be retrieved later for display on the profile page.
    - **Displaying Liked Posts:** The [Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java?ref_type=heads) fetches the liked posts from Firebase, sorts them by timestamp, and displays them in a grouped format under the "Liked Posts" section. The items are grouped by user and ordered by when they were liked.

 <br>
      <br>

Feature Category: Greater Data Usage, Handling and Sophistication <br>
3. [Data-Profile] The app must include a Profile Page for users (or any relevant entity within your app’s theme) that displays a media file, such as an image, animation (e.g., GIF), or video. (easy)
    * Code:   [Profile.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Profile/Profile.java?ref_type=heads)
    * Description of the feature: The app includes a Profile Page that displays the user’s avatar, email, and their liked posts. The user can also see a list of the posts they have liked, all stored and retrieved from Firebase.
    * Description of your implementation: - **Displaying Profile Data:**
    - The profile page retrieves the user’s avatar URL, email address, and liked posts from Firebase. The avatar is loaded into an `ImageView`, and the liked posts are displayed in a `RecyclerView`, managed by the `PostAdapter.java`.
    - Firebase Authentication is used to fetch the current user's profile details, including the avatar and email, and this data is displayed as soon as the user navigates to their profile page.

 <br>
      <br>


Feature Category: Peer to Peer Messaging <br>
4. [P2P-DM]. The app must provide users with the ability to send direct, private messages to each other. (hard)
    * Code:[Chat.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/Chat.java)
    * [ChatActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatActivity.java)
    * [ChatAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatAdapter.java)
    * [ChatDetailActivity.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/ChatDetailActivity.java)
    * [Message.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/Message.java)
    * [User.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/User.java)
    * [UserAdapter.java](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/P2P/UserAdapter.java)
    * Description of your implementation: 
   - 1) Data Retrieval: The implementation of the P2P chat system is based on Firebase services. Specifically, Firebase Authentication is used to manage user login and registration, allowing each user to be uniquely identified by their UID (User ID). Once sign up, users are assigned a unique UID that is subsequently used for all other interactions in the app, ensuring secure identification and authorization. Firebase Realtime Database and Cloud Firestore are utilized to handle data storage and retrieval for chat conversations, enabling real-time synchronization between users. <br>
   - 2) User Data Management: Upon user registration, user information, including their username, avatar, and UID, is automatically saved to Firebase Realtime Database. This data is structured hierarchically, with each user identified by their UID under the "users" node, containing fields such as "name", "avatar", and "uid". This allows easy access and updating of user-related information during interactions.
   - 3) Adapter Design Pattern: To manage the display of users and messages within the chat, the adapter design pattern is employed. The UserAdapter and ChatAdapter classes are responsible for dynamically binding user and message data to UI components within RecyclerView. This pattern ensures efficient reuse of UI elements and provides a smooth user experience when displaying large lists of chat messages or user contacts.
   - 4) User Interface and Navigation: The application interface consists of several activities that facilitate navigation between different features. The ChatActivity is used for the actual chat functionality, displaying the conversation between the current user and their selected contact. User selection for initiating a conversation is handled through a list displayed by UserAdapter, which allows users to click on a contact and proceed to a detailed chat view. Additionally, navigation buttons and listeners are implemented to handle transitions between the home screen, chat page, and user profiles.
   - 5) Message Sending and Listening: The Chat class is responsible for managing the sending and receiving of messages between users. Messages are represented by the Message class, which includes fields such as senderId, text, and timestamp. When a message is sent, it is saved to Cloud Firestore under the "chats" collection, with a unique chatId generated for each pair of users. To ensure real-time communication, Firebase Realtime Database's addSnapshotListener() is used to listen for incoming messages, automatically updating the UI when a new message is detected.
    <br>

Feature Category: UI Design and Testing <br>
5. [UI-Layout]. The app must incorporate appropriate layout adjustments for UI components to support both portrait and landscape orientations, as well as various screen sizes. This requirement is in addition to the [UXUI] basic feature and necessitates the implementation of new layouts for each orientation and screen size. (easy) <br>
    * Code: [login.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/login.xml) and [login.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/login.xml) , [activity_main.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_main.xml) and [activity_main.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_main.xml) , [activity_create_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_create_post.xml) and [activity_create_post.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_create_post.xml) , [activity_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_post.xml) and [activity_post.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_post.xml) , [activity_create_comment.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_create_comment.xml) and [activity_create_comment.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_create_comment.xml) , [activity_chat.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_chat.xml) and [activity_chat.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_chat.xml) ,  [activity_chat_detail.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_chat_detail.xml) and [activity_chat_detail.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_chat_detail.xml) , [activity_profile.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_profile.xml) and [activity_profile.xml(land)](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout-land/activity_profile.xml) , [activity_item.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_item.xml) , [activity_load_show_data.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/activity_load_show_data.xml) , [item_comment.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_comment.xml) , [item_message.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_message.xml) , [item_post.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_post.xml) , [item_user.xml](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/res/layout/item_user.xml) , methods [onConfigurationChanged](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L212-230) and [setupListeners](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/MainActivity.java#L232-302). <br>
    * Description of the feature:  <br>
    - The app is designed to provide a responsive and adaptive user interface, ensuring proper layout adjustments for both portrait and landscape orientations, as well as various screen sizes. To achieve this, separate layout files are created for each orientation and stored in the [layout](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/tree/main/app/app/src/main/res/layout) folder for portrait mode and the [layout-land](https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/tree/main/app/app/src/main/res/layout-land) folder for landscape mode. This allows the app to automatically load the appropriate layout depending on the device's orientation, providing a seamless experience whether the user holds the device vertically or horizontally.
    - In addition to orientation-specific layouts, the app is also optimized for different screen sizes, ensuring that UI components are properly scaled and positioned across a range of devices, from small smartphones to large tablets. By implementing dimension resources and utilizing flexible layout components like ConstraintLayout, the app dynamically adjusts its UI elements to maintain usability and readability on all screen sizes.
    - This approach ensures that the user interface remains consistent and functional regardless of the device or orientation, enhancing the user experience by providing intuitive and visually balanced layouts in every scenario.

        <br><br>

<hr>

### Surprise Feature

(i) 
- Git: [ce888a40c1944883b80b211068997012eb95925c] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/ce888a40c1944883b80b211068997012eb95925c/app/app/src/main/java/com/example/smartcityapp/Search/CaeEXP.java)
- Time: Oct 04
- Code: Class: [CaeEXP.java]  Line: [20-30]

(ii) 
- The original code is changed into a factory method design pattern to replace if-else to achieve the extensibility of CaeEXP. 
- If new classes of category are added in the future, just add new classes without modifying the past code.
- First abstract the original CaeEXP class, and then create three new subclasses named type, participants, date to inherit CaeEXP this parent class.
- Through the factory method class CAEParserFactory to achieve the creation of objects for different subclasses.
- Git: [b92f103d22c9fbdad8756ad425c226baa36fb298] 
- Time: Oct 14
- Code: Class: [CaeEXP.java] Line:[12,25,33] Description: change the CaeEXP class to abstract class (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/CaeEXP.java)
- Code: Class: [TypeEXP.java]  Description: This is a new class extends from CaeEXP. (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/TypeEXP.java)
- Code: Class: [ParticipantsEXP]  Description: This is a new class extends from CaeEXP. (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/ParticipantsEXP.java)
- Code: Class: [DateEXP] Description: This is a new class extends from CaeEXP. (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/DateEXP.java)
- Code: Class：[CAEParserFactory] Description: Create object for different subclasses.(https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/main/java/com/example/smartcityapp/Search/CAEParserFactory.java)

(iii)
I choose the MIT License. 

Explanation:

1. This license is permissive and allows others to use, modify, and distribute the software with minimal restrictions, making it more attractive for developers and collaborators. 
2. The MIT License offers more flexibility for both open-source and commercial use. This flexibility aligns well with the potential need for broad adoption and integration in various communities and applications.

(iv)

1. One ethical issue that may arise in the development or deployment of this app relates to privacy concerns (IEEE Code of Ethics 1.03, 3.12). Since the app handles data from users, such as their names and activity preferences, there is a responsibility to ensure that this information is protected and not misused or accessed without proper authorization.
2. Furthermore, the app should comply with all legal regulations regarding data protection to avoid ethical violations (IEEE Code of Ethics 2.02).
3. Additionally,  the app must promote the public good by enhancing the quality of life and not compromising the user's trust or the environment (IEEE Code of Ethics 1.03). Ethical handling of user data is crucial to maintaining the integrity and reputation of the profession (IEEE Code of Ethics 6.0).

<br> <hr>


## Testing Summary

*[What features have you tested? What is your testing coverage?]*
*Please provide details (see rubrics) including some screenshots of your testing summary, showing the achieved testing coverage. Feel free to provide further details on your tests.*

*Here is an example:*

1. Tests for Tokenizer
    - Code: [TokenizerTest Class, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java) for the [Tokenizer Class, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43)
    - *Number of test cases: 12*
    - *Code coverage: 85% methods covered in Token and 100% methods covered in Tokenizer*
    - *Types of tests created and descriptions: Test whether the token and tokenizer meet the requirements of the syntax design*

2. Tests for Parser
    - Code: [ParserTest Class,entire file] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/ParserTest.java?ref_type=heads)
    - *Number of test cases: 12*
    - *Code coverage: 83% methods covered in Parser*
    - *Types of tests created and descriptions: Test whether the String input can be parsed successfully*
3. Tests for CreateUniqueID
    - Code:[CreateUniqueIDTest ] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/CreateUniqueIDTest.java?ref_type=heads)
    - *Number of test cases: 1*
    -  *Code coverage: 100% methods covered in CreateUniqueID*
    - *Types of tests created and descriptions: Test whether the id can be created successfully*
4. Tests for Message
- Code:[MessageTest] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/MessageTest.java?ref_type=heads)
    - *Number of test cases: 1*
    -  *Code coverage: 100% methods covered in MessageID*
    - *Types of tests created and descriptions: Test whether the message can be created successfully*
5. Tests for User
- Code:[UserTest] (https://gitlab.cecs.anu.edu.au/u7897414/gp-24s2/-/blob/main/app/app/src/test/java/com/example/smartcityapp/UserTest.java?ref_type=heads)
    - *Number of test cases: 1*
    -  *Code coverage: 100% methods covered in UserID*
    - *Types of tests created and descriptions: Test whether the user of list can be created successfully*

...

<br> <hr>



## Summary of Known Errors and Bugs


1. *Bug 1:*
    - Three tests, ChatAdapterTest, SignupTest and UserSessionTest can run  and pass when run seperately but can't run and pass when run with coverage.
    - This bug leading us can't figure out the true coverage of tests in our project.

<br> <hr>


## Team Management

### Meeting Minutes
* Link to the minutes of meetings.


- *[Team Meeting 1](team-meeting-1.md)*
- *[Team Meeting 2](team-meeting-2.md)*
- *[Team Meeting 3](team-meeting-3.md)*
- *[Team Meeting 4](team-meeting-4.md)*

<hr>

### Conflict Resolution Protocol
[Team conflict resolution protocol](ConflictResolutionProtocol.md)*

