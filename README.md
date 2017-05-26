CleanArchitecture-Kotlin
--------------
This repository shows how to implement Clean Architecture using Kotlin.

Clean approach
--------------
This app is modeled using the Uncle Bob's Clean Architecture approach. To reach the main goals of **Clean**, we have the following patterns:

 * **MVP**: Separates the presentation layer from the logic, so that everything about how the interface works is separated from how we represent it on screen.
 * **Interactor**:  Contains the business logic code. These are run in the background or main thread and communicate events to the upper layer using callbacks.
 * **Repository**: Picks different data sources depending on certain conditions.The idea behind all this is that the data origin is transparent for the client,
which does not care if the data is coming from memory, disk or the cloud, the only truth is that the data will arrive and will be got.
 * **Navigator**: Allows to navigate through different UI elements.

 ![CleanArchitecture-Kotlin image](/art/Clean_Architecture.jpg?raw=true)

Every dependency is provided by the dependency injection framework which maximizes the power of **Inversion of Control** principle. By this way,
the dependencies point from the outer layers to the inner ones.

Configuration
--------------
You can compile and run and it should works fine.
If you want to login, sign in or recover password, you should to change the API_URL in
build.gradle, where the configuration parameters are located and adapt the response.
