# Module 1 – Analysis: Unit 1 – Your First Android App

## 1. Overview of What Was Covered

This module covered two pathways under Android Basics with Compose → First Android App. Pathway 1 ("Intro to Kotlin") built the language foundations: variable declarations (`val`/`var`), Kotlin's built-in data types, functions, return values, and named arguments — assessed through a quiz. Pathway 2 ("Create your first Android app") moved into actual Android development: creating a project from the Empty Activity template, exploring the generated project files, editing a Composable function's text, changing a background color, and adding padding — producing a working Compose app that displays a personalized greeting.

> ✏️ **Add your own sentence here:** what felt like the biggest jump between "learning Kotlin syntax" and "seeing it become a real running app"?

## 2. Techniques Used and How They Compare

**Technique A: `val` vs `var` for variable declarations**
- `val` creates a read-only reference; `var` allows reassignment.
- In the app code, `name: String` is a function *parameter*, not a `val`/`var` declaration — but the same immutability principle shows up in how Compose favors passing data in as parameters rather than mutating global state, which keeps a composable's output predictable for a given input.

**Technique B: Composable functions vs a plain Kotlin function**
- A plain Kotlin function (like `fun greet(name: String)`) just runs code and returns a value or `Unit`.
- A `@Composable` function (like `Greeting`) doesn't "return" UI the normal way — it describes what the UI *should look like* for given inputs, and Compose's runtime decides when to re-invoke it (recomposition) if those inputs change.

**Comparison:** the quiz's data/function concepts (parameters, arguments, return types) turned out to be the exact same building blocks used to define a Composable — `fun Greeting(name: String, modifier: Modifier = Modifier)` uses a parameter with a **default argument** (`Modifier = Modifier`), the same technique tested in the quiz's named-arguments question. Seeing the same language feature reused in a real UI function made the earlier quiz concepts click into place rather than feeling abstract.

## 3. Strengths and Limitations

**Strengths observed in this lab:**
- The `@Preview` annotation lets you see UI changes (like the background color or padding) instantly in Android Studio's design pane, without rebuilding and running the whole app on an emulator — a fast feedback loop.
- Default parameter values (`modifier: Modifier = Modifier`) mean the function can be called simply as `Greeting("Name")` for the common case, while still allowing a caller to pass a custom `Modifier` when needed.

**Limitations / things to watch for:**
- Hardcoding the name directly in `Greeting("Benat Siraj Ahmed")` inside `MainActivity` works for a one-off demo, but isn't how a real app would handle user data — it would come from user input or a data source, not be hardcoded at the call site.
- `Surface(color = Color.Cyan)` hardcodes a specific color rather than pulling from `MaterialTheme.colorScheme`, so it won't automatically adapt to light/dark theme the way the outer `Surface` in `MainActivity` does.

## 4. Justification of Implementation Decisions

I kept the `Greeting` composable's signature (`name: String, modifier: Modifier = Modifier`) rather than hardcoding the name inside the composable itself, because passing it as a parameter is what makes the function reusable — the same `Greeting` composable can render a preview with one name and the actual app with another (which is exactly what happens: `GreetingPreview` and `MainActivity` both call `Greeting` with different names).

> ✏️ **Add your own justification here:** once you run the app and compare the emulator output to the `@Preview` pane, note any difference you noticed and why.

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

This is the core reusable piece: `name` is required, `modifier` has a default so most callers don't need to specify one. `modifier.padding(24.dp)` adds spacing without hardcoding it inside `Text` itself, keeping the composable flexible for different layout contexts. I personalized the app by changing the argument passed in `MainActivity`'s `setContent` block and in `GreetingPreview` from the tutorial's example name to `"Benat Siraj Ahmed"` — full file in [`Source-Code/MainActivity.kt`](./Source-Code/MainActivity.kt).

## 6. Evidence

- Badges: "Learning" (levels progressing through this unit), "First Learning Pathway and Quiz", "Introduction to Programming in Kotlin" — see [`Badge-Evidence/`](./Badge-Evidence/)
- Source code: [`Source-Code/MainActivity.kt`](./Source-Code/MainActivity.kt)
- Output screenshots: see [`Screenshots/`](./Screenshots/)

## 8. Setup Android Studio (Link #2)

This pathway covered installing and configuring Android Studio itself — SDK setup, the IDE layout, and running a project for the first time — assessed via a quiz (scored 10/10), earning the "Set up Android Studio" badge plus another Learning badge. Combined with Pathway 2's "Run your first app on the Android Emulator" step, this closed the loop from writing Compose code to actually seeing it execute on a virtual device.

> ✏️ **Add your own sentence here:** one thing about the Android Studio setup/emulator process that wasn't obvious until you did it yourself (e.g. AVD setup, first build time, SDK version prompts).

## 9. References

- Google. (2026). *Android Basics with Compose – Unit 1: Your first Android app*. Android Developers. https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1
- Google. (2026). *Create your first Android app*. Android Developers. https://developer.android.com/codelabs/basic-android-kotlin-compose-first-app
