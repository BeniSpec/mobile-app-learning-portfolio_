# Module 2 – Analysis: Unit 2, Pathway 1 – Kotlin Fundamentals

## 1. Overview of What Was Covered

This module covered Pathway 1 of Unit 2 (Building App UI), which goes deeper into Kotlin itself rather than Android UI: variables, conditionals, nullability, classes and objects, and function types/lambda expressions. Unlike Unit 1's exercises, these codelabs ran in the Kotlin Playground rather than inside an Android Studio project, so the focus was purely on language fundamentals that later get used inside real Compose UI code. The pathway finished with the "Kotlin Fundamentals" quiz (9/10) and its matching badge.

## 2. Techniques Used and How They Compare

**val/var vs nullable types (`String?`)**
`val`/`var` control whether a variable can be *reassigned*. Nullability (`?`) is a separate, independent concern — whether a variable can *hold null at all*. A `val mentorName: String? = null` can never be reassigned to a different reference once set with `val`, but it can still legitimately hold `null` because of the `?`. Mixing these two ideas up was my biggest early confusion; they solve different problems.

**if/else vs when**
Both branch on a condition, but `if/else` is best for simple true/false decisions, while `when` is Kotlin's cleaner replacement for long chains of `else if` — especially useful for matching against ranges (`in 0..5 ->`) or multiple discrete values. For something like classifying a badge count into a status label, `when` reads far more clearly than nested `if` statements would.

**Regular function vs lambda expression**
A regular function is declared with `fun` and called by name. A lambda (`{ count -> count * 2 }`) is an unnamed function value that can be stored in a variable or passed as an argument. The comparison that stood out: a normal function is fixed once written, but a lambda stored in a `val` of type `(Int) -> Int` can be swapped for a *different* lambda later, as long as the input/output types match — which is exactly what makes Compose's `onClick = { ... }` pattern possible later in the course.

**Comparison:** all three of these techniques trade a small amount of upfront complexity for safety or flexibility later — nullability forces you to handle the "missing value" case explicitly instead of crashing at runtime; `when` scales better than `if/else` as more cases are added; and lambdas let behaviour be passed around as data instead of being hardcoded.

## 3. Strengths and Limitations

**Strengths**
- The `?:` (Elvis operator) gives a one-line way to provide a default when a nullable value is null, avoiding a separate `if (x == null)` check every time.
- `when` with ranges (`in 6..9 ->`) is far more readable than an equivalent `if/else if` chain once there are more than 2–3 branches.
- Storing a lambda in a typed variable (`val encouragement: (String) -> String`) makes the expected input/output explicit, which catches mistakes at compile time rather than at runtime.

**Limitations**
- Overusing `!!` (the not-null assertion) defeats the purpose of nullability altogether — it just converts a possible null into an immediate crash, so it should only be used when you are certain a value cannot be null.
- A `when` block without an `else` branch will fail to compile if the compiler can't prove all cases are covered, which can be confusing the first time it happens.
- Deeply nested lambdas can become hard to read; at some point a named function is clearer than a lambda, even though a lambda is technically shorter.

## 4. Justification of Implementation Decisions

I used a `val` for `studentName` since it is never reassigned after being set, but a `var` for `badgeCount`, since it changes as more badges are earned (`badgeCount += 1`). Choosing `val` wherever possible (rather than defaulting to `var` for everything) makes it clear, just by reading the declaration, which values are meant to stay constant — this matches what the pathway's summary explicitly recommends.

## 5. Code Highlights

```kotlin
var mentorName: String? = null
println("Mentor: ${mentorName ?: "No mentor assigned yet"}")
```

This uses the Elvis operator (`?:`) to supply a fallback string only when `mentorName` is null, instead of the code crashing or needing a separate `if` check. Full file: [`Source-Code/KotlinFundamentals.kt`](./Source-Code/KotlinFundamentals.kt).

## 6. Evidence

- Source code: [`Source-Code/KotlinFundamentals.kt`](./Source-Code/KotlinFundamentals.kt)
- Badges: Kotlin Fundamentals, plus 3 more Learning badges (levels 14 → 17) — see [`Badge-Evidence/`](./Badge-Evidence/)
- Quiz result: 9/10 on the Kotlin Fundamentals quiz

## 7. References

- Google. (2026). *Android Basics with Compose – Unit 2: Building app UI*. Android Developers. https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
- Google. (2026). *Use classes and objects in Kotlin*. Android Developers. https://developer.android.com/codelabs/basic-android-kotlin-compose-classes-and-objects
