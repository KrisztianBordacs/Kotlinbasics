package com.example.kotlinbasics2.model

data class Order (
    val orderId:Int,
    val costumer: Customer,
    val orderItem: List<Item>,
    val shipping: Shipping,
    val payment: Payment,
    val status: String
)data class Customer (
    val costumerId: String,
    val name: String,
    val email: String,
    val phone: String
)data class Shipping (
    val address: Address,
    val shippingMethod: String,
    val estimatedShippingTime: Byte
)data class Payment(
    val paymentMethode: String,
    val totalAmount: Double,
    val paid: Boolean
)data class Address (
    val street: String,
    val city: String,
    val postalCode: Int,
    val country: String
)data class Item (
    val itemId : String,
    val productName: String,
    val quantity: Byte,
    val pricePerUnit: Double,
    val discount: Double?
)

data class Project (
    val projectName: String,
    val subject: String,
    val durationWeeks: Byte,
    val teamMembers: List<Student>,
    val assingments: List<Assignment>,
    val completed: Boolean
)data class Student(
    val studentId: String,
    val name: String,
    val grade: Byte,
    val hasComplited: Boolean
)data class Assignment(
    val assingmentName: String,
    val maxPoint: Int,
    val studentScores: Scores
)data class Scores (
    val STU123: Int,
    val STU124: Int,
    val STU125: Int
)

data class City (
    val cityName: String,
    val transitSystem: Transit,
    val controlCenter: Contact
)data class Transit (
    val buses: Buses,
    val trams: Tram
)data class Buses (
    val routeNumber: Int,
    val routeName: String,
    val vehicles: List<Vehicles>,
    val schedule: Schedule
)data class Vehicles(
    val vehicleId: String,
    val capacity: Int,
    val currentLocation: Location,
    val status: String
)data class Location(
    val latitute: Double,
    val longitude: Double
)data class Schedule(
    val weekday: List<Weekday>,
    val weekend: List<Weekend>
)data class Weekday(
    val time: Time
)data class Time(
    val departureTime: String,
    val arrivalTime: String
)data class Weekend(
    val time: Time
)data class Tram(
    val routeNumber: Int,
    val routeName: String,
    val vehicles: Vehicles,
    val schedule: Schedule
)data class Contact(
    val contactNumber: String,
    val emergencyContacts: List<EmergencyContact>
)data class EmergencyContact(
    val name: String,
    val phone: String,
    val shift: String
)