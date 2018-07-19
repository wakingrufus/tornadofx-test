# tornadofx-test
Kotlin extensions for TornadoFX and TestFX

## Testing a View or Fragment

You can test a `View` or `Fragment` in isolation.
Suppose you have the following Fragment:

```kotlin
class TestFragment : Fragment() {
    companion object : KLogging()

    val string: String by param()

    override val root = vbox {
        label(string){
            id = "label"
        }
    }
}
```

### JUnit
Use the `tornadofx-test-junit` library to test your Views and Fragments with JUnit4

```kotlin
class TestFragmentTest : TornadoFxTest() {

    @Test
    fun test() {
        showViewWithParams<TestFragment>(mapOf("string" to "string"))

        verifyThat("#label", hasText("string"))
    }
}
```

Use the `tornadofx-test-junit5` library to test your Views and Fragments with JUnit5

```kotlin
@ExtendWith(ApplicationExtension::class)
class TestFragmentTest : TornadoFxTest() {

    @Test
    fun test() {
        showViewWithParams<TestFragment>(mapOf("string" to "string"))

        verifyThat("#label", hasText("string"))
    }
}
```