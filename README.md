# Product DIsplay Page in Shopping App- Modern Android Architecture

 <!-- ABOUT THE PROJECT -->
## About The Project
This Sample Application was developed by using Jetpack Compose. MVVM architecture and best practice are followed. You can find everything you need in the Jetpack Compose project within the application.

## Architecture
MVVM (Model-View-ViewModel) architecture pattern has been used in the development of this application. The development language of the application is Kotlin.

* Architecture;
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
  
* UI
  * [Compose](https://developer.android.com/jetpack/compose) declarative UI framework

* Tech/Tools
  * [Kotlin](https://kotlinlang.org/) 100% coverage
  * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://developer.android.com/kotlin/flow) for async operations
  * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
  * [Jetpack](https://developer.android.com/jetpack)
    * [Compose](https://developer.android.com/jetpack/compose)
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that stores, exposes and manages UI state
  * [Retrofit](https://square.github.io/retrofit/) for networking
  * [Coil](https://github.com/coil-kt/coil) for image loading

## Presentation patterns layers
* View - Composable screens that consume state, apply effects and delegate events upstream.
* ViewModel - [AAC ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that manages and set the state of the corresponding screen. Additionally, it intercepts UI events as callbacks and produces side-effects. The ViewModel is scoped to the lifetime of the corresponding screen composable in the backstack.
* Model - Data source classes that retrieve content. In a Clean architecture context, one could use UseCases or Interactors that tap into repositories or data sources directly.

