# Module 1 – Analysis: Unit 1 – Your First Android App

## 1. Overview of What Was Covered

This module covered all three parts of Unit 1 in Android Basics with Compose: Introduction to Programming in Kotlin, Setup Android Studio, and Build a Basic Layout (which included the "Create your first Android app" coding lab). The first part covered Kotlin basics — variable declarations (`val`/`var`), data types, functions, and return values, tested through a quiz. The second part covered installing and configuring Android Studio. The third part was hands-on: creating a project from the Empty Activity template, editing a Composable function's text, changing a background color, adding padding, running the app on the emulator, and finally building a small layout combining text and image composables.

The biggest jump for me was going from just answering quiz questions about Kotlin syntax to actually seeing those same ideas (parameters, default values) used inside real Compose code that runs on a screen.

## 2. Techniques Used and How They Compare

**val vs var**
`val` creates a value that can't be reassigned. `var` can be reassigned. In the quiz this was tested directly (declaring something with `var` that never changes is bad practice). In the actual app code, the `name` parameter in the `Greeting` function works the same way — it's passed in once and not reassigned, which keeps the function predictable.

**Plain Kotlin function vs Composable function**
A normal Kotlin function just runs and returns a value. A `@Composable` function like `Greeting` describes what the UI should look like — Compose decides when to re-run it if the input changes. This is a different way of thinking about functions than the "input → output" model from the quiz.

**Row vs Column layout**
`Row` arranges its children left-to-right; `Column` arranges them top-to-bottom. Building the basic layout meant choosing between these based on what the design actually needed — text next to an image uses `Row`, text stacked above/below an image uses `Column`. Neither is "better," it's purely a design decision.

**Comparison:** the named-argument and default-value ideas from the quiz turned out to be the same thing used in `fun Greeting(name: String, modifier: Modifier = Modifier)` — `modifier` has a default value, same concept, just now inside real UI code instead of a quiz question. That same composable pattern (parameters in, UI description out) scales up directly into combining multiple composables inside a `Row`/`Column` for the basic layout exercise.

## 3. Strengths and Limitations

**Strengths**
- The `@Preview` annotation shows UI changes instantly in Android Studio without needing to run the full app on an emulator — much faster to check small changes.
- Giving `modifier` a default value means most calls can just be `Greeting("Name")`, but a custom modifier can still be passed in when needed.
- `Row`/`Column` compose cleanly — nesting one inside the other builds more complex layouts without needing a separate layout language (unlike older XML-based Android layouts).

**Limitations**
- Hardcoding the name (`Greeting("Benat Siraj Ahmed")`) works for this small demo, but a real app would get that from user input, not type it directly into the code.
- `Surface(color = Color.Cyan)` is a fixed color, so it won't change with light/dark theme the way the outer `Surface` using `MaterialTheme.colorScheme.background` does.
- Without explicit `Arrangement`/`Alignment` parameters, `Row`/`Column` default spacing can look cramped, so those need to be set deliberately for a good layout.

## 4. Justification of Implementation Decisions

I kept `name` as a parameter instead of hardcoding it directly inside `Greeting`, because that's what lets the same function be reused with different names — the preview and the real app call it with different values, and it still works without duplicating the function.

## 5. Code Highlights

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Hi, my name is $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}
```

`name` is required, `modifier` has a default so it doesn't need to be passed every time. I changed the name passed into this function (in `MainActivity` and in `GreetingPreview`) to "Benat" instead of the tutorial's example name. Full file: [`Source-Code/MainActivity.kt`](./Source-Code/MainActivity.kt).

## 6. Build a Basic Layout

This part covered laying out a small Compose app step by step: building a simple app with text composables, then adding an image, and combining both into a finished screen (the "birthday card app" example from the pathway). The core idea was using layout composables like `Row` and `Column` to control whether elements sit side-by-side or stacked, plus modifiers like `padding` to control spacing. Finished with a quiz (10/10), earning the "Build a Basic Layout" badge.

## 7. Evidence

- Source code: [`Source-Code/MainActivity.kt`](./Source-Code/MainActivity.kt)
- Badges: Learning, First Learning Pathway and Quiz, Introduction to Programming in Kotlin, Set up Android Studio, Build a Basic Layout — see [`Badge-Evidence/`](./Badge-Evidence/)
- Output screenshots: see [`Screenshots/`](./Screenshots/)

## 8. References

- Google. (2026). *Android Basics with Compose – Unit 1: Your first Android app*. Android Developers. https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1
- Google. (2026). *Create your first Android app*. Android Developers. https://developer.android.com/codelabs/basic-android-kotlin-compose-first-app
