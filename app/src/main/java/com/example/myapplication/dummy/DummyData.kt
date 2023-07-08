package com.example.myapplication.dummy

val dummyFood = listOf<Food>(
    Food(
        name = "Pizza",
        price = 20,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Pizza is a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients, which is then baked at a high temperature, traditionally in a wood-fired oven."
    ),
    Food(
        name = "Sandwich",
        price = 30,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread, or more generally any dish wherein bread serves as a container or wrapper for another food type."
    ),
    Food(
        name = "Burger",
        price = 10,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Burger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled."
    ),
    Food(
        name = "Pizza",
        price = 20,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Pizza is a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients, which is then baked at a high temperature, traditionally in a wood-fired oven."
    ),
    Food(
        name = "Sandwich",
        price = 30,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread, or more generally any dish wherein bread serves as a container or wrapper for another food type."
    ),
    Food(
        name = "Burger",
        price = 10,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Burger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled."
    ),
    Food(
        name = "Pizza",
        price = 20,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Pizza is a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients, which is then baked at a high temperature, traditionally in a wood-fired oven."
    ),
    Food(
        name = "Sandwich",
        price = 30,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread, or more generally any dish wherein bread serves as a container or wrapper for another food type."
    ),
    Food(
        name = "Burger",
        price = 10,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Burger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled."
    ),
    Food(
        name = "Pizza",
        price = 20,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Pizza is a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients, which is then baked at a high temperature, traditionally in a wood-fired oven."
    ),
    Food(
        name = "Sandwich",
        price = 30,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread, or more generally any dish wherein bread serves as a container or wrapper for another food type."
    ),
    Food(
        name = "Burger",
        price = 10,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Burger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled."
    ),
)

data class Food(
    val name: String = "",
    val price: Int = 0,
    val image: String = "",
    val description: String = "",
)

val dummyCategory = listOf<String>(
    "All",
    "Pizza",
    "Burger",
    "Sandwich",
    "Noddles",
    "Rice",
    "Dessert",
)