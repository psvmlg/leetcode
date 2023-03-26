class TestingDelegates: TestInterface by TestInterfaceImpl() {

    fun main() {
        apply()
    }
}

interface TestInterface {
    fun apply()
}

class TestInterfaceImpl : TestInterface {
    override fun apply() = Unit
}