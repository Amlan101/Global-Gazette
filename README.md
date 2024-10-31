
# Global-Gazette

An engaging and up-to-date news aggregator app, bringing live news directly to users with a clean, user-friendly interface and easy-to-navigate sections for a seamless reading experience.


![Logo](https://imgur.com/mokWdWn.png)

## Features

- **Latest Headlines**: Instantly access the top news headlines from around the world.
- **Favorite Articles**: Bookmark and organize your favorite news articles for quick access.
- **Search Functionality**: Easily search for specific topics or articles using the search bar.
- **Detailed Article View**: View full article details in a WebView, offering a browser-like experience without leaving the app.
- **Offline Access**: Room Database integration enables offline access to saved news articles.
## 📱 Screenshots

### App Overview

| **Headlines Page** | **Favorites Page** |
|---------------------|--------------------|
| ![Headlines Page](https://imgur.com/weYku4o.png) | ![Favorites Page](https://imgur.com/rz0tsZh.png) |
| *Latest news headlines from various sources.* | *The page where users can access saved favorite articles.* |

### Additional Features

| **Search Page** | **Article Details** |
|-----------------|---------------------|
| ![Search Page](https://imgur.com/Dtjeeav.png) | ![Article Details](https://imgur.com/ud4FQOo.png) |
| *Search for news articles on specific topics.* | *Detailed view of selected article with in-app WebView.* |
## 🚀 Installation and Run Locally

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Amlan101/Global-Gazette.git
2. **Open in Android Studio**:
  - Launch Android Studio and open the cloned project.
3. **Sync Project**:
  - Run a Gradle sync in Android Studio to download all necessary dependencies.
4. **Download APK** *(optional)*:
  - If you want to quickly test the app without setup, download the APK from [here](https://drive.google.com/file/d/1nHyFF5jn2YoCHJnDGY32ORTXId_txKF_/view?usp=drive_link).
    ## 🛠️ Tech Stack

- **Kotlin** - Main programming language for Android development
- **XML** - UI layout design
- **Retrofit** - HTTP client for efficient API integration
- **Room Database** - Local storage for offline access to favorite articles
- **MVVM Architecture** - Structured codebase with clear separation of concerns
- **Jetpack Libraries** - ViewModel, LiveData, Navigation
## 📘 Lessons Learned

Building Global Gazette was an insightful project in Android development, strengthening skills in advanced Android concepts. Key takeaways include:

- **MVVM Architecture**: Leveraged MVVM to create a scalable and maintainable codebase, supporting testability and modularity.
- **Retrofit Integration**: Implemented Retrofit to handle API requests seamlessly, ensuring efficient, asynchronous data fetching for news updates.
- **Room Database**: Added offline access for user-favorite articles, improving user experience and app accessibility.
- **Jetpack Components**: Used Android Jetpack libraries, including ViewModel and LiveData, to support reactive data handling and lifecycle management.
