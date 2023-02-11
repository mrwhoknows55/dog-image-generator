# Random Dog Image Generator

Simple app which get random dog images from api and store it in-memory LRU cache 


### Technologies and Libraries used:

- Kotlin
- MVVM Architecture
- Coroutines for concurrency
- Hilt for dependency injection
- Retrofit and OkHttp3 as REST client
- Jetpack Navigation Components
- Timber for logging

### Package Structure
```
├── cache
│   ├── Cache.kt
│   └── LRUCache.kt
├── di
│   └── AppModule.kt
├── DogApplication.kt
├── net
│   ├── DogApiService.kt
│   └── dto
│       └── RandomDogResponse.kt
├── repo
│   └── DogRepository.kt
├── ui
│   ├── generate_dog
│   │   ├── GenerateDogsFragment.kt
│   │   └── GenerateDogsViewModel.kt
│   ├── home
│   │   └── HomeFragment.kt
│   ├── MainActivity.kt
│   └── view_dogs
│       ├── DogImagesListAdapter.kt
│       ├── ViewDogsFragment.kt
│       └── ViewDogsViewModel.kt
└── util
    ├── Resource.kt
    └── SafeClickListener.kt

```

