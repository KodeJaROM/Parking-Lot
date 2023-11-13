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
                    val carInfo = input[1] + " " + input[2]
                    parkingLot[firstAvailableSpot] =
                        carInfo // This stores the license plate number and color of the car
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

        //        function to print the statistics of the parking lot
        fun showStatus() {
            if (parkingLot.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                var isEmpty = true

                for (index in parkingLot.indices) {
                    val spot = parkingLot[index]
                    if (spot != "0") {
                        println("${index + 1} $spot")
                        isEmpty = false
                    }
                }
                if (isEmpty) {
                    println("Parking lot is empty.")
                }
            }
        }

        //        function to print all cars of a specific color (case insensitive) on a comma separated line
        fun regByColor() {
            if (parkingLot.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                val result =
                    parkingLot.filter { it.split(" ")[1].equals(input[1], ignoreCase = true) }
                        .map { it.split(" ")[0] }
                        .joinToString(", ")

                if (result.isNotEmpty()) {
                    println(result)
                } else {
                    println("No cars with color ${input[1]} were found.")
                }
            }
        }

        // function to print the indexes of cars with a specific color (case insensitive) on a comma-separated line
        fun spotByColor() {
            if (parkingLot.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                val result = parkingLot
                    .mapIndexed { index, element ->
                        index to element.split(" ")[1].equals(input[1], ignoreCase = true)
                    }
                    .filter { it.second }
                    .map { it.first + 1}
                    .joinToString(", ")

                if (result.isNotEmpty()) {
                    println(result)
                } else {
                    println("No cars with color ${input[1]} were found.")
                }
            }
        }

        // function to print the indexes of cars with a specific license plate
        fun spotByReg() {
            if (parkingLot.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                val result = parkingLot
                    .mapIndexed { index, element ->
                        index to element.split(" ")[0].equals(input[1], ignoreCase = true)
                    }
                    .filter { it.second }
                    .map { it.first + 1}
                    .joinToString(", ")

                if (result.isNotEmpty()) {
                    println(result)
                } else {
                    println("No cars with registration number ${input[1]} were found.")
                }
            }
        }



        when (input[0]) {
            "exit" -> break
            "park" -> park()
            "leave" -> leave()
            "create" -> createParkingLot()
            "status" -> showStatus()
            "reg_by_color" -> regByColor()
            "spot_by_color" -> spotByColor()
            "spot_by_reg" -> spotByReg()
        }
    }
}





