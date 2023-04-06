interface Processor {
    fun process(request: ProcessorRequest): ProcessorResponse?
}

data class ProcessorRequest(val string: String)

data class ProcessorResponse(val string: String)


class CacheProcessor(private val processor: Processor) : Processor {
    override fun process(request: ProcessorRequest): ProcessorResponse? {
        val cacheValue = "FF"
        if (Math.random() > 0.5) {
            return ProcessorResponse(cacheValue)
        }
        println("Cant find in cache")
        return processor.process(request)
    }
}

class LogProcessor(private val processor: Processor) : Processor {
    override fun process(request: ProcessorRequest): ProcessorResponse? {
        println("Inside the logger processor")
        return processor.process(request)
    }
}

class RequestProcessor(): Processor {
    override fun process(request: ProcessorRequest): ProcessorResponse? {
        return ProcessorResponse("This is main response")
    }

}

fun main() {
    val processor = LogProcessor(CacheProcessor(RequestProcessor()))
    repeat(10) {
        processor.process(ProcessorRequest("This is main request"))
    }
}