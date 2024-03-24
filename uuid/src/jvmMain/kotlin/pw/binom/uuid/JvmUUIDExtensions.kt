package pw.binom.uuid

import java.util.UUID as JvmUUID

val UUID.java
    get() = JvmUUID(mostSigBits, leastSigBits)
val JvmUUID.binom
    get()=UUID(mostSignificantBits, leastSignificantBits)