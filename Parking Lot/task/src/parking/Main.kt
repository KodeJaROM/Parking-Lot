package parking

fun main() {
//    Creating an empty parking lot list
    var parkingLot = mutableListOf<String>()

    while (true) {
        val input = readln().split(" ")

        //        function to park a car in the first available spot or notify user if full
        fun park() {
            if (parkingLot.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                val firstAvailableSpot = parkingLot.indexOf("0")
                if (firstAvailableSpot != -1) {
                    parkingLot[firstAvailableSpot] =
                        input[1] // This stores the license plate number of the car
                    println("${input[2]} car parked in spot ${firstAvailableSpot + 1}.")
                } else {
                    println("Sorry, the parking lot is full.")
                }
            }
        }

        //        function to remove a car or notify user if the spot is empty
        fun leave() {
            if (parkingLot.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                val spotToRemoveCar = input[1].toInt() - 1
                if (parkingLot[spotToRemoveCar] != "0") {
                    parkingLot[spotToRemoveCar] = "0" //This clears the parking spot
                    println("Spot ${input[1]} is free.")
                } else {
                    println("There is no car in spot ${input[1]}.")
                }
            }
        }

        //        function to specify the size of the parking lot
        fun createParkingLot() {
                parkingLot = MutableList(input[1].toInt()) { "0" }
                println("Created a parking lot with ${input[1]} spots.")
        }

        when (input[0]) {
            "exit" -> break
            "park" -> park()
            "leave" -> leave()
            "create" -> createParkingLot()
        }
    }
}





