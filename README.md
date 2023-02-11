# Random Dog Image Generator

Simple app which gets random dog images from api and store it in-memory LRU cache 

### You can download & install latest app ⬇

[![Dog Image Generator APK](https://img.shields.io/badge/Download-Latest-App?style=for-the-badge&logo=android)](https://github.com/mrwhoknows55/dog-image-generator/releases/download/1.0/dog-image-generator-app-release.apk)

### Demo [Video](https://drive.google.com/file/d/1Hiu99s2800xm0luPb7fA7b_uNXV3vEJr/view?usp=share_link)

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

