import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    val post = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
            "postId": 3,
            "postAuthor": "Petya",
            "content": "Lorem ipsum dolor sit amet, 
            consectetuer adipiscing elit. 
            Aenean commodo ligula eget dolor. 
            Aenean massa. Cum sociis natoque penatibus 
            et magnis dis parturient montes, 
            nascetur ridiculus mus. Donec quam felis, 
            ultricies nec, pellentesque eu, pretium quis, sem.
             Nulla consequat massa quis enim. Donec pede justo,
              fringilla vel, aliquet nec, vulputate"
        }""".trimIndent())
        .setToken(token)
        .build()

    val another = Message.builder()
        .putData("action", "type3")
        .putData("content", """{
            "postId": 5,
            "postAuthor": "Petya"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(another)
}