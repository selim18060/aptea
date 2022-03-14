# test-le-bon-coin
The application will use theTechnicalTestApi. It will consist on a simple MainActivity which will display a list of items and their details. 

I tried to set up the app with good practices (making the app easily scalable/editable), using Koin and Coroutines(very efficient, and has no memory leaks (the problem of AsyncTask). The code is both simple and well implemented (the problem of RxJava)).

The main reason for choosing Kotlin language over Java for this project is because Kotlin is making Android development faster, better and concise, brief but comprehensive.

As for the design pattern, there are basically two main ones for Android development: MVP and MVVM. i used MVVM because Google support it with their LiveData and ViewModel libraries (Android Architecture Components).

For the dependency injection, Dagger needs to use an annotation processor to scan the code and generate appropriate classes. It may take some time and it may slow down the build. On the other hand, because Koin resolves dependencies at runtime it has slightly worse runtime performance, so i chose Koin for performance reasons

For loading picture i used Glide because the images are loaded to memory and are cached faster than in Picasso which allows for a much faster loading. This also reduces the likelihood of a popular OutOfMemoryError occurring

PS : For more performance, I suggest to improve the display of the list by using the google Paging 3 library.. I was limited by time I couldn't set it up.
