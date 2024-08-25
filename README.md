This Project involves the usage of the following concepts: 
## MVVM Architecture:
View        : Activity/Fragment holds an instance of a ViewModel
ViewModel   : A class provides data for a UI views, and call other component to load data and present it to the view
                NB: LifeCycle of viewModel is different than that of the view
                NB: VM uses liveData, observer data class from android compenent arch
                NB: VM does not interract directly with data model, it uses class repository
Repository  : Class that fetches the data from the model(Room), and remote data sources(Retrofit, webservice):
Model       : using Room to fetch SQLite

## Room Persistence Library
## Kotlin coroutines
## Dependency Injection with Kodein/Dager


================================================ Steps:
=> Adding dependencies and plugin then sync to gradle:
Dep: Room
Dep: Coroutines
Dep: GG Material design
Dep: ViewModel
Dep: Kodein
Plugin: "Kotlin-kapt"

=> Adding a data Class Entity to hold a table
    @Annotation Entity 
    data class ShoppingItem
=> Adding a DAO(Data Access Object) interface to handle the access to DB:
    @dao