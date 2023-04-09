import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class StripeInterviewQuestionKtTest {

    private lateinit var sut: StripeInterviewQuestion;
    @org.junit.Before
    fun setUp() {
        sut = StripeInterviewQuestion()
    }

    @Test
    fun `expect something to happen here`() {
        assertTrue(sut.getBestTimeForListOfServers("BEGIN BEGIN 0 0 1 END BEGIN 0 1 END").equals(mutableListOf(2, 1)))
    }
}