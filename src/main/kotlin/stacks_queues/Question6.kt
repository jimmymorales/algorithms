package stacks_queues

private class AnimalShelter {
    private val dogs = ArrayDeque<Pair<Dog, Int>>()
    private val cats = ArrayDeque<Pair<Cat, Int>>()
    private var order = 0

    fun enqueue(animal: Animal) {
        order++
        when (animal) {
            is Cat -> cats.add(animal to order)
            is Dog -> dogs.add(animal to order)
        }
    }

    fun dequeueAny(): Animal {
        if (cats.isEmpty()) return dequeueDog()
        if (dogs.isEmpty()) return dequeueCat()

        return if (cats.last().second > dogs.last().second) dequeueCat() else dequeueDog()
    }

    fun dequeueCat(): Cat = cats.removeLast().first

    fun dequeueDog(): Dog = dogs.removeLast().first
}

private sealed class Animal
private object Dog : Animal()
private object Cat : Animal()
