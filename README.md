# Jetpack Compose MVVM Starter Template

A clean Android starter project using:

- Jetpack Compose
- MVVM Architecture
- Hilt for Dependency Injection
- Retrofit for API calls
- Room Database for local storage
- Navigation with arguments

---

## 📁 Project Structure
``` bash
com.example.composemvvm/
├── api/ → Retrofit API service
├── data/local/ → Room DB setup (entities, dao)
├── di/ → Hilt modules (Retrofit, Room)
├── models/ → Data models
├── repository/ → Repositories for API/DB
├── screens/ → Compose UI
├── ui/theme/ → Theme files (Color, Theme, Type)
├── viewmodels/ → ViewModels
├── MainActivity.kt → NavHost
└── Routes.kt → Routes
```

---

## 💡 How It Works

- `ViewModel` fetches data from `RoomRepository` or `DataRepository`
- Room uses `Flow` with `stateIn()` to update Compose UI in real-time
- Navigation supports argument passing (`navArgument`)
- Hilt injects dependencies across app

---

## 🚀 Quick Start

1. Clone the repo:  
   `git clone https://github.com/adityasood04/Compose-MVVM.git`
2. Copy the necessary files required in your project.

---

### If you find this template useful, please give it a star!
Found a bug or have a suggestion? [Open an issue](https://github.com/adityasood04/Compose-MVVM/issues/new)
