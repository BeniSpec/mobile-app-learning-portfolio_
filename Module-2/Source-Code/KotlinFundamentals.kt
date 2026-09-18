/**
 * Module 2 - Unit 2, Pathway 1: Kotlin Fundamentals
 *
 * A short standalone Kotlin file that demonstrates the five topics
 * covered in this pathway: variables, conditionals, nullability,
 * classes/objects, and lambda expressions (function types).
 *
 * This is not an Android app (this pathway's codelabs run in the
 * Kotlin Playground, not Android Studio), so it is written as a
 * plain Kotlin file that can be run directly.
 */

// ---------- 4. Classes and objects ----------
class Student(val name: String, var badgesEarned: Int) {

    // A class method
    fun studySummary(): String {
        return "$name has earned $badgesEarned badges so far."
    }
}

fun main() {

    // ---------- 1. Variables (val vs var) ----------
    val studentName = "Benat"      // val = cannot be reassigned
    var badgeCount = 9             // var = can be reassigned
    badgeCount += 1                // allowed, because badgeCount is a var

    println("Student: $studentName")
    println("Badges earned: $badgeCount")

    // ---------- 2. Conditionals (if / when) ----------
    val progressMessage = if (badgeCount >= 10) {
        "Minimum badge requirement met!"
    } else {
        "Still working towards the 10-badge minimum."
    }
    println(progressMessage)

    // 'when' is Kotlin's cleaner alternative to a long if/else chain
    val moduleStatus = when (badgeCount) {
        in 0..5 -> "Just starting out"
        in 6..9 -> "Almost there"
        else -> "Milestone reached"
    }
    println("Status: $moduleStatus")

    // ---------- 3. Nullability ----------
    var mentorName: String? = null   // the '?' means this can hold null
    println("Mentor: ${mentorName ?: "No mentor assigned yet"}")

    mentorName = "Ts Mohd Zulkifli"
    println("Mentor: ${mentorName ?: "No mentor assigned yet"}")

    // ---------- 4. Using the class/object from above ----------
    val benat = Student(name = studentName, badgesEarned = badgeCount)
    println(benat.studySummary())

    // ---------- 5. Lambda expressions / function types ----------
    // A lambda is a small function that can be stored in a variable
    // and passed around like any other value.
    val doubleBadges: (Int) -> Int = { count -> count * 2 }
    println("If badges doubled: ${doubleBadges(badgeCount)}")

    // Passing a lambda directly into a higher-order function
    val encouragement: (String) -> String = { name -> "Keep going, $name!" }
    println(encouragement(studentName))
}
